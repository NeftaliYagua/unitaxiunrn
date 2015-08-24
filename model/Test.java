package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date actual = new Date();
		SimpleDateFormat formatoHora = new SimpleDateFormat("hh:mm:ss");
		SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy"); 
		
		Usuario u = new Usuario("Lautaro","Lopez","12345679","llopez@domain.com","97654321");
		
		Notificacion n = new Notificacion("Llegando", 20);
		
		Pedido p = new Pedido(0.0, formatoFecha.format(actual), formatoHora.format(actual), Pedido.FormaDePago.EFECTIVO, u);
		
		Taxi t = new Taxi("abc 123","El rey","Licenciado");
		
		

	}

}
