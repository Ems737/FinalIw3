package ar.edu.iua.business;

import java.util.List;


import ar.edu.iua.business.exception.BusinessException;
import ar.edu.iua.business.exception.NotFoundException;
import ar.edu.iua.model.Camion;
import ar.edu.iua.model.Chofer;
import ar.edu.iua.model.Cliente;
import ar.edu.iua.model.Orden;
import ar.edu.iua.model.Producto;
import ar.edu.iua.model.dto.RespuestaGenerica;

public interface IOrdenBusiness {

	public Orden load(Long id) throws BusinessException, NotFoundException;

	public List<Orden> list() throws BusinessException;

	public Orden save(Orden producto) throws BusinessException;

	public void delete(Long id) throws BusinessException, NotFoundException;
	
    Orden add(Orden orden) throws BusinessException;
    
    public Orden update(Orden producto, Long id) throws NotFoundException, BusinessException;
    
	public Orden load(String codigoExterno) throws NotFoundException, BusinessException;
	
	public Orden asegurarOrden(Orden orden, Cliente cliente, Camion camion, Chofer chofer, Producto producto) throws BusinessException;
	
	public RespuestaGenerica<Orden> recibir(Orden orden) throws BusinessException;
	

}
