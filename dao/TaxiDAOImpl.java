package dao;

import java.util.List;

import com.db4o.ObjectContainer;
import com.db4o.query.Predicate;

import model.Taxi;

public class TaxiDAOImpl implements TaxiDAO {
	ObjectContainer db;

	public TaxiDAOImpl(ObjectContainer session) {
		db = session;
	}

	@Override
	public void guardarTaxi(Taxi taxi) {
		// TODO Auto-generated method stub
		db.store(taxi);
	}

	@Override
	public Taxi getById(String id) {
		// TODO Auto-generated method stub
		List<Taxi> result = db.query(new Predicate<Taxi>() {
			@Override
			public boolean match(Taxi taxi) {
				return taxi.getId().equals(id);
			}
		});
		return result.get(0);
	}

	@Override
	public void borrarTaxi(Taxi taxi) {
		// TODO Auto-generated method stub
		db.delete(taxi);
	}

	@Override
	public List<Taxi> listarTaxis() {
		// TODO Auto-generated method stub
		List<Taxi> result = db.query(Taxi.class);
		return result;
	}

	@Override
	public List<Taxi> listarTaxisLibres() {
		List<Taxi> taxis = db.query(new Predicate<Taxi>() {
			public boolean match(Taxi taxi) {
				return taxi.getLibre();
			}
		});
		return taxis;
	}

}
