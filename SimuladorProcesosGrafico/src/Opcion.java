import javax.swing.JRadioButton;

public class Opcion extends JRadioButton {
	
	public Opcion(int pi,String texto){
		String t1;
		setText(texto);
		setBounds(49 +pi*101, 80, 100, 50);
	}
}