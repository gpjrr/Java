
public class Grafo {
	int n;
	String[] Names;
	Lista[] Nodos;
	int[] marc;
	int[] Dism;
	boolean[] vis;
	String[] Ant;
	
	public Grafo() {
		Names=new String[200];
		Nodos=new Lista[200];
		marc=new int[200];
		Dism=new int[200];
		vis=new boolean[200];
		Ant=new String[200];
		n=0;	
	}	
		
	public void InsertarNodo(String name){
		if( BuscarNodo( name ) !=-1 )
			return;
		Names[++n ]=name;
		Nodos[n]=new Lista();
		Nodos[ n ].Nombre=name;
	}	
	public void InsertarArista( String n1,String n2,int dis ) {
		int p1=BuscarNodo( n1 );
		int p2=BuscarNodo( n2 );
		if( p1==-1 || p2==-1 )
			return;
		Nodos[p1].Insertar( n2 ,  dis );
		Nodos[p2].Insertar( n1 ,  dis );
	}
	public int BuscarNodo( String name ) {
		
		for(int i=1;i<=n;i++)
			if( name.compareTo( Names[i] )==0 )
				return i;

		return -1;
	}
	public String PrintCercanos( String name ) {
		String cad="";
		int pos=BuscarNodo( name );
		if( pos==-1 )
			return "\n";
		cad+=name+": ";
		cad+=Nodos[pos].Imprimir();
		return cad;
	}
	public void ELiminarNodo(String  name) {
		int pos=BuscarNodo(name );
		if( pos==-1 )
			return;
		Names[pos]="";
		
		Nodo vis=Nodos[pos].Raiz;
		while( vis!=null ) {
			EliminarArista( vis.Nombre ,name);
			vis=vis.Sig;
		}
		Nodos[pos].Raiz=null;
	}
	public void EliminarArista(String n1,String n2  ) {
		int pos=BuscarNodo( n1 );
		Nodos[pos].Eliminar( n2 );
		
	}
	public void limpiar() {
		for(int i=1;i<=n;i++)
			marc[i]=0;
	}
	public String ImprimirGrafo( ) {
		String cad="";
		for(int i=1;i<=n;i++) 
			cad+=PrintCercanos( Names[i] );	
		return cad;
	}
	public String Bfs( String Nombreini ) {
		int[] vis=new int[400];
		for(int i=1;i<=n;i++)
			vis[i]=0;
		
		String cad="";
		Cola fila=new Cola();
		int pos=BuscarNodo( Nombreini );
		if( pos==-1 )
			return "el nodo no existe";
		fila.Insertar( 0 , Nombreini );
		
		while( fila.IsEmpty()!=true ) {
			//proceso de validacion 
			pos=BuscarNodo( fila.topNombre() );
			int con=fila.topValor();
			fila.Eliminar();
			if( vis[pos]==1 )
				continue; 
			
			
			/// proceso de busqueda
			Nodo it=Nodos[ pos ].Raiz;
			while( it!=null ) {
				int pos2=BuscarNodo( it.Nombre );
				if( vis[ pos2 ]==0 ) 
					fila.Insertar( con+1 , it.Nombre );
				it=it.Sig;
			}
			vis[pos]=1;
			cad+=Names[pos]+" "+con+"\n";
		}
		return cad;
	}	
	public String Dfs( String Nombre ) {	
		int pos=BuscarNodo( Nombre );
		if( pos==-1 )
			return "no existe el nodo";
		if( marc[pos]==1 )
			return "";
		String Cad=Nombre+" ";
		marc[pos]=1;
		
		Nodo it=Nodos[pos].Raiz;
		while( it!=null ) {
			Cad+=Dfs( it.Nombre );
			it=it.Sig;
		}
		return Cad;
		
	}


	public String Dijkstra(String Inicio) {
		String Cad="";
		int pos=BuscarNodo( Inicio );
		if( pos==-1 )
			return "no existe el nodo\n";
		for(int i=1;i<=n;i++ ) {
			Dism[i]=1000000;
			vis[i]=false;
		}
		
		Heap cola=new Heap();
		cola.Insert(Inicio, 0);
		Dism[pos]=0;
		Ant[pos]=Inicio;
		while( cola.n>=1 ) {
			//cola.Print();
			Estado act=cola.EstadoTop();
			String yo=act.Name;
			int dis=act.Dis;
			
			System.out.print( yo+"--"+dis+"\n" );
			cola.Eliminar();
			pos=BuscarNodo( yo );
			
			if( vis[pos]==true  ) 
				continue;
			
			vis[pos]=true;
			Cad+=yo+" "+Dism[pos]+"\n";
			String Ntem=yo;
			while( Ntem.equals( Inicio )!=true ) {
				Cad+=Ntem+"-";
				int t1=BuscarNodo( Ntem );
				Ntem=Ant[t1];
			}
			Cad+=Inicio+"\n";
			
			Nodo it=Nodos[pos].Raiz;
			while( it!=null ) {
				int pos2=BuscarNodo( it.Nombre );
				int disact=dis+it.dis;
				//System.out.print(it.Nombre+"__"+disact+"\n" );
				if( disact<Dism[pos2]  ) {
					Dism[pos2]=disact;
					Ant[pos2]=yo;
					cola.Insert( it.Nombre , disact );
					//System.out.print(it.Nombre +"--"+disact+"\n" );
				}
				it=it.Sig;
			}
			
		}
		
		
		
		return Cad;
	}
}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	