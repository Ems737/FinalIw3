package ar.edu.iua.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


import java.io.Serializable;

import java.util.Date;

import javax.persistence.*;

@Entity
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class)


public class Orden implements Serializable {

	private static final long serialVersionUID = 451621105748580924L;

	@Id
	@Column(unique=true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique=true)
	private long numeroOrden;

	@Column()
	private double preset;
	@Column()
	private double pesajeInicial; 
	
	@ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "camiones_id")
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
	private String turno; 
	
	@Column(columnDefinition = "DATETIME")
	private Date fechaHoraPesajeInicial; 
	
	@Column(columnDefinition = "DATETIME")
	private Date fechaHoraInicioCarga; 
	
	@Column(columnDefinition = "DATETIME")
	private Date fechaHoraFinCarga; 
	
	@Column(columnDefinition = "DATETIME")
	private Date fechaHoraPesajeFinal; 
	
	//Fecha donde ingresa primeramente la orden
	@Column(columnDefinition = "DATETIME NOT NULL")
	private Date fechaHora;
	
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
	
	/*//Codigo de integracion 
	@Column(length=50, nullable=false, unique=true)
	private String codigoExterno; 
	*/

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public double getPreset() {
		return preset;
	}

	public void setPreset(double preset) {
		this.preset = preset;
	}

	public double getPesajeInicial() {
		return pesajeInicial;
	}

	public void setPesajeInicial(double pesajeInicial) {
		this.pesajeInicial = pesajeInicial;
	}

	public Camion getCamion() {
		return camion;
	}

	public void setCamion(Camion camion) {
		this.camion = camion;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Chofer getChofer() {
		return chofer;
	}

	public void setChofer(Chofer chofer) {
		this.chofer = chofer;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	public Date getFechaHoraPesajeInicial() {
		return fechaHoraPesajeInicial;
	}

	public void setFechaHoraPesajeInicial(Date fechaHoraPesajeInicial) {
		this.fechaHoraPesajeInicial = fechaHoraPesajeInicial;
	}

	public Date getFechaHoraInicioCarga() {
		return fechaHoraInicioCarga;
	}

	public void setFechaHoraInicioCarga(Date fechaHoraInicioCarga) {
		this.fechaHoraInicioCarga = fechaHoraInicioCarga;
	}

	public Date getFechaHoraFinCarga() {
		return fechaHoraFinCarga;
	}

	public void setFechaHoraFinCarga(Date fechaHoraFinCarga) {
		this.fechaHoraFinCarga = fechaHoraFinCarga;
	}

	public Date getFechaHoraPesajeFinal() {
		return fechaHoraPesajeFinal;
	}

	public void setFechaHoraPesajeFinal(Date fechaHoraPesajeFinal) {
		this.fechaHoraPesajeFinal = fechaHoraPesajeFinal;
	}

	public int getPassword() {
		return password;
	}

	public void setPassword(int password) {
		this.password = password;
	}

	public double getUltimaMasaAcumulada() {
		return ultimaMasaAcumulada;
	}

	public void setUltimaMasaAcumulada(double ultimaMasaAcumulada) {
		this.ultimaMasaAcumulada = ultimaMasaAcumulada;
	}

	public double getUltimaDensidad() {
		return ultimaDensidad;
	}

	public void setUltimaDensidad(double ultimaDensidad) {
		this.ultimaDensidad = ultimaDensidad;
	}

	public double getUltimaTemperatura() {
		return ultimaTemperatura;
	}

	public void setUltimaTemperatura(double ultimaTemperatura) {
		this.ultimaTemperatura = ultimaTemperatura;
	}

	public double getUltimoCaudal() {
		return ultimoCaudal;
	}

	public void setUltimoCaudal(double ultimoCaudal) {
		this.ultimoCaudal = ultimoCaudal;
	}

	public Date getFechaHoraUltimoAlmacenamiento() {
		return fechaHoraUltimoAlmacenamiento;
	}

	public void setFechaHoraUltimoAlmacenamiento(Date fechaHoraUltimoAlmacenamiento) {
		this.fechaHoraUltimoAlmacenamiento = fechaHoraUltimoAlmacenamiento;
	}

	public double getPromedioDensidad() {
		return promedioDensidad;
	}

	public void setPromedioDensidad(double promedioDensidad) {
		this.promedioDensidad = promedioDensidad;
	}

	public double getPromedioTemperatura() {
		return promedioTemperatura;
	}

	public void setPromedioTemperatura(double promedioTemperatura) {
		this.promedioTemperatura = promedioTemperatura;
	}

	public double getPromedioCaudal() {
		return promedioCaudal;
	}

	public void setPromedioCaudal(double promedioCaudal) {
		this.promedioCaudal = promedioCaudal;
	}
	
	public void setFechaHora(Date date) {
		this.fechaHora=date;
		
	}
	
	public Date getFechaHora() {
		return fechaHora;
	}
	
	public long getNumeroOrden() {
		return numeroOrden;
	}

	public void setNumeroOrden(long numeroOrden) {
		this.numeroOrden = numeroOrden;
	}
/*
	public String getCodigoExterno() {
		return codigoExterno;
	}

	public void setCodigoExterno(String codigoExterno) {
		this.codigoExterno = codigoExterno;
	}
*/
	


	/*
	public Orden(Orden orden, Cliente cliente, Camion camion, Chofer chofer, Producto producto) {
		this.codigoExterno = orden.codigoExterno;
		this.numeroOrden = orden.getNumeroOrden();
		this.preset = orden.getPreset();
		this.camion = camion;
		this.cliente = cliente;
		this.chofer = chofer;
		this.producto = producto;
		this.estado = 1;
		this.turno = orden.getTurno();
	
	}
*/	
	public String checkBasicData(){
		
		//if(getCodigoExterno()==null || getCodigoExterno().trim().length()==0)
		//	return "El codigo externo es obligatorio";
		if(this.getNumeroOrden()<=0)
			return "El numero de orden es obligatorio";
		
		if(getCamion()==null)
			return "El Camion es obligatorio";
		if(getCamion().getCodigoExterno()==null || getCamion().getCodigoExterno().trim().length()==0)
			return "El codigo externo del Camion es obligatorio";
		if(getCamion().getPatente()==null|| getCamion().getPatente().trim().length()==0)
			return "La patente del camion es obligatoria";
		
		if(getChofer()==null)
			return "El Chofer es obligatorio";
		if(getChofer().getCodigoExterno()==null || getCamion().getCodigoExterno().trim().length()==0)
			return "El codigo externo del Chofer es obligatorio";
		if(getChofer().getDni()<=0)
			return "El Dni del chofer es obligatorio";
		
		if(getCliente()==null)
			return "El Cliente es obligatorio";
		if(getCliente().getCodigoExterno()==null || getCliente().getCodigoExterno().trim().length()==0)
			return "El codigo externo del Cliente es obligatorio";
		if(getCliente().getRazonSocial()==null || getCliente().getRazonSocial().trim().length()==0)
			return "La Razon Social del cliente es obligatoria";
		
		if(getProducto()==null)
			return "El Producto es obligatorio";
		if(getProducto().getCodigoExterno()==null || getProducto().getCodigoExterno().trim().length()==0)
			return "El codigo externo del Producto es obligatorio";
		if(getProducto().getNombre()==null || getProducto().getNombre().trim().length()==0)
			return "El Nombre del producto es obligatorio";
		
		if(getPreset()==0.0 || getPreset()<0)
			return "El present es obligatorio";
		if(getTurno()==null || getTurno().trim().length()==0)
			return "El turno es un atributo obligatorio";
	
		int numero=1;
		setEstado(numero);
		return null; 
	}

	
	
	
    
}