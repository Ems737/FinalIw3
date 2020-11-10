package ar.edu.iua.business;

import java.util.List;
import ar.edu.iua.business.exception.BusinessException;
import ar.edu.iua.business.exception.NotFoundException;
import ar.edu.iua.model.Camion;


public interface ICamionBusiness {

	
	//public Camion load(Object object) throws NotFoundException, BusinessException;
	public Camion load(long id) throws NotFoundException, BusinessException;

	public List<Camion> list() throws BusinessException;
	
	public Camion add (Camion camion) throws BusinessException;

	public Camion update(Camion camion) throws NotFoundException, BusinessException;
	
	public void delete(Long id) throws NotFoundException, BusinessException;



	

}
