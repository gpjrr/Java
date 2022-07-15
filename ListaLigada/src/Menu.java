import java.util.Scanner;

/*
lista: un conjunto de nodos
nodo= un dato+ un apuntador

variable, darle nombre a una direccion
int a;
apuntador es una varible que guarda direcciones
*/

public class Menu {
	public static void main(String[] args) {
		Scanner sc=new Scanner( System.in );
		Lista cadena=new Lista();
		
		Lista oracion=new Lista();	
		/*
		for(int i=1;i<=5;i++) {
			String tem=sc.next();
			cadena.Insertar( tem );
		}*/
		
		cadena.Insertar( "hola" );
		cadena.Insertar( "soy" );
		cadena.Insertar( "erwin" );
		cadena.Insertar( "como" );
		cadena.Insertar( "estas" );
		cadena.Insertar( "y" );
		cadena.Insertar( "hoy" );
		cadena.Insertar( "es" );
		cadena.Insertar( "miercoles" );
		cadena.Insertar( "hoy" );
		cadena.Insertar( "ya" );
		cadena.Insertar( "es" );
		cadena.Insertar( "viernes" );
		cadena.Insertar( "fin" );
		System.out.print(  cadena.Imprimir()  + "\n" );
		System.out.print( cadena.ImprimirDerecho()  + "\n" );
		
		/*
		1   2   3   4
		v v v v v
		v v v v v v
		v v v v v v v
		*/
		int con= cadena.Tot/2;
		if( cadena.Tot%2==1 )
			con++;
		for(int i=0;i<con;i++){
			cadena.Eliminar(i);
		}
		//cadena.Eliminar( "como" );
		System.out.print( cadena.Imprimir()  + "\n" );
		System.out.print( cadena.ImprimirDerecho()  + "\n" );
		
	// System.out.print(  "el valor es"+ cadena.Buscar(  "perro" )+"\n" );
	// System.out.print(  "el valor es"+ cadena.Buscar( "como" ) );
	}
}




