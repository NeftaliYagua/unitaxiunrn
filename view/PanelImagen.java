package view;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;

public class PanelImagen extends javax.swing.JPanel {
	private String nameImage;

	public PanelImagen(String nameImage) {
		this.setNameImage(nameImage);
		this.setSize(400, 280);
	}

	@Override
	public void paintComponent(Graphics g) {
		Dimension tamanio = getSize();
		ImageIcon imagenFondo = new ImageIcon(getClass().getResource("/imagenes/" + getNameImage()));
		g.drawImage(imagenFondo.getImage(), 0, 0, tamanio.width, tamanio.height, null);
		setOpaque(false);
		super.paintComponent(g);
	}

	public String getNameImage() {
		return nameImage;
	}

	public void setNameImage(String nameImage) {
		this.nameImage = nameImage;
	}

}