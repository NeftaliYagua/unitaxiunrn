package dto;

public class CoordenadaDTO {

	private double latitud;
	private double longitud;
	
	public CoordenadaDTO(){
		latitud = 0.0;
		longitud = 0.0;
	}
	
	/**
	 * @param latitud
	 * @param longitud
	 */
	public CoordenadaDTO(double latitud, double longitud) {
		super();
		this.latitud = latitud;
		this.longitud = longitud;
	}

	public double getLatitud() {
		return latitud;
	}

	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}

	public double getLongitud() {
		return longitud;
	}

	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}

	@Override
	public String toString() {
		return "Coordenada [latitud=" + latitud + ", longitud=" + longitud + "]";
	}
	
}