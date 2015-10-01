package model;

import java.util.Iterator;
import java.util.ListIterator;

import api.Servicio;
import dto.PedidoDTO;
import dto.TaxiDTO;
import dto.UsuarioDTO;

public class Test {

	public static void main(String[] args) {

		// TODO Auto-generated method stub
		/*
		 * Date actual = new Date(); SimpleDateFormat formatoHora = new
		 * SimpleDateFormat("hh:mm:ss"); SimpleDateFormat formatoFecha = new
		 * SimpleDateFormat("dd-MM-yyyy");
		 * 
		 * // Inicialización de los datos
		 * 
		 * Taxi t = new Taxi("abc 123","El rey","Licenciado","el 28 mil",
		 * Taxi.Estado.OCUPADO); Taxi t2 = new Taxi("yyy 321"
		 * ,"Roberrrrrrto","Licena2","el 28 mil", Taxi.Estado.LIBRE); Usuario u
		 * = new
		 * Usuario("Lautaro","Lopez","12345679","llopez@domain.com","97654321");
		 * Pedido p = new Pedido(100.0, formatoFecha.format(actual),
		 * formatoHora.format(actual), Pedido.FormaDePago.EFECTIVO, u);
		 * RadioTaxi radioTaxi = new RadioTaxi(); radioTaxi.addTaxi(t);
		 * radioTaxi.addTaxi(t2);
		 * 
		 * // Fin inicialización
		 * 
		 * //Inicio del flujo de datos
		 * 
		 * radioTaxi.addPedidoPendiente(p); radioTaxi.asignarTaxi();
		 * 
		 * p.getTaxi().getNotificacion().setMensaje("Voy");
		 * 
		 * p.getTaxi().getNotificacion().setTiempo("20");;
		 * 
		 * p.getTaxi().getNotificacion().notificar(p.getUsuario());
		 * 
		 * p.setEstado(Pedido.Estado.FINALIZADO);
		 * 
		 * p.getTaxi().setEstado(Taxi.Estado.LIBRE);
		 */

		Servicio api = new Servicio();

		UsuarioDTO usuarioDTO = new UsuarioDTO("Horacio", "Munoz", "12345678", "hmunoz@mail.com", "12345678");

		TaxiDTO taxiDTO = new TaxiDTO("abc 123", "Lopez", "licencia", "Rapitaxi", false);
		TaxiDTO taxiDTO2 = new TaxiDTO("xyz 789", "Pepito", "licencia", "Rapitaxi", false);
		TaxiDTO taxiDTO3 = new TaxiDTO("jda 378", "Micho", "licencia", "Rapitaxi", false);
		TaxiDTO taxiDTO4 = new TaxiDTO("abc 123", "Tito", "licencia", "Rapitaxi", false);
		TaxiDTO taxiDTO5 = new TaxiDTO("osh 123", "Lucas", "licencia", "Rapitaxi", true);
		TaxiDTO taxiDTO6 = new TaxiDTO("djs 383", "Gordo", "licencia", "Rapitaxi", false);
		TaxiDTO taxiDTO7 = new TaxiDTO("dss 322", "Nicolas", "licencia", "Rapitaxi", false);
		TaxiDTO taxiDTO8 = new TaxiDTO("wtx 003", "Cabezon", "licencia", "Rapitaxi", false);

		taxiDTO = api.crearTaxi(taxiDTO);
		taxiDTO2 = api.crearTaxi(taxiDTO2);
		taxiDTO3 = api.crearTaxi(taxiDTO3);
		taxiDTO4 = api.crearTaxi(taxiDTO4);
		taxiDTO5 = api.crearTaxi(taxiDTO5);
		taxiDTO6 = api.crearTaxi(taxiDTO6);
		taxiDTO7 = api.crearTaxi(taxiDTO7);
		taxiDTO8 = api.crearTaxi(taxiDTO8);

		// TEST

		taxiDTO5 = api.obtenerTaxi(taxiDTO5);
		// Set choferes = api.distinctNative();
		//
		// for( Iterator it = choferes.iterator(); it.hasNext();) {
		// Taxi x = (Taxi)it.next();
		// System.out.println(x.getChofer());
		//
		// }

		PedidoDTO pedidoDTO = new PedidoDTO(2, "fecha", "hora", "EFECTIVO", usuarioDTO, taxiDTO);
		pedidoDTO = api.crearPedido(pedidoDTO);

		// Testeo modificarlo
		pedidoDTO.setFecha("Nueva fechaa");
		api.actualizarPedido(pedidoDTO);

		// Testeo modificarlo
		pedidoDTO.setFecha("Nueva fechaa");
		api.actualizarPedido(pedidoDTO);

		PedidoDTO pedidoDTO1 = new PedidoDTO(20, "26-09-2015", "08:10", "DEBITO", usuarioDTO, taxiDTO5);
		pedidoDTO1 = api.crearPedido(pedidoDTO1);

		PedidoDTO pedidoDTO2 = new PedidoDTO(20, "16-10-2015", "00:00", "CREDITO", usuarioDTO, taxiDTO5);
		pedidoDTO2 = api.crearPedido(pedidoDTO2);

		// recupero el pedido de la bd
		System.out.println(api.obtenerPedido(pedidoDTO).getId());
		System.out.println(api.obtenerPedido(pedidoDTO).getUsuario().getNombre());
		System.out.println(api.obtenerPedido(pedidoDTO).getUsuario().getApellido());
		System.out.println(api.obtenerPedido(pedidoDTO).getTaxi().getEmpresa());

		// for (Taxi t : api.listarTaxis()) {
		// System.out.println(t.getId());
		// System.out.println(t.getPatente());
		// }

		for (TaxiDTO t : api.listarTaxisLibres()) {
			System.out.println(t.getId());
			System.out.println(t.getPatente());
		}

		System.out.println("El chofer con mas viajes realizados fue: " + api.listarChoferConMasViajesRealizados());
		
		api.contarChoferes();
		
//		System.out.println(api.distinctNative());
	}

}
