package ar.edu.iua.business;

import java.util.List;

import ar.edu.iua.business.exception.BusinessException;
import ar.edu.iua.business.exception.NotFoundException;
import ar.edu.iua.model.Chofer;

public interface IChoferBusiness {
	
	//public Camion load(Object object) throws NotFoundException, BusinessException;
		public Chofer load(long id) throws NotFoundException, BusinessException;

		public List<Chofer> list() throws BusinessException;
		
		public Chofer add (Chofer chofer) throws BusinessException;

		public Chofer update(Chofer chofer) throws NotFoundException, BusinessException;
		
		public void delete(Long id) throws NotFoundException, BusinessException;


}
