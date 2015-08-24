package model;

public class Taxi {
	enum Estado{
		LIBRE, OCUPADO
	}
	
	private String patente;
	private String chofer;
	private String licencia;
	private String empresa;
	private Estado estado;
	
	public Taxi(String patente, String chofer, String licencia, String empresa, Estado estado) {
		super();
		this.patente = patente;
		this.chofer = chofer;
		this.licencia = licencia;
		this.empresa = empresa;
		this.estado = estado;
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

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
}
