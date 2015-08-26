package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class RadioTaxi {
	private List<Pedido> pedidosPendientes;
	private List<Taxi> listaDeTaxis;
	

	public RadioTaxi(){
		listaDeTaxis = new LinkedList<>();
		pedidosPendientes = new ArrayList<>();
	}
	
	public void addTaxi(Taxi t){
		listaDeTaxis.add(t);
	}

	
	public Pedido getPedidoPendiente() {
		Pedido p = pedidosPendientes.get(0);
		pedidosPendientes.remove(0);
		return p;
	}



	public void addPedidoPendiente(Pedido pedido) {		
		this.pedidosPendientes.add(pedido);
	}



	public void asignarTaxi(){
		Taxi taxi = taxiLibre();
		taxi.setEstado(Taxi.Estado.OCUPADO);
		Pedido pedido = this.getPedidoPendiente();
		pedido.setEstado(Pedido.Estado.EN_CURSO);
		pedido.setTaxi(taxi);
	}
	
	private Taxi taxiLibre(){
		Iterator<Taxi> it = listaDeTaxis.iterator();
		 
		while (it.hasNext() && it.next().getEstado() != Taxi.Estado.LIBRE){
			
		}
		  		
		return it.next();
	}
}
