import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.JOptionPane;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc=new Scanner( System.in );
		Grafo grafi=new Grafo();
		for(int i=1;i<=9;i++)
			grafi.InsertarVertice( Integer.toString(i)  );
		grafi.InsertarArista("1","2", 4);
		grafi.InsertarArista("1","8", 9);
		grafi.InsertarArista("2","8", 11);
		grafi.InsertarArista("2","3", 9);
		grafi.InsertarArista("8","9", 7);
		grafi.InsertarArista("8","7", 1);
		grafi.InsertarArista("9","7", 6);
		grafi.InsertarArista("9","3", 2);
		grafi.InsertarArista("7","6", 2);
		grafi.InsertarArista("3","6", 4);
		grafi.InsertarArista("3","4", 7);
		grafi.InsertarArista("4","6", 15);
		grafi.InsertarArista("4","5", 10);
		grafi.InsertarArista("6","5", 11);
		
		System.out.print(grafi.toString());
		System.out.println("Busqueda en profundidad:");
		System.out.println("dar el nombre del primer nodo\n");
		String tst=sc.nextLine();
		System.out.println("Resultado:");
		System.out.println( grafi.BusquedaProfundidad( tst ) );
		
		System.out.println("Dijkstra:");
		System.out.println("dar el nombre del primer nodo\n");
		String nodo1=" ",nodo2=" ";
		nodo1=sc.nextLine();
		System.out.println("dar el nombre del segundo nodo\n");
		nodo2=sc.nextLine();
		System.out.println("Resultado:");
		System.out.println( grafi.dijkstra( nodo1,nodo2 ) );
	}
}