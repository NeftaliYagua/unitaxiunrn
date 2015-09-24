package dto;

public class PedidoDTO {
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
	private UsuarioDTO usuario;
	private TaxiDTO taxi;

	public PedidoDTO(double precio, String fecha, String hora, String pago,
			UsuarioDTO usuarioDTO, TaxiDTO taxiDTO) {
		super();
		this.precio = precio;
		this.fecha = fecha;
		this.hora = hora;
		this.pago = pago;
		this.estado  = "PENDIENTE";
		this.usuario = usuarioDTO;
		this.taxi = taxiDTO;
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

	public UsuarioDTO getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioDTO usuario) {
		this.usuario = usuario;
	}

	public TaxiDTO getTaxi() {
		return taxi;
	}

	public void setTaxi(TaxiDTO taxi) {
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

}
