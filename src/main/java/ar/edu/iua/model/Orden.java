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
	@Column(length=50, nullable=false, unique=true)
	private String codigoExterno; 
	
	
	
	public long getNumeroOrden() {
		return numeroOrden;
	}

	public void setNumeroOrden(long numeroOrden) {
		this.numeroOrden = numeroOrden;
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

	public Date getTurno() {
		return turno;
	}

	public void setTurno(Date turno) {
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

	public String getCodigoExterno() {
		return codigoExterno;
	}

	public void setCodigoExterno(String codigoExterno) {
		this.codigoExterno = codigoExterno;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

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
	
	
    
}