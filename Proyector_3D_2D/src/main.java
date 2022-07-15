
import java.util.Scanner;
public class main {
	public static void main( String[] args ) {
		/*
		 Scanner sc = new Scanner(System.in);
System.out.println("Dar las coordenadas del observador en el formato x,y,z");
		Punto punto=new Punto( sc.nextInt(),sc.nextInt(),sc.nextInt() );
		
		System.out.println("Dar el ancho de la base");
		int bas=sc.nextInt(),lad;
		do {
			System.out.println("Dame el total de lados entre 3 y 6 ");
			lad=sc.nextInt();
			if( lad>6 || lad<3 )
				System.out.println("Error, numero fuera del rango");
		}while( lad>6 || lad<3 );
			Ventana window=new Ventana(punto,objeto);
		*/
		Figura objeto=new Figura( 6,5 );
		Ventana window=new Ventana(new Punto(1,1,1),objeto);

		
	}
}
