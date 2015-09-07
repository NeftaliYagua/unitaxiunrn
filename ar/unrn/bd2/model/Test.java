package ar.unrn.bd2.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date actual = new Date();
		SimpleDateFormat formatoHora = new SimpleDateFormat("hh:mm:ss");
		SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy"); 
		
		// Inicialización de los datos
		
		Taxi t = new Taxi("abc 123","El rey","Licenciado","el 28 mil", Taxi.Estado.OCUPADO);
		Taxi t2 = new Taxi("yyy 321","Roberrrrrrto","Licena2","el 28 mil", Taxi.Estado.LIBRE);
		Usuario u = new Usuario("Lautaro","Lopez","12345679","llopez@domain.com","97654321");
		Pedido p = new Pedido(100.0, formatoFecha.format(actual), formatoHora.format(actual), Pedido.FormaDePago.EFECTIVO, u);
		RadioTaxi radioTaxi = new RadioTaxi();
		radioTaxi.addTaxi(t);
		radioTaxi.addTaxi(t2);
		
		// Fin inicialización
		
		//Inicio del flujo de datos		
		
		radioTaxi.addPedidoPendiente(p);
		radioTaxi.asignarTaxi();
		
		p.getTaxi().getNotificacion().setMensaje("Voy");
		
		p.getTaxi().getNotificacion().setTiempo("20");;
		
		p.getTaxi().getNotificacion().notificar(p.getUsuario());
		
		p.setEstado(Pedido.Estado.FINALIZADO);
		
		p.getTaxi().setEstado(Taxi.Estado.LIBRE);
		
		
		
		//Notificacion n = new Notificacion("Llegando", 20);
		
		
		
		
		
		

	}

}
