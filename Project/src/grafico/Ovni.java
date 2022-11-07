package grafico;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

public class Ovni extends Thread {	 
	
	Image img;
	int x, y, velocidad;
	boolean visible, empezaov;
	
	public Ovni() {
		//posicion do ovni e velocidad
		x = -50;
		y = 0;
		velocidad = 3;
		img = new ImageIcon(getClass().getResource("/imagenes/ovni.png")).getImage();
		visible = true;
		empezaov = true; //booleano que marca o comezo do fio
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	
	public int getX() {
		return x;
	}	
	
	public boolean isVisible() {
		return visible;
	}

	public Rectangle getPosition(){
        return new Rectangle(x, y, img.getWidth(null), img.getHeight(null));
    }

	public void mover() {
		if (x < 800) 
			x = x + velocidad;
		if (x >=800)
			x = -50;		
	}
	
	public void pintar(Graphics g) {
		g.drawImage(img, x, y, null);
	}	
	
	public void run() {	
		while(empezaov) {			
			try {
				if (x == -50) {
					Thread.sleep(10000); //cada vez que se poña o principio espera 10 segundos
				}
				mover(); //que se vaia movendo cada 20ms
				Thread.sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
