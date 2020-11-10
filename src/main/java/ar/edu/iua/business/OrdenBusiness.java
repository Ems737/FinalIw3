/*package ar.edu.iua.business;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
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
	private OrdenRepository ordenDAO;

	@Override
	public Orden load(Long id) throws BusinessException, NotFoundException {
		Optional<Orden> op;
		try {
			op = ordenDAO.findById(id);

		} catch (Exception e) {
			throw new BusinessException(e);
		}
		if (!op.isPresent())
			throw new NotFoundException("No se encuentra el orden id=" + id);
		return op.get();
	}

	@Override
	public List<Orden> list() throws BusinessException {
		try {
			return ordenDAO.findAll();
		} catch (Exception e) {
			throw new BusinessException(e);
		}
	}

	@Override
	public Orden save(Orden orden) throws BusinessException {
		try {
			return ordenDAO.save(orden);
		} catch (Exception e) {
			throw new BusinessException(e);
		}
	}

	@Override
	public void delete(Long id) throws BusinessException,NotFoundException {
		try {
			ordenDAO.deleteById(id);
		} catch (EmptyResultDataAccessException e1) {
			throw new NotFoundException("No se encuentra el orden id=" + id);
		} catch (Exception e) {
			throw new BusinessException(e);
		}
	}
	
	@Override
    public Orden add(Orden orden) throws BusinessException {
        try {
            return ordenDAO.save(orden);
        } catch (Exception e) {
            throw new BusinessException(e);
        }
    }
/*	
	@Override
    public Orden update(Orden producto, Long id) throws NotFoundException, BusinessException {
        Orden op;
        try {
    	op = load(id);
        } catch(Exception e) {
        	throw new BusinessException(e);
        }
    	if(producto.getNombre()!=null){
    		op.setNombre(producto.getNombre());
    	}
    	if(producto.getDescripcion()!=null){
    		op.setDescripcion(producto.getDescripcion());
    	}
    	op.setEnStock(producto.isEnStock());
    	
    	return add(op);
    	
    }

	@Override
	public Orden load(String codigoExterno) throws NotFoundException, BusinessException {
		Optional<Orden> or;
		try {
			or = ordenDAO.findFirstByCodigoExterno(codigoExterno);
		} catch (Exception e) {
			throw new BusinessException(e);
		}
		if (!or.isPresent()) {
			throw new NotFoundException(
					"La Orden con código externo " + codigoExterno + " no se encuentra en la BD");
		}
		return or.get();
	}

	@Override
	public Orden asegurarOrden(Orden orden, Cliente cliente, Camion camion, Chofer chofer, Producto producto)
			throws BusinessException {
		Orden o = null;
		try {
			//Probamos cargar desde la BD una O a traves del codigoExterno
			o = load(orden.getCodigoExterno());
			//Establecemos los nuevos valores en el camion guardado en la BD
			o.setCliente(cliente);
			o.setCamion(camion);
			o.setChofer(chofer);
			o.setProducto(producto);
			o.setPreset(orden.getPreset());
			o.setTurno(orden.getTurno());
			// Colocar aquí los datos recibidos no opcionales
		} catch (NotFoundException e) {
			o = new Orden(orden, cliente, camion, chofer, producto);
		}
		return ordenDAO.save(o);

	}

	@Override
	public Orden update(Orden producto, Long id) throws NotFoundException, BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RespuestaGenerica<Orden> recibir(Orden orden) throws BusinessException {
		
		MensajeRespuesta m = new MensajeRespuesta();
		RespuestaGenerica<Orden> = new RespuestaGenerica<Orden>(orden,m);
		
		String mensajeCheck = orden.checkBasicData();
		
		if(mensajeCheck!=null)
		{
			m.setCodigo(-1);
			m.setMensaje(mensajeCheck);
		}
		
		
	}

	
	
	
}
*/

