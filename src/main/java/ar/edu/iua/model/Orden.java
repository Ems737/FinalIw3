package ar.edu.iua.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="numeroOrden")


public class Orden implements Serializable {

	private static final long serialVersionUID = 451621105748580924L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long numeroOrden;
	
	@Column()
	private double preset;
	@Column()
	private double pesajeInicial; 
	
	@ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "camion_id")
	private Camion camion; 
	@ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "cliente_id")
	private Cliente cliente; 
	@ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "chofer_id")
	private Chofer chofer;
	@ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "producto_id")
	private Producto producto; 
	
	//VA DEL 1 AL 4
	@Column()
	private int estado; 
	
	//DATOS QUE SE VAN ACTUALIZANDO SEGUN LA ORDEN DETALLE QUE SE RECIBE 

	@Column(columnDefinition = "DATETIME")
	private Date turno; 
	
	@Column(columnDefinition = "DATETIME")
	private Date fechaHoraPesajeInicial; 
	
	@Column(columnDefinition = "DATETIME")
	private Date fechaHoraInicioCarga; 
	
	@Column(columnDefinition = "DATETIME")
	private Date fechaHoraFinCarga; 
	
	@Column(columnDefinition = "DATETIME")
	private Date fechaHoraPesajeFinal; 
	
	@Column(length=5)
	private int password; 
	
	@Column()
	private double ultimaMasaAcumulada; 
	@Column()
	private double ultimaDensidad;
	@Column()
	private double ultimaTemperatura; 
	@Column()
	private double ultimoCaudal; 
	
	@Column(columnDefinition = "DATETIME")
	private Date fechaHoraUltimoAlmacenamiento; 
	
	@Column()
	private double promedioDensidad;
	@Column()
	private double promedioTemperatura; 
	@Column()
	private double promedioCaudal; 
	
	//Codigo de integracion 
	private String codigoExternoCamion; 
	
    
}