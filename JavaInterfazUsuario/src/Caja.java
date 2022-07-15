import java.awt.Color;
import javax.swing.JTextField;

public class Caja  extends JTextField {
	String Texto;
	
	public Caja( int x1,int y1,String Contenido ) {
		setText( Contenido );// meterle texto a la caja al construirse
		setBounds(x1,y1,100,40);// dimensiones y la posicion
		setEditable(true);//si es false no te permite interactuar
		//Color(red,green,blue)
		//setBackground(new Color(0, 255, 10));// color del fondo 
		setForeground(new Color(0, 0, 0) );// color de la fuente		
	}
	public void Check() {
		Texto=this.getText();
	}
	
}
