package ar.edu.iua.model.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.iua.model.Camion;

@Repository
public interface CamionRepository extends JpaRepository<Camion, Long>{
	public List<Camion> findByNombreContainingOrDescripcionContainingOrderByNombreDesc(String nombre, String descripcion);
	
	//Metodo para obtener el camion a traves del codigo Externo
	public Optional<Camion> findFirstByCodigoExterno(String codigoExterno);
}


