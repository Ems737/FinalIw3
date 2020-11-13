package ar.edu.iua.business;

import java.util.Date;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import ar.edu.iua.business.exception.BusinessException;

import ar.edu.iua.model.Orden;

import ar.edu.iua.model.dto.MensajeRespuesta;
import ar.edu.iua.model.dto.RespuestaGenerica;
import ar.edu.iua.model.persistence.OrdenRepository;

@Service
public class OrdenBusiness implements IOrdenBusiness {

	@Autowired
	private IChoferBusiness choferService;

	@Autowired
	private ICamionBusiness camionService;

	@Autowired
	private IClienteBusiness clienteService;

	@Autowired
	private IProductoBusiness productoService;

	@Autowired
	private OrdenRepository ordenDAO;

	@Override
	public RespuestaGenerica<Orden> recibir(Orden orden) throws BusinessException {

		MensajeRespuesta m = new MensajeRespuesta();
		RespuestaGenerica<Orden> rg = new RespuestaGenerica<Orden>(orden, m);

		String mensajeCheck = orden.checkBasicData();

		if (mensajeCheck != "Ok para estado 1") {
			m.setCodigo(-1);
			m.setMensaje(mensajeCheck);
			return rg;
		}

		try {
			orden.setNumeroOrden(orden.getNumeroOrden());
			orden.setChofer(choferService.asegurarChofer(orden.getChofer()));
			orden.setCamion(camionService.asegurarCamion(orden.getCamion()));
			orden.setCliente(clienteService.asegurarCliente(orden.getCliente()));
			orden.setChofer(choferService.asegurarChofer(orden.getChofer()));
			orden.setProducto(productoService.asegurarProducto(orden.getProducto()));
			orden.setTurno(new Date());
			orden.setPreset(orden.getPreset());
			orden.setEstado(1);
			ordenDAO.save(orden);
		} catch (Exception e) {
			throw new BusinessException(e);
		}

		return rg;

	}
}
