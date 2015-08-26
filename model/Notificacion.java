package model;

public class Notificacion {
	private String mensaje;
	private String tiempo;
	
	
	public Notificacion() {
		// TODO Auto-generated constructor stub
	}
	
	public Notificacion(String mensaje, String tiempo) {
		super();
		this.mensaje = mensaje;
		this.tiempo = tiempo;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getTiempo() {
		return tiempo;
	}

	public void setTiempo(String tiempo) {
		this.tiempo = tiempo;
	}
	
	public void notificar(Usuario u){
		System.out.println(u.getNombre()+" "+u.getApellido()+" "+this.mensaje+" en "+this.tiempo);
	}
	
}
