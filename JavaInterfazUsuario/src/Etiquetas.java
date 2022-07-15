import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
public class Etiquetas extends JLabel{
	public Etiquetas( String texto,int px,int py,int ancho,int largo ) {
		setText( texto );// configuras el texto 
		setOpaque(true);// configura que sea "visible" opacidad 
		setHorizontalAlignment( SwingConstants.CENTER );// centrar en el eje x 
		setVerticalAlignment( SwingConstants.CENTER );// centrar en el eje y 
		setLayout( null );
		setBackground( Color.ORANGE );// color del fondo 
		setForeground( Color.BLACK );// color del texto
		setFont( new Font("Serif",Font.BOLD ,20) );// el tipo de fuente
		setBounds(px,py,ancho,largo);
		
		
	}
	
}
