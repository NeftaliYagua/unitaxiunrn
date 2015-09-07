package ar.unrn.bd2.model;

public class Recorrido {
	private Coordenada origen;
	private Coordenada destino;

	public Recorrido() {
		this.origen = new Coordenada();
		this.destino = new Coordenada();
	}

	public Coordenada getOrigen() {
		return this.origen;
	}

	public void setOrigen(Coordenada origen) {
		this.origen = origen;
	}

	
	public Coordenada getDestino() {
		return destino;
	}

	public void setDestino(Coordenada destino) {
		this.destino = destino;
	}
	
	public int getDistancia(){
		return 0;
	}
}
