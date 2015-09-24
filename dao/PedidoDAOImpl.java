package dao;

import java.util.List;

import com.db4o.ObjectContainer;
import com.db4o.query.Predicate;

import model.Pedido;

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
		List<Pedido> result = db.query(Pedido.class);
		return result;
	}

}
