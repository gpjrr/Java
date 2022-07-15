import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.JOptionPane;

public class EjecutaMain {
	public static void main(String[] args) throws IOException {
		Scanner sc=new Scanner( System.in );// el scaner de lo que va a escribir el usuario
		Grafo grafi=new Grafo();/// construimos el grafo
	
		
		int opc=0;
		while( opc!=6 ) {
			// mostramos el menu
			System.out.println("1) busqueda en profundidad \n");
			System.out.println("2) busqueda en amplitud \n");
			System.out.println("3) dijkstra's algorithm \n");
			System.out.println("4) prims's algorithm \n");
			System.out.println("5) ver grafo \n");
			System.out.println("6) salir del programa \n");
			opc=sc.nextInt();// leemos la opcion
			
			
			// aqui el usuario escoge el grafo con el cual va a trabajar 
			try {
				
				grafi=new Grafo();
				// le pedimos el numero del grafo al usuario
				System.out.println("hay 8 grafos cual desea usar? inserta un numero entre 1-8");
				String Nombe=new String();
				Nombe="Grafo";
				Nombe+= Integer.toString( sc.nextInt() );
				Nombe+=".txt";
				// en nombe construimos el nombre del archivo conforme al numero que dio el usuario
				System.out.println( Nombe );
				// en construir cargamos la informacion del archivo,
				grafi.Construir( Nombe );
			}
			catch(FileNotFoundException e){/// si se equivoca el usuario regresa un error
				System.out.println( "no es posiblee ");
	            JOptionPane.showMessageDialog(null, "No se ha encontrado el archivo");
	            System.exit(0);
	        }
			
			if( opc==1 ) {/// pedimos el nodo e imprimimos el resultado mandando el nombre del nodo a la funcion 
				System.out.println("dar el nombre del primer nodo\n");
				sc.nextLine();
	System.out.println( grafi.BusquedaProfundidad( sc.nextLine() ) );
			}
			if( opc==2 ) {
				/// pedimos el nodo e imprimimos el resultado mandando el nombre del nodo a la funcion
				System.out.println("dar el nombre del primer nodo\n");
				sc.nextLine();
	System.out.println( grafi.BusquedaAmplitud( sc.nextLine() ) );
			}

			if( opc==3 ) {
				/// pedimos la informacion de los 2 nodos
				System.out.println("dar el nombre del primer nodo\n");
				sc.nextLine();
				String nodo1=" ",nodo2=" ";
				nodo1=sc.nextLine();
				System.out.println("dar el nombre del segundo nodo\n");
				nodo2=sc.nextLine();
				// imprimimos lo que regrese la funcion a la que le mandamos el nombre de los 2 nodos
				System.out.println( grafi.dijkstra( nodo1,nodo2 ) );
			}
			if( opc==4 ) {
				/// pedimos el nodo e imprimimos el resultado mandando el nombre del nodo a la funcion
				System.out.println("dar el nombre del primer nodo\n");
				sc.nextLine();
				System.out.println( grafi.prims( sc.nextLine() ) );
			}
			if( opc==5 ) 
				/// mostramos la informacion del grafo
				System.out.println( grafi.toString() );
			
		}
		
	}

}