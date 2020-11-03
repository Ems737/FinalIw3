package ar.edu.iua.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "ordenes")
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="id")
public class Orden implements Serializable {

	private static final long serialVersionUID = 451621105748580924L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 100)
	private String nombre;
	@Column(length = 250)
	private String descripcion;
	@Column(columnDefinition = "TINYINT DEFAULT 0")
	private boolean enStock;


    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "camion_patente")
    private Camion camion;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "chofer_dni")
    private Chofer chofer;
    
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "detalleCarga_id")
    private DetalleCarga detallecarga;
    
	public Long getPatente() {
		return id;
	}

	public void setPatente(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public boolean isEnStock() {
		return enStock;
	}

	public void setEnStock(boolean enStock) {
		this.enStock = enStock;
	}

    public Camion getCamion() {
        return camion;
    }

    public void setCamion(Camion camion) {
        this.camion = camion;
    }


    public Orden(String nombre, String descripcion, double precioLista) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Orden() {
    }
}
