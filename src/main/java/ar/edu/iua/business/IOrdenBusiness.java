package ar.edu.iua.business;

import java.util.List;

import ar.edu.iua.business.exception.BusinessException;
import ar.edu.iua.business.exception.NotFoundException;
import ar.edu.iua.model.Orden;

public interface IOrdenBusiness {

	public Orden load(Long id) throws BusinessException, NotFoundException;

	public List<Orden> list() throws BusinessException;

	public Orden save(Orden producto) throws BusinessException;

	public void delete(Long id) throws BusinessException, NotFoundException;
	
    Orden add(Orden orden) throws BusinessException;
    
    public Orden update(Orden producto, Long id) throws NotFoundException, BusinessException;

}
