package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import controller.PedidosController;
import model.Pedido;
import model.Usuario;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class DetallePedidoView extends JFrame {

	private JPanel jPanel1;
	private JTextField textFieldFechaYHora;
	private JTextField textFieldEstado;
	private JTextField textFieldPatente;
	private JTextField textFieldChofer;
	private JTextField textFieldEmpresa;
	private JTable tableMensajes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DetallePedidoView frame = new DetallePedidoView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DetallePedidoView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 622, 441);
		// contentPane = new JPanel();
		// contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		// contentPane.setLayout(new BorderLayout(0, 0));
		// setContentPane(contentPane);

		jPanel1 = new JPanel();
		getContentPane().add(jPanel1, BorderLayout.CENTER);
		jPanel1.setLayout(null);
		jPanel1.setFont(new java.awt.Font("Dialog", 0, 14));
		jPanel1.setPreferredSize(new java.awt.Dimension(323, 338));

		JLabel lblTaxiAsignado = new JLabel("Taxi asignado");
		lblTaxiAsignado.setFont(new java.awt.Font("Segoe UI", 0, 16));
		lblTaxiAsignado.setBounds(325, 78, 104, 25);
		jPanel1.add(lblTaxiAsignado);

		JLabel lblPatente = new JLabel("Patente");
		lblPatente.setBounds(325, 117, 63, 14);
		jPanel1.add(lblPatente);

		JLabel lblChofer = new JLabel("Chofer");
		lblChofer.setBounds(450, 114, 63, 14);
		jPanel1.add(lblChofer);

		JLabel lblEmpresa = new JLabel("Empresa");
		lblEmpresa.setBounds(325, 166, 63, 14);
		jPanel1.add(lblEmpresa);

		JLabel lblDescripcionDelPedido = new JLabel("Descripcion del pedido");
		lblDescripcionDelPedido.setFont(new java.awt.Font("Segoe UI", 0, 16));
		lblDescripcionDelPedido.setBounds(55, 78, 190, 19);
		jPanel1.add(lblDescripcionDelPedido);

		JLabel lblNroDePedido = new JLabel("Fecha y hora");
		lblNroDePedido.setBounds(55, 114, 87, 14);
		jPanel1.add(lblNroDePedido);

		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setBounds(55, 163, 46, 14);
		jPanel1.add(lblEstado);

		JLabel lblDetalleDelPedido = new JLabel("Detalle del pedido");
		lblDetalleDelPedido.setFont(new java.awt.Font("Segoe UI", 0, 18));
		lblDetalleDelPedido.setBounds(227, 11, 177, 34);
		jPanel1.add(lblDetalleDelPedido);

		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.setBounds(240, 358, 122, 34);
		jPanel1.add(btnCerrar);

		textFieldFechaYHora = new JTextField();
		textFieldFechaYHora.setEditable(false);
		textFieldFechaYHora.setBounds(55, 137, 132, 20);
		jPanel1.add(textFieldFechaYHora);
		textFieldFechaYHora.setColumns(10);

		textFieldEstado = new JTextField();
		textFieldEstado.setEditable(false);
		textFieldEstado.setBounds(55, 185, 132, 20);
		jPanel1.add(textFieldEstado);
		textFieldEstado.setColumns(10);

		textFieldPatente = new JTextField();
		textFieldPatente.setEditable(false);
		textFieldPatente.setBounds(325, 135, 104, 20);
		jPanel1.add(textFieldPatente);
		textFieldPatente.setColumns(10);

		textFieldChofer = new JTextField();
		textFieldChofer.setEditable(false);
		textFieldChofer.setBounds(450, 134, 100, 20);
		jPanel1.add(textFieldChofer);
		textFieldChofer.setColumns(10);

		textFieldEmpresa = new JTextField();
		textFieldEmpresa.setEditable(false);
		textFieldEmpresa.setBounds(325, 188, 104, 20);
		jPanel1.add(textFieldEmpresa);
		textFieldEmpresa.setColumns(10);

		JLabel lblMensajes = new JLabel("Mensajes");
		lblMensajes.setBounds(54, 226, 77, 25);
		jPanel1.add(lblMensajes);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(55, 251, 495, 99);
		{
			TableModel taxisTableModel = new DefaultTableModel(new String[][] { { "Sin mensajes..." } },
					new String[] { "Notificación del taxista" });
			tableMensajes = new JTable();

			scrollPane.setViewportView(tableMensajes);
			tableMensajes.setModel(taxisTableModel);
			tableMensajes.setBounds(24, 335, 586, 88);
			tableMensajes.setPreferredSize(new java.awt.Dimension(580, 160));
		}
		jPanel1.add(scrollPane);
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				// DetallePedidoView.this.setVisible(false);
				// PedidosController.getInstance().crearVistaPedido();
				DetallePedidoView.this.setVisible(false);
			}
		});
	}

	public void setMensajesTable(String m) {
		DefaultTableModel model = (DefaultTableModel) this.getTableMensajes().getModel();
		if (model.getValueAt(0, 0) == "Sin mensajes...")
			model.removeRow(0);
		Object[] newRow = { m };
		model.addRow(newRow);
		tableMensajes.setModel(model);

	}

	public JTextField getTextFieldFechaYHora() {
		return textFieldFechaYHora;
	}

	public void setTextFieldFechaYHora(JTextField textFieldFechaYHora) {
		this.textFieldFechaYHora = textFieldFechaYHora;
	}

	public JTextField getTextFieldEstado() {
		return textFieldEstado;
	}

	public void setTextFieldEstado(JTextField textFieldEstado) {
		this.textFieldEstado = textFieldEstado;
	}

	public JTextField getTextFieldPatente() {
		return textFieldPatente;
	}

	public void setTextFieldPatente(JTextField textFieldPatente) {
		this.textFieldPatente = textFieldPatente;
	}

	public JTextField getTextFieldChofer() {
		return textFieldChofer;
	}

	public void setTextFieldChofer(JTextField textFieldChofer) {
		this.textFieldChofer = textFieldChofer;
	}

	public JTextField getTextFieldEmpresa() {
		return textFieldEmpresa;
	}

	public void setTextFieldEmpresa(JTextField textFieldEmpresa) {
		this.textFieldEmpresa = textFieldEmpresa;
	}

	public JTable getTableMensajes() {
		return tableMensajes;
	}

	public void setTableMensajes(JTable tableMensajes) {
		this.tableMensajes = tableMensajes;
	}

}
