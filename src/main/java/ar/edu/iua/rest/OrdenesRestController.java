package ar.edu.iua.rest;

import ar.edu.iua.business.IOrdenBusiness;
import ar.edu.iua.business.exception.BusinessException;
import ar.edu.iua.business.exception.NotFoundException;
import ar.edu.iua.model.Orden;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// 5 - con el @RestController le decimos a esta clase que es la controladora en donde una direccion http como localhost:8080/ordens/v1/1 nos devuelva un objeto para mapear
// RequestMapping se usa para decir que los metodos que escribo en esta clase (los resultados) entran por la URL definida en constantes
// Usamos la interfaz IOrdenBusiness solo para llamar a los métodos que creamos para trabajar sobre los datos (estos metodos estan implementados en OrdenBusiness donde reside la lógica)
// GetMapping y PostMapping se usan como metodos HTTP , GET o POST
// PathVariable se usa para definir que un atributo al usar por ejemplo un get puede cambiar (ver metodo load)
// el produces luego de cualquier anotador POST o GET nos dice el tipo de dato que tiene que devolver (es el content-type)

@RestController
@RequestMapping(value = Constantes.URL_ORDENES)
public class OrdenesRestController extends BaseRestController {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private IOrdenBusiness ordenBusiness;

	@GetMapping(value = { "" }, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Orden>> list() {
		try {
			return new ResponseEntity<List<Orden>>(ordenBusiness.list(), HttpStatus.OK);
		} catch (BusinessException e) {
			log.error(e.getMessage(), e);
			return new ResponseEntity<List<Orden>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// curl -X POST "http://localhost:8080/api/v1/ordens" -H "Content-Type: application/json" -d '{"nombre":"Arroz","descripcion":"Arroz que no se pasa","precioLista":89.56,"enStock":true, "ordenDetalle":'{"detalle":"Light"}'}' -v
	@PostMapping(value = { "" }, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> add(@RequestBody Orden orden) {
		try {
			ordenBusiness.add(orden);
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set("location", Constantes.URL_ORDENES + "/" + orden.getId());
			return new ResponseEntity<String>(responseHeaders, HttpStatus.CREATED);
		} catch (BusinessException e) {
			log.error(e.getMessage(), e);
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// curl -X PUT "http://localhost:8080/api/v1/ordens" -H "Content-Type: application/json" -d '{"id":1,"nombre":"Arroz","descripcion":"Arroz que no se pasa","precioLista":76.32,"enStock":true}' -v
	@PutMapping(value = { "/{id}" }, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> update(@RequestBody Orden orden, @PathVariable("id") Long id) {
		try {
			ordenBusiness.update(orden, id);
			return new ResponseEntity<String>(HttpStatus.OK);
		} catch (BusinessException e) {
			log.error(e.getMessage(), e);
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (NotFoundException e) {
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping(value = { "/{id}" }, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Orden> load(@PathVariable("id") Long id) {
		try {
			return new ResponseEntity<Orden>(ordenBusiness.load(id),HttpStatus.OK);
		} catch (BusinessException e) {
			log.error(e.getMessage(), e);
			return new ResponseEntity<Orden>(HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (NotFoundException e) {
			return new ResponseEntity<Orden>(HttpStatus.NOT_FOUND);
		}
	}

	// curl -X DELETE "http://localhost:8080/api/v1/ordens/1"
	@SuppressWarnings("Duplicates")
    @DeleteMapping(value = { "/{id}" }, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> delete(@PathVariable("id") Long id) {
		try {
			ordenBusiness.delete(id);
			return new ResponseEntity<String>(HttpStatus.OK);
		} catch (BusinessException e) {
			log.error(e.getMessage(), e);
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (NotFoundException e) {
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
	}

			
			
}