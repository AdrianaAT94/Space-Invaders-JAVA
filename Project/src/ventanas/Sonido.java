package ventanas;

import java.applet.AudioClip;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Sonido extends JFrame implements ActionListener {

	Boton On, Off, Atras;
	//booleana que controla o sonido
	public static boolean sonido;
	public static AudioClip FONDO;
	
	public Sonido() {
		super("Space Invaders AAT"); //Nome
        //declarar e colocar fondo
        PanelImagen p = new PanelImagen(); //Panel que conten a imaxe
        setContentPane(p); //Asignar panel
		setLayout(new GridBagLayout());
		setSize(800,700);
		setResizable(false); //Que non se poda cambiar o tamaño da ventana
	    setDefaultCloseOperation(0); //Que non se poda pechar a ventana en x
		setLocationRelativeTo(null);
	
		//Crear botons e poñer a escoita
		On = new Boton("ON", 200, 110);
		On.setFocusPainted(false);
		//por defecto con sonido
		On.setIcon(new ImageIcon(getClass().getResource("/imagenes/check.png")));
		Off = new Boton("OFF", 200, 110);
		Off.setFocusPainted(false);
		Atras = new Boton("Atrás", 240, 150);
		Atras.setFocusPainted(false);
		On.addActionListener(this);
		Off.addActionListener(this);
		Atras.addActionListener(this);
		
		GridBagConstraints c = new GridBagConstraints();
		c.gridx=0; // especifica a coordenada x
		c.gridy=0;	// coordenada y
		c.gridwidth=1; //número de celdas que ocupa no GridBagLayout
		c.gridheight=1; 
		c.anchor=GridBagConstraints.CENTER; //posición dentro dunha celda
		c.fill=GridBagConstraints.BOTH; //espacio que ocupara dentro dunha celda
		c.weightx=1.0; //porcentaxe de espazo libre que ocupara 
		c.weighty=1.0;
		c.insets=new Insets(20,200,20,200); //poñer marxes
		add(On,c);
		
		c.gridx=0; 
		c.gridy=1;	
		c.gridwidth=1; 
		c.gridheight=1; 
		c.anchor=GridBagConstraints.CENTER; 
		c.fill=GridBagConstraints.BOTH; 
		c.weightx=1.0; 
		c.weighty=1.0;
		c.insets=new Insets(20,200,20,200); 
		add(Off,c);
		
		c.gridx=0; 
		c.gridy=2;	
		c.gridwidth=1; 
		c.gridheight=1; 
		c.anchor=GridBagConstraints.CENTER; 
		c.fill=GridBagConstraints.BOTH; 
		c.weightx=1.0; 
		c.weighty=1.0;
		c.insets=new Insets(100,20,100,300); 
		add(Atras,c);

	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("ON")) {
			On.setIcon(new ImageIcon(getClass().getResource("/imagenes/check.png")));
			Off.setIcon(null);
			Sonido.FONDO.loop();
			sonido = true;
		}
		if (e.getActionCommand().equals("OFF")) {
			Off.setIcon(new ImageIcon(getClass().getResource("/imagenes/check.png")));
			On.setIcon(null);
			Sonido.FONDO.stop();
			sonido = false;
		}
		if (e.getActionCommand().equals("Atrás")) {
			Menu menu = new Menu();
			dispose();
			menu.setVisible(true);
		}
	}
}