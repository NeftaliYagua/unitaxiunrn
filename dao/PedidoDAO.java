package dao;

import model.Pedido;

public interface PedidoDAO {
	public void guardarPedido(Pedido pedido);
	public Pedido obtenerPedido(Pedido pedido);
	public Pedido actualizarPedido(Pedido pedido);
	public void borrarPedido(Pedido pedido);

}
