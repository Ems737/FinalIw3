package ar.edu.iua.business;


import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import ar.edu.iua.business.exception.BusinessException;
import ar.edu.iua.business.exception.NotFoundException;
import ar.edu.iua.model.DetalleOrden;
import ar.edu.iua.model.Orden;
import ar.edu.iua.model.dto.MensajeRespuesta;
import ar.edu.iua.model.dto.RespuestaGenerica;
import ar.edu.iua.model.persistence.DetalleOrdenRepository;
import ar.edu.iua.model.persistence.OrdenRepository;

@Service
public class DetalleOrdenBusiness implements IDetalleOrdenBusiness {

	@Autowired
	private IOrdenBusiness ordenService;

	@Autowired
	private IDetalleOrdenBusiness detalleOrdenService;


	@Autowired
	private DetalleOrdenRepository detalleOrdenDAO;
	@Autowired
	private OrdenRepository ordenDAO;
	
	@Override
	public DetalleOrden load(long id) throws BusinessException, NotFoundException {
		Optional<DetalleOrden> detalleOrden = null;
		try {

			detalleOrden = detalleOrdenDAO.findByid(id);

		} catch (Exception e) {
			throw new BusinessException(e);
		}
		if (!detalleOrden.isPresent())
			throw new NotFoundException("El orden no se encuentra en la BD");

		return detalleOrden.get();
	}


	@Override
	public RespuestaGenerica<DetalleOrden> cargarCamion(DetalleOrden detalleOrden, int nroOrden) throws BusinessException, NotFoundException
	{
		MensajeRespuesta m = new MensajeRespuesta();
		RespuestaGenerica<DetalleOrden> rg = new RespuestaGenerica<DetalleOrden>(detalleOrden, m);
		
		Orden orden = ordenService.load(nroOrden);
		
		String mensajeCheck = detalleOrden.checkBasicData(orden);
		
		if(mensajeCheck!="Cargando camion") {
			m.setCodigo(-1);
			m.setMensaje(mensajeCheck);
			return rg; 
		}
		
		try {
			detalleOrden.setOrden(orden);
			detalleOrden.setMasaAcumulada(detalleOrden.getMasaAcumulada());
			detalleOrden.setDensidad(detalleOrden.getDensidad());
			detalleOrden.setTemperatura(detalleOrden.getTemperatura());
			detalleOrden.setCaudal(detalleOrden.getCaudal());
			detalleOrden.setFechaHoraMedicion(new Date());
			
			
			//MODIFICAMOS LA ORDEN 
			//VER SI HACE IR ACUMULANDO
			orden.setUltimaMasaAcumulada(detalleOrden.getMasaAcumulada());
			orden.setUltimaDensidad(detalleOrden.getDensidad());
			orden.setUltimaTemperatura(detalleOrden.getTemperatura());
			orden.setUltimoCaudal(detalleOrden.getCaudal());
			//VER EL TEMA DE LA HORA PORQUE ES EL PRIMER DETALLE VALIDO
			
			detalleOrdenDAO.save(detalleOrden);
			ordenDAO.save(orden);
		} catch (Exception e) {
			throw new BusinessException();
		}
		
		return rg; 
	}

	
}
