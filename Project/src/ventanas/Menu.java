package ventanas;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class Menu extends JFrame implements ActionListener {

	//Botons menu
	Boton Jugar, Diseño, Sonido, Salir;
	Font fuente;
	
	public Menu(){
		super("Space Invaders AAT"); //Nome
        //declarar e colocar fondo
        PanelImagen p = new PanelImagen(); //Panel que conten a imaxe
        setContentPane(p); //Asignar panel
        setSize(800,700); //Tamaño ventana
        setDefaultCloseOperation(0); //Que non se poda pechar a ventana en x
        setResizable(false); //Que non se poda cambiar o tamaño da ventana
        setLayout(new GridBagLayout()); //Distribucion da ventana
        setLocationRelativeTo(null); //Colocar a ventana no centro
       
        //Crear botons e poñer a escoita
        Jugar = new Boton("Jugar", 200, 110); 
        Jugar.setForeground(Color.BLACK); //cambiar color de letras
        Jugar.setFocusPainted(false); //para que non sala o cuadro o redor das letras
        Diseño = new Boton("Diseño", 200, 110);
        Diseño.setForeground(Color.BLACK);
        Diseño.setFocusPainted(false);
		Sonido = new Boton("Sonido", 200, 110);
		Sonido.setForeground(Color.BLACK);
		Sonido.setFocusPainted(false);
		Salir = new Boton("Salir", 200, 110);
		Salir.setForeground(Color.BLACK);
		Salir.setFocusPainted(false);
		Jugar.addActionListener(this);
		Diseño.addActionListener(this);
		Sonido.addActionListener(this);
		Salir.addActionListener(this);	
		
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
		add(Jugar,c);
		
		c.gridx=0; 
		c.gridy=1;	
		c.gridwidth=1; 
		c.gridheight=1; 
		c.anchor=GridBagConstraints.CENTER; 
		c.fill=GridBagConstraints.BOTH; 
		c.weightx=1.0; 
		c.weighty=1.0;
		c.insets=new Insets(20,200,20,200); 
		add(Diseño,c);
		
		c.gridx=0; 
		c.gridy=2;	
		c.gridwidth=1; 
		c.gridheight=1; 
		c.anchor=GridBagConstraints.CENTER; 
		c.fill=GridBagConstraints.BOTH; 
		c.weightx=1.0; 
		c.weighty=1.0;
		c.insets=new Insets(20,200,20,200); 
		add(Sonido,c);
		
		c.gridx=0; 
		c.gridy=3;	
		c.gridwidth=1; 
		c.gridheight=1; 
		c.anchor=GridBagConstraints.CENTER; 
		c.fill=GridBagConstraints.BOTH; 
		c.weightx=1.0; 
		c.weighty=1.0;
		c.insets=new Insets(20,200,20,200); 
		add(Salir,c);
	}

	public void actionPerformed(ActionEvent e) {	
		if (e.getActionCommand().equals("Jugar")) {
			Xogo jug = new Xogo();
			dispose(); //elimina ventana
			jug.setVisible(true);
		}
		if (e.getActionCommand().equals("Diseño")) {
			Diseño dis = new Diseño();
			dispose();
			dis.setVisible(true);
		}
		if (e.getActionCommand().equals("Sonido")) {
			Sonido son = new Sonido();
			dispose();
			son.setVisible(true);
		}
		if (e.getActionCommand().equals("Salir")) {
			System.exit(0); //Pechar programa
		}
	}
}
