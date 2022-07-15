public class Grafo {
	int[][] mat=new int[1000][1000];
	String[] Nombre=new String[100];
	int n;
	public Grafo() {
		n=0;
	}
	int buscar(String yo) {
		for(int i=0;i<n;i++)
			if( Nombre[i].compareTo(yo)==0 )
				return i;
		return -1;
	}
	void InsertarNodo(String name) {
		Nombre[n++]=name;
	}
	void InsertarArista(String n1,String n2,int peso) {
		int v1=buscar(n1);
		int v2=buscar(n2);
		if( Math.min( v1 , v2)==-1 )
			return;

		mat[v1][v2]=peso;
		mat[v2][v1]=peso;
	}
	
	public Set GetSet(String Nodo) {
		Set Res=new Set();
		int pos=buscar( Nodo );
		if( pos==-1 )
			return Res;
		Res.ID=pos;
		Res.Insertar(Nodo  , 0);
		for(int i=0;i<n;i++)
			if( mat[pos][i]!=0 )
				Res.Insertar(Nombre[i] , mat[pos][i] );
		return Res;
	}
	
}
