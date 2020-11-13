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

import ar.edu.iua.business.IProductoBusiness;
import ar.edu.iua.business.exception.BusinessException;
import ar.edu.iua.business.exception.NotFoundException;
import ar.edu.iua.model.Producto;

@RestController
@RequestMapping(value = Constantes.URL_PRODUCTOS)

public class ProductoRestController {
	
		@Autowired
		private IProductoBusiness productoBusiness;
		
				@GetMapping(value = "/load", produces = MediaType.APPLICATION_JSON_VALUE)
				public ResponseEntity<Producto> load(
						@RequestParam(name = "nombre", required = false, defaultValue = "*") String nombre,
						@RequestParam(name = "id", required = false, defaultValue = "0") long id){
					try {
						System.out.println(nombre + id);
						return new ResponseEntity<Producto>(productoBusiness.load(id,nombre),HttpStatus.OK);
					} catch (BusinessException e) {
						return new ResponseEntity<Producto>(HttpStatus.INTERNAL_SERVER_ERROR);
					} catch (NotFoundException e) {
						return new ResponseEntity<Producto>(HttpStatus.NOT_FOUND);
					}
				}
		
		

		@GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<List<Producto>> list(){
			try {
				return new ResponseEntity<List<Producto>>(productoBusiness.list(),HttpStatus.OK);
			} catch (BusinessException e) {
				return new ResponseEntity<List<Producto>>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
		}
		
		@PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<String> add(@RequestBody Producto producto){
			try {
				productoBusiness.add(producto);
				HttpHeaders responseHeaders = new HttpHeaders();
				responseHeaders.set("location", Constantes.URL_CHOFERES + "/" + producto.getId());
				return new ResponseEntity<String>(responseHeaders, HttpStatus.CREATED);
			} catch (BusinessException e) {
				return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		
		@PutMapping(value = "/update/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<String> update(@PathVariable("id") long id,@RequestBody Producto producto) {
			try {
				
				productoBusiness.update(producto,id);
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
				productoBusiness.delete(id);
				return new ResponseEntity<String>(HttpStatus.OK);
			} catch (BusinessException e) {
				return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
			} catch (NotFoundException e) {
				return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
			}
		}

		
		
		
		
		
	
}
