package ventanas;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Diseño extends JFrame implements ActionListener{

	//Declaracion de paneles, etiquetas e botons
	JPanel panel1, panel2, panel3;
	JLabel Fondo, Alien, Nave;
	ButtonGroup grupoaliens, gruponaves, grupofondos;
	JRadioButton al1, al2, al3, nav1, nav2, nav3, fon1, fon2, fon3;
	Boton Atras;
	
	
	//estaticas
	public static Image imgal, imgnav, imgfon;
	
	
	public Diseño () {
		super("Space Invaders AAT"); //Nome
        //declarar e colocar fondo
        PanelImagen p = new PanelImagen(); //Panel que conten a imaxe
        setContentPane(p); //Asignar panel
        setSize(800,700); //Tama�o ventana
        setResizable(false); //Que non se poda cambiar o tamaño da ventana
        setDefaultCloseOperation(0); //Que non se poda pechar a ventana en x
        setLayout(new GridBagLayout());
        setLocationRelativeTo(null);
		
        //Crear grupos de botons e etiquetas
        //Poñer a escoita
        //Dar color o texto das etiquetas e insertar imaxes nos botons
        //por defecto marcado o 1 de cada grupo
      	
        grupoaliens = new ButtonGroup();
        gruponaves = new ButtonGroup();
        grupofondos = new ButtonGroup();
        
        //Declaro colores para o fondo e as etiquetas dos paneles
        Color co= new Color(255,255,102);
        Color col= new Color(255,0,255);
        
        //Creanse paneles e daselle un color de fondo
        panel1 = new JPanel();
        panel1.setBackground(co);
        panel2 = new JPanel(); 
        panel2.setBackground(co);
        panel3 = new JPanel();
        panel3.setBackground(co);
        
        Atras = new Boton("Atrás", 240, 150);
        Atras.setFocusPainted(false);
        Atras.addActionListener(this);
        Fondo = new JLabel("Fondo");
        Fondo.setFont(new Font("Lucida Sans", Font.BOLD, 16));
        Fondo.setForeground(col);
        Alien = new JLabel("Alien");
        Alien.setFont(new Font("Lucida Sans", Font.BOLD, 16));
        Alien.setForeground(col);
        Nave = new JLabel("Nave");
        Nave.setFont(new Font("Lucida Sans", Font.BOLD, 16));
        Nave.setForeground(col);
 
        //crear radiobuttons
        al1 = new JRadioButton(new ImageIcon(getClass().getResource("/imagenes/alien1.png")));
		al1.addActionListener(this);
		al2 = new JRadioButton(new ImageIcon(getClass().getResource("/imagenes/alien2.png")));
		al2.setBackground(Color.BLACK);
		al2.addActionListener(this);
		al3 = new JRadioButton(new ImageIcon(getClass().getResource("/imagenes/alien3.png")));
		al3.setBackground(Color.BLACK);
		al3.addActionListener(this);
		nav1 = new JRadioButton(new ImageIcon(getClass().getResource("/imagenes/nave1.png")));
		nav1.addActionListener(this);
		nav2 = new JRadioButton(new ImageIcon(getClass().getResource("/imagenes/nave2.png")));
		nav2.setBackground(Color.BLACK);
		nav2.addActionListener(this);
		nav3 = new JRadioButton(new ImageIcon(getClass().getResource("/imagenes/nave3.png")));
		nav3.setBackground(Color.BLACK);
		nav3.addActionListener(this);
		fon1 = new JRadioButton(new ImageIcon(getClass().getResource("/imagenes/btfondo1.png")));
		fon1.addActionListener(this);
		fon2 = new JRadioButton(new ImageIcon(getClass().getResource("/imagenes/btfondo2.png")));
		fon2.setBackground(Color.BLACK);
		fon2.addActionListener(this);
		fon3 = new JRadioButton(new ImageIcon(getClass().getResource("/imagenes/btfondo3.png")));
		fon3.setBackground(Color.BLACK);
		fon3.addActionListener(this);
		
		//selecionados
        al1.setSelected(true);
        nav1.setSelected(true);
        fon1.setSelected(true);
	
		//añadir a grupos
		grupoaliens.add(al1);
		grupoaliens.add(al2);
		grupoaliens.add(al3);
		
		gruponaves.add(nav1);
		gruponaves.add(nav2);
		gruponaves.add(nav3);
		
		grupofondos.add(fon1);
		grupofondos.add(fon2);
		grupofondos.add(fon3);
		
		//Añadense as etiquetas os paneles
		panel1.add(Fondo);
		panel2.add(Nave);
		panel3.add(Alien);
		
		//añadir listeners
		al1.addActionListener(this);
		al2.addActionListener(this);
		al3.addActionListener(this);
		nav1.addActionListener(this);
		nav2.addActionListener(this);
		nav3.addActionListener(this);
		fon1.addActionListener(this);
		fon2.addActionListener(this);
		fon3.addActionListener(this);
		
		
		//FONDO
		GridBagConstraints c = new GridBagConstraints();	
		c.gridx=0; // especifica a coordenada x
		c.gridy=0;	// coordenada y
		c.gridwidth=3; //número de celdas que ocupa no GridBagLayout
		c.gridheight=1; 
		c.anchor=GridBagConstraints.CENTER; //posición dentro dunha celda
		c.fill=GridBagConstraints.CENTER; //espacio que ocupara dentro dunha celda
		c.weightx=1.0; //porcentaxe de espazo libre que ocupara 
		c.weighty=1.0;
		c.insets=new Insets(10,10,10,10);
		add(panel1,c);
		
		c.gridx=0; 
		c.gridy=1;	
		c.gridwidth=1; 
		c.gridheight=1; 
		c.anchor=GridBagConstraints.CENTER; 
		c.fill=GridBagConstraints.CENTER; 
		c.weightx=1.0; 
		c.weighty=1.0;
		c.insets=new Insets(10,10,10,10); 
		add(fon1,c);
		
		c.gridx=1; 
		c.gridy=1;	
		c.gridwidth=1; 
		c.gridheight=1; 
		c.anchor=GridBagConstraints.CENTER; 
		c.fill=GridBagConstraints.CENTER; 
		c.weightx=1.0; 
		c.weighty=1.0;
		c.insets=new Insets(10,10,10,10); 
		add(fon2,c);
		
		c.gridx=2; 
		c.gridy=1;	
		c.gridwidth=1; 
		c.gridheight=1; 
		c.anchor=GridBagConstraints.CENTER; 
		c.fill=GridBagConstraints.CENTER; 
		c.weightx=1.0; 
		c.weighty=1.0;
		c.insets=new Insets(10,10,10,10); 
		add(fon3,c);
		
		//NAVE
		c.gridx=0; 
		c.gridy=2;	
		c.gridwidth=3; 
		c.gridheight=1; 
		c.anchor=GridBagConstraints.CENTER; 
		c.fill=GridBagConstraints.CENTER;
		c.weightx=1.0; 
		c.weighty=1.0;
		c.insets=new Insets(10,10,10,10); 
		add(panel2,c);
		
		c.gridx=0; 
		c.gridy=3;
		c.gridwidth=1; 
		c.gridheight=1; 
		c.anchor=GridBagConstraints.CENTER; 
		c.fill=GridBagConstraints.CENTER; 
		c.weightx=1.0; 
		c.weighty=1.0;
		c.insets=new Insets(10,10,10,10); 
		add(nav1,c);
		
		c.gridx=1; 
		c.gridy=3;	
		c.gridwidth=1; 
		c.gridheight=1; 
		c.anchor=GridBagConstraints.CENTER; 
		c.fill=GridBagConstraints.CENTER; 
		c.weightx=1.0; 
		c.weighty=1.0;
		c.insets=new Insets(10,10,10,10); 
		add(nav2,c);
		
		c.gridx=2; 
		c.gridy=3;	
		c.gridwidth=1; 
		c.gridheight=1; 
		c.anchor=GridBagConstraints.CENTER; 
		c.fill=GridBagConstraints.CENTER; 
		c.weightx=1.0; 
		c.weighty=1.0;
		c.insets=new Insets(10,10,10,10); 
		add(nav3,c);
		
		//ALIEN
		c.gridx=0; 
		c.gridy=4;	
		c.gridwidth=3; 
		c.gridheight=1; 
		c.anchor=GridBagConstraints.CENTER; 
		c.fill=GridBagConstraints.CENTER;
		c.weightx=1.0; 
		c.weighty=1.0;
		c.insets=new Insets(10,10,10,10); 
		add(panel3,c);
		
		c.gridx=0; 
		c.gridy=5;	
		c.gridwidth=1; 
		c.gridheight=1; 
		c.anchor=GridBagConstraints.CENTER; 
		c.fill=GridBagConstraints.CENTER; 
		c.weightx=1.0; 
		c.weighty=1.0;
		c.insets=new Insets(10,10,10,10); 
		add(al1,c);
		
		c.gridx=1; 
		c.gridy=5;	
		c.gridwidth=1; 
		c.gridheight=1; 
		c.anchor=GridBagConstraints.CENTER; 
		c.fill=GridBagConstraints.CENTER; 
		c.weightx=1.0;  
		c.weighty=1.0;
		c.insets=new Insets(10,10,10,10); 
		add(al2,c);
		
		c.gridx=2; 
		c.gridy=5;	
		c.gridwidth=1; 
		c.gridheight=1; 
		c.anchor=GridBagConstraints.CENTER; 
		c.fill=GridBagConstraints.CENTER; 
		c.weightx=1.0; 
		c.weighty=1.0;
		c.insets=new Insets(10,10,10,10); 
		add(al3,c);
		
		//Atras
		c.gridx=0; 
		c.gridy=6;	
		c.gridwidth=1; 
		c.gridheight=1; 
		c.anchor=GridBagConstraints.CENTER; 
		c.fill=GridBagConstraints.BOTH; 
		c.weightx=1.0; 
		c.weighty=1.0;
		c.insets=new Insets(50,10,50,10); 
		add(Atras,c);
			
	}
	public void seleccionFondo() {
		//Eleccion de fondo
		if (fon1.isSelected()) { 
			fon1.setBackground(null);
			fon2.setBackground(Color.BLACK);
			fon3.setBackground(Color.BLACK);
			imgfon = new ImageIcon(getClass().getResource("/imagenes/fondo1.png")).getImage();
						
		} else if (fon2.isSelected()) {
			fon2.setBackground(null);
			fon1.setBackground(Color.BLACK);
			fon3.setBackground(Color.BLACK);
			imgfon = new ImageIcon(getClass().getResource("/imagenes/fondo2.png")).getImage();
			
		} else if(fon3.isSelected()){
			fon3.setBackground(null);
			fon1.setBackground(Color.BLACK);
			fon2.setBackground(Color.BLACK);
			imgfon = new ImageIcon(getClass().getResource("/imagenes/fondo3.png")).getImage();
		}
	}
	
	public void seleccionAlien() {
		//Eleccion de alien
		if (al1.isSelected()) { 
			al1.setBackground(null);
			al2.setBackground(Color.BLACK);
			al3.setBackground(Color.BLACK);
			imgal = new ImageIcon(getClass().getResource("/imagenes/alien1.png")).getImage();
			
		} else if (al2.isSelected()) {
			al2.setBackground(null);
			al1.setBackground(Color.BLACK);
			al3.setBackground(Color.BLACK);
			imgal = new ImageIcon(getClass().getResource("/imagenes/alien2.png")).getImage();
			
		} else if(al3.isSelected()){
			al3.setBackground(null);
			al1.setBackground(Color.BLACK);
			al2.setBackground(Color.BLACK);
			imgal = new ImageIcon(getClass().getResource("/imagenes/alien3.png")).getImage();
		}
	}
	
	public void seleccionNave() {
		//Eleccion de nave
		if (nav1.isSelected()) { 
			nav1.setBackground(null);
			nav2.setBackground(Color.BLACK);
			nav3.setBackground(Color.BLACK);
			imgnav = new ImageIcon(getClass().getResource("/imagenes/nave1.png")).getImage();
						
		} else if (nav2.isSelected()) {
			nav2.setBackground(null);
			nav1.setBackground(Color.BLACK);
			nav3.setBackground(Color.BLACK);
			imgnav = new ImageIcon(getClass().getResource("/imagenes/nave2.png")).getImage();
						
		} else if(nav3.isSelected()){
			nav3.setBackground(null);
			nav1.setBackground(Color.BLACK);
			nav2.setBackground(Color.BLACK);
			imgnav = new ImageIcon(getClass().getResource("/imagenes/nave3.png")).getImage();
			
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		
		seleccionFondo();
		seleccionAlien();
		seleccionNave();
		
		if (e.getActionCommand().equals("Atrás")) {
			Menu men = new Menu();
			dispose();
			men.setVisible(true);
		}		
	}
}
