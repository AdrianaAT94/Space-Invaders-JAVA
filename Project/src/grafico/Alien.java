package grafico;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;
import ventanas.Diseño;
import ventanas.Sonido;

public class Alien {

	Image img;
	int x, y, velocidad, direccion, movimientoX, movimientoY;
	boolean bajar, visible;
	ArrayList<LaserA> lasers;
	LaserA lA;
	Random aleatorio;
	AudioClip LALIEN, EXPLOSION;
  
	public Alien() {
		
		if (Diseño.imgal == null) //sinon se elige ningun, por defecto
			img = new ImageIcon(getClass().getResource("/imagenes/alien1.png")).getImage();			
		else 
			img = Diseño.imgal;		
		
		if (Sonido.sonido==true) {
			LALIEN = Applet.newAudioClip(Sonido.class.getResource("/sonidos/lalien.wav"));	
			EXPLOSION = Applet.newAudioClip(Sonido.class.getResource("/sonidos/explosion.wav"));
		}
		
	    movimientoX = 0; //conta o que se desplaza nas x
		direccion = 1; // 1 = dereita, -1 = esquerda
		visible = true; //variable que indica si e visible ou no
		bajar = false; //variable que indica si debe baixar
		movimientoY = 0; //conta o que se desplaza nas y
		lasers = new ArrayList<LaserA>(); //ArrayList que vai ter os lasers
		aleatorio = new Random(); //aleatorio a partir do cal se van dibujar os lasers dos aliens
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
	
	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public Image getImg() {
		return img;
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

	public void mover(){
		/* 
		 * si x chejou o borde
		 * 		ponse a 0 para que se volva a contar o desplazado de x
		 * 		podese baixar
		 * 		cambiase a direccion
		 * si se pode baixar
		 * 		y baixa con velocidad
		 * 		empezase a contar o desplazado de y
		 * 		si o desplazado de y é maior que o alto da imagen (neste caso sería 20)
		 * 		xa acabou de baixar polo que non se para de baixar
		 * 		ponse a 0 para que se volva a contar o desplazado de x
		 * si non baixa
		 * 		x movese ca velocidad e ca direccion correspondente
		 * 		e empezase a contar o desplazado de x
		 */
		
        if(movimientoX>490){
            movimientoX = 0;
            bajar = true;
            direccion*=-1;
        }

        if(bajar){
            y = y + velocidad;
            movimientoY+= velocidad;
            if(movimientoY > img.getHeight(null)) {
                bajar = false;
                movimientoY = 0;
            }
        } else {
            x += velocidad * direccion;
            movimientoX+= velocidad;
        }
	}
	
	public void pintaLaserA(Graphics g) {
		for(int i = 0; i < lasers.size(); i++){ //recorre o tamaño do arraylist
            lA = lasers.get(i); //e vaise creando  
            g.drawImage(lA.getImag(), lA.getX(), lA.getY(), null);//dibujase na posicion
            if(lA.isVisible()) //si e visible
                lA.moverAb(); //movese
            else //sinon e visible
                lasers.remove(i); //borrase do arraylist
        }
	}
	
	public void disparan() {
		if(aleatorio.nextInt()%700==1 && y < 730) { //para que disparen cando o aleatorio sea 1 e mentras non cheje a posicion 730
            lasers.add(new LaserA(x, y)); //que sala na posicion do alien   
            if (Sonido.sonido==true)
            	LALIEN.play();
		}
	}
	
	public void pintar(Graphics g){
		g.drawImage(img, x, y, null); //una vez que e dibuja empeze a moverse e disparar
		mover();
		disparan();	
	}
	
	public void acerta() {
		for(int i = 0; i < lasers.size(); i++){
            lA = lasers.get(i);
            if (lA.getPosition().intersects(Board.nave.getPosition())) { //si o laser creado choca ca nave
            	lA.setVisible(false); // o laser deixa de ser visible
            	Board.gameOver(); //perdese    
            	if (Sonido.sonido==true)
            		EXPLOSION.play(); 
            }
		}
	}
}
