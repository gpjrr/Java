import java.util.Scanner;
import java.util.*;
public class main {
	    public static void main(String [] args){
	        Scanner sc = new Scanner(System.in);
	        Arbol Tree = new Arbol();
	       int d = 0,opc = 0;
	       System.out.println("escribe la oracion");
	       String Oracion=sc.nextLine();
	       StringTokenizer st = new StringTokenizer( Oracion );
	       
	       while( st.hasMoreTokens() ) {
	    	   String Palabra=st.nextToken() ;
	    	   char Comita=Palabra.charAt( Palabra.length()-1 );
	    	   if(Comita==',' || Comita=='.')
	    		   Palabra=Palabra.substring(0, Palabra.length() - 1);
	    	   Palabra=Palabra.toLowerCase();
	    	   
	    	   Nodo temp= Tree.Busqueda( Palabra , Tree.raiz );
	    	   //System.out.println("Palabra "+Palabra+"__");
	    	   if( temp==null ) {
	    		   Tree.Insertar( Palabra );
	    		   
	    	   }
	    	   else 
	    		   temp.contador++;
	    	  
	       }
	       
	       Tree.Inorden( Tree.raiz );
	    }
}

/*
 Usted sabe que puede contar conmigo no hASTa dos o hasta diez sino contar cONMIgo, 
 hola Hola HOLa Adios adios ADios
 */
 