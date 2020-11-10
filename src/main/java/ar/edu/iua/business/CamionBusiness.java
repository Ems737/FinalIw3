package ar.edu.iua.business;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;


import ar.edu.iua.business.exception.BusinessException;
import ar.edu.iua.business.exception.NotFoundException;	
//import ar.edu.iua.eventos.CamionEvent;
import ar.edu.iua.model.Camion;
import ar.edu.iua.model.persistence.CamionRepository;

@Service
public class CamionBusiness implements ICamionBusiness {

	@Autowired
	private CamionRepository camionDAO; 
	
	@Override
		public Camion load(String patente, long id) throws NotFoundException, BusinessException {
			Optional<Camion> camion; 
			try {
					if(patente !="*" && id == 0)
						camion = camionDAO.findByPatente(patente);
					else 
						camion = camionDAO.findById(id);
					
				} catch (Exception e) {
					throw new BusinessException(e);
				} 
			if(!camion.isPresent())
				throw new NotFoundException("El camion no se encuentra en la BD");
			
			return camion.get(); 
		}
	
	@Override
	public Camion load(long id) throws NotFoundException, BusinessException {
		Optional<Camion> camion; 
		try {
				
					camion = camionDAO.findById(id);
				
			} catch (Exception e) {
				throw new BusinessException(e);
			} 
		if(!camion.isPresent())
			throw new NotFoundException("El camion no se encuentra en la BD");
		
		return camion.get(); 
	}
		
	
	/*//VER PORQUE NO FUNCIONA CON EL ID 
	@Override
	public Camion load(Object object) throws NotFoundException, BusinessException {
		Optional<Camion> camion;
		try {
				
				if(object.is)
				if(object.getClass().getName().equals("java.lang.String"))
					camion = camionDAO.findByPatente((String)object);
				else
					camion = camionDAO.findById((Long) object);
			} catch (Exception e) {
				throw new BusinessException(e);
			} 
		if(!camion.isPresent())
			throw new NotFoundException("El camion no se encuentra en la BD");
		
		return camion.get(); 
	}
	*/
	
	/*
	@Override
	public Camion load(long id) throws NotFoundException, BusinessException {
		Optional<Camion> camion;
		try {
				camion = camionDAO.findById(id);
			} catch (Exception e) {
				throw new BusinessException(e);
			} 
		if(!camion.isPresent())
			throw new NotFoundException("El camion no se encuentra en la BD");
		
		return camion.get(); 
		
	}
*/
	@Override
	public List<Camion> list() throws BusinessException {
		try {
			return camionDAO.findAll();
		} catch (Exception e) {
			throw new BusinessException(e);
		}
	}

	@Override
	public Camion add(Camion camion) throws BusinessException {
		try {
			if(camion.checkBasicData()==null)
				return camionDAO.save(camion);
		} catch (Exception e) {
			throw new BusinessException(e);
		}
		return new Camion();
		
	}

	@Override
	public Camion update(Camion camion, Long id) throws NotFoundException, BusinessException {
		
		Camion camionNuevo = new Camion();
		Camion camionViejo = load(id);
			System.out.println(camionViejo.getId() + camionViejo.getPatente());
			if(camion.getPatente()==null || camion.getPatente().trim().length()==0)
				camionNuevo.setPatente(camionViejo.getPatente());
			else
				camionNuevo.setPatente(camion.getPatente());
			
			/*if(camion.getOrdenList().isEmpty())
				camionNuevo.setOrdenList(camionViejo.getOrdenList());
			else
				camionNuevo.setOrdenList(camion.getOrdenList());
			*/
			if(camion.getDescripcion()==null || camion.getDescripcion().trim().length()==0)
				camionNuevo.setDescripcion(camionViejo.getDescripcion());
			else 
				camionNuevo.setDescripcion(camion.getDescripcion());
			
			if(camion.getCodigoexterno()==null || camion.getCodigoexterno().trim().length()==0)
				camionNuevo.setCodigoexterno(camionViejo.getCodigoexterno());
			else
				camionNuevo.setCodigoexterno(camion.getCodigoexterno());
			
			/*if(camion.getCisternado().length==0)
				camionNuevo.setCisternado(camionViejo.getCisternado());
			else
				camionNuevo.setCisternado(camion.getCisternado());
				*/
			
		return add(camionNuevo);
	}
	

	@Override
	public void delete(Long id) throws NotFoundException, BusinessException {
		try {
			camionDAO.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new NotFoundException("No se encuentra el camion con id=" + id);
		} catch (Exception e) {
			throw new BusinessException(e);
		}
		
	}
	
	

}
