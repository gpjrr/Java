import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.JOptionPane;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc=new Scanner( System.in );
		Grafo grafi=new Grafo();
	
		
		int opc=0;
		while( opc!=4 ) {
			System.out.println("1) Kruskal’s algorithm \n");
			System.out.println("2) prims's algorithm \n");
			System.out.println("3) ver grafo \n");
			System.out.println("4) salir del programa \n");
			opc=sc.nextInt();
			try {
				grafi=new Grafo();
				System.out.println("hay  grafos cual desea usar? inserta un numero entre 1-9");
				String Nombe=new String();
				Nombe="Grafo";
				Nombe+= Integer.toString( sc.nextInt() );
				Nombe+=".txt";
				System.out.println( Nombe );
				grafi.Construir( Nombe );
			}
			catch(FileNotFoundException e){
				System.out.println( "no es posiblee ");
	            JOptionPane.showMessageDialog(null, "No se ha encontrado el archivo");
	            System.exit(0);
	        }
			
			if( opc==1 ) 
				System.out.println( grafi.Kruskal() );
			if( opc==2 ) {
				System.out.println("dar el nombre del primer nodo\n");
				sc.nextLine();
				System.out.println( grafi.prims( sc.nextLine() ) );
			}
			if( opc==3 ) 
				System.out.println( grafi.toString() );
			if( opc==4 )
				System.out.println( "El codigo ha sido Finalizado correctamente\n" );
		}
		
	}

}