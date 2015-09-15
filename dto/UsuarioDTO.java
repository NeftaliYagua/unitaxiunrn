package dto;

import model.Usuario;

public class UsuarioDTO {
	private String nombre;
	private String apellido;
	private String dni;
	private String mail;
	private String telefono;

	public UsuarioDTO(String nombre, String apellido, String dni, String mail, String telefono) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.mail = mail;
		this.telefono = telefono;
	}

	public UsuarioDTO(Usuario usuario) {
		super();
		this.nombre = usuario.getNombre();
		this.apellido = usuario.getApellido();
		this.dni = usuario.getDni();
		this.mail = usuario.getMail();
		this.telefono = usuario.getTelefono();
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

}