public class Main {
	public static void main(String[] args) {
		Grafo grafito=new Grafo();
		grafito.InsertarNodo("A");
		grafito.InsertarNodo("B");
		grafito.InsertarNodo("C");
		grafito.InsertarNodo("D");
		grafito.InsertarNodo("E");
		grafito.InsertarNodo("F");
		grafito.InsertarNodo("G");
		grafito.InsertarNodo("H");
		grafito.InsertarArista("A", "B",10);
		grafito.InsertarArista("A", "C",8);
		grafito.InsertarArista("C", "B",8);
		grafito.InsertarArista("D", "B",4);
		grafito.InsertarArista("C", "E",5);
		grafito.InsertarArista("G", "E",2);
		grafito.InsertarArista("G", "C",7);
		grafito.InsertarArista("E", "D",5);
		grafito.InsertarArista("D", "F",5);
		grafito.InsertarArista("E", "F",7);
		grafito.InsertarArista("F", "G",12);
		grafito.InsertarArista("F", "H",4);
		grafito.InsertarArista("G", "H",5);
		CoverSet Problem=new CoverSet();
		for( int i=0;i<grafito.n;i++ )
			Problem.InsertarSet( grafito.GetSet( grafito.Nombre[i] ) );
		for( int i=0;i<grafito.n;i++ )
			Problem.SubSets[i].Mostrar();
		
		
		//System.out.println("mascara="+Problem.MaskAll);
		Problem.solve(0, 0, 0);
		System.out.println("--------------------------------");
		System.out.println("costo del Set Cover="+Problem.resmin);
		System.out.print("Vertex Cover:");
		for(int i=0;i< Problem.conR ;i++)
			System.out.print(Problem.NRes[i]+" ");
		System.out.println("\nSet Cover:");
		for(int i=0;i< Problem.conR ;i++)
			Problem.buscar(Problem.NRes[i]);
		
	}
	
	
}
