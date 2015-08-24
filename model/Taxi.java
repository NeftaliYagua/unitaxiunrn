package model;

public class Taxi {
	private String patente;
	private String chofer;
	private String licencia;
	
	public Taxi(String patente, String chofer, String licencia) {
		super();
		this.patente = patente;
		this.chofer = chofer;
		this.licencia = licencia;
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
	
}
