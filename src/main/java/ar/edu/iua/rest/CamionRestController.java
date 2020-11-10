package ar.edu.iua.rest;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.iua.business.ICamionBusiness;
import ar.edu.iua.business.exception.BusinessException;
import ar.edu.iua.business.exception.NotFoundException;
import ar.edu.iua.model.Camion;





@RestController
@RequestMapping(value = Constantes.URL_CAMIONES)

public class CamionRestController {
	
		@Autowired
		private ICamionBusiness camionBusiness;
		
		
		//curl "http://localhost:8080/api/v1/camiones/1"
				@GetMapping(value = "/load", produces = MediaType.APPLICATION_JSON_VALUE)
				public ResponseEntity<Camion> load(
						@RequestParam(name = "patente", required = false, defaultValue = "*") String patente,
						@RequestParam(name = "id", required = false, defaultValue = "0") long id){
					try {
						return new ResponseEntity<Camion>(camionBusiness.load(patente,id),HttpStatus.OK);
					} catch (BusinessException e) {
						return new ResponseEntity<Camion>(HttpStatus.INTERNAL_SERVER_ERROR);
					} catch (NotFoundException e) {
						return new ResponseEntity<Camion>(HttpStatus.NOT_FOUND);
					}
				}
		
		/*
		//curl "http://localhost:8080/api/v1/camiones/1"
		@GetMapping(value = "/{atributo}", produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Camion> load(@PathVariable(name = "atributo")Object object) {
			try {
				return new ResponseEntity<Camion>(camionBusiness.load(object),HttpStatus.OK);
			} catch (BusinessException e) {
				return new ResponseEntity<Camion>(HttpStatus.INTERNAL_SERVER_ERROR);
			} catch (NotFoundException e) {
				return new ResponseEntity<Camion>(HttpStatus.NOT_FOUND);
			}
		}*/
		
		
	
		
		/*
		//curl "http://localhost:8080/api/v1/camiones/1"
		@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Camion> load(@PathVariable(name = "id")long id) {
			try {
				return new ResponseEntity<Camion>(camionBusiness.load(id),HttpStatus.OK);
			} catch (BusinessException e) {
				return new ResponseEntity<Camion>(HttpStatus.INTERNAL_SERVER_ERROR);
			} catch (NotFoundException e) {
				return new ResponseEntity<Camion>(HttpStatus.NOT_FOUND);
			}
		}
		*/

		@GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<List<Camion>> list(){
			try {
				return new ResponseEntity<List<Camion>>(camionBusiness.list(),HttpStatus.OK);
			} catch (BusinessException e) {
				return new ResponseEntity<List<Camion>>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
		}
		
		@PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<String> add(@RequestBody Camion camion){
			try {
				camionBusiness.add(camion);
				HttpHeaders responseHeaders = new HttpHeaders();
				responseHeaders.set("location", Constantes.URL_CAMIONES + "/" + camion.getId());
				return new ResponseEntity<String>(responseHeaders, HttpStatus.CREATED);
			} catch (BusinessException e) {
				return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		
		@PutMapping(value = "/update/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<String> update(@PathVariable("id") Long id,@RequestBody Camion camion) {
			try {
				
				camionBusiness.update(camion,id);
				return new ResponseEntity<String>(HttpStatus.OK);
			} catch (BusinessException e) {
				return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
			} catch (NotFoundException e) {
				return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
			}
		}
		
		@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<String> delete(@PathVariable(name = "id")long id) {
			try {
				camionBusiness.delete(id);
				return new ResponseEntity<String>(HttpStatus.OK);
			} catch (BusinessException e) {
				return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
			} catch (NotFoundException e) {
				return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
			}
		}

		
		
		
		
		
	
}
