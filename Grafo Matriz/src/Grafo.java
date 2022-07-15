
public class Grafo {
	int n;
	int[][] mat;
	String[] names;
	
	// [ "b","a","c","" ]
	public Grafo() {
		n=0;
		mat=new int[200][200];
		names=new  String[200];
	}
	public void InsertarNodo( String nombre ) {
		n++;
		names[n]=nombre;
	}
	public void InsertarAristas( String n1,String n2,int dis ) {
		int p1=BuscarNodo( n1 );
		int p2=BuscarNodo( n2 );
		
		if( p1==-1 || p2==-2 )
			return;
		
		/// union de una sola direccion ,
		// sup que vamos del n1 al n2
		/*
		  mat[p1][p2]=dis;
		 
		 */
		  mat[p1][p2]=dis;
		  mat[p2][p1]=dis;
		
	}
	public void EliminarAristas( String n1,String n2 ) {
		int p1=BuscarNodo( n1 );
		int p2=BuscarNodo( n2 );
		
		if( p1==-1 || p2==-2 )
			return;
		 mat[p1][p2]=0;
		 mat[p2][p1]=0;	
	}
	public int BuscarNodo(  String nombre) {
		int pos=-1;
		
		for( int  i=1;i<=n;i++ )
			if(  names[i].equals( nombre ) ==true ) {
				pos=i;
				break;
			}
		return pos;
	}
	public String mostrarAristas(String n1) {
			String cad="";
			int p1=BuscarNodo( n1 );
			if( p1==-1 )
				return "el nodo no existe";
			for(int i=1;i<=n;i++)
				if( mat[ p1 ][i]!=0 )
	cad+=n1+"---"+names[i]+"="+mat[ p1 ][i]+"\n";
	
			return cad;
		
	}
	public String mostrarMatriz() {
		String cad="";
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++)
				cad+=mat[i][j]+" ";
			cad+="\n";
		}
	
		return cad;
	}
	
}






