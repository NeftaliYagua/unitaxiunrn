package dao;

import java.util.List;

import model.Pedido;

public interface PedidoDAO {
	public void guardarPedido(Pedido pedido);
	public Pedido getById(String id);
	public List<Pedido> listarPedidos();
	public List<Pedido> listarPedidosPendientes();
	public void borrarPedido(Pedido pedido);

}
