package ventanas;

import java.applet.Applet;
import javax.swing.JFrame;

public class Main extends JFrame {
	//A clase que se ejecuta que vai empezar no menu
	Menu menu;
	public Main() {
		menu = new Menu();
		menu.setVisible(true);
		//o fondo iniaciase na main posto que esta en todas as clases salvo que se poña sonido off
		Sonido.FONDO = Applet.newAudioClip(Sonido.class.getResource("/sonidos/fondo.wav"));
		//sonido empeza on
		Sonido.sonido=true;
	}

    public static void main(String[] args) {
        new Main();
        Sonido.FONDO.loop();
    }
}
