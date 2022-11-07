package ventanas;

import grafico.Board;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MenuPausa extends JFrame implements ActionListener {
	
	JPanel panel1;
	JLabel pausa;
	Boton cont, reinit, menu, salir;
	
	public MenuPausa() {
		super("Space Invaders AAT"); //Nome
		PanelImagen p = new PanelImagen();
        setContentPane(p);
        setSize(800,700); //Tamaño ventana
        setDefaultCloseOperation(0); //Que non se poda pechar a ventana en x
        setResizable(false); //Que non se poda cambiar o tamaño da ventana
        setLayout(new GridBagLayout());
        setLocationRelativeTo(null);
        
        //Declaro colores para o fondo e as etiquetas dos paneles
        Color co= new Color(255,255,102);
        Color col= new Color(255,0,255);
        
        //Crease panel e daselle un color de fondo
        panel1 = new JPanel();
        panel1.setBackground(co);
        
        pausa = new JLabel("Pausa");
        pausa.setForeground(col);
        cont = new Boton("CONTINUAR", 200, 110);
        cont.setForeground(Color.BLACK);
        cont.setFocusPainted(false);
        reinit = new Boton("REINICIAR", 200, 110);
        reinit.setForeground(Color.BLACK);
        reinit.setFocusPainted(false);
        menu = new Boton("SALIR AL MENU", 200, 110);
        menu.setForeground(Color.BLACK);
        menu.setFocusPainted(false);
        salir = new Boton("SALIR", 200, 110);
        salir.setForeground(Color.BLACK);
        salir.setFocusPainted(false);
        cont.addActionListener(this);
        reinit.addActionListener(this);
        menu.addActionListener(this);
        salir.addActionListener(this);
        
        //Añadese a etiqueta o panel
	    panel1.add(pausa);
        
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
		c.fill=GridBagConstraints.BOTH; 
		c.weightx=1.0; 
		c.weighty=1.0;
		c.insets=new Insets(20,200,20,200); 
		add(cont,c);
		
		c.gridx=0; 
		c.gridy=2;	
		c.gridwidth=1; 
		c.gridheight=1; 
		c.anchor=GridBagConstraints.CENTER; 
		c.fill=GridBagConstraints.BOTH; 
		c.weightx=1.0; 
		c.weighty=1.0;
		c.insets=new Insets(20,200,20,200); 
		add(reinit,c);
		
		c.gridx=0; 
		c.gridy=3;	
		c.gridwidth=1; 
		c.gridheight=1; 
		c.anchor=GridBagConstraints.CENTER; 
		c.fill=GridBagConstraints.BOTH; 
		c.weightx=1.0;  
		c.weighty=1.0;
		c.insets=new Insets(20,200,20,200); 
		add(menu,c);
		
		c.gridx=0; 
		c.gridy=4;	
		c.gridwidth=1; 
		c.gridheight=1; 
		c.anchor=GridBagConstraints.CENTER; 
		c.fill=GridBagConstraints.BOTH; 
		c.weightx=1.0;  
		c.weighty=1.0;
		c.insets=new Insets(20,200,20,200); 
		add(salir,c);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("CONTINUAR")) {
			dispose();
			Xogo.frame.setVisible(true); //volvese a visualizar o frame do xogo
			Board.timer.restart(); //restaurase o xogo
			Board.ovni.resume(); //volvese a mover o ovni
		}		
		if (e.getActionCommand().equals("REINICIAR")) {
			Xogo jug = new Xogo();
			dispose();
			jug.setVisible(true);
		}
		if (e.getActionCommand().equals("SALIR AL MENU")) {
			Menu men = new Menu();
			dispose();
			men.setVisible(true);
		}
		if (e.getActionCommand().equals("SALIR")) {
			System.exit(0); //Pechar programa
		}
		
	}

}
