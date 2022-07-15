
public class Main {
	public static void main(String[] args) {
		
			Grafo mapa=new Grafo();
			mapa.InsertarNodo("b");
			mapa.InsertarNodo("a");
			mapa.InsertarNodo("c");
			mapa.InsertarNodo("d");
			mapa.InsertarNodo("e");
			mapa.InsertarNodo("z");

			mapa.InsertarAristas("b","a",1);
			mapa.InsertarAristas("b", "c",7);
			mapa.InsertarAristas("b", "d",3);
			mapa.InsertarAristas("a", "c",5);
			mapa.InsertarAristas("a", "e",9);
			mapa.InsertarAristas("c", "d",4);
			mapa.InsertarAristas("d", "z",6);
			
			System.out.print( mapa.mostrarAristas( "a" ) );
			System.out.print( mapa.mostrarAristas( "b" ) );
			System.out.print( mapa.mostrarAristas( "c" ) );
			System.out.print( mapa.mostrarAristas( "d" ) );
			System.out.print( mapa.mostrarAristas( "e" ) );
			System.out.print( mapa.mostrarAristas( "z" ) );
			System.out.print( mapa.mostrarMatriz() );
			mapa.EliminarAristas("d","z");
			System.out.print( "\n\n" );
			System.out.print( mapa.mostrarMatriz() );
	}
}
