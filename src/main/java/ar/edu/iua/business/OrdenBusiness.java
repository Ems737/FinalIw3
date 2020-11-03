/*package ar.edu.iua.business;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import ar.edu.iua.business.exception.BusinessException;
import ar.edu.iua.business.exception.NotFoundException;
import ar.edu.iua.model.Orden;
import ar.edu.iua.model.persistence.OrdenRepository;

@Service
public class OrdenBusiness implements IOrdenBusiness {

    private Logger log = LoggerFactory.getLogger(this.getClass());


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


}
*/
