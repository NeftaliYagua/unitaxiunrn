package dto;

public class RecorridoDTO {
	private CoordenadaDTO origen;
	private CoordenadaDTO destino;

	public RecorridoDTO() {
		this.origen = new CoordenadaDTO();
		this.destino = new CoordenadaDTO();
	}

	public CoordenadaDTO getOrigen() {
		return this.origen;
	}

	public void setOrigen(CoordenadaDTO origen) {
		this.origen = origen;
	}

	
	public CoordenadaDTO getDestino() {
		return destino;
	}

	public void setDestino(CoordenadaDTO destino) {
		this.destino = destino;
	}
	
}
