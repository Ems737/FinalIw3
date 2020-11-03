/*package ar.edu.iua.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="numeroOrden")

//ESTE ES NUESTRO SISTEMA EXTERNO
public class Sap implements Serializable {

	private static final long serialVersionUID = 451621105748580924L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long numeroOrden;
	
    private Date turno; 
    
    private double preset; 
    
}
*/