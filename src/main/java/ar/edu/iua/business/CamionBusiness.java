package ar.edu.iua.business;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import ar.edu.iua.business.exception.BusinessException;
import ar.edu.iua.business.exception.NotFoundException;	
//import ar.edu.iua.eventos.CamionEvent;
import ar.edu.iua.model.Camion;
import ar.edu.iua.model.Camion;
import ar.edu.iua.model.persistence.CamionRepository;

@Service
public class CamionBusiness implements ICamionBusiness {

	@Autowired
	private CamionRepository camionDAO;

	@Override
	public Camion load(Long id) throws NotFoundException, BusinessException {
		Optional<Camion> op;
		try {
			op = camionDAO.findById(id);
		} catch (Exception e) {
			throw new BusinessException(e);
		}
		if (!op.isPresent()) {
			throw new NotFoundException("El camion con id " + id + " no se encuentra en la BD");
		}
		return op.get();
	}

	@Override
	public Camion add(Camion camion) throws BusinessException {
		try {
			return camionDAO.save(camion);
		} catch (Exception e) {
			throw new BusinessException(e);
		}
	}

	@Override
	public void delete(Long id) throws NotFoundException, BusinessException {
		try {
			camionDAO.deleteById(id);
		} catch (EmptyResultDataAccessException e1) {
			throw new NotFoundException("No se encuentra el camion id=" + id);
		} catch (Exception e) {
			throw new BusinessException(e);
		}

	}

/*
	@Autowired
	private ApplicationEventPublisher appEventPublisher;

	private void generaEvento(Camion camion, CamionEvent.Tipo tipo) {
		appEventPublisher.publishEvent(new CamionEvent(camion, tipo));
	}

	@Override
	public List<Camion> list(String parte) throws BusinessException {
		try {
			return camionDAO.findByNombreContainingOrDescripcionContainingOrderByNombreDesc(parte, parte);
		} catch (Exception e) {
			throw new BusinessException(e);
		}
	}
*/

		@Override
	    public Camion update(Camion camion) throws NotFoundException, BusinessException {
	        Camion op;
	        try {
	    	op = load(camion.getId());
	        } catch(Exception e) {
	        	throw new BusinessException(e);
	        }
	    	if(camion.getPatente()!=null){
	    		op.setPatente(camion.getPatente());
	    	}
	    	if(camion.getDescripcion()!=null){
	    		op.setDescripcion(camion.getDescripcion());
	    	}
	    	return add(op);
	    	
	    }
	
	@Override
	public Camion load(String codigoExterno) throws NotFoundException, BusinessException {
		Optional<Camion> op;
		try {
			op = camionDAO.findFirstByCodigoExterno(codigoExterno);
		} catch (Exception e) {
			throw new BusinessException(e);
		}
		if (!op.isPresent()) {
			throw new NotFoundException(
					"El camion con código externo " + codigoExterno + " no se encuentra en la BD");
		}
		return op.get();
	}

//camion se recibe incompleto desde un sistema externo.
	@Override
	public Camion asegurarCamion(Camion camion) throws BusinessException {
		Camion p = null;
		try {
			//Probamos cargar desde la BD un camion a traves del codigoExterno
			p = load(camion.getCodigoExterno());
			//Establecemos los nuevos valores en el camion guardado en la BD
			p.setPatente(camion.getPatente());
			p.setDescripcion(camion.getDescripcion());
			p.setCisternado(camion.getCisternado());
			// Colocar aquí los datos recibidos no opcionales
		} catch (NotFoundException e) {
			p = new Camion(camion);
		}
		return camionDAO.save(p);
	}

}

//@Autowired
//private ICamionBusiness camionBusiness
