package grafico;

import java.awt.Image;

import javax.swing.ImageIcon;

public class LaserA extends LaserN{

	Image imag;
	//hereda de LaserN todas as propiedades e metodos
	public LaserA(int x, int y) {
		super(x, y);
		imag = new ImageIcon(getClass().getResource("/imagenes/laserA.png")).getImage();
	}
		
	public Image getImag() {
		return imag;
	}

	//creo un novo metodo porque non se move igual que LaserN
	public void moverAb(){
		y++;
		
		if(y >= 700) //cando chegue a posicion 700 deixa de ser visible
			 visible = false;
    }
}
