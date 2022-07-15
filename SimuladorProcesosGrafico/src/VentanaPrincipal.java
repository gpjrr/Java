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

public class VentanaPrincipal extends JFrame {
	JPanel PanelPrincipal;
	int alt, ancho;
	int plus=20;
	Simulador Sim;
	Object[][] ListaProceso;
	JScrollPane scrollDesarrollo;
	JScrollPane scrollCola;
	VentanaTabla tablita;
	VentanaManual manual;
	public VentanaPrincipal(Simulador settings ) {
		Sim=settings;
		alt=600;  
		ancho=1000;
		setTitle("Simulador de procesos");
		setBounds(0,50,ancho,alt);// dimensiones de la ventana
		// pos x, pos y , hancho, altura 
		setLocationRelativeTo(null);// va a centrar la posicion de la ventana
		setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		setVisible(true);
		ConfigurarPanel();
		ConfigurarBotonAdd();
		ConfigurarTablaProcesos();
		ConfigurarTablaDesarrollo();
		ConfigurarBotonSimular();
		ConfigurarBotonFinalizar();
		ConfigurarBotonReset();
		ConfigurarBotonTabla();
		ConfigurarTextoProcesos();
		ConfigurarBotonCambiar();
		ConfigurarTextoCola();
		if( Sim.Tipo==2 ) ConfigurarTextoQuantum();
		System.out.println("Holaaaaaaa");
		ConfigurarTablaStatus();
		ConfigurarBotonManual();
		System.out.println("Adios");
		// ConfigurarProcesos();
		PanelPrincipal.repaint();
	}
	
	public void ConfigurarCloseOptionManual() {
		manual.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		manual.addWindowListener(new java.awt.event.WindowAdapter() {
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		    	manual.dispose();
		    } }    );
	}
	public void ConfigurarBotonManual() {
		Boton Cambiar=new Boton("?",775,40,50,50 );
		ActionListener oyente=new  ActionListener() {
			public void actionPerformed( ActionEvent ae ) {
			try{
				manual=new VentanaManual();
				ConfigurarCloseOptionManual();
				System.out.println("No hace nada");
				//dispose();
			}
			catch(Exception e) {
					System.out.println("pelame="+e);
			}
			//// guardar la info
			}
		};
		Cambiar.addActionListener( oyente );
		PanelPrincipal.add(Cambiar);
	}
	public void ConfigurarTextoCola() {
		Etiquetas Titulo=new  Etiquetas("Estado de la cola",70,360,200,40);
		PanelPrincipal.add( Titulo );
	}
	public void ConfigurarTablaStatus() {
		String[] ColumProcesos= {"Nombre del proceso","Tiempo restante"};
		Object[][] Contenido=new Object[Sim.n][2];// filas,columnas
		int it=0;
		//
		if( Sim.Tipo==1 ) {
			for( int i=0;i<Sim.n;i++) 
				if( Sim.cola[i].Tlive>0 ){
					Contenido[it][0]=Sim.cola[i].Nombre;
					Contenido[it][1]=Sim.cola[i].Tlive;
					it++;
				}
		}
		else {
			if( Sim.fin>0 ) {
				int j=Math.max(0, Sim.seleccionado);
				System.out.println("act="+Sim.activados+" j="+j);
				if( Sim.cola[j].Tlive==0  && Sim.activados>0) {
					j++;j%=Sim.fin;
					while( Sim.cola[j].Tlive==0 ) {
						j++;j%=Sim.fin;
					}		
				}
				for( int i=0;i<Sim.activados;i++) {
					System.out.println(" j="+j);
					if( Sim.cola[j].Tlive>0 ){
						Contenido[it][0]=Sim.cola[j].Nombre;
						Contenido[it][1]=Sim.cola[j].Tlive;
						it++;
					}
					j++;j%=Sim.fin;
					while( Sim.cola[j].Tlive==0 ) {
						j++;j%=Sim.fin;
					}		
				}
				System.out.println("Hol_fwerfadsf_aaaa");
			}
		}
		//System.out.println("Hol__aaaa");
		int anch,larg;
		anch=300; larg=150;
		JTable TCola=new JTable( Contenido,ColumProcesos );
		TCola.setName("Estado de la cola");
		TCola.setPreferredScrollableViewportSize(new Dimension(anch,larg));
		TCola.setFillsViewportHeight(true);
		scrollCola = new JScrollPane( TCola );
		scrollCola.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollCola.setBounds(20,400,anch,larg);
		//Add the scroll pane to this panel.
        
		PanelPrincipal.add(scrollCola);
        
		
	}
	public void ConfigurarBotonCambiar() {
		Boton Cambiar=new Boton("Cambiar",650,40,95+20,50 );
		ActionListener oyente=new  ActionListener() {
			public void actionPerformed( ActionEvent ae ) {
			try{
				VentanaSeleccion back=new VentanaSeleccion(Sim);
				dispose();
			}
			catch(Exception e) {
					System.out.println("Epa="+e);
			}
			//// guardar la info
			}
		};
		Cambiar.addActionListener( oyente );
		PanelPrincipal.add(Cambiar);
		
	}
	public void ConfigurarTextoQuantum() {
		String testo="Quantum=";
		testo+=Sim.Quantum;
		Etiquetas Titulo=new  Etiquetas(testo,770+plus+40,40,150,50);
		PanelPrincipal.add( Titulo );
	}
	public void ConfigurarTextoProcesos() {
		Etiquetas Titulo=new  Etiquetas("Tabla de Procesos",680,360,200,40);
		PanelPrincipal.add( Titulo );
	}
	public void	ConfigurarCloseOption() {
		tablita.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		tablita.addWindowListener(new java.awt.event.WindowAdapter() {
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		    	tablita.dispose();
		    	
		    } }    );
	}
	public void ConfigurarBotonTabla() {
		//Boton Tabla=new Boton("Repetir",430,40,95,50 );
		Boton Tabla=new Boton("Tabla",540,40,95,50 );
		ActionListener oyente=new  ActionListener() {
			public void actionPerformed( ActionEvent ae ) {
			try{
				if( Sim.YaFinalizo()==true ) {
					Sim.OrdenarNombre();
					tablita=new VentanaTabla(Sim);
					ConfigurarCloseOption();
					//dispose();
				}
			}
			catch(Exception e) {
					System.out.println("Epa="+e);
			}
			//// guardar la info
			}
		};
		Tabla.addActionListener( oyente );
		PanelPrincipal.add(Tabla);
	}
	public void ConfigurarBotonReset() {
		//Boton Paso=new Boton("Simulacion",295,40,120,50 );
		Boton Reset=new Boton("Repetir",430,40,95,50 );
		ActionListener oyente=new  ActionListener() {
			public void actionPerformed( ActionEvent ae ) {
			try{
					//TSimulacion;
				Simulador Copia=new Simulador(Sim.Tipo,Sim.Quantum);
				for(int i=0;i<Sim.n;i++)
					Copia.Insertar( Sim.arr[i] );
				dispose();
				VentanaPrincipal nueva=new VentanaPrincipal( Copia );
			}
			catch(Exception e) {
					System.out.println("Epa="+e);
			}
			//// guardar la info
			}
		};
		Reset.addActionListener( oyente );
		PanelPrincipal.add(Reset );
	}
	public void ConfigurarBotonFinalizar() {
		//Boton Paso=new Boton("Avanzar",180,40,100,50 );
		Boton Paso=new Boton("Simulacion",295,40,120,50 );
		ActionListener oyente=new  ActionListener() {
			public void actionPerformed( ActionEvent ae ) {
			try{
				while( Sim.YaFinalizo()!=true ) {
					Sim.Paso();
				}
				PanelPrincipal.remove(scrollDesarrollo);
				ConfigurarTablaDesarrollo();
				ConfigurarTablaProcesos();
				PanelPrincipal.remove(scrollCola);
				ConfigurarTablaStatus();
				PanelPrincipal.repaint();
				//TSimulacion;
			}
			catch(Exception e) {
					System.out.println("Epa="+e);
			}
			//// guardar la info
			}
		};
		Paso.addActionListener( oyente );
		PanelPrincipal.add(Paso );
	}
	public void ConfigurarBotonSimular() {
		//Boton Agregar=new Boton("Nuevo Proceso",20,40,145,50 );
		Boton Simular=new Boton("Avanzar",180,40,95,50 );
		ActionListener oyente=new  ActionListener() {
			public void actionPerformed( ActionEvent ae ) {
			try{
				if( Sim.YaFinalizo()!=true ) {
					Sim.Paso();
					PanelPrincipal.remove(scrollDesarrollo);
					PanelPrincipal.remove(scrollCola);
					ConfigurarTablaStatus();
					ConfigurarTablaDesarrollo();
					ConfigurarTablaProcesos();
					PanelPrincipal.repaint();
				}
				//TSimulacion;
			}
			catch(Exception e) {
					System.out.println("Epale con el refresh="+e);
			}
			//// guardar la info
			}
		};
		Simular.addActionListener( oyente );
		PanelPrincipal.add(Simular );
	}
	public void ConfigurarTablaDesarrollo() {
		String[] ColumProcesos= {"Tiempo","Proceso Ejecutado","Proceso Nuevo","Proceso Finalizado"};
		ListaProceso=new Object[Sim.ITM][4];// filas,columnas
		for( int i=0;i<Sim.ITM;i++) {
			ListaProceso[i][0]=Sim.Mem[i].Time;
			ListaProceso[i][1]=Sim.Mem[i].Proceso;
			ListaProceso[i][2]=Sim.Mem[i].PLLego;
			ListaProceso[i][3]=Sim.Mem[i].Muerto;
			//System.out.println(Contenido[i][0]+" "+Contenido[i][0]+" "+Contenido[i][2]);
		}
		int anch,larg;
		anch=950; larg=250;
		JTable TSimulacion=new JTable( ListaProceso,ColumProcesos );
		TSimulacion.setName("Simulacion");
		TSimulacion.setPreferredScrollableViewportSize(new Dimension(anch,larg));
		TSimulacion.setFillsViewportHeight(true);
		scrollDesarrollo = new JScrollPane( TSimulacion );
		scrollDesarrollo.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollDesarrollo.setBounds(20,100,anch,larg);
		//Add the scroll pane to this panel.
        PanelPrincipal.add(scrollDesarrollo);
	}
	public void ConfigurarTablaProcesos(){
		String[] ColumProcesos= {"Nombre del proceso","Tiempo de rafaga","Tiempo de llegada"};
		Object[][] Contenido=new Object[Sim.n][3];// filas,columnas
		for( int i=0;i<Sim.n;i++) {
			Contenido[i][0]=Sim.arr[i].Nombre;
			Contenido[i][1]=Sim.arr[i].T;
			Contenido[i][2]=Sim.arr[i].Tll;
			//System.out.println(Contenido[i][0]+" "+Contenido[i][0]+" "+Contenido[i][2]);
		}
		int anch,larg;
		anch=400; larg=150;
		JTable TProcesos=new JTable( Contenido,ColumProcesos );
		TProcesos.setName("Lista De Procesos");
		TProcesos.setPreferredScrollableViewportSize(new Dimension(anch,larg));
		TProcesos.setFillsViewportHeight(true);
		JScrollPane scrollPane = new JScrollPane( TProcesos );
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(570,400,anch,larg);
		//Add the scroll pane to this panel.
        PanelPrincipal.add(scrollPane);
	}
	public void ConfigurarPanel() {
		PanelPrincipal= new JPanel();// construimos panel  
		PanelPrincipal.setLayout( null );
		PanelPrincipal.setBackground( Color.gray );/// definir color
		PanelPrincipal.setBounds(0, 50,ancho,alt);//dimensiones 
		this.getContentPane().add( PanelPrincipal );
	}
	public void ConfigurarBotonAdd(){
		Boton Agregar=new Boton("Nuevo Proceso",20,40,145,50 );
		ActionListener oyente=new  ActionListener() {
			public void actionPerformed( ActionEvent ae ) {
			try{
				dispose();
				VentanaProceso nueva =new VentanaProceso(Sim);
				return;
			}
			catch(Exception e) {
					System.out.println("E="+e);
			}
			//// guardar la info
			}
		};
		Agregar.addActionListener( oyente );
		PanelPrincipal.add(Agregar );
	}
}
