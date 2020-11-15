package ar.edu.iua.business;


import ar.edu.iua.business.exception.BusinessException;
import ar.edu.iua.business.exception.NotFoundException;
import ar.edu.iua.model.DetalleOrden;
import ar.edu.iua.model.Orden;
import ar.edu.iua.model.dto.RespuestaGenerica;

public interface IOrdenBusiness {

	/*

	public List<Orden> list() throws BusinessException;

	public Orden save(Orden producto) throws BusinessException;

	public void delete(Long id) throws BusinessException, NotFoundException;
	
    Orden add(Orden orden) throws BusinessException;
    
    public Orden update(Orden producto, Long id) throws NotFoundException, BusinessException;
    
	public Orden load(String codigoExterno) throws NotFoundException, BusinessException;
	
	public Orden asegurarOrden(Orden orden, Cliente cliente, Camion camion, Chofer chofer, Producto producto) throws BusinessException;
	*/
	public RespuestaGenerica<Orden> recibirEstadoUno(Orden orden) throws BusinessException;
	public RespuestaGenerica<Orden> recibirEstadoDos(Orden orden, int nroOrden) throws BusinessException,NotFoundException;
	public RespuestaGenerica<Orden> cargarCamion(DetalleOrden detalleOrden) throws BusinessException,NotFoundException;
	public Orden load(int nroOrden) throws BusinessException, NotFoundException;
	
	

}
