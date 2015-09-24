package dao;

import java.util.List;

import model.Taxi;

public interface TaxiDAO {
	public void guardarTaxi(Taxi taxi);
	public Taxi getById(long id);
	public List<Taxi> listarTaxis();
	public List<Taxi> listarTaxisLibres();
	public void borrarTaxi(Taxi taxi);

}
