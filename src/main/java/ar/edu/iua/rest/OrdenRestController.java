package ar.edu.iua.rest;

import ar.edu.iua.business.IOrdenBusiness;
import ar.edu.iua.business.exception.BusinessException;
import ar.edu.iua.business.exception.NotFoundException;
import ar.edu.iua.model.Orden;
import ar.edu.iua.model.dto.MensajeRespuesta;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;





@RestController
@RequestMapping(value = Constantes.URL_ORDENES)
public class OrdenRestController {


	
	@Autowired
	private IOrdenBusiness ordenBusiness;
	
	@PostMapping(value = "/integracion", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<MensajeRespuesta> load(@RequestBody Orden orden) {

		try {
			MensajeRespuesta m = ordenBusiness.recibirEstadoUno(orden).getMensaje();
			if (m.getCodigo() == 0) {
				return new ResponseEntity<MensajeRespuesta>(m, HttpStatus.OK);
			} else {
				return new ResponseEntity<MensajeRespuesta>(m, HttpStatus.BAD_REQUEST);

			}
		} catch (BusinessException e) {
			return new ResponseEntity<MensajeRespuesta>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(value = "/integracion/{nroOrden}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<MensajeRespuesta> pesajeInicial(@RequestBody Orden orden, 
			@PathVariable("nroOrden") int nroOrden) throws NotFoundException {

		try {
			MensajeRespuesta m = ordenBusiness.recibirEstadoDos(orden, nroOrden).getMensaje();
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