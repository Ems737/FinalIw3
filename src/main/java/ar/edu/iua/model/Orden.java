package ar.edu.iua.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
	private long numeroOrden;
	
	//JSON QUE NOS DA CIERTOS DATOS DE EL CAMION, EL CLIENTE, ETC. 
	
	//UN SISTEMA EXTERNO DA CIERTOS ATRIBUTOS DE ESTOS OBJETOS 
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
	private Date fechaHoraAlmacenamiento; 
	
	//SE RECIBE DEL SISTEMA EXTERNO? 
	@Column()
	private double pesajeInicial; 
	
	//COMO GENERARLA?
	@Column(length=5)
	private int password; 
	
	

	

	//GENERAR GETTER Y SETTER
    
}