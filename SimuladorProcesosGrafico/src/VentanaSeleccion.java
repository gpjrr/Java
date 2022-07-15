import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;// botones
import java.awt.event.ActionListener;//botones
import java.io.FileNotFoundException;
import javax.swing.ButtonGroup;//botones en grupo 1 opcion 
import javax.swing.ImageIcon;
import javax.swing.JFrame;// ventana
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;// panel=hoja colocas todos los elementos
import javax.swing.JTable;
import javax.swing.JTextField;//espacio usuario puede escribir
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.concurrent.TimeUnit;

public class VentanaSeleccion extends JFrame{
	int lol=20;
	JPanel PanelPrincipal;
	int alt, ancho;
	Simulador Sim;
	Opcion[] Arr_bot;
	Caja CQuatum;
	public VentanaSeleccion(Simulador simi){
		Sim=simi;
		ancho=alt=300;
		setTitle("Simulador de procesos");
		setBounds(0,50,ancho,alt);// dimensiones de la ventana
		// pos x, pos y , hancho, altura 
		setLocationRelativeTo(null);// va a centrar la posicion de la ventana
		setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		setVisible(true);
		ConfigurarPanel();
		ConfigurarBotonesNiveles();
		ConfigurarBotonStart();
		ConfigurarTexto();
		ConfigurarBotonSalir();
		ConfigurarQuantum();
		ConfigurarCaja();
		PanelPrincipal.repaint();
	}
	public void ConfigurarCaja() {
		CQuatum=new Caja(lol+130,150,"");
		PanelPrincipal.add( CQuatum );
		
	}
	public void ConfigurarQuantum(){
		Etiquetas Titulo=new  Etiquetas("Quantum:",lol+25,150,100,35);
		PanelPrincipal.add( Titulo );
	}
	public void ConfigurarBotonSalir() {
		Boton Salir=new Boton("Salir",5,200,100,50 );
		ActionListener oyente=new  ActionListener() {
			public void actionPerformed( ActionEvent ae ) {
			try{
				dispose();
			}
			catch(Exception e) {
					System.out.println("Epale no se hace="+e);
			}
			//// guardar la info
			}
		};
		Salir.addActionListener( oyente );
		PanelPrincipal.add(Salir);
	}
	public void ConfigurarTexto(){
		Etiquetas Titulo=new  Etiquetas("Selecciona un Algoritmo",20,10,250,35);
		PanelPrincipal.add( Titulo );
	}
	public void ConfigurarBotonStart() {
		//Boton Agregar=new Boton("Nuevo Proceso",20,40,145,50 );
		Boton Start=new Boton("Empezar",180,200,100,50 );
		ActionListener oyente=new  ActionListener() {
			public void actionPerformed( ActionEvent ae ) {
			try{
				if(Arr_bot[0].isSelected() ) {
					Sim.Tipo=1;
					VentanaPrincipal window=new VentanaPrincipal(Sim);
				}
				else {
					Sim.Tipo=2;
					CQuatum.Check();
					Sim.Quantum=Integer.parseInt( CQuatum.Texto );
					VentanaPrincipal window=new VentanaPrincipal(Sim);
				}
				dispose();

			}
			catch(Exception e) {
					System.out.println("Epale="+e);
			}
			//// guardar la info
			}
		};
		Start.addActionListener( oyente );
		PanelPrincipal.add(Start);
	}
	public void ConfigurarBotonesNiveles() {
		//metemos conjunto de niveles
		Arr_bot=new Opcion[3];
		ButtonGroup banda=new ButtonGroup();		
			Arr_bot[0]=new Opcion(0,"Fifo");
			PanelPrincipal.add( Arr_bot[0] );
			banda.add( Arr_bot[0] );
			Arr_bot[1]=new Opcion(1,"RoundRobin");
			PanelPrincipal.add( Arr_bot[1] );
			banda.add( Arr_bot[1] );
		Arr_bot[0].setSelected(true);		
	}
	public void ConfigurarPanel() {
		PanelPrincipal= new JPanel();// construimos panel  
		PanelPrincipal.setLayout( null );
		PanelPrincipal.setBackground( Color.gray );/// definir color
		PanelPrincipal.setBounds(0, 50,ancho,alt);//dimensiones 
		this.getContentPane().add( PanelPrincipal );
	}
}
