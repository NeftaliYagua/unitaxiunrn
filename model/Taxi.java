package model;

public class Taxi {
//	public enum Estado{
//		LIBRE, OCUPADO
//	}
	
	private String patente;
	private String chofer;
	private String licencia;
	private String empresa;
	private boolean libre;
	private Notificacion notificacion;
	
	public Taxi(String patente, String chofer, String licencia, String empresa, boolean libre) {
		super();
		this.patente = patente;
		this.chofer = chofer;
		this.licencia = licencia;
		this.empresa = empresa;
		this.libre = libre;
		this.notificacion = new Notificacion();
	}

	public Taxi() {
		// TODO Auto-generated constructor stub
	}

	public String getPatente() {
		return patente;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}

	public String getChofer() {
		return chofer;
	}

	public void setChofer(String chofer) {
		this.chofer = chofer;
	}

	public String getLicencia() {
		return licencia;
	}

	public void setLicencia(String licencia) {
		this.licencia = licencia;
	}
	
	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public boolean getLibre() {
		return libre;
	}

	public void setLibre(boolean libre) {
		this.libre = libre;
	}

	public Notificacion getNotificacion() {
		return notificacion;
	}

	public void setNotificacion(Notificacion notificacion) {
		this.notificacion = notificacion;
	}
		
	public String[] toArray(){
		String[] cadena = {this.getPatente(), this.getChofer(), this.getEmpresa(), String.valueOf(this.getLibre())};
		return cadena;
	}
	
	public Object getId(){
		return null;		
	}
	
}
