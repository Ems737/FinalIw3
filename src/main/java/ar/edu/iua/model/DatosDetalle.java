package ar.edu.iua.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="id")

//ESTE ES NUESTRO SISTEMA EXTERNO
public class DatosDetalle implements Serializable {

	private static final long serialVersionUID = 4551249436451185765L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//VINCULAR CON SISTEMA SAP
	private long id;
	
	private double masaAcumulada; 
	private double densidad;
	private double temperatura; 
	private double caudal; 
	

	//GENERAR GETTER Y SETTER
    
}