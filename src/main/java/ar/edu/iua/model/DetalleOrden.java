package ar.edu.iua.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="id")

//ESTE ES NUESTRO SISTEMA EXTERNO
public class DetalleOrden implements Serializable {

	private static final long serialVersionUID = 4551249436451185765L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column()
	private double masaAcumulada; 
	@Column()
	private double densidad;
	@Column()
	private double temperatura; 
	@Column()
	private double caudal; 
	@Column()
	private Date fechaHoraMedicion; 
	
	@ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "numeroOrden")
	private Orden orden; 
	

	//GENERAR GETTER Y SETTER
    
}