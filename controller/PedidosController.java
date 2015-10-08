package controller;

import java.util.LinkedList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import api.Servicio;
import dto.PedidoDTO;
import dto.TaxiDTO;
import model.RadioTaxi;
import view.DetallePedidoView;
import view.FactoriaDeVentanas;
import view.PedidoView;
import view.RadioTaxiView;
import view.TaxiView;

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
		// Taxi t = new Taxi("abc 123", "El rey", "Licenciado", "el 28 mil",
		// true);
		// Taxi t2 = new Taxi("yyy 321", "Roberrrrrrto", "Licena2", "el 28 mil",
		// true);

		// Creo la api
		Servicio api = Servicio.getInstance();
		TaxiDTO t = new TaxiDTO("abc 123", "El rey", "Licenciado", "el 28 mil", true);
		TaxiDTO t2 = new TaxiDTO("yyy 321", "Roberrrrrrto", "Licena2", "el 28 mil", true);
		api.crearTaxi(t);
		api.crearTaxi(t2);

		// RadioTaxi radioTaxi = new RadioTaxi();
		// radioTaxi.addTaxi(t);
		// radioTaxi.addTaxi(t2);
		PedidosController ctrl = PedidosController.getInstance();
		ctrl.crearVista();
		ctrl.crearVistaPedido();

	}

	public void crearVista() {
		Servicio api = Servicio.getInstance();
		// this.radioTaxi = r;
		DefaultTableModel modeloTaxis = this.crearTableModelDeTaxis(new LinkedList<TaxiDTO>(api.listarTaxis()));
		DefaultTableModel modeloPedidos = this.crearTableModelDePedidos(new LinkedList<PedidoDTO>(api.listarPedidos()));
		RadioTaxiView vista = FactoriaDeVentanas.getRadioTaxiInstance();
		// vista.limpiarVentana();
		vista.setTaxisTable(modeloTaxis);
		vista.setPedidosTable(modeloPedidos);
		// vista.actualizarVentana();
		vista.setLocationRelativeTo(null);
		vista.setVisible(true);
	}

	public void actualizarPedidos(PedidoDTO p) {
		Servicio api = Servicio.getInstance();
		// this.radioTaxi.addPedidoPendiente(p);
		api.crearPedido(p);
		DefaultTableModel modeloPedidos = this
				.crearTableModelDePedidos(new LinkedList<PedidoDTO>(api.listarPedidosPendientes()));
		RadioTaxiView vista = FactoriaDeVentanas.getRadioTaxiInstance();
		// vista.limpiarVentana();
		vista.setPedidosTable(modeloPedidos);
	}

	public void actualizarPedidos() {
		Servicio api = Servicio.getInstance();
		RadioTaxiView vista = FactoriaDeVentanas.getRadioTaxiInstance();
		DefaultTableModel modeloPedidos = this
				.crearTableModelDePedidos(new LinkedList<PedidoDTO>(api.listarPedidosPendientes()));
		vista.setPedidosTable(modeloPedidos);
	}

	public void actualizarTaxis() {
		Servicio api = Servicio.getInstance();
		RadioTaxiView vista = FactoriaDeVentanas.getRadioTaxiInstance();
		// if (!this.radioTaxi.getListaDeTaxis().isEmpty()) {
		DefaultTableModel modeloTaxis = this.crearTableModelDeTaxis(new LinkedList<TaxiDTO>(api.listarTaxis()));
		vista.setTaxisTable(modeloTaxis);
		// } else {
		// // No hay taxis
		// }
	}

	public void liberarTaxi(TaxiDTO taxiDTO) {
		Servicio api = Servicio.getInstance();
		// for (Taxi t : this.radioTaxi.getListaDeTaxis()) {
		// t.equals(taxi);
		// }
		taxiDTO.setLibre(true);
		api.actualizarTaxi(taxiDTO);
		actualizarTaxis();
	}

	public void crearVistaPedido() {
		PedidoView vista = FactoriaDeVentanas.getPedidoViewInstance();
		vista.setVisible(true);
	}

	public DetallePedidoView crearDetallePedido(PedidoDTO p) {
		DetallePedidoView vista = new DetallePedidoView();

		Servicio api = Servicio.getInstance();
		p = api.obtenerPedido(p);

		vista.getTextFieldFechaYHora().setText(p.getFecha() + " " + p.getHora());
		vista.getTextFieldEstado().setText(p.getEstado());
		vista.getTextFieldChofer().setText(p.getTaxi().getChofer());
		vista.getTextFieldPatente().setText(p.getTaxi().getPatente());
		vista.getTextFieldEmpresa().setText(p.getTaxi().getEmpresa());
		vista.getLblUsuario().setText(vista.getLblUsuario().getText() + " " + p.getUsuario().getNombre() + " "
				+ p.getUsuario().getApellido());
		vista.getLblDni().setText(vista.getLblDni().getText() + " " + p.getUsuario().getDni());

		vista.setVisible(true);
		return vista;
	}

	public DefaultTableModel crearTableModelDeTaxis(LinkedList<TaxiDTO> listaTaxis) {

		DefaultTableModel modelo = new DefaultTableModel();
		if (listaTaxis.isEmpty()) {
			String[] titulosCol = { "" };
			modelo.setColumnIdentifiers(titulosCol);
			String[] fila = { "No hay taxis para mostar" };
			modelo.addRow(fila);
		} else {
			String[] titulosCol = { "Patente", "Chofer", "Empresa", "Estado" };

			modelo.setColumnIdentifiers(titulosCol);
			for (TaxiDTO t : listaTaxis) {
				modelo.addRow(t.toArray());
			}
		}
		return modelo;

	}

	public DefaultTableModel crearTableModelDePedidos(LinkedList<PedidoDTO> listaPedidos) {
		DefaultTableModel modelo = new DefaultTableModel();
		if (listaPedidos.isEmpty()) {
			String[] titulosCol = { "" };
			modelo.setColumnIdentifiers(titulosCol);
			String[] fila = { "No hay pedidos pendientes" };
			modelo.addRow(fila);
		} else {
			String[] titulosCol = { "Nombre y apellido", "fecha", "Estado" };
			modelo.setColumnIdentifiers(titulosCol);
			for (PedidoDTO p : listaPedidos) {
				modelo.addRow(p.toArray());
			}
		}
		return modelo;
	}

	public void gestionarPedido() {
		Servicio api = Servicio.getInstance();
		try {
			// Pedido p = radioTaxi.asignarTaxi();
			// this.actualizarPedidos();
			// this.actualizarTaxis();
			//
			// TaxiView tView = new TaxiView(p, this.crearDetallePedido(p));
			// tView.setVisible(true);
			// tView.setLocationRelativeTo(null);

			PedidoDTO pedidoDTO = api.listarPedidosPendientes().get(0);
			// pedidoDTO.setEstado("EN_CURSO");
			// pedidoDTO = api.actualizarPedido(pedidoDTO);
			// Asigno el taxi
			pedidoDTO = api.asignarUnTaxi(pedidoDTO, api.listarTaxisLibres().get(0));

			this.actualizarPedidos();
			this.actualizarTaxis();

			TaxiView tView = new TaxiView(pedidoDTO, this.crearDetallePedido(pedidoDTO));
			tView.setVisible(true);
			tView.setLocationRelativeTo(null);
		} catch (Exception e) {
			System.out.println("Mostrar mensaje: " + e.getMessage());
			JOptionPane.showMessageDialog(null, e.getMessage(), "Ocurrio un error", JOptionPane.WARNING_MESSAGE);
		}

	}

}
