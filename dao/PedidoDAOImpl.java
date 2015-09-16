package dao;

import model.Pedido;

public class PedidoDAOImpl implements PedidoDAO{
	private static DAO<Pedido> dao = new DAOImpl<Pedido>(Pedido.class);

	@Override
	public void guardarPedido(Pedido pedido) {
		// TODO Auto-generated method stub
		dao.guardar(pedido);	
	}

	@Override
	public Pedido obtenerPedido(Pedido pedido) {
		// TODO Auto-generated method stub
		return dao.obtener(pedido);
	}

	@Override
	public Pedido actualizarPedido(Pedido pedido) {
		// TODO Auto-generated method stub
		return null;
	}	

	@Override
	public void borrarPedido(Pedido pedido) {
		// TODO Auto-generated method stub
		dao.borrar(pedido);
	}

}
