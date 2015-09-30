package model;

import java.util.UUID;

import com.db4o.activation.ActivationPurpose;
import com.db4o.activation.Activator;
import com.db4o.ta.Activatable;

public class Usuario implements Activatable {
	private String id;
	private String nombre;
	private String apellido;
	private String dni;
	private String mail;
	private String telefono;
	private transient Activator _activator;

	public Usuario() {

		this.id = UUID.randomUUID().toString();

	}

	public Usuario(String nombre, String apellido, String dni, String mail, String telefono) {
		super();
		this.id = UUID.randomUUID().toString();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.mail = mail;
		this.telefono = telefono;
	}

	public Usuario(String id, String nombre, String apellido, String dni, String mail, String telefono) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.mail = mail;
		this.telefono = telefono;
	}

	public String getNombre() {
		activate(ActivationPurpose.READ);
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		activate(ActivationPurpose.READ);
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDni() {
		activate(ActivationPurpose.READ);
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getMail() {
		activate(ActivationPurpose.READ);
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getTelefono() {
		activate(ActivationPurpose.READ);
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
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
		if (obj instanceof Usuario) {
			Usuario tmpUsuario = (Usuario) obj;
			if (this.getId().equals(tmpUsuario.getId())) {
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
