package ar.edu.iua.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="choferes")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="dni")
public class Chofer implements Serializable {

	private static final long serialVersionUID = 3759989795563161398L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long dni;
	
	@OneToMany(targetEntity=Orden.class, mappedBy="chofer", fetch = FetchType.LAZY)
    @JsonBackReference
    private List<Orden> ordenList;
	
	public Long getDni() {
		return dni;
	}

	public void setDni(Long dni) {
		this.dni = dni;
	}
	
	

}