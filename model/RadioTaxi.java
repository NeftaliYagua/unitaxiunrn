package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.sun.org.glassfish.gmbal.Description;

public class RadioTaxi {
	private List<Pedido> pedidosPendientes;
	private List<Taxi> listaDeTaxis;
	

	public RadioTaxi(){
		listaDeTaxis = new LinkedList<>();
		pedidosPendientes = new LinkedList();
	}
	
	public void addTaxi(Taxi t){
		listaDeTaxis.add(t);
	}

	
	public Pedido getPedidoPendiente() {
		if (!pedidosPendientes.isEmpty()) {
			return pedidosPendientes.remove(0);
		}	
		return null;
	}



	public void addPedidoPendiente(Pedido pedido) {		
		this.pedidosPendientes.add(pedido);
	}


	/**
	 * Asigna el primer taxi que tenga Estado.LIBRE a un pedido. 
	 * Cambia su estado a Estado.OCUPADO, selecciona el primer pedido de
	 * la cola de pedidos pendientes y le modifica el estado a Estado.EN_CURSO
	 * y luego le asigna el taxi que se obtuvo antes.
	 *
	 */	
	public Pedido asignarTaxi(){
		Taxi taxi = taxiLibre();
		taxi.setEstado(Taxi.Estado.OCUPADO);
		Pedido pedido = this.getPedidoPendiente();
		pedido.setEstado(Pedido.Estado.EN_CURSO);
		pedido.setTaxi(taxi);
		return pedido;
	}
	
	/**
	 * Extrae el primer taxi que tenga Estado.LIBRE de la coleccion de taxis. 
	 * Retorna el taxi y luego lo vuelve a añadir a la colección pero al final, 
	 * para mantener una politica de elección de taxis libres justa.	  
	 *
	 */
	private Taxi taxiLibre(){
		Iterator<Taxi> it = listaDeTaxis.iterator();
		 
		while (it.hasNext()){
			Taxi t = it.next();
			if (t.getEstado() == Taxi.Estado.LIBRE) {
				it.remove();
				this.addTaxi(t);
				return t;
			}			
		}
		
		return null;
		
	}

	public List<Pedido> getPedidosPendientes() {
		return pedidosPendientes;
	}

	public List<Taxi> getListaDeTaxis() {
		return listaDeTaxis;
	}
	
	
}
