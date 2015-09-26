package model;

import java.util.UUID;

public class Taxi {
	// public enum Estado{
	// LIBRE, OCUPADO
	// }

	private String id;
	private String patente;
	private String chofer;
	private String licencia;
	private String empresa;
	private boolean libre;
	private Notificacion notificacion;

	public Taxi() {
		this.id = UUID.randomUUID().toString();
	}

	public Taxi(String patente, String chofer, String licencia, String empresa, boolean libre) {
		super();
		this.id = UUID.randomUUID().toString();
		this.patente = patente;
		this.chofer = chofer;
		this.licencia = licencia;
		this.empresa = empresa;
		this.libre = libre;
		this.notificacion = new Notificacion();
	}

	public Taxi(String id, String patente, String chofer, String licencia, String empresa, boolean libre) {
		super();
		this.id = id;
		this.patente = patente;
		this.chofer = chofer;
		this.licencia = licencia;
		this.empresa = empresa;
		this.libre = libre;
		this.notificacion = new Notificacion();
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

	public String[] toArray() {
		String[] cadena = { this.getPatente(), this.getChofer(), this.getEmpresa(), String.valueOf(this.getLibre()) };
		return cadena;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Taxi) {
			Taxi tmpTaxi = (Taxi) obj;
			if (this.getId().equals(tmpTaxi.getId())) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

}
