public class menu {
	public static void main(String[] args) {
		Grafo  mapa=new Grafo();
		mapa.InsertarNodo("a");
		mapa.InsertarNodo("b");
		mapa.InsertarNodo("c");
		mapa.InsertarNodo("d");
		mapa.InsertarNodo("e");
		mapa.InsertarNodo("f");
		mapa.InsertarNodo("g");
		mapa.InsertarNodo("f");
		mapa.InsertarNodo("z");
		mapa.InsertarNodo("t");
		mapa.InsertarArista( "z", "t", 1 );
		mapa.InsertarArista( "a", "d", 5 );
		mapa.InsertarArista( "b", "c", 2 );
		mapa.InsertarArista( "b", "g", 6 );
		mapa.InsertarArista( "b", "f", 4 );
		mapa.InsertarArista( "c", "d", 4 );
		mapa.InsertarArista( "c", "f", 12 );
		mapa.InsertarArista( "c", "e", 10 );
		mapa.InsertarArista( "d", "e", 15 );
		mapa.InsertarArista( "e", "f", 3 );
		mapa.InsertarArista( "e", "z", 5 );
		mapa.InsertarArista( "f", "g", 8 );
		mapa.InsertarArista( "f", "z", 16 );
		mapa.InsertarArista( "g", "z", 7 );
		mapa.InsertarArista( "a", "b", 16 );
		mapa.InsertarArista( "a", "c", 10 );
		System.out.print( mapa.ImprimirGrafo()+"\n" );
		//System.out.print( mapa.Bfs("t")+"\n" );
		//System.out.print( mapa.Dfs("c")+"\n" );
		
		System.out.print( mapa.Dijkstra("a")  +"\n" );
		
		//mapa.ELiminarNodo( "c" );
		//System.out.print( mapa.ImprimirGrafo() );
	}
	
}