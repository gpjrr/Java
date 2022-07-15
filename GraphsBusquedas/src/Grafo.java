import java.util.Arrays; 
import java.util.Random;
import java.util.Scanner; 		
import java.io.*;

public class Grafo {
	int n,m;
	private Vertice Raiz;
	String Word="";
	
	Arista[] Lineas=new Arista[1000];
	int Tlinea;
	
	public void Construir( String titulo ) throws IOException{		
//		dis=new  int[3030];
		File f=new File( titulo );
		FileReader rf=new FileReader(f);
		BufferedReader br=new BufferedReader( rf );
		
		m=0;
		n=Integer.parseInt( br.readLine() );
		
		
		for(int i=1;i<=n;i++) {
			// leer vertices nombres
			InsertarVertice( br.readLine() );
		}
			
		while(n>=0) {
			/// leeer aristas 
			String wrd=br.readLine();
			String n1="",n2="";
			
			for(int j=0;  wrd.charAt(j)!=' ';j++) 
				n1+=wrd.charAt(j);
			
			String popo="";
			for(int j=wrd.length()-1 ;wrd.charAt(j)!=' ' ;j--)
				popo+=wrd.charAt(j);
			
			for(int j=popo.length()-1;j>=0;j--)
				n2+=popo.charAt( j );
			
			int dis=Integer.parseInt( br.readLine() );
			if( dis==-1 )
				return;
			//System.out.println( n1+" "+n2+"\n" );
			InsertarArista( n1,n2,dis );
			m++;
		}
		
	}
	
	public Vertice BuscarVertice(String nombre) {
		for(Vertice i=Raiz; i!=null ; i=i.sig  )
			if( i.Name.equals( nombre ) )
				return i;
		return null;
	}
	
	public void InsertarVertice( String nombre ) {
		Vertice nuevo=BuscarVertice( nombre );
		if( nuevo==null ) {
	
			if( Raiz!=null ) {
				Vertice i=Raiz;
				for(  ; i.sig!=null; i=i.sig );
				i.sig= new Vertice( nombre );
			}
			else 
				Raiz=new Vertice( nombre ); 
		}
	}
	
	public void InsertarArista( String origen, String destino,int dis ) {
		Vertice b1=BuscarVertice( origen );
		Vertice b2=BuscarVertice( destino );
		if( b1!=null && b2!=null ) {
			VerticeAdyacente n1=new VerticeAdyacente( origen, dis );
			VerticeAdyacente n2=new VerticeAdyacente( destino, dis );
			
			if( b1.raiz!=null ) {
				VerticeAdyacente i=b1.raiz;
				for(;i.sig!=null;i=i.sig);
				i.sig=n2;		
			}
			else
				b1.raiz=n2;
			
			if( b2.raiz!=null ) {
				VerticeAdyacente i=b2.raiz;
				for(;i.sig!=null;i=i.sig);
				i.sig=n1;		
			}
			else
				b2.raiz=n1;
			
		}
	
	}
	
	public String toString() {
		String cad="";
		for(Vertice i=Raiz; i!=null ; i=i.sig  ) {
			cad+=i.Name;
			cad+=" :";
			cad+=i.imprime();
			cad+="\n";
		}
		return cad;
	}
 	
	public boolean find(Vertice yo, String busco) {///aqui buscamos al nodo "busco" 
		//el vertice "yo" es la posicion en la que estoy
		if( yo.Name.compareTo( busco )==0 )/// si encuentro al nodo return true 
			return true;
		if( yo.vis==true )/// estoy en un nodo que ya visite 
			return false;
		yo.vis=true;/// lo marca como visitado
		for( VerticeAdyacente i=yo.raiz;i!=null; i=i.sig )/// se mueve a sus adyacentes
			if( find( BuscarVertice( i.Name),busco )==true  )
				return true;
		return false;
	}
	
	public void OrdenarAristas() {
		for(int i=0;i<Tlinea;i++)/// bubble sort 
			for(int j=0;j<Tlinea;j++)//ordenamos las aristas del arreglo respecto a la distancia
				if( Lineas[j].Dis>Lineas[i].Dis  ) {
					Arista tem=new Arista( Lineas[i].Nod1,Lineas[i].Nod2, Lineas[i].Dis );
				Lineas[i]=new Arista( Lineas[j].Nod1,Lineas[j].Nod2,Lineas[j].Dis );
				Lineas[j]=new Arista( tem.Nod1,tem.Nod2,tem.Dis );
				}
					
	}

	public void Limpiar() {//aqui limpiamos a todos los nodos
		for( Vertice it=Raiz;it!=null;it=it.sig )
			it.vis=false;
	
	}
	
	public String Kruskal() {
		String Res="";//// aqui guardamos la respuesta
		Tlinea=0;
		for(int i=0;i<500;i++) 
			Lineas[i]=new Arista("","",0);
		
		for(Vertice it=Raiz;it!=null;it=it.sig ) {/// extraer todas la aristas del grafo
			for( VerticeAdyacente jt=it.raiz;jt!=null; jt=jt.sig )
				Lineas[ Tlinea++ ]=new Arista(it.Name,jt.Name, jt.Dis );
			it.vis=false;
		}
		OrdenarAristas();
		
		Grafo MST=new Grafo();/// construimos el grafo vacio 
		
		for(int i=0;i<Tlinea;i++){/// recorremos las aristas de menor a mayor
			Arista lin=Lineas[i];
			//System.out.println(Lineas[i].Nod1+"------"+Lineas[i].Nod2+" Dis="+Lineas[i].Dis);
			//System.out.println(lin.Nod1+"_"+lin.Nod2+"="+lin.Dis);
			MST.Limpiar();	/// le quitamos la marca de visitados a los nodos
			Vertice tem=MST.BuscarVertice( lin.Nod1 );//busco el primer en el mst
			boolean ban=false;/// es una banderita para saber si se va a agregar la arista
			if (  tem==null ) // si no existe lo puedo conectar
				ban=true;
			else{
				if( MST.find( tem, lin.Nod2 )==false )/// usamos la dfs 
					ban=true;// va a ser true si no hay un camino entre los 2 nodos
			}
			
			
			if( ban==true ) {/// se agrega la arista 
				MST.InsertarVertice( lin.Nod1 );/// intentamos agregar
				MST.InsertarVertice( lin.Nod2 );
				/// usamos la funcion de agregar arista 
				MST.InsertarArista( lin.Nod1,lin.Nod2,lin.Dis );
				/// guardamos la informacion de la arista en el string de respuesta
				Res+=lin.Nod1+"-"+lin.Nod2+" dis="+lin.Dis+"\n";
			}
		}
		
		return Res;
	}

	public String prims(String origen) {
		Vertice yo=BuscarVertice(origen);
		VerticeAdyacente pos=yo.raiz; 
		Cola queue= new Cola(1010);
		while( pos!=null ) {
			queue.Insertar( new Arista( pos.Name , yo.Name , pos.Dis ) );
			pos=pos.sig;
		}
		yo.vis=true;
		
		while( queue.tot>=1 ) {
			Arista tem=queue.Ver();
			queue.Eliminar();
			Vertice ult=BuscarVertice( tem.Nod1 );
			if( ult.vis==false ) {
				ult.vis=true;
				Word+=tem.Nod1 + "-"+ tem.Nod2 +" dis="+tem.Dis+"\n"; 
				pos=ult.raiz;
				while( pos!=null ) {
					queue.Insertar( new Arista( pos.Name , ult.Name , pos.Dis ) );
					pos=pos.sig;
				}
			}
		}
		
		return Word;
	}

	public String dijkstra(String origen,String destino) {
		int min=0;
		
		Vertice pos=BuscarVertice(origen);
		
		if( pos==null )
			return "no existe el nodo";
		
		pos.dist=0;
		Arista tem=new Arista(pos.Name," ",0);
		Cola queue=new Cola(1000);
		queue.Insertar( tem );
		int Suma=0;
		while( queue.tot>=1 ) {
			tem=queue.Ver();
			queue.Eliminar();
			pos= BuscarVertice(tem.Nod1);
			
			
			if( tem.Dis>pos.dist )
				continue;
			
			pos.dist=tem.Dis;
			pos.dad=tem.Nod2;
			if( pos.Name.equals( destino )==true ) {
				Suma=tem.Dis;
				break;
			}
			
			VerticeAdyacente vis=pos.raiz;
			while( vis!=null ) {
				int t1=tem.Dis+vis.Dis;
				Vertice posible=BuscarVertice( vis.Name );
				if( posible.dist>t1 ) 
					queue.Insertar( new Arista(posible.Name , pos.Name ,t1) );
				vis=vis.sig;
			}
						
		}		
		
		String word="dis="+Suma+"\n";
		pos=BuscarVertice( destino );
		
		while( pos!=null ) {
			//System.out.println(pos.Name+" "+pos.dad);
			word+=pos.Name+" ";
			pos=BuscarVertice( pos.dad );
		}
		word+="\n";
			
		return word;
		
		
	}
}