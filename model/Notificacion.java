package model;

public class Notificacion {
	private String mensaje;
	private double distancia;
	
	public Notificacion(String mensaje, double distancia) {
		super();
		this.mensaje = mensaje;
		this.distancia = distancia;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public double getDistancia() {
		return distancia;
	}

	public void setDistancia(double distancia) {
		this.distancia = distancia;
	}
	
}
