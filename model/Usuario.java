package model;

import java.util.UUID;

public class Usuario {
	private String id;
	private String nombre;
	private String apellido;
	private String dni;
	private String mail;
	private String telefono;

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
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
