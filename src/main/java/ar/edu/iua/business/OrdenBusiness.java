package ar.edu.iua.business;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.iua.business.exception.BusinessException;
import ar.edu.iua.business.exception.NotFoundException;
import ar.edu.iua.model.Camion;
import ar.edu.iua.model.Chofer;
import ar.edu.iua.model.Cliente;
import ar.edu.iua.model.Orden;
import ar.edu.iua.model.Producto;
import ar.edu.iua.model.dto.MensajeRespuesta;
import ar.edu.iua.model.dto.RespuestaGenerica;
import ar.edu.iua.model.persistence.OrdenRepository;

@Service
public class OrdenBusiness implements IOrdenBusiness {

	@Autowired
	private ICamionBusiness camionService;

	@Autowired
	private OrdenRepository ordenDAO;
	
	@Override
	public RespuestaGenerica<Orden> recibir(Orden orden) throws BusinessException {

		MensajeRespuesta m = new MensajeRespuesta();
		RespuestaGenerica<Orden> r = new RespuestaGenerica<Orden>(orden, m);

		//Si checBasicData devuelve "null" es porque todos los datos recibidos son correctos
		String mensajeCheck = orden.checkBasicData();
		if (mensajeCheck != null) {
			m.setCodigo(-1);
			m.setMensaje(mensajeCheck);
			return r;
		}

		//Si se recibio bien la Orden, entonces actualizo los datos en la base de datos y los guardo
		try {
			orden.setCamion(camionService.asegurarCamion(orden.getCamion()));
			orden.setFechaHora(new Date());
			ordenDAO.save(orden);
		} catch (Exception e) {
			throw new BusinessException(e);
		}

		return r;
	}

	@Override
	public Orden load(Long id) throws BusinessException, NotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Orden> list() throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Orden save(Orden producto) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) throws BusinessException, NotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Orden add(Orden orden) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Orden update(Orden producto, Long id) throws NotFoundException, BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Orden load(String codigoExterno) throws NotFoundException, BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Orden asegurarOrden(Orden orden, Cliente cliente, Camion camion, Chofer chofer, Producto producto)
			throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

}