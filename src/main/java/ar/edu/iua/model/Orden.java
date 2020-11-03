package ar.edu.iua.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="numeroOrden")

//ES LA RELACION ENTRE EL SISTEMA INTERNO Y EXTERNO
public class Orden implements Serializable {

	private static final long serialVersionUID = 451621105748580924L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//VINCULAR CON SISTEMA SAP
	private long numeroOrden;
	
	//VINCULAR CON EL SISTEMA TMS
	private double pesajeInicial; 
	
	private int estado; 
	
	//COMO GENERARLA?
	@Column(length=5)
	private int password; 
	
	//VER
	private datosDetalle datosDetalle; 
	

	//GENERAR GETTER Y SETTER
    
}