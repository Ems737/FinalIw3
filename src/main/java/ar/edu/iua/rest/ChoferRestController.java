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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.iua.business.IChoferBusiness;
import ar.edu.iua.business.exception.BusinessException;
import ar.edu.iua.business.exception.NotFoundException;
import ar.edu.iua.model.Chofer;

@RestController
@RequestMapping(value = Constantes.URL_CHOFERES)

public class ChoferRestController {
	
		@Autowired
		private IChoferBusiness choferBusiness;
		
		//curl "http://localhost:8080/api/v1/choferes/1"
				@GetMapping(value = "/load", produces = MediaType.APPLICATION_JSON_VALUE)
				public ResponseEntity<Chofer> load(
						@RequestParam(name = "dni", required = false, defaultValue = "0") long dni,
						@RequestParam(name = "id", required = false, defaultValue = "0") long id){
					try {
						return new ResponseEntity<Chofer>(choferBusiness.load(id,dni),HttpStatus.OK);
					} catch (BusinessException e) {
						return new ResponseEntity<Chofer>(HttpStatus.INTERNAL_SERVER_ERROR);
					} catch (NotFoundException e) {
						return new ResponseEntity<Chofer>(HttpStatus.NOT_FOUND);
					}
				}
		
		

		@GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<List<Chofer>> list(){
			try {
				return new ResponseEntity<List<Chofer>>(choferBusiness.list(),HttpStatus.OK);
			} catch (BusinessException e) {
				return new ResponseEntity<List<Chofer>>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
		}
		
		@PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<String> add(@RequestBody Chofer chofer){
			try {
				choferBusiness.add(chofer);
				HttpHeaders responseHeaders = new HttpHeaders();
				responseHeaders.set("location", Constantes.URL_CHOFERES + "/" + chofer.getId());
				return new ResponseEntity<String>(responseHeaders, HttpStatus.CREATED);
			} catch (BusinessException e) {
				return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		
		@PutMapping(value = "/update/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<String> update(@PathVariable("id") long id,@RequestBody Chofer chofer) {
			try {
				
				choferBusiness.update(chofer,id);
				return new ResponseEntity<String>(HttpStatus.OK);
			} catch (BusinessException e) {
				return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
			} catch (NotFoundException e) {
				return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
			}
		}
		
		@DeleteMapping(value = "delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<String> delete(@PathVariable(name = "id")long id) {
			try {
				choferBusiness.delete(id);
				return new ResponseEntity<String>(HttpStatus.OK);
			} catch (BusinessException e) {
				return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
			} catch (NotFoundException e) {
				return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
			}
		}

		
		
		
		
		
	
}
