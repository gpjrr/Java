import java.util.Arrays; 
import java.util.Random;
import java.util.Scanner; 		
import java.io.*;

public class Grafo {
	int n,m;
	private Vertice Raiz;
	String Word="";
		
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
		
		String word="distancia ="+Suma+"\n";
		pos=BuscarVertice( destino );
		
		while( pos!=null ) {
			word+=pos.Name+" ";
			pos=BuscarVertice( pos.dad );
		}
		word+="\n";
			
		return word;
		
		
	}


}