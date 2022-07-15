import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.JOptionPane;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc=new Scanner( System.in );
		Mapa mp=new Mapa();
		mp.Construir("Mapa3.txt");
		System.out.println("El mapa a resolver es: \n");
		System.out.println( mp.Mostrar() );
		System.out.println("La solucion es: \n");
		System.out.println( mp.Solve() );	
	}

}