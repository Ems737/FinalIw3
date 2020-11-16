package ar.edu.iua.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.*;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "id")

public class Orden implements Serializable {

	private static final long serialVersionUID = 451621105748580924L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(unique = true)
	private int numeroOrden;

	@Column()
	private double preset;
	@Column()
	private double pesajeInicial;
	@Column()
	private double pesajeFinal;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "camion_id")
	private Camion camion;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "chofer_id")
	private Chofer chofer;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "producto_id")
	private Producto producto;

	// VA DEL 1 AL 4
	@Column()
	private int estado;

	// DATOS QUE SE VAN ACTUALIZANDO SEGUN LA ORDEN DETALLE QUE SE RECIBE

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

	@Column(length = 5)
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

	public int getId() {
		return id;
	}

	public int getNumeroOrden() {
		return numeroOrden;
	}

	public void setNumeroOrden(int numeroOrden) {
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

	
	public double getPesajeFinal() {
		return pesajeFinal;
	}

	public void setPesajeFinal(double pesajeFinal) {
		this.pesajeFinal = pesajeFinal;
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

	public String checkBasicDataStatusOne() {

		System.out.println(getNumeroOrden());
		if ((getNumeroOrden() <= 0))
			return "El numero de orden es obligatorio";
		if (getTurno() == null)
			return "El atributo turno es obligatorio";
		if (getChofer() == null)
			return "El atributo chofer es obligatorio";
		if (getChofer().getCodigoexterno().equals(null) || getChofer().getCodigoexterno().trim().length() == 0)
			return "El atributo chofer.codigoexterno es obligatorio";
		if (getChofer().getDni() == 0)
			return "El atributo chofer.dni es obligatorio";
		if (getCamion() == null)
			return "El atributo camion es obligatorio";
		if (getCamion().getCodigoexterno().equals(null) || getCamion().getCodigoexterno().trim().length() == 0)
			return "El atributo camion.codigoexterno es obligatorio";
		if (getCamion().getPatente() == null || getCamion().getPatente().trim().length() == 0)
			return "El atributo camion.patente es obligatorio";
		if (getCliente() == null)
			return "El atributo cliente es obligatorio";
		if (getCliente().getCodigoexterno().equals(null) || getCliente().getCodigoexterno().trim().length() == 0)
			return "El atributo cliente.codigoexterno es obligatorio";
		if (getCliente().getRazonSocial() == null || getCliente().getRazonSocial().trim().length() == 0)
			return "El atributo cliente.razonSocial es obligatorio";
		if (getProducto() == null)
			return "El atributo producto es obligatorio";
		if (getProducto().getCodigoexterno().equals(null) || getProducto().getCodigoexterno().trim().length() == 0)
			return "El atributo producto.codigoexterno es obligatorio";
		if (getProducto().getNombre() == null || getProducto().getNombre().trim().length() == 0)
			return "El atributo producto.nombre es obligatorio";
		if ((getPreset() <= 0.0))
			return "El preset es obligatorio";

		return "Ok para estado 1";
	}

	public String checkBasicDataStatusTwo(int estado, Date turno) {

		String fechaActual = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
		String horaActual = new SimpleDateFormat("HH-00-00").format(new Date());
		String fechaTurno = new SimpleDateFormat("dd-MM-yyyy").format(turno);
		String horaTurno = new SimpleDateFormat("HH-00-00").format(turno);

		if (!fechaActual.equals(fechaTurno))
			return "El dia de carga no corresponde a la fecha del turno";
		if (!horaActual.equals(horaTurno))
			return "La hora de carga no corresponde a la hora del turno";
		if (estado != 1)
			return "Para realizar el pesaje inicial la orden debe estar en estado 1";
		if (getPesajeInicial() <= 0)
			return "El atributo pesaje es obligatorio";
		return "Ok para estado 2";

	}

	public String checkBasicDataStatusThree(Orden orden, int nroOrden) {

		if(getPesajeFinal()==0)
			return "El atributo pesaje final es obligatorio"; 
		if(getPesajeFinal() < orden.getPesajeInicial() || getPesajeFinal()<(orden.getPesajeInicial()+orden.getPreset()))
			return "Pesaje final invalido";
		if (orden.getEstado()!= 3)
			return "Para realizar el pesaje final, la orden debe estar en estado 3";
		return "Ok para pesaje final";

	}
	
	
}