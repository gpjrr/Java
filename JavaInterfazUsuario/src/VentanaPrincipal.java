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

public class VentanaPrincipal extends JFrame {
	 int con=0;
	JPanel PanelPrincipal;
	Caja caja;
	public VentanaPrincipal() {
		setTitle("Ventana Principal");
		setBounds(0,50,800,1000);// dimensiones de la ventana
		// pos x, pos y , hancho, altura 
		setLocationRelativeTo(null);// va a centrar la posicion de la ventana
		setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		setVisible(true);
		//cierra la ventana al detener el codigo
		ConfigurarPanel();
		ConfigurarBoton1();
		ConfigurarBoton2();
		ConfigurarEtiqueta();	
		ConfigurarFoto();
		ConfigurarCajaTexto();
		PanelPrincipal.repaint();
	}
	public void ConfigurarCajaTexto() {
		caja=new  Caja(300,500,"" );
		KeyAdapter funcion=new KeyAdapter(){
            public void keyPressed(KeyEvent evt){
                if(evt.getKeyCode() == KeyEvent.VK_ENTER){
                    caja.Check();
                    System.out.println("hola "+caja.Texto);
                }
            }
        }; 
		caja.addKeyListener( funcion );		
		PanelPrincipal.add( caja );
	}
	public void ConfigurarFoto() {
			/// construis la etiqueta y mandarle la imagen con el nombre 
			JLabel Tigre=new JLabel( new ImageIcon("tigre.jpg") );
			// definir las dimensiones y la posicion 
			Tigre.setBounds(200, 200, 414, 276);
			// las dimensiones se miden desde el centro de la imagen
			
			// agregar 
			PanelPrincipal.add( Tigre );			
		/*
		 try{	
		
		}
		catch(FileNotFoundException e){
			JOptionPane.showMessageDialog(null, "No se ha encontrado el archivo");
			System.exit(0);
		}
		 */
		
		
	
	}
	public void ConfigurarPanel() {
		PanelPrincipal= new JPanel();// construimos panel  
		PanelPrincipal.setLayout( null );
		PanelPrincipal.setBackground( Color.blue );/// definir color
		PanelPrincipal.setBounds(0, 50, 800, 1000);//dimensiones 
		this.getContentPane().add( PanelPrincipal );
	}
	
	public void ConfigurarBoton1() {
		Boton Hola=new  Boton("saludo",50,50,200,100);
		// configurar el oyente 
		ActionListener oyente=new  ActionListener() {
			public void actionPerformed( ActionEvent ae ) {
				caja.Check();
				//todo lo que se va a hacer al presionar el boton 
				System.out.println("hola "+"\n");
				con++;
			}
		};
		// agregamos el oyente al boton 
		Hola.addActionListener( oyente );
		PanelPrincipal.add(  Hola );
	}
	public void ConfigurarBoton2() {
		Boton Nuevo=new  Boton("Nueva Ventana",50,500,200,100);
		// configurar el oyente 
		ActionListener oyente=new  ActionListener() {
			public void actionPerformed( ActionEvent ae ) {
				caja.Check();
				dispose();
				String Cad=caja.Texto;
				VentanaSecundaria NuevaV=new VentanaSecundaria( Cad );
			}
		};
		// agregamos el oyente al boton 
		Nuevo.addActionListener( oyente );
		PanelPrincipal.add(  Nuevo );
	}

	public void ConfigurarEtiqueta() {
		Etiquetas Titulo=new  Etiquetas("titulo", 100,200,100,50);
		PanelPrincipal.add( Titulo );
	}
}
