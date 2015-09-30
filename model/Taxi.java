package model;

import java.util.UUID;

import com.db4o.activation.ActivationPurpose;
import com.db4o.activation.Activator;
import com.db4o.ta.Activatable;

public class Taxi implements Activatable {
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
	private transient Activator _activator;

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
		activate(ActivationPurpose.READ);
		return patente;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}

	public String getChofer() {
		activate(ActivationPurpose.READ);
		return chofer;
	}

	public void setChofer(String chofer) {
		this.chofer = chofer;
	}

	public String getLicencia() {
		activate(ActivationPurpose.READ);
		return licencia;
	}

	public void setLicencia(String licencia) {
		this.licencia = licencia;
	}

	public String getEmpresa() {
		activate(ActivationPurpose.READ);
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public boolean getLibre() {
		activate(ActivationPurpose.READ);
		return libre;
	}

	public void setLibre(boolean libre) {
		this.libre = libre;
	}

	public Notificacion getNotificacion() {
		activate(ActivationPurpose.READ);
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
		activate(ActivationPurpose.READ);
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

	@Override
	public void activate(ActivationPurpose purpose) {
		if (_activator != null) {
			_activator.activate(purpose);
		}
	}

	@Override
	public void bind(Activator activator) {
		if (_activator == activator) {
			return;
		}
		if (activator != null && _activator != null) {
			throw new IllegalStateException();
		}
		_activator = activator;
	}

}
