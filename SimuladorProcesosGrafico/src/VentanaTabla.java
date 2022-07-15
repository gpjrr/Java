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


public class VentanaTabla extends JFrame{
	JPanel PanelPrincipal;
	Object[][] ListaProceso;
	Simulador Sim;
	int alt,ancho;
	JScrollPane scrollResultado;
	public VentanaTabla( Simulador simi ) {
		Sim=simi;
		alt=300;  ancho=1300;
		setTitle("Tabla de Resultados");
		setBounds(0,50,ancho,alt);// dimensiones de la ventana
		// pos x, pos y , hancho, altura 
		setLocationRelativeTo(null);// va a centrar la posicion de la ventana
		setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		setVisible(true);
		ConfigurarPanel();
		ConfigruarTablaResultados();
		//ConfigurarCloseOption();
	}
	
	public void ConfigruarTablaResultados() {
		String[] ColumProcesos= {	"Proceso",
									"Tiempo LLegada",
									"Duracion Rafaga",
									"Tiempo Arranque",
									"Tiempo Finalizacion",
									"Tiempo Retorno",
									"Tiempo Respuesta",
									"Tasa Desperdicio",
									"Tasa Penalizacion",
									"Tiempo Espera"
				};//10
		ListaProceso=new Object[Sim.n+2][10];// filas,columnas
		float[] prom=new float[100];
		for(int i=0;i<Sim.n;i++) {
			ListaProceso[i][0]=Sim.cola[i].Nombre;
			ListaProceso[i][1]=Sim.cola[i].Tll;
			ListaProceso[i][2]=Sim.cola[i].T;
			ListaProceso[i][3]=Sim.cola[i].Ta;
			ListaProceso[i][4]=Sim.cola[i].Tf;
			ListaProceso[i][5]=Sim.cola[i].Tret;
			ListaProceso[i][6]=Sim.cola[i].Tans;
			ListaProceso[i][7]=Sim.cola[i].Tw;
			ListaProceso[i][8]=Sim.cola[i].Tpen;
			ListaProceso[i][9]=Sim.cola[i].Tesp;
			Sim.cola[i].Resultado();
			prom[5]+=Sim.cola[i].Tret;
			prom[6]+=Sim.cola[i].Tans;
			prom[7]+=Sim.cola[i].Tw;
			prom[8]+=Sim.cola[i].Tpen;
			prom[9]+=Sim.cola[i].Tesp;
		}
		ListaProceso[Sim.n][0]="Total";
		for(int i=5;i<=9;i++) {
			ListaProceso[Sim.n][i]=prom[i];
			prom[i]/=Sim.n;
		}
		ListaProceso[Sim.n+1][0]="Promedio";
		for(int i=5;i<=9;i++) {
			ListaProceso[Sim.n+1][i]=prom[i];
			//prom[i]/=Sim.n;
		}
		JTable Tresultados=new JTable( ListaProceso,ColumProcesos );
		Tresultados.setName("Simulacion");
		Tresultados.setPreferredScrollableViewportSize(new Dimension(ancho,alt));
		Tresultados.setFillsViewportHeight(true);
		scrollResultado = new JScrollPane( Tresultados );
		scrollResultado.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollResultado.setBounds(0,0,ancho,alt);
		//Add the scroll pane to this panel.
        PanelPrincipal.add(scrollResultado);
		
	}
	public void ConfigurarPanel() {
		PanelPrincipal= new JPanel();// construimos panel  
		PanelPrincipal.setLayout( null );
		PanelPrincipal.setBackground( Color.gray );/// definir color
		PanelPrincipal.setBounds(0, 50,ancho,alt);//dimensiones 
		this.getContentPane().add( PanelPrincipal );
	}
}
