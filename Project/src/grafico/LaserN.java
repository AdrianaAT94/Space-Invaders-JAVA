package grafico;

import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

public class LaserN {

	Image img;
	int x, y, velocidad = 5;
	boolean visible;
	
	public LaserN(int x, int y) {
		img = new ImageIcon(getClass().getResource("/imagenes/laserN.png")).getImage();
		this.x = x;
        this.y = y;
        visible = true;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	
	public Image getImg() {
		return img;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}	
	
	public boolean isVisible() {
		return visible;
	}
	
	public Rectangle getPosition(){
        return new Rectangle(x, y, img.getWidth(null), img.getHeight(null));
    }
	
	public void moverAr(){
        y = y - velocidad;
        
        if(y<0) //cando chegue a posicion 0 deixa de ser visible
            visible = false;
	}
}
