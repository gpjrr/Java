import java.util.Scanner;

public class Menu {
	public static void main(String[] args) {
		Arbol tree=new Arbol();
		Scanner sc=new Scanner( System.in );
		
		
			tree.Insertar( 45  );
			tree.Insertar( 30 );
			tree.Insertar( 8 );
			tree.Insertar(  16 );
			tree.Insertar( 2 );
			tree.Insertar( 35 );
			tree.Insertar( 50 );
			tree.Insertar( 70 );
		//System.out.print( tree.Buscar( 8 )+" \n" );
		//System.out.print( tree.Buscar( 16 ) +"\n ");
		tree.Preorden(  tree.Raiz );
		
	}
}	