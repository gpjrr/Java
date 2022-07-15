import java.awt.Color;
import java.awt.event.ActionEvent;// botones
import java.awt.event.ActionListener;//botones
import java.io.FileNotFoundException;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import javax.swing.ButtonGroup;//botones en grupo 1 opcion 
import javax.swing.ImageIcon;
import javax.swing.JFrame;// ventana
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;// panel=hoja colocas todos los elementos
import javax.swing.JTextField;//espacio usuario puede escribir

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
public class VentanaPrincipal extends JFrame {
	int con=0;
	JPanel PanelPrincipal;
	Funtion obj;
	public VentanaPrincipal(Funtion yo,int blobo,int limi) {
		obj=yo;
		obj.blo=blobo;
		obj.lim=limi;
		setTitle("Ventana Principal");
		setBounds(0,50,800,1000);// dimensiones de la ventana
		// pos x, pos y , hancho, altura 
		setLocationRelativeTo(null);// va a centrar la posicion de la ventana
		setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		setVisible(true);
		//cierra la ventana al detener el codigo
		ConfigurarPanel();
		PanelPrincipal.repaint();
	}
	public void ConfigurarPanel() {
		PanelPrincipal= new JPanel();// construimos panel  
		PanelPrincipal.setLayout( null );
		PanelPrincipal.setBackground( Color.white );/// definir color
		PanelPrincipal.setBounds(0, 50, 800, 1000);//dimensiones 
		this.getContentPane().add( PanelPrincipal );
	}
	public void paint (Graphics g){
	        super.paint(g);
	        
	        g.setColor (Color.blue);
	        g.drawRect (0, 600, 1000, 600);
	        //base 500
	        Point ant=obj.GetPoint(0);
	        for(int i=0;i<=obj.lim;i++) {
	        	g.setColor (Color.red);
	        	Point tem=obj.GetPoint(i);
	        	tem.y=600-tem.y;
	        	obj.arr[i]=new Point(tem.x , tem.y);
	        /*g.drawLine(tem.x, 600-tem.y ,tem.x, 600-tem.y );*/
	        	
	        	g.drawLine(ant.x, ant.y ,tem.x, tem.y );
	        	//System.out.print(tem.x+" "+(600- tem.y)+"\n");
	        	if( i%obj.blo==0 ) {
	        		g.setColor (Color.black);
	        		g.drawLine (i, 600, i,tem.y);
	        		if( i<=obj.lim )
	        			obj.sum+=obj.blo*(tem.y-600);
	        	}
	        	ant=new Point( tem.x,tem.y );
	        }
	        System.out.println("la integral en [0,"+obj.lim+"]  calculada  "+obj.integral(obj.lim));
	        System.out.println("la integral en [0,"+obj.lim+"] es "+(-obj.sum));
	    }
}
