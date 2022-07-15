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
public class VentanaProceso extends JFrame {
	String Nombre;
	int Rafaga;
	int LLego;
	JPanel PanelPrincipal;
	int alt, ancho;
	int DisCajas=60;
	int ejex=200;	 int yy=20;
	boolean Finish;
	Caja CNombre,CRafaga,CLLego;
	Proceso Nuevo;
	Simulador Sim;
	public VentanaProceso(Simulador ssim) {
		try {
			Sim=ssim;
			//System.out.println("Creadoooo");
		alt=400; Finish=false;
		int entrener=0;
		setTitle("Nuevo Proceso");
		setBounds(0,50,alt,alt);// dimensiones de la ventana
		// pos x, pos y , hancho, altura 
		setLocationRelativeTo(null);// va a centrar la posicion de la ventana
		setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		setVisible(true);
		ConfigurarPanel();
		ConfigurarTextoCaja("            Nombre:",yy);
		ConfigurarTextoCaja("Duracion de rafaga:",yy+DisCajas);
		ConfigurarTextoCaja(" Tiempo de llegada:",yy+DisCajas*2);
		ConfigurarCajaTextoNombre();
		ConfigurarCajaTextoDuracion();
		ConfigurarCajaTextoLLegada();
		ConfigurarBotonGuardar();
		ConfigurarBotonVolver();
		PanelPrincipal.repaint();
		}catch(Exception e) {
			System.out.print("EE=="+e);
		}
	}
	public void ConfigurarBotonVolver() {
		Boton Volver=new Boton("Volver",35,300,145,50 );
		ActionListener oyente=new  ActionListener() {
			public void actionPerformed( ActionEvent ae ) {
				VentanaPrincipal nueva =new VentanaPrincipal(Sim);		
				dispose();
			}
		};
		Volver.addActionListener( oyente );
		PanelPrincipal.add( Volver );
	
	}
	public void ConfigurarBotonGuardar() {
		Boton Guardar=new Boton("Guardar",220,300,145,50 );
		ActionListener oyente=new  ActionListener() {
			public void actionPerformed( ActionEvent ae ) {
				CNombre.Check();  CRafaga.Check();  CLLego.Check();
				Nombre=CNombre.Texto; 
				try {
					Rafaga=-1;
					LLego=-1;
					Rafaga=Integer.parseInt( CRafaga.Texto ); 
					LLego=Integer.parseInt( CLLego.Texto );
				}catch(Exception e) {
					System.out.println("Hay caracteres que no son numeros\n");
				}
				if( Rafaga!=-1 && LLego!=-1 ) {
					Finish=true;
					Sim.Insertar( new Proceso(Nombre,Rafaga,LLego) );
					//Info.Sim1.Insertar( new Proceso(Nombre,Rafaga,LLego) );
					VentanaPrincipal nueva =new VentanaPrincipal(Sim);		
					dispose();
				}
			}
		};
		Guardar.addActionListener( oyente );
		PanelPrincipal.add( Guardar );
	}
	
	public void ConfigurarPanel() {
		PanelPrincipal= new JPanel();// construimos panel  
		PanelPrincipal.setLayout( null );
		PanelPrincipal.setBackground( Color.white );/// definir color
		PanelPrincipal.setBounds(0, 50,alt,alt);//dimensiones 
		this.getContentPane().add( PanelPrincipal );
	}
	public void ConfigurarCajaTextoNombre() {
		CNombre=new Caja(ejex,20,"" );
		PanelPrincipal.add( CNombre );
	}
	public void ConfigurarCajaTextoDuracion() {
		CRafaga=new Caja(ejex,20+DisCajas,"" );
		PanelPrincipal.add( CRafaga );
	}
	public void ConfigurarCajaTextoLLegada() {
		CLLego=new Caja(ejex,20+DisCajas*2,"" );
		PanelPrincipal.add( CLLego );
	}
	public void ConfigurarTextoCaja(String texto,int CoordY){
		Etiquetas Titulo=new  Etiquetas(texto,10,CoordY,180,40);
		PanelPrincipal.add( Titulo );
	}
	public boolean Creado() {
		//PanelPrincipal.repaint();
		return Finish;
	}
	
}