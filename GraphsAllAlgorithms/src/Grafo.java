import java.util.Arrays; 
import java.util.Random;
import java.util.Scanner; 		
import java.io.*;

public class Grafo {
	int n,m;
	private Vertice Raiz;
	String Word="";
	
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


	public void dfs( Vertice pos ) {
		pos.vis=true;
		Word+=pos.Name+" ";
		VerticeAdyacente son=pos.raiz;
		for( ;son!=null;son=son.sig )
			if( BuscarVertice( son.Name ).vis==false )
				dfs( BuscarVertice(son.Name) );
	}
	
	public String BusquedaProfundidad( String sujeto ) {
		Word="";
		for(Vertice i=Raiz;i!=null;i=i.sig)
			i.vis=false;
		
		Vertice pos=BuscarVertice( sujeto );
		if( pos==null )
			return Word;
		dfs( pos );
		return Word;
	}
	
	public String BusquedaAmplitud( String sujeto ) {
		Word="nodo \t distancia \n";
		for(Vertice i=Raiz;i!=null;i=i.sig)
			i.vis=false;
	
		Vertice pos=BuscarVertice( sujeto );
		if( pos==null )
			return Word;
	
		int[]  nivel=new int[1010];
		Vertice[] cola=new Vertice[1010];
		int ini=1;
		int fin=1;
		
		cola[1]=BuscarVertice( sujeto );
		nivel[1]=0;
		while( ini<=fin ) {
			System.out.println(ini+" "+fin+"\n" );
			Vertice yo=cola[ini++];
			if( yo.vis==true )
				continue;
			yo.vis=true;
			Word+=yo.Name+" \t "+nivel[ini]+"\n";
			
			VerticeAdyacente son=yo.raiz;
			for( ;son!=null;son=son.sig )
				if( BuscarVertice( son.Name ).vis==false ) {
					cola[ ++fin ]=BuscarVertice( son.Name );
					nivel[ fin ]=nivel[ini-1]+1;
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
			word+=pos.Name+" ";
			pos=BuscarVertice( pos.dad );
		}
		word+="\n";
			
		return word;
		
		
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
}