package model;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class RadioTaxi {
	List<Taxi> listaDeTaxis;

	public RadioTaxi(){
		listaDeTaxis = new LinkedList<>();
	}

	public Taxi asignarTaxi(){
		return taxiLibre();
	}
	
	private Taxi taxiLibre(){
		Iterator<Taxi> it = listaDeTaxis.iterator();
		 
		while (it.hasNext() && it.next().getEstado() != Taxi.Estado.LIBRE){
			
		}
		
		return it.next();
	}
}
