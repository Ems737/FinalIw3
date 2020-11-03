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
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="patente")
public class Camion implements Serializable{

	private static final long serialVersionUID = 7360841509302825955L;


	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    //Deberiamos cambiarlo a JSON
    private String descripcion;

    @OneToMany(targetEntity=Orden.class, mappedBy="camion", fetch = FetchType.LAZY)
    @JsonBackReference
    private List<Orden> ordenList;


    public int getId() {
        return patente;
    }
    public void setId(int patente) {
        this.patente = patente;
    }

    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}