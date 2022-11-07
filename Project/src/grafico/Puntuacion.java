package grafico;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Puntuacion {

	int punt;
	
	public Puntuacion() {
		punt=0;
	}
	
	public void setPunt(int punt) {
		this.punt = punt;
	}
	
	public int getPunt() {
		return punt;
	}	
	
	public void pintar(Graphics g) {
		g.setColor(Color.GRAY); //Color.
  		g.setFont(new Font("Verdana", Font.BOLD, 30)); //Tipo de letra.
  		g.drawString(String.valueOf(getPunt()), 10, 30); //Posicion donde se dibuja
	}
}
