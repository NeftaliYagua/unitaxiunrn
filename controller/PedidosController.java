package controller;

import java.awt.Point;
import java.awt.Window;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.table.DefaultTableModel;

import model.Pedido;
import model.RadioTaxi;
import model.Taxi;
import view.FactoriaDeVentanas;
import view.PedidoView;
import view.RadioTaxiView;


public class PedidosController {
	private RadioTaxi radioTaxi;
	private static PedidosController ctrl = null;
	
	
	private PedidosController() {
		// TODO Auto-generated constructor stub
	}
	
	public static PedidosController getInstance(){
		if (ctrl == null) {
			ctrl = new PedidosController();
		}
		return ctrl;
	}	
	
	public static void main(String[] args) {
		//PedidoView pedidoView = new PedidoView();
		//pedidoView.setVisible(true);
		Taxi t = new Taxi("abc 123","El rey","Licenciado","el 28 mil", Taxi.Estado.OCUPADO);
		Taxi t2 = new Taxi("yyy 321","Roberrrrrrto","Licena2","el 28 mil", Taxi.Estado.LIBRE);
		RadioTaxi radioTaxi = new RadioTaxi();
		radioTaxi.addTaxi(t);
		radioTaxi.addTaxi(t2);
		PedidosController ctrl = PedidosController.getInstance();	
		ctrl.crearVista(radioTaxi);
		ctrl.crearVistaPedido();
	}
	
	public void crearVista(RadioTaxi r){
		this.radioTaxi = r;
		DefaultTableModel modeloTaxis = this.crearTableModelDeTaxis((LinkedList<Taxi>) r.getListaDeTaxis());
		DefaultTableModel modeloPedidos = this.crearTableModelDePedidos((LinkedList<Pedido>) r.getPedidosPendientes());
		RadioTaxiView vista = FactoriaDeVentanas.getRadioTaxiInstance();
		//vista.limpiarVentana();
		vista.setTaxisTable(modeloTaxis);
		vista.setPedidosTable(modeloPedidos);
		//vista.actualizarVentana();
		vista.setLocationRelativeTo(null);			
		vista.setVisible(true);	
	}
	
	public void actualizarPedidos(Pedido p){
		this.radioTaxi.addPedidoPendiente(p);
		DefaultTableModel modeloPedidos = this.crearTableModelDePedidos((LinkedList<Pedido>) this.radioTaxi.getPedidosPendientes());
		RadioTaxiView vista = FactoriaDeVentanas.getRadioTaxiInstance();
		//vista.limpiarVentana();		
		vista.setPedidosTable(modeloPedidos);		
	}
	
	public void crearVistaPedido(){					
		PedidoView vista = FactoriaDeVentanas.getPedidoViewInstance();
		//vista.limpiarVentana();		
		//vista.actualizarVentana();		
		vista.setVisible(true);	
	}
	
	public DefaultTableModel crearTableModelDeTaxis(LinkedList<Taxi> listaTaxis){
		String[] titulosCol = {"Patente", "Chofer", "Empresa", "Estado"}; 
		DefaultTableModel modelo = new DefaultTableModel();
		modelo.setColumnIdentifiers(titulosCol);
		for (Taxi t : listaTaxis) {
			modelo.addRow(t.toArray());
		}
		return modelo;
	}
	
	public DefaultTableModel crearTableModelDePedidos(LinkedList<Pedido> listaPedidos){
		DefaultTableModel modelo = new DefaultTableModel();
		if (listaPedidos.isEmpty()) {
			String[] titulosCol = {""};			
			modelo.setColumnIdentifiers(titulosCol);
			String[] fila = {"No hay pedidos pendientes"};
			modelo.addRow(fila);
		}else{
			String[] titulosCol = {"Nombre y apellido", "fecha", "Estado"}; 			
			modelo.setColumnIdentifiers(titulosCol);
			for (Pedido p : listaPedidos) {
				modelo.addRow(p.toArray());
			}
		}
		return modelo;
	}
	
}


