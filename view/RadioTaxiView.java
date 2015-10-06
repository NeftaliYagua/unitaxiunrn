package view;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import controller.PedidosController;

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
public class RadioTaxiView extends javax.swing.JFrame {
	private JPanel jPanel1;
	private JLabel jLabel3;
	private JTable taxisTable;
	private JScrollPane jScrollPane1;
	private JScrollPane jScrollPane2;
	private JButton asignarTaxi;
	private JTable pedidosTable;
	private JLabel jLabel2;
	private JLabel jLabel1;

	/**
	 * Auto-generated main method to display this JFrame
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				RadioTaxiView inst = new RadioTaxiView();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}

	public RadioTaxiView() {
		super();
		initGUI();
	}

	public void setTaxisTable(DefaultTableModel model) {
		taxisTable.setModel(model);

	}

	public void setPedidosTable(DefaultTableModel model) {
		pedidosTable.setModel(model);

	}

	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				jPanel1 = new PanelImagen("fondo.jpg");
				setContentPane(jPanel1);

				Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/icono.png"));
				setIconImage(icon);

				// getContentPane().add(jPanel1, "Center");
				jPanel1.setLayout(null);
				jPanel1.setBounds(0, 0, 684, 517);

				{
					jLabel1 = new JLabel();
					jPanel1.add(jLabel1);
					jLabel1.setText("Radio taxi");
					jLabel1.setBounds(271, 12, 151, 25);
					jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 22));
				}
				{
					jLabel2 = new JLabel();
					jPanel1.add(jLabel2);
					jLabel2.setText("Pedidos");
					jLabel2.setBounds(24, 55, 97, 19);
					jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 16));
				}
				{
					jLabel3 = new JLabel();
					jPanel1.add(jLabel3);
					jLabel3.setText("Taxis");
					jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 16));
					jLabel3.setBounds(24, 301, 95, 19);
				}
				{
					jScrollPane1 = new JScrollPane();
					jPanel1.add(jScrollPane1);
					jScrollPane1.setBounds(24, 85, 586, 170);
					{
						TableModel pedidosTableModel = new DefaultTableModel(
								new String[][] { { "One", "Two" }, { "Three", "Four" } },
								new String[] { "Column 1", "Column 2" });
						pedidosTable = new JTable();
						jScrollPane1.setViewportView(pedidosTable);
						pedidosTable.setModel(pedidosTableModel);
						pedidosTable.setBounds(24, 80, 586, 146);
						pedidosTable.setPreferredSize(new java.awt.Dimension(568, 167));
					}
				}
				{
					jScrollPane2 = new JScrollPane();
					jPanel1.add(jScrollPane2);
					jScrollPane2.setBounds(24, 326, 583, 163);
					{
						TableModel taxisTableModel = new DefaultTableModel(
								new String[][] { { "One", "Two" }, { "Three", "Four" } },
								new String[] { "Column 1", "Column 2" });
						taxisTable = new JTable();
						jScrollPane2.setViewportView(taxisTable);
						taxisTable.setModel(taxisTableModel);
						taxisTable.setBounds(24, 335, 586, 88);
						taxisTable.setPreferredSize(new java.awt.Dimension(580, 160));
					}
				}
				{
					asignarTaxi = new JButton();
					jPanel1.add(asignarTaxi);
					asignarTaxi.setText("Asignar un taxi");
					asignarTaxi.setBounds(468, 283, 139, 32);
					asignarTaxi.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							PedidosController ctrl = PedidosController.getInstance();
							 ctrl.gestionarPedido();
						}
					});
				}
			}
			pack();
			this.setSize(700, 556);
		} catch (Exception e) {
			// add your error handling code here
			e.printStackTrace();
		}
	}

}
