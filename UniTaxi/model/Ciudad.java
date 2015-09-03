package model;

public class Ciudad {
	
	private String nombre;
	private Provincia provincia;
	
	public Ciudad() {
		// TODO Auto-generated constructor stub
	}
	
	public Ciudad(String nombre,Provincia prov) {
		this.nombre = nombre;
		this.provincia = prov;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Provincia getProvincia() {
		return provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}
	
	
	

}
