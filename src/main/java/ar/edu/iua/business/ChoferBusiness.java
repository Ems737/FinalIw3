package ar.edu.iua.business;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import ar.edu.iua.business.exception.BusinessException;
import ar.edu.iua.business.exception.NotFoundException;
import ar.edu.iua.model.Camion;
import ar.edu.iua.model.Chofer;
import ar.edu.iua.model.Chofer;
import ar.edu.iua.model.persistence.ChoferRepository;



@Service
public class ChoferBusiness implements IChoferBusiness{
	
	@Autowired
	private ChoferRepository choferDAO;

	@Override
	public Chofer load(long id) throws NotFoundException, BusinessException {
		Optional<Chofer> chofer;
		try {
				chofer = choferDAO.findById(id);
			} catch (Exception e) {
				throw new BusinessException(e);
			} 
		if(!chofer.isPresent())
			throw new NotFoundException("El Chofer no se encuentra en la BD");
		
		return chofer.get(); 
	}

	@Override
	public List<Chofer> list() throws BusinessException {
		try {
			return choferDAO.findAll();
		} catch (Exception e) {
			throw new BusinessException(e);
		}
	}

	@Override
	public Chofer add(Chofer chofer) throws BusinessException {
		try {
			if(chofer.checkBasicData()==null)
				return choferDAO.save(chofer);
		} catch (Exception e) {
			throw new BusinessException(e);
		}
		return new Chofer();
	}

	@Override
	public Chofer update(Chofer Chofer) throws NotFoundException, BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) throws NotFoundException, BusinessException {
		try {
			choferDAO.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new NotFoundException("No se encuentra el chofer con id=" + id);
		} catch (Exception e) {
			throw new BusinessException(e);
		}
		
	}

}