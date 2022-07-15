package arbolesbinarios;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author JulioCesar
 */
/* programa: UsaArbolBin.java
 * Hace uso de la clase ArbolBinario */
import java.io.*;

public class UsaArbolBin{
	public static void main(String[] args) throws IOException{
		int valor;
		int opc;
		ArbolBinario arbol = new ArbolBinario();
		/*ejemploooooooooooooooo*/
		arbol.alta(10);
		arbol.alta(5);
		arbol.alta(17);
		arbol.alta(13);
		arbol.alta(15);
		arbol.alta(1);
		arbol.alta(8);
		arbol.alta(6);
		arbol.alta(9);
		arbol.alta(20);
		arbol.alta(18);
		arbol.alta(21);
		arbol.preOrd();
		/*Puedes borrarlo si gustas*/
		
		while(true){
			System.out.print("\n\n");
			System.out.print("\t\t\tM E N U\n");
			System.out.print("\t1. Insertar\n");
			System.out.print("\t2. Buscar\n");
			System.out.print("\t3. Eliminar\n");
			System.out.print("\t4. Recorrer\n");
			System.out.print("\t5. alta recursiva\n");
			System.out.print("\t6. baja recursiva\n");
			System.out.print("\t9. Salir\n");
			System.out.print("\n\n\n\n");
			System.out.print("\t\t\t\tOpcion... ");
			opc = getChar();
			
			switch(opc){
				case '1':	System.out.print("Introducir el valor a insertar: ");
							valor = getInt();
							arbol.insertar(valor, valor + 0.9);
							break;
				case '2': 	System.out.print("Introducir la clave a buscar: ");
							valor = getInt();
//							Nodo encontrado = arbol.busca(valor);
							Nodo encontrado = arbol.busqueda(valor);
							if(encontrado != null){
								System.out.print("Se encontro: ");
								encontrado.muestraNodo();
								System.out.print("\n");
							} else {
								System.out.print("Llave no encontrada: ");
								System.out.print(valor + "\n\n");
							}
							break;
				case '3':	System.out.print("Introducir la llave a eliminar: ");
							valor = getInt();
							boolean eliminado = arbol.eliminar(valor);
							if(eliminado) 
								System.out.print("eliminado; " + valor + '\n');
							else System.out.print("no se pudo eliminar " + valor + "\n");
							break;
				case '4':	System.out.print("elija tipo 1(Pre), 2(en Ord Inv), 3(pos),4(en Orden), 5(hojas), 6(nodos internos), 7(Ord Desc):");
							valor = getInt();
							arbol.recorrido(valor);
							break;
				case '5':	System.out.print("Introducir el valor a insertar: ");
							valor = getInt();
							arbol.alta(valor);
							break;				
				case '6':	System.out.print("Introducir la llave a eliminar: ");
							valor = getInt();
							arbol.baja(valor);
							break;				
				case '9': 	System.out.print("Adios\n\n");
							return;
				default:	System.out.print("entrada invalida\n");
			} // fin del switch
		} // fin del while
		
	} // fin del main()
	
// -------------------------------------------------------------
	public static String getString() throws IOException{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		return s;
	}
	
// -------------------------------------------------------------
	public static char getChar() throws IOException{
		String s = getString();
		return s.charAt(0);
	}
	
//-------------------------------------------------------------
	public static int getInt() throws IOException{
		String s = getString();
		return Integer.parseInt(s);
	}
	
// -------------------------------------------------------------
} // fin de la clase UsaArbolBin