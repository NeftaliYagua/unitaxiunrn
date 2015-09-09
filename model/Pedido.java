package model;

public class Pedido {
	public static enum FormaDePago {
		CREDITO, DEBITO, EFECTIVO
	}; 
	
	public static enum Estado{
		PENDIENTE, EN_CURSO, FINALIZADO
	}
	
	private double precio;
	private String fecha;
	private String hora;
	private FormaDePago pago;
	private Estado estado;
	private Usuario usuario;
	private Taxi taxi;

	public Pedido(double precio, String fecha, String hora, FormaDePago pago,
			Usuario usuario) {
		super();
		this.precio = precio;
		this.fecha = fecha;
		this.hora = hora;
		this.pago = pago;
		this.usuario = usuario;
		this.estado  = Estado.PENDIENTE;
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

	public Taxi getTaxi() {
		return taxi;
	}

	public void setTaxi(Taxi taxi) {
		this.taxi = taxi;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	public String[] toArray(){
		String[] cadena = {this.getUsuario().getNombre()+" "+this.getUsuario().getApellido(), this.getFecha(), getEstado().toString()};
		return cadena;
	}
	
	
	
	
	
	
	

}
