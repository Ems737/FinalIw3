package ar.edu.iua.rest;

import ar.edu.iua.business.IDetalleOrdenBusiness;
import ar.edu.iua.business.exception.BusinessException;
import ar.edu.iua.business.exception.NotFoundException;
import ar.edu.iua.model.DetalleOrden;
import ar.edu.iua.model.dto.MensajeRespuesta;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;





@RestController
@RequestMapping(value = Constantes.URL_DETALLE_ORDEN)
public class DetalleOrdenRestController {


	
	@Autowired
	private IDetalleOrdenBusiness detalleOrdenBusiness;
	
	
	
	@PostMapping(value = "/cargarCamion/{nroOrden}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<MensajeRespuesta> cargarCamion(@RequestBody DetalleOrden detalleOrden, 
			@PathVariable("nroOrden") int nroOrden) throws NotFoundException {

		try {
			MensajeRespuesta m = detalleOrdenBusiness.cargarCamion(detalleOrden, nroOrden).getMensaje();
			if (m.getCodigo() == 0) {
				return new ResponseEntity<MensajeRespuesta>(m, HttpStatus.OK);
			} else {
				return new ResponseEntity<MensajeRespuesta>(m, HttpStatus.BAD_REQUEST);

			}
		} catch (BusinessException e) {
			return new ResponseEntity<MensajeRespuesta>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	

}