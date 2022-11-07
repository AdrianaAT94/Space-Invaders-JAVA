package grafico;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import ventanas.Diseño;

public class Fondo {
	
	Image img;
	int x,y;
	
	public Fondo(){
		
		if (Diseño.imgfon == null) { //sinon se elige ningun, por defecto
			img = new ImageIcon(getClass().getResource("/imagenes/fondo1.png")).getImage();
				
		}
		else {
			img = Diseño.imgfon;
		}		
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setImg(Image img) {
		this.img = img;
	}

	public void pintar(Graphics g){
		g.drawImage(img, x, y, null);
	}
}
