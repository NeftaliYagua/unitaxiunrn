package dao;

import java.util.List;

import com.db4o.ObjectContainer;
import com.db4o.query.Predicate;

import model.Pedido;
import model.Taxi;

public class PedidoDAOImpl implements PedidoDAO {
	ObjectContainer db;

	public PedidoDAOImpl(ObjectContainer session) {
		db = session;
	}

	@Override
	public void guardarPedido(Pedido pedido) {
		// TODO Auto-generated method stub
		db.store(pedido);
	}

	@Override
	public Pedido getById(String id) {
		// TODO Auto-generated method stub
		List<Pedido> result = db.query(new Predicate<Pedido>() {
			@Override
			public boolean match(Pedido pedido) {
				return pedido.getId().equals(id);
			}
		});
		return result.get(0);
	}

	@Override
	public void borrarPedido(Pedido pedido) {
		// TODO Auto-generated method stub
		db.delete(pedido);
	}

	@Override
	public List<Pedido> listarPedidos() {
		// TODO Auto-generated method stub
		List<Pedido> result = db.query(new Predicate<Pedido>() {
			public boolean match(Pedido pedido) {
				return true;
			}
		});
		return result;
	}

	@Override
	public List<Pedido> listarPedidosPendientes() {
		List<Pedido> pedidos = db.query(new Predicate<Pedido>() {
			public boolean match(Pedido pedido) {
				return pedido.getEstado().equals("PENDIENTE");
			}
		});
		return pedidos;
	}

	@Override
	public List<Pedido> pedidosPorTaxi(Taxi taxi) {
		List<Pedido> pedidos = db.query(new Predicate<Pedido>() {
			public boolean match(Pedido pedido) {
				return pedido.getTaxi().equals(taxi);
			}
		});
		return pedidos;
	}

	@Override
	public int cantPedidosPorTaxi(Taxi taxi) {
		int numberOfObjects = db.query(new Predicate<Pedido>() {
			public boolean match(Pedido pedido) {
				return pedido.getTaxi().equals(taxi);
			}
		}).size();
		return numberOfObjects;
	}

}
