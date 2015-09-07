package controller;

import java.util.LinkedList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import ar.unrn.bd2.model.Pedido;
import ar.unrn.bd2.model.RadioTaxi;
import ar.unrn.bd2.model.Taxi;
import ar.unrn.bd2.view.DetallePedidoView;
import ar.unrn.bd2.view.FactoriaDeVentanas;
import ar.unrn.bd2.view.PedidoView;
import ar.unrn.bd2.view.RadioTaxiView;
import ar.unrn.bd2.view.TaxiView;

public class PedidosController {
	private RadioTaxi radioTaxi;
	private static PedidosController ctrl = null;

	private PedidosController() {
		// TODO Auto-generated constructor stub
	}

	public static PedidosController getInstance() {
		if (ctrl == null) {
			ctrl = new PedidosController();
		}
		return ctrl;
	}

	public static void main(String[] args) {
		// PedidoView pedidoView = new PedidoView();
		// pedidoView.setVisible(true);
		Taxi t = new Taxi("abc 123", "El rey", "Licenciado", "el 28 mil", Taxi.Estado.LIBRE);
		Taxi t2 = new Taxi("yyy 321", "Roberrrrrrto", "Licena2", "el 28 mil", Taxi.Estado.LIBRE);
		RadioTaxi radioTaxi = new RadioTaxi();
		radioTaxi.addTaxi(t);
		radioTaxi.addTaxi(t2);
		PedidosController ctrl = PedidosController.getInstance();
		ctrl.crearVista(radioTaxi);
		ctrl.crearVistaPedido();

	}

	public void crearVista(RadioTaxi r) {
		this.radioTaxi = r;
		DefaultTableModel modeloTaxis = this.crearTableModelDeTaxis((LinkedList<Taxi>) r.getListaDeTaxis());
		DefaultTableModel modeloPedidos = this.crearTableModelDePedidos((LinkedList<Pedido>) r.getPedidosPendientes());
		RadioTaxiView vista = FactoriaDeVentanas.getRadioTaxiInstance();
		// vista.limpiarVentana();
		vista.setTaxisTable(modeloTaxis);
		vista.setPedidosTable(modeloPedidos);
		// vista.actualizarVentana();
		vista.setLocationRelativeTo(null);
		vista.setVisible(true);
	}

	public void actualizarPedidos(Pedido p) {
		this.radioTaxi.addPedidoPendiente(p);
		DefaultTableModel modeloPedidos = this
				.crearTableModelDePedidos((LinkedList<Pedido>) this.radioTaxi.getPedidosPendientes());
		RadioTaxiView vista = FactoriaDeVentanas.getRadioTaxiInstance();
		// vista.limpiarVentana();
		vista.setPedidosTable(modeloPedidos);
	}

	public void actualizarPedidos() {
		RadioTaxiView vista = FactoriaDeVentanas.getRadioTaxiInstance();
		DefaultTableModel modeloPedidos = this
				.crearTableModelDePedidos((LinkedList<Pedido>) this.radioTaxi.getPedidosPendientes());
		vista.setPedidosTable(modeloPedidos);
	}

	public void actualizarTaxis() {
		RadioTaxiView vista = FactoriaDeVentanas.getRadioTaxiInstance();
		if (!this.radioTaxi.getListaDeTaxis().isEmpty()) {

			DefaultTableModel modeloTaxis = this
					.crearTableModelDeTaxis((LinkedList<Taxi>) this.radioTaxi.getListaDeTaxis());
			vista.setTaxisTable(modeloTaxis);
		} else {
			// No hay taxis
		}
	}

	public void liberarTaxi(Taxi taxi) {

		for (Taxi t : this.radioTaxi.getListaDeTaxis()) {
			t.equals(taxi);
		}
		actualizarTaxis();
	}

	public void crearVistaPedido() {
		PedidoView vista = FactoriaDeVentanas.getPedidoViewInstance();
		vista.setVisible(true);
	}

	public DetallePedidoView crearDetallePedido(Pedido p) {
		DetallePedidoView vista = new DetallePedidoView();

		vista.getTextFieldFechaYHora().setText(p.getFecha() + " " + p.getHora());
		vista.getTextFieldEstado().setText(p.getEstado().name());
		vista.getTextFieldChofer().setText(p.getTaxi().getChofer());
		vista.getTextFieldPatente().setText(p.getTaxi().getPatente());
		vista.getTextFieldEmpresa().setText(p.getTaxi().getEmpresa());
		vista.getLblUsuario().setText(vista.getLblUsuario().getText() + " " + p.getUsuario().getNombre() + " "
				+ p.getUsuario().getApellido());
		vista.getLblDni().setText(vista.getLblDni().getText() + " " + p.getUsuario().getDni());
		
		vista.setVisible(true);
		return vista;
	}

	public DefaultTableModel crearTableModelDeTaxis(LinkedList<Taxi> listaTaxis) {
		String[] titulosCol = { "Patente", "Chofer", "Empresa", "Estado" };
		DefaultTableModel modelo = new DefaultTableModel();
		modelo.setColumnIdentifiers(titulosCol);
		for (Taxi t : listaTaxis) {
			modelo.addRow(t.toArray());
		}
		return modelo;
	}

	public DefaultTableModel crearTableModelDePedidos(LinkedList<Pedido> listaPedidos) {
		DefaultTableModel modelo = new DefaultTableModel();
		if (listaPedidos.isEmpty()) {
			String[] titulosCol = { "" };
			modelo.setColumnIdentifiers(titulosCol);
			String[] fila = { "No hay pedidos pendientes" };
			modelo.addRow(fila);
		} else {
			String[] titulosCol = { "Nombre y apellido", "fecha", "Estado" };
			modelo.setColumnIdentifiers(titulosCol);
			for (Pedido p : listaPedidos) {
				modelo.addRow(p.toArray());
			}
		}
		return modelo;
	}

	public void gestionarPedido() {

		try {
			Pedido p = radioTaxi.asignarTaxi();
			this.actualizarPedidos();
			this.actualizarTaxis();

			TaxiView tView = new TaxiView(p,this.crearDetallePedido(p));
			tView.setVisible(true);
			tView.setLocationRelativeTo(null);
			
		} catch (Exception e) {
			System.out.println("Mostrar mensaje: " + e.getMessage());
			JOptionPane.showMessageDialog(null, e.getMessage(), "Ocurrio un error", JOptionPane.WARNING_MESSAGE);
		}

	}

}
