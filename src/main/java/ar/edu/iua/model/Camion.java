package ar.edu.iua.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="camiones")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="id")

public class Camion implements Serializable{

	private static final long serialVersionUID = 7360841509302825955L;


	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

	@Column(unique=true)
	private String patente; 

    @Column()
    private String descripcion;

    @OneToMany(targetEntity=Orden.class, mappedBy="camion", fetch = FetchType.LAZY)
    @JsonBackReference
    private List<Orden> ordenList;
    
   
    @Column()
    private double cisternado[];

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPatente() {
		return patente;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Orden> getOrdenList() {
		return ordenList;
	}

	public void setOrdenList(List<Orden> ordenList) {
		this.ordenList = ordenList;
	}

	public double[] getCisternado() {
		return cisternado;
	}

	public void setCisternado(double[] cisternado) {
		this.cisternado = cisternado;
	}

	
    
    
}