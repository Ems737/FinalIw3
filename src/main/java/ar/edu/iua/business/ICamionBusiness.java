package ar.edu.iua.business;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import ar.edu.iua.business.exception.BusinessException;
import ar.edu.iua.business.exception.NotFoundException;
import ar.edu.iua.model.Camion;

public interface ICamionBusiness {

	public Camion load(Long id) throws NotFoundException, BusinessException;

	public Camion add(Camion producto) throws BusinessException;

	public Camion update(Camion producto) throws NotFoundException, BusinessException;

	public void delete(Long id) throws NotFoundException, BusinessException;

	//Carga un camion desde la BD a traves del codigo Externo
	public Camion load(String codigoExterno) throws NotFoundException, BusinessException;
	
	public Camion asegurarCamion(Camion camion) throws BusinessException;

}
