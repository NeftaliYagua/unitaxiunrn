package model;

public class Pedido {
//	public static enum FormaDePago {
//		CREDITO, DEBITO, EFECTIVO
//	}; 
//	
//	public static enum Estado{
//		PENDIENTE, EN_CURSO, FINALIZADO
//	}
	
	private double precio;
	private String fecha;
	private String hora;
	private String pago;
	private String estado;
	private Usuario usuario;
	private Taxi taxi;

	public Pedido(double precio, String fecha, String hora, String pago,
			Usuario usuario, Taxi taxi) {
		super();
		this.precio = precio;
		this.fecha = fecha;
		this.hora = hora;
		this.pago = pago;
		this.estado  = "PENDIENTE";
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
	
	public String[] toArray(){
		String[] cadena = {this.getUsuario().getNombre()+" "+this.getUsuario().getApellido(), this.getFecha(), getEstado().toString()};
		return cadena;
	}

	public Object getObjectId() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	
	
	

}
