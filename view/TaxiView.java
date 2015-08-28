package view;
import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import model.Pedido;
import model.Taxi;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class TaxiView extends javax.swing.JFrame {
	private JPanel jPanel1;
	private JLabel lalbel;
	private JButton sendMsj;
	private JLabel jLabel2;
	private JTextField msj;
	private JButton cambiarEstado;
	private JButton botonLibre;
	private JLabel jLabel1;
	private JLabel nombreTaxi;
	private Pedido pedido;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				TaxiView inst = new TaxiView();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public TaxiView() {
		super();
		initGUI();
	}
	
	public TaxiView(Pedido pedido) {
		super();
		this.pedido = pedido;			
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				jPanel1 = new JPanel();
				getContentPane().add(jPanel1, BorderLayout.CENTER);
				jPanel1.setLayout(null);
				jPanel1.setFont(new java.awt.Font("Dialog",0,14));
				jPanel1.setPreferredSize(new java.awt.Dimension(323, 338));
				{
					lalbel = new JLabel();
					jPanel1.add(lalbel);
					lalbel.setText("Taxi");
					lalbel.setBounds(12, 12, 38, 28);
					lalbel.setFont(new java.awt.Font("Segoe UI",0,18));
				}
				{
					nombreTaxi = new JLabel();
					jPanel1.add(nombreTaxi);
					nombreTaxi.setText(this.pedido.getTaxi().getPatente().toString());
					nombreTaxi.setFont(new java.awt.Font("Segoe UI",0,18));
					nombreTaxi.setBounds(53, 12, 258, 28);
				}
				{
					jLabel1 = new JLabel();
					jPanel1.add(jLabel1);
					jLabel1.setText("Estado");
					jLabel1.setFont(new java.awt.Font("Segoe UI",0,16));
					jLabel1.setBounds(12, 52, 114, 28);
				}
				{
					botonLibre = new JButton();
					jPanel1.add(botonLibre);
					botonLibre.setText("Taxi Libre");
					botonLibre.setBounds(12, 86, 90, 34);
					botonLibre.setEnabled(false);
				}
				{
					cambiarEstado = new JButton();
					jPanel1.add(cambiarEstado);
					cambiarEstado.setText("Cambiar estado");
					cambiarEstado.setBounds(126, 85, 145, 35);
				}
				{
					msj = new JTextField();
					jPanel1.add(msj);
					msj.setBounds(12, 178, 281, 33);
				}
				{
					jLabel2 = new JLabel();
					jPanel1.add(jLabel2);
					jLabel2.setText("Enviar un mensaje");
					jLabel2.setBounds(12, 157, 96, 16);
				}
				{
					sendMsj = new JButton();
					jPanel1.add(sendMsj);
					sendMsj.setText("Enviar ");
					sendMsj.setBounds(293, 178, 74, 33);
				}
			}
			pack();
			this.setSize(400, 290);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}

}
