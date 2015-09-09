package dto;

public class CiudadDTO {
	
	private String nombre;
	private ProvinciaDTO provincia;
	
	public CiudadDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public CiudadDTO(String nombre,ProvinciaDTO prov) {
		this.nombre = nombre;
		this.provincia = prov;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ProvinciaDTO getProvincia() {
		return provincia;
	}

	public void setProvincia(ProvinciaDTO provincia) {
		this.provincia = provincia;
	}
	
	
	

}
