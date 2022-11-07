package grafico;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

import ventanas.Xogo;
import ventanas.MenuGameOver;
import ventanas.MenuPausa;
import ventanas.MenuWin;
import ventanas.Sonido;

public class Board extends JPanel implements KeyListener,ActionListener {

	public static Timer timer; //fio de java que leva todo
	public static Nave nave; //nave
	public static Alien[][] alien1, alien2, alien3, alien4, alien5; //matrices dos aliens de cada nivel
	public static Ovni ovni; //fio do ovni
	public static Puntuacion punt; //puntuacion
	public static int columnas, filas, quedan1, quedan2, quedan3, quedan4, quedan5;  //o numero de aliens //enteiro que  vai levar a conta dos aliens de cada matriz
	public static boolean mas2, mas3, mas4, mas5; //booleana que da paso o seguinte nivel
 	Fondo fon;	//fondo
 	boolean abajo; //booleana que indica cando unha matriz chegou abaixo
 	static AudioClip GAMEOVER, WIN;
	
	public Board(){
		setDoubleBuffered(true);
        addKeyListener(this);
		setFocusable(true); //Recibe as notificacions do teclado.
		setSize(800, 700);
		
		if (Sonido.sonido == true) {
			GAMEOVER = Applet.newAudioClip(Sonido.class.getResource("/sonidos/gameover.wav"));
			WIN = Applet.newAudioClip(Sonido.class.getResource("/sonidos/win.wav"));
		}
		
		//daselle un numero de aliens
		//inicianse as booleanas a false
		columnas = 8;
		filas = 4;
		abajo = false;	
		mas2 = false;
		mas3 = false;
		mas4 = false;
		mas5 = false;
		
		//NAVE
		nave = new Nave();
		nave.setX(getWidth()/2);
		nave.setY(600); //coloca abaixo
		nave.setVelocidad(5);
		nave.setDisparo(true);
		
		//MATRICES ALIENS	
		alien1 = new Alien[columnas][filas];
		alien2 = new Alien[columnas][filas];
		alien3 = new Alien[columnas][filas];
		alien4 = new Alien[columnas][filas];
		alien5 = new Alien[columnas][filas];
		//recorrese a matriz
		for(int i = 0; i < columnas; i++) {
            for(int j = 0; j < filas; j++){
	        	quedan1 = columnas * filas;
            	alien1[i][j] = new Alien();
            	alien1[i][j].setVelocidad(2);
            	//vanse colocando en cada posicion e deixando margen entre uns e outros
            	alien1[i][j].setX(20 + i*alien1[i][j].getImg().getWidth(null) + i*3/*margen*/);
            	alien1[i][j].setY(20 + j*alien1[i][j].getImg().getHeight(null) + j*3);
            	
            	quedan2 = columnas * filas;
            	alien2[i][j] = new Alien();
            	alien2[i][j].setVelocidad(3);
            	alien2[i][j].setX(20 + i*alien2[i][j].getImg().getWidth(null) + i*3);
            	alien2[i][j].setY(20 + j*alien2[i][j].getImg().getHeight(null) + j*3);
            	
            	quedan3 = columnas * filas;
            	alien3[i][j] = new Alien();
            	alien3[i][j].setVelocidad(4);
            	alien3[i][j].setX(20 + i*alien3[i][j].getImg().getWidth(null) + i*3);
            	alien3[i][j].setY(20 + j*alien3[i][j].getImg().getHeight(null) + j*3);
            	
            	quedan4 = columnas * filas;
            	alien4[i][j] = new Alien();
            	alien4[i][j].setVelocidad(5);
            	alien4[i][j].setX(20 + i*alien4[i][j].getImg().getWidth(null) + i*3);
            	alien4[i][j].setY(20 + j*alien4[i][j].getImg().getHeight(null) + j*3);
            	
            	quedan5 = columnas * filas;
            	alien5[i][j] = new Alien();
            	alien5[i][j].setVelocidad(6);
            	alien5[i][j].setX(20 + i*alien5[i][j].getImg().getWidth(null) + i*3);
            	alien5[i][j].setY(20 + j*alien5[i][j].getImg().getHeight(null) + j*3);            
            }
		}
       
							
		//FONDO
		fon = new Fondo();
		fon.setX(0);
		fon.setY(0);
		
		//OVNI
		ovni = new Ovni();
		ovni.start();
		
		//PUNTUACION 
		punt = new Puntuacion();
				
		timer = new Timer(15, this);
        timer.start();	         
        
	}
	
	public void paint(Graphics g) {
		super.paint(g);	
		//FONDO
		fon.pintar(g);
		
		//NAVE
		nave.pintar(g);	
		
		//LASER NAVE
        nave.pintaLaserN(g);
        
        //ALIENS
        pintaAlien1(g);
        //cada vez que se pase un nivel activase a variable 
        //e cambiase a matriz que conleva mais velocidad e un cambio de fondo
        if (mas2==true) {
        	pintaAlien2(g);
        	fon.setImg(new ImageIcon(getClass().getResource("/imagenes/esp2.jpg")).getImage());
        }
        if (mas3==true) {
        	pintaAlien3(g);
        	fon.setImg(new ImageIcon(getClass().getResource("/imagenes/esp3.jpg")).getImage());
        }
        if (mas4==true){
        	pintaAlien4(g);
        	fon.setImg(new ImageIcon(getClass().getResource("/imagenes/esp4.jpg")).getImage());        	
        }
        if (mas5==true) {
        	pintaAlien5(g);
        	fon.setImg(new ImageIcon(getClass().getResource("/imagenes/esp5.jpg")).getImage());        	
        }
        
        //OVNI
        if (ovni.isVisible()) { //si o ovni e visible
        	ovni.pintar(g); //pintase e inciase o fio
        	ovni.empezaov = true;
        } 
		else { //sinon e visible colocase o principio e volvese facer visible
			ovni.setX(-50);
			ovni.setVisible(true);
		}        
        
        //PUNTUACION 
        punt.pintar(g);
	}
	
	//metodos que van dibujar as matrices de cada nivel
	public void pintaAlien1(Graphics g) {
		//ALIEN1 
		//recorrese a matriz
        for(int i = 0; i < columnas; i++) {
        	for(int j = 0; j < filas; j++) {
            	if(alien1[i][j].isVisible())
            		alien1[i][j].pintar(g);    

            	if (alien1[i][j].getY() >=570) { //cando chegue abaixo perder
            		timer.stop();
            		if(!abajo) {
            			gameOver();
            		}
            		abajo=true;
            		//para que solo se abra cando cheje o primeiro
            		//sinon abririase o gameover por cada alien que toque abaixo
            	}
    
            	//LASER ALIEN1
            	alien1[i][j].pintaLaserA(g);                         	  
        	}
        }
        
        if (quedan1 == 0) //cando non queden aliens na matriz
    		mas2 = true;	//ponse a true a variable que vai cambiar de nivel
   	}
	
	public void pintaAlien2(Graphics g) {
		//ALIEN2
		 for(int i = 0; i < columnas; i++) {
			 for(int j = 0; j < filas; j++) {
				 if(alien2[i][j].isVisible()) 
					 alien2[i][j].pintar(g);   
				 
				 if (alien2[i][j].getY() >=570) { //cando chegue abaixo perder   
					 timer.stop();
					 if(!abajo) {
						 gameOver();
					 }
					 abajo=true;
					 //para que solo se abra cando cheje o primeiro
					 //sinon abririase o gameover por cada alien que toque abaixo
				 }

            	//LASER ALIEN2                      
            	alien2[i][j].pintaLaserA(g);
			 }
		 }
		 
		 if (quedan2 == 0) 
	    	mas3 = true;		     
	}
	
	public void pintaAlien3(Graphics g) {
		//ALIEN3
		 for(int i = 0; i < columnas; i++) {
			 for(int j = 0; j < filas; j++) {
				 if(alien3[i][j].isVisible()) 
					 alien3[i][j].pintar(g);   
				 
				 if (alien3[i][j].getY() >=570) { //cando chegue abaixo perder   
					 timer.stop();
					 if(!abajo) {
						 gameOver();
					 }
					 abajo=true;
					 //para que solo se abra cando cheje o primeiro
					 //sinon abririase o gameover por cada alien que toque abaixo
				 }

            	//LASER ALIEN3                       
            	alien3[i][j].pintaLaserA(g);       	     
			 }
		 }
		 
		 if (quedan3 == 0) 
	    	mas4 = true;
	}
	
	public void pintaAlien4(Graphics g) {
		//ALIEN4
		 for(int i = 0; i < columnas; i++) {
			 for(int j = 0; j < filas; j++) {
				 if(alien4[i][j].isVisible()) 
					 alien4[i][j].pintar(g);   
				 
				 if (alien4[i][j].getY() >=570) { //cando chegue abaixo perder   
					 timer.stop();
					 if(!abajo) {
						 gameOver();
					 }
					 abajo=true;
					 //para que solo se abra cando cheje o primeiro
					 //sinon abririase o gameover por cada alien que toque abaixo
				 }

            	//LASER ALIEN4                      
            	alien4[i][j].pintaLaserA(g);            		        	   
			 }
		 }
		 
		 if (quedan4 == 0) 
 	    	mas5 = true;
	}
	
	public void pintaAlien5(Graphics g) {
		//ALIEN5
		 for(int i = 0; i < columnas; i++) {
			 for(int j = 0; j < filas; j++) {
				 if(alien5[i][j].isVisible()) 
					 alien5[i][j].pintar(g);   
				 
				 if (alien5[i][j].getY() >=570) { //cando chegue abaixo perder   
					 timer.stop();
					 if(!abajo) {
						 gameOver();
					 }
					 abajo=true;
					 //para que solo se abra cando cheje o primeiro
					 //sinon abririase o gameover por cada alien que toque abaixo
				 }

				 //LASER ALIEN5                      
				 alien5[i][j].pintaLaserA(g);     
				 
				 //aqui non se activa ningunha variable porque e o ultimo nivel
			 }
		 }
	}
		
	@Override
	public void keyTyped(KeyEvent e) {}
	
	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode(); //collese a tecla pulsada
		
		if(key == KeyEvent.VK_RIGHT) //si e a flecha dereita
			nave.moverD(); //movese a nave a dereita
	
		if(key == KeyEvent.VK_LEFT) //si e a flecha esquerda
			nave.moverE(); //movese a nave a esquerda
	
		if (e.getKeyCode() == KeyEvent.VK_P) { //si e a tecla p
        	MenuPausa men = new MenuPausa();   //abre o menu pausa
        	Xogo.frame.setVisible(false); //aqui agachase mentras estea o menu pausa
        	//non se pode cerrar "dispose()" porque si non despois non se poderia continuar a partida
        	men.setVisible(true); //faise visible o menu
        	timer.stop(); //parase o xogo
        	ovni.suspend(); //para parar o ovni
        }
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode(); //collese a tecla soltada
		
		if(key == KeyEvent.VK_SPACE) { //si e o espacio
			nave.setDisparo(true); //activase o disparo			
			nave.disparo(); //e disparase
			//ten que ser cando e soltada e non pulsada porque si non poderiase faser
			//unha tira de lasers e tamen consumiria moitos mais recursos
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//o que vai facer sempre
		nave.borraLaserN();
		for(int i = 0; i < columnas; i++) {
            for(int j = 0; j < filas; j++) {
            	alien1[i][j].acerta();              	
            	nave.acertaAlien(alien1[i][j]); 
            	if (mas2==true) { //para que non os pinte ainda que non se vexan
            		alien2[i][j].acerta();
            		nave.acertaAlien(alien2[i][j]);
            	}
            	if (mas3==true) {
            		alien3[i][j].acerta();
            		nave.acertaAlien(alien3[i][j]);
            	}
            	if (mas4==true) {
            		alien4[i][j].acerta();
            		nave.acertaAlien(alien4[i][j]);
            	}    
            	if (mas5==true) {
            		alien5[i][j].acerta();
            		nave.acertaAlien(alien5[i][j]);
            	}    
            }
		}				
		nave.acertaOvni();
        repaint();
      
	}	
	
	public static void gameOver() {
		MenuGameOver menu = new MenuGameOver();
		menu.setVisible(true);		
		timer.stop();
		ovni.empezaov = false;
		if (Sonido.sonido == true) {
			Sonido.FONDO.stop();
			GAMEOVER.play();
		}
	}
	
	public static void win() {
		MenuWin menu = new MenuWin();
		menu.setVisible(true);		
		timer.stop();
		ovni.empezaov = false;
		if (Sonido.sonido == true) {
			Sonido.FONDO.stop();
			WIN.play();
		}
	}
}
