package ventanas;

import grafico.Board;
import javax.swing.JFrame;

public class Xogo extends JFrame {
	
	public static Xogo frame; //creo a estatica para despois poder escondelo o pulsar p no jpanel
	
    public Xogo(){   	
    	super("Space Invaders AAT"); //Nome
        add(new Board());
        frame = this;
        setSize(800, 700); //Tamaño da ventana.
		setResizable(false); //Que non se poda cambiar o tamaño da ventana
		setVisible(true); //Que se vexa a ventana.
		setLocationRelativeTo(null); //Colocar a ventana no centro
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Poder cerrar a ventana.
    }
}
