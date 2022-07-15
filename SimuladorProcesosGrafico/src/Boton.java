import java.awt.Font;

import javax.swing.JButton;

public class Boton extends JButton{
	public Boton( String texto, int px,int py,int hancho,int largo ) {
		setVisible( true );// hace visible el boton
		setText( texto );
		setEnabled(true );
		setFont(  new Font("Serif",Font.BOLD ,17) );
		setBounds( px,py,hancho,largo );
		
	}
	
}
