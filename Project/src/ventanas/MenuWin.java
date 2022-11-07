package ventanas;

import grafico.Puntuacion;
import grafico.Board;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MenuWin extends JFrame implements ActionListener{

	//Declaracion de paneles, etiquetas e botons
	JPanel panel1, panel2;
	JLabel ganar, puntu;
	Boton volver, salir;
	Puntuacion p;
	
	public MenuWin() {
		super("Space Invaders AAT"); //Nome
		PanelImagen p = new PanelImagen();
        setContentPane(p);
		setSize(400,350); //Tamaño ventana
		setResizable(false); //Que non se poda cambiar o tamaño da ventana
	    setDefaultCloseOperation(0); //Que non se poda pechar a ventana en x
	    setLayout(new GridBagLayout());
	    setLocationRelativeTo(null);
	    
	    //Declaro colores para o fondo e as etiquetas dos paneles
        Color co= new Color(255,255,102);
        Color col= new Color(255,0,255);
        
        //Creanse paneles e daselle un color de fondo
        panel1 = new JPanel();
        panel1.setBackground(co);
        panel2 = new JPanel();
        panel2.setBackground(co);
	            
	    ganar = new JLabel("WIN");
	    ganar.setForeground(col);
	    ganar.setFont(new Font("Lucida Sans", Font.BOLD, 16));
	    puntu = new JLabel("PUNTUACIÓN: "+Board.punt.getPunt());;
	    puntu.setForeground(col);
	    volver = new Boton("VOLVER", 200, 110);
	    volver.setFocusPainted(false);
	    volver.addActionListener(this);
	    salir = new Boton("SALIR", 200, 110);
	    salir.setFocusPainted(false);
	    salir.addActionListener(this);
	    
	    //Añadense as etiquetas os paneles
	    panel1.add(ganar);
	    panel2.add(puntu);
	     
	    GridBagConstraints c = new GridBagConstraints();			
	    c.gridx=0; // especifica a coordenada x			
	    c.gridy=0;	// coordenada y			
	    c.gridwidth=1; //número de celdas que ocupa no GridBagLayout			
	    c.gridheight=1; 			
	    c.anchor=GridBagConstraints.NORTH; //posición dentro dunha celda			
	    c.fill=GridBagConstraints.NORTH; //espacio que ocupara dentro dunha celda			
	    c.weightx=1.0; //porcentaxe de espazo libre que ocupara 			
	    c.weighty=1.0;			
	    c.insets=new Insets(10,10,10,10); //poñer marxes			
	    add(panel1,c);			
		
	    c.gridx=0; 	
	    c.gridy=1;		
	    c.gridwidth=1; 	
	    c.gridheight=1; 		
	    c.anchor=GridBagConstraints.CENTER; 	
	    c.fill=GridBagConstraints.CENTER; 		
	    c.weightx=1.0;  		
	    c.weighty=1.0;		
	    //c.insets=new Insets(20,200,20,200); 
	    add(panel2,c);			
			
	    c.gridx=0; 	
	    c.gridy=2;	
	    c.gridwidth=1; 	
	    c.gridheight=1; 		
	    c.anchor=GridBagConstraints.CENTER; 	
	    c.fill=GridBagConstraints.BOTH; 		
	    c.weightx=1.0;  		
	    c.weighty=1.0;		
	    //c.insets=new Insets(20,200,20,200); 	
	    add(volver,c);
	    
	    c.gridx=0; 		
	    c.gridy=3;		
	    c.gridwidth=1; 		
	    c.gridheight=1; 			
	    c.anchor=GridBagConstraints.CENTER; 	
	    c.fill=GridBagConstraints.BOTH; 			
	    c.weightx=1.0; 			
	    c.weighty=1.0;			
	    //c.insets=new Insets(20,200,20,200); 
		add(salir,c);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equals("VOLVER")) {
			Menu men = new Menu();
			Xogo.frame.dispose();
			dispose();
			men.setVisible(true);
			if (Sonido.sonido == true)
				Sonido.FONDO.loop();
		}
		if (e.getActionCommand().equals("SALIR")) {
			System.exit(0); //Pechar programa
		}
		
	}
	
}
