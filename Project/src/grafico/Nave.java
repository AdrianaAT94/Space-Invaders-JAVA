package grafico;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import ventanas.Diseño;
import ventanas.Sonido;

public class Nave {
	
	Image img;
	int x, y, velocidad;
	boolean disparo;
	ArrayList<LaserN> lasers;
	LaserN lN;	
	AudioClip LNAVE, COLISION;
	
	public Nave(){
		
		if (Diseño.imgnav == null)  //sinon se elige ningun, por defecto
			img = new ImageIcon(getClass().getResource("/imagenes/nave1.png")).getImage();
		else 
			img = Diseño.imgnav;	
				
		if (Sonido.sonido == true) {
			LNAVE = Applet.newAudioClip(Sonido.class.getResource("/sonidos/lnave.wav"));
			COLISION = Applet.newAudioClip(Sonido.class.getResource("/sonidos/colision.wav"));
		}
		
		lasers = new ArrayList<LaserN>(); //ArrayList que vai ter os lasers
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}
	
	public void setDisparo(boolean disparo) {
		this.disparo = disparo;
	}
	
	public boolean isDisparo() {
		return disparo;
	}	
	
	public Rectangle getPosition(){
        return new Rectangle(x, y, img.getWidth(null), img.getHeight(null));
    }
	
	public  void moverD() {
		if(x < 750)		
			x = x + velocidad;
	}
	
	public void moverE() {
		if(x > 0)
			x = x - velocidad;
	}
	
	public void disparo(){
		lasers.add(new LaserN(x + img.getWidth(null)/2, y)); //que sala na posicion da nave(no medio as x)
		disparo = true;
		if (Sonido.sonido == true)
			LNAVE.play();
	}
		
	public void pintar(Graphics g){
		g.drawImage(img, x, y, null);
	}
	
	public void pintaLaserN(Graphics g){
		for(int i = 0; i < lasers.size(); i++){ //recorre o tamaño  do arraylist
            lN = lasers.get(i); //e vaise creando 
            g.drawImage(lN.getImg(), lN.getX(), lN.getY(), null); //dibujase na posicion
        }
	}
	
	public void borraLaserN() {
		for(int i = 0; i < lasers.size(); i++){	 		 
			lN = lasers.get(i);
			if(lN.isVisible()) //si e visible
				lN.moverAr(); //movese
			else //sinon e visible
                lasers.remove(i); //borrase do arraylist
		}
	}
	
	public void acertaAlien(Alien alien) { //pasaselle como argumento o alien co que choca
		for(int l = 0; l < lasers.size(); l++){
			lN = lasers.get(l);
			if (lN.getPosition().intersects(alien.getPosition()) && lN.isVisible() && alien.isVisible()) {
				//si o laser creado choca co ovni e ambos son visibles
    			//deixan de ser visibles e sumase a puntuacion
				alien.setVisible(false);
				lN.setVisible(false);
				//vanse restando o numero dos aliens de cada matriz cando se
				//pon a true a cadansua variable
				//menos no ultimo que se gaña. 5 niveis
				Board.quedan1--;
				if (Board.mas2 == true) {
					Board.quedan2--;
				}
				if (Board.mas3 == true) {
					Board.quedan3--;
				}
				if (Board.mas4 == true) {
					Board.quedan4--;
				}
				if (Board.mas5 == true) {
					Board.quedan5--;
				}
				Board.punt.setPunt(Board.punt.punt+10);
				if(Board.quedan5 <= 0)
					Board.win();
				if (Sonido.sonido == true)
					COLISION.play();
            }            
		}
	}
	
	public void acertaOvni() {
		for(int l = 0; l < lasers.size(); l++){
    		lN = lasers.get(l);
    		if (lN.getPosition().intersects(Board.ovni.getPosition()) && lN.isVisible() && Board.ovni.isVisible()) {
    			//si o laser creado choca co ovni e ambos son visibles
    			//deixan de ser visibles e sumase a puntuacion
    			Board.ovni.setVisible(false);
    			lN.setVisible(false);
    			Board.punt.setPunt(Board.punt.punt+100);
    			if (Sonido.sonido == true)
    				COLISION.play();
    		}
		}
	}
}
