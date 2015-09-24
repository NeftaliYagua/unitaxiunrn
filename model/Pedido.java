package model;

import java.util.UUID;

public class Pedido {

	private String id;
	private double precio;
	private String fecha;
	private String hora;
	private String pago;
	private String estado;
	private Usuario usuario;
	private Taxi taxi;

	public Pedido() {
		this.id = UUID.randomUUID().toString();
	}

	public Pedido(String id, double precio, String fecha, String hora, String pago, String estado, Usuario usuario,
			Taxi taxi) {
		super();
		this.id = id;
		this.precio = precio;
		this.fecha = fecha;
		this.hora = hora;
		this.pago = pago;
		this.estado = estado;
		this.usuario = usuario;
		this.taxi = taxi;
	}

	public Pedido(double precio, String fecha, String hora, String pago, Usuario usuario,
			Taxi taxi) {
		super();
		this.id = UUID.randomUUID().toString();
		this.precio = precio;
		this.fecha = fecha;
		this.hora = hora;
		this.pago = pago;
		this.estado = "PENDIENTE";
		this.usuario = usuario;
		this.taxi = taxi;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getPago() {
		return pago;
	}

	public void setPago(String pago) {
		this.pago = pago;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Taxi getTaxi() {
		return taxi;
	}

	public void setTaxi(Taxi taxi) {
		this.taxi = taxi;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String[] toArray() {
		String[] cadena = { this.getUsuario().getNombre() + " " + this.getUsuario().getApellido(), this.getFecha(),
				getEstado().toString() };
		return cadena;
	}

	public Object getObjectId() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
