import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class VentanaSecundaria extends JFrame {
	JPanel Panel;


	public VentanaSecundaria(String nombre) {
		setTitle("Ventana Para Saludar");
		setBounds(0,0,600,600);
		setLocationRelativeTo(null);
		
		
		setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		setVisible(true);
		ConfigurarPanel();
		Etiquetas Titulo=new  Etiquetas(nombre, 100,200,100,200);
			Panel.add( Titulo );
		Panel.repaint();
			
	}
	
	public void ConfigurarPanel() {
		Panel= new JPanel();// construimos panel  
		Panel.setLayout( null );
		Panel.setBackground( Color.red );/// definir color
		Panel.setBounds(0, 0, 600, 600);//dimensiones 
		this.getContentPane().add( Panel );
	}
}
