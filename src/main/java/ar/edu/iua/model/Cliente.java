package ar.edu.iua.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
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
@Table(name="clientes")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="id")

public class Cliente implements Serializable {
	
	private static final long serialVersionUID = 6736832429914967093L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false)
	private String razonSocial; 
	
	@Column(nullable = false)
	private long contacto; 
	
	@OneToMany(targetEntity=Orden.class, mappedBy="cliente", fetch = FetchType.LAZY)
    @JsonBackReference
    private List<Orden> ordenList;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public long getContacto() {
		return contacto;
	}

	public void setContacto(long contacto) {
		this.contacto = contacto;
	}

	public List<Orden> getOrdenList() {
		return ordenList;
	}

	public void setOrdenList(List<Orden> ordenList) {
		this.ordenList = ordenList;
	}
	
	
	public String checkBasicData()
	{
		if(getRazonSocial().length()==0)
			return "La razon social es un atributo obligatorio";
		
		if(getContacto()==0)
			return "El contacto es un atributo obligatorio";
		
		return null; 
		
	}
	

}