package model;

import java.util.Date;

public class Pedido {
	enum FormaDePago{CREDITO, DEBITO, EFECTIVO};
	
	private double precio;
	private String fecha;
	private String hora;
	private FormaDePago pago;
	private Usuario usuario;
	
	public Pedido(double precio, String fecha, String hora, FormaDePago pago, Usuario usuario) {
		super();
		this.precio = precio;
		this.fecha = fecha;
		this.hora = hora;
		this.pago = pago;
		this.usuario = usuario;
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

	public FormaDePago getPago() {
		return pago;
	}

	public void setPago(FormaDePago pago) {
		this.pago = pago;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
