package dto;

import model.Taxi;

public class TaxiDTO {

	private String id;
	private String patente;
	private String chofer;
	private String licencia;
	private String empresa;
	private boolean libre;
	// private Notificacion notificacion;

	public TaxiDTO(String patente, String chofer, String licencia, String empresa, boolean libre) {
		super();
		this.patente = patente;
		this.chofer = chofer;
		this.licencia = licencia;
		this.empresa = empresa;
		this.libre = libre;
		// this.notificacion = new Notificacion();
	}

	public TaxiDTO(String id, String patente, String chofer, String licencia, String empresa, boolean libre) {
		super();
		this.id = id;
		this.patente = patente;
		this.chofer = chofer;
		this.licencia = licencia;
		this.empresa = empresa;
		this.libre = libre;
	}

	public TaxiDTO(Taxi taxi) {
		super();
		this.id = taxi.getId();
		this.patente = taxi.getPatente();
		this.chofer = taxi.getChofer();
		this.licencia = taxi.getLicencia();
		this.empresa = taxi.getEmpresa();
		this.libre = taxi.getLibre();
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	public String[] toArray() {
		String[] cadena = { this.getPatente(), this.getChofer(), this.getEmpresa(), String.valueOf(this.getLibre()) };
		return cadena;
	}
}
