package ventanas;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;

public class PanelImagen extends javax.swing.JPanel {
	public PanelImagen(){
		this.setSize(1000,900);
	}
	@Override
	public void paintComponent (Graphics g){
		Dimension tamanio = getSize(); //Tamaño que se lle vai dar a imaxe(toda a ventana)
		//Collese a imagen
		ImageIcon imagenFondo = new ImageIcon(getClass().getResource("/imagenes/fondoprincipal.png"));
		//Debuxase na posicion asignada
		g.drawImage(imagenFondo.getImage(),0,0,tamanio.width, tamanio.height, null);
		//Que non sea opaca
		setOpaque(false);
		super.paintComponent(g);
	}
}
