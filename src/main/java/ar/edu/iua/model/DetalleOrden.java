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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getMasaAcumulada() {
		return masaAcumulada;
	}

	public void setMasaAcumulada(double masaAcumulada) {
		this.masaAcumulada = masaAcumulada;
	}

	public double getDensidad() {
		return densidad;
	}

	public void setDensidad(double densidad) {
		this.densidad = densidad;
	}

	public double getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(double temperatura) {
		this.temperatura = temperatura;
	}

	public double getCaudal() {
		return caudal;
	}

	public void setCaudal(double caudal) {
		this.caudal = caudal;
	}

	public Date getFechaHoraMedicion() {
		return fechaHoraMedicion;
	}

	public void setFechaHoraMedicion(Date fechaHoraMedicion) {
		this.fechaHoraMedicion = fechaHoraMedicion;
	}

	public Orden getOrden() {
		return orden;
	}

	public void setOrden(Orden orden) {
		this.orden = orden;
	}

	public DetalleOrden() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DetalleOrden(long id, double masaAcumulada, double densidad, double temperatura, double caudal,
			Date fechaHoraMedicion, Orden orden) {
		super();
		this.masaAcumulada = masaAcumulada;
		this.densidad = densidad;
		this.temperatura = temperatura;
		this.caudal = caudal;
		this.fechaHoraMedicion = fechaHoraMedicion;
		this.orden = orden;
	} 
	
	public String checkBasicData(Orden orden)
	{
		if(orden.getEstado()!=2)
			return "Para comenzar a cargar el camion, la orden debe estar en estado 2";
		if(getCaudal()==0)
			return "El atributo caudal es obligatorio";
		if(getCaudal()<0)
			return "El caudal debe ser > 0";
		if(getMasaAcumulada()==0)
			return "El atributo masa acumulada es obligatorio";
		if(getMasaAcumulada()< orden.getUltimaMasaAcumulada())
			return "La masa acumulada debe ser creciente";
		if(getDensidad()==0)
			return "El atributo densidad es obligatorio";
		if(getDensidad()<0 || getDensidad()>1) //VER
			return "La densidad debe ser entre 0 y 1";
		if(getTemperatura()==0)
			return "El atributo temperatura es obligatorio";
		if(getTemperatura()<0) // VER
			return "La temperatura debe ser mayor a 0";
		if(orden.getPreset()< getMasaAcumulada()) //esto deberia ser un endpoint
			return "Camion cargado"; 
		return "Cargando camion"; 
		
	}
    
}