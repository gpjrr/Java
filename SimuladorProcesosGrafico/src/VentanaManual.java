import java.awt.Color;
import java.awt.event.ActionEvent;// botones
import java.awt.event.ActionListener;//botones
import java.io.FileNotFoundException;

import javax.swing.ButtonGroup;//botones en grupo 1 opcion 
import javax.swing.ImageIcon;
import javax.swing.JFrame;// ventana
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;// panel=hoja colocas todos los elementos
import javax.swing.JTextField;//espacio usuario puede escribir
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class VentanaManual extends JFrame {
	int alt,ancho;
	JPanel PanelPrincipal;
	public VentanaManual() {
		try {
		alt=470;  
		ancho=500;
		setTitle("Manual de usuario");
		setBounds(0,50,ancho,alt);// dimensiones de la ventana
		// pos x, pos y , hancho, altura
			setLocationRelativeTo(null);// va a centrar la posicion de la ventana		
			setDefaultCloseOperation(this.EXIT_ON_CLOSE);		
			setVisible(true);
			ConfigurarPanel();
			ConfigurarNuevo();
			PanelPrincipal.repaint();
		}
		catch(Exception e) {
			System.out.println("Hola popis");
		}
	}
	public void ConfigurarNuevo() {
		String testo="<html>Explicacion de Botones<br>"
				+ "NuevoProceso:Nos permite agregar otro proceso al simulador"
				+ "<br>debemos dar 3 datos:<br>"
				+ "El nombre del proceso.<br>"
				+ "La duracion de la rafaga. <br>"
				+ "El tiempo de llegada.<br>";
		testo+="Avanzar:Nos permite dar 1 paso en la simulacion.<br>"
				+ "Simulacion:Realiza el proceso completo de Simulacion.<br>"
				+ "Repetir:Repite el proceso de simulacion.<br>"
				+ "Tabla:Muestra la tabla de los resultados al<br>"
				+ "finalizar el proceso.<br>"
				+ "Cambiar:Nos permite regresar al primer menu <br>"
				+ "para seleccionar otro algoritmo.</html>";
		Etiquetas Titulo=new  Etiquetas(testo,0,0,ancho,alt);
		PanelPrincipal.add( Titulo );
	}
	public void ConfigurarPanel() {
		PanelPrincipal= new JPanel();// construimos panel  
		PanelPrincipal.setLayout( null );
		PanelPrincipal.setBackground( Color.gray );/// definir color
		PanelPrincipal.setBounds(0, 50,ancho,alt);//dimensiones 
		this.getContentPane().add( PanelPrincipal );
	}
	
}
