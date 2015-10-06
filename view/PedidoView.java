package view;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import api.Servicio;
import controller.PedidosController;
import dto.PedidoDTO;
import dto.UsuarioDTO;

/**
 * This code was edited or generated using CloudGarden's Jigloo SWT/Swing GUI
 * Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose
 * whatever) then you should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details. Use of Jigloo implies
 * acceptance of these licensing terms. A COMMERCIAL LICENSE HAS NOT BEEN
 * PURCHASED FOR THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED LEGALLY FOR
 * ANY CORPORATE OR COMMERCIAL PURPOSE.
 */
public class PedidoView extends javax.swing.JFrame {
	private JPanel jPanel1;
	private JLabel titulo;
	private JTextField nombre;
	private JTextField apellido;
	private JLabel jLabel7;
	private JLabel jLabel6;
	private JComboBox tipoPago;
	private JLabel jLabel5;
	private JTextField direcc;
	private JTextField telefono;
	private JLabel jLabel4;
	private JButton enviar;
	private JTextField dni;
	private JLabel jLabel3;
	private JLabel jLabel2;
	private JLabel jLabel1;
	private Servicio api;

	/**
	 * Auto-generated main method to display this JFrame
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				PedidoView inst = new PedidoView();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}

	public PedidoView() {
		super();
		initGUI();
	}

	public void limpiarVentana() {
		nombre.setText("");
		apellido.setText("");
		direcc.setText("");
		dni.setText("");
		telefono.setText("");
		tipoPago.setSelectedIndex(0);
	}

	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				jPanel1 = new PanelImagen("fondo.jpg");
				setContentPane(jPanel1);

				Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/pedido.png"));
				setIconImage(icon);

				// getContentPane().add(jPanel1, BorderLayout.CENTER);
				jPanel1.setLayout(null);
				jPanel1.setPreferredSize(new java.awt.Dimension(668, 422));
				{
					titulo = new JLabel();
					jPanel1.add(titulo);
					titulo.setText("Ingrese sus datos");
					titulo.setFont(new java.awt.Font("Segoe UI", 0, 18));
					titulo.setBounds(24, 12, 170, 38);
				}
				{
					nombre = new JTextField();
					jPanel1.add(nombre);
					nombre.setBounds(23, 81, 205, 36);
				}
				{
					jLabel1 = new JLabel();
					jPanel1.add(jLabel1);
					jLabel1.setText("Nombre");
					jLabel1.setBounds(24, 62, 115, 16);
				}
				{
					jLabel2 = new JLabel();
					jPanel1.add(jLabel2);
					jLabel2.setText("Apellido");
					jLabel2.setBounds(24, 129, 187, 16);
				}
				{
					apellido = new JTextField();
					jPanel1.add(apellido);
					apellido.setBounds(24, 151, 205, 35);
				}
				{
					jLabel3 = new JLabel();
					jPanel1.add(jLabel3);
					jLabel3.setText("DNI");
					jLabel3.setBounds(24, 206, 44, 16);
				}
				{
					dni = new JTextField();
					jPanel1.add(dni);
					dni.setBounds(24, 228, 205, 34);
				}
				{
					enviar = new JButton();
					jPanel1.add(enviar);
					enviar.setText("Pedir un taxi");
					enviar.setBounds(352, 269, 189, 33);
					enviar.setFont(new java.awt.Font("Segoe UI", 0, 16));
					enviar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							api = Servicio.getInstance();
							UsuarioDTO u = new UsuarioDTO(nombre.getText(), apellido.getText(), dni.getText(),
									"mail hardcodeado", telefono.getText());
							u = api.crearUsuario(u);

							Date actual = new Date();
							SimpleDateFormat formatoHora = new SimpleDateFormat("hh:mm:ss");
							SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");

							PedidoDTO p = new PedidoDTO(100.0, formatoFecha.format(actual), formatoHora.format(actual),
									tipoPago.getSelectedItem().toString(), u, null);
							PedidosController ctrl = PedidosController.getInstance();
							ctrl.actualizarPedidos(p);
							limpiarVentana();
							// PedidoView.this.setVisible(false);
							// ctrl.crearVistaDetallePedido();
						}
					});
				}
				{
					jLabel4 = new JLabel();
					jPanel1.add(jLabel4);
					jLabel4.setText("Telefono");
					jLabel4.setBounds(24, 274, 103, 16);
				}
				{
					telefono = new JTextField();
					jPanel1.add(telefono);
					telefono.setBounds(24, 296, 205, 34);
				}
				{
					jLabel5 = new JLabel();
					jPanel1.add(jLabel5);
					jLabel5.setText("Ingrese su pedido");
					jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18));
					jLabel5.setBounds(340, 12, 170, 38);
				}
				{
					direcc = new JTextField();
					jPanel1.add(direcc);
					direcc.setBounds(340, 78, 210, 39);
				}
				{
					ComboBoxModel tipoPagoModel = new DefaultComboBoxModel(
							new String[] { "EFECTIVO", "DEBITO", "CREDITO" });
					tipoPago = new JComboBox();
					jPanel1.add(tipoPago);
					tipoPago.setModel(tipoPagoModel);
					tipoPago.setBounds(340, 149, 210, 37);
				}
				{
					jLabel6 = new JLabel();
					jPanel1.add(jLabel6);
					jLabel6.setText("Dirección destino");
					jLabel6.setBounds(340, 62, 102, 16);
				}
				{
					jLabel7 = new JLabel();
					jPanel1.add(jLabel7);
					jLabel7.setText("Forma de pago");
					jLabel7.setBounds(340, 128, 104, 16);
				}
			}
			pack();
			this.setSize(617, 414);
		} catch (Exception e) {
			// add your error handling code here
			e.printStackTrace();
		}
	}

}
