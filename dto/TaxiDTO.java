package dto;

public class TaxiDTO {

	private String patente;
	private String chofer;
	private String licencia;
	private String empresa;
	private boolean libre;
	//private Notificacion notificacion;
	
	public TaxiDTO(String patente, String chofer, String licencia, String empresa, boolean libre) {
		super();
		this.patente = patente;
		this.chofer = chofer;
		this.licencia = licencia;
		this.empresa = empresa;
		this.libre = libre;
		//this.notificacion = new Notificacion();
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


	
	
}
