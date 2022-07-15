import java.util.Arrays; 
import java.util.Random;
import java.util.Scanner; 		
import java.io.*;

public class Grafo {
	int n,m;
	// n es el total de nodos
	// m el total de aristas
	private Vertice Raiz;
	String Word="";
	
	/// construimos el; grafo, recibe el nombre del archivo 
	public void Construir( String titulo ) throws IOException{		
//		dis=new  int[3030];
		
		///abirmos el archivo  y el lector del archio
		File f=new File( titulo );
		FileReader rf=new FileReader(f);
		BufferedReader br=new BufferedReader( rf );
		
		m=0;
		n=Integer.parseInt( br.readLine() );// leemos el total de nodos
		
		
		for(int i=1;i<=n;i++) {
			// leer vertices nombres
		/// leemos el nombre del nodo y lo construimos en la funcion
			InsertarVertice( br.readLine() );
		}
			
		// vamos a leer las aristas
		/// n
		while(n>=0) {// el ciclo truena hasta que lea una distancia -1
			/// leeer aristas 
			String wrd=br.readLine();
			// leemos una oracion larga que contiene el nombre de los 2 nodos
			String n1="",n2="";
			
			//separamos la oracion y guardamos el primer nombre
			for(int j=0;  wrd.charAt(j)!=' ';j++) 
				n1+=wrd.charAt(j);
			
			/// leemos el segundo nombre
			String popo="";
			for(int j=wrd.length()-1 ;wrd.charAt(j)!=' ' ;j--)
				popo+=wrd.charAt(j);
			
			/// se voltean las letras porque se leyo al reves jajaj
			for(int j=popo.length()-1;j>=0;j--)
				n2+=popo.charAt( j );
			// leemos la distancia entre estos 2 nodos
			int dis=Integer.parseInt( br.readLine() );
			if( dis==-1 )// si es -1 ya no hay aristas
				return;
			// insertamos la arista mandando los nombre y la distancias 
			InsertarArista( n1,n2,dis );
			m++;// incrementamos el contador de arisas 
		}
		
	}
	
	// busca el nodo de  un vertice dado el nombre
	public Vertice BuscarVertice(String nombre) {
		// con i recorremos la lista de nodos
		for(Vertice i=Raiz; i!=null ; i=i.sig  )
			if( i.Name.equals( nombre ) )// si son iguales los nombre  regtresamos el nodo
				return i;
		return null;/// si no hay nada regresa null
	}
	
	// metemos un nuevo nodo al grafo
	public void InsertarVertice( String nombre ) {
		Vertice nuevo=BuscarVertice( nombre );
		//	primero lo buscamos para evitar repetidos
		if( nuevo==null ) {
			
			if( Raiz!=null ) {// si ya hay otros nodo ent lo metemos al final de la lista
				Vertice i=Raiz;// avanzamos con i en la lista
				for(  ; i.sig!=null; i=i.sig );
				// que i apunte al nuevo vertice
				i.sig= new Vertice( nombre );
			}
			else // si no hay nodos va a ser la raiz
				Raiz=new Vertice( nombre ); 
		}
	}
	
	
	/// inserta una arista entre 2 nodos
	public void InsertarArista( String origen, String destino,int dis ) {
		Vertice b1=BuscarVertice( origen );
		Vertice b2=BuscarVertice( destino );
		// buscamos que existan los 2 nodos del grafo
		if( b1!=null && b2!=null ) {
			// si existen entonces podemos construir la arista
			
			//construimos los vertices adyacentes para la sublista de cada nodo, siendo que es bidireccional la arista 
			VerticeAdyacente n1=new VerticeAdyacente( origen, dis );
			VerticeAdyacente n2=new VerticeAdyacente( destino, dis );
			
			// checamos si el nodo origen ya tiene adyacentes
			if( b1.raiz!=null ) {
				/// si ya los tiene avanzmos hasta el final de su sublista con i
				VerticeAdyacente i=b1.raiz;
				for(;i.sig!=null;i=i.sig);
				// metemos el nuevo subnodo
				i.sig=n2;		
			}
			else// sino habian nodos decimos que es su raiz
				b1.raiz=n2;
			
			/// hacemos lo mismo con el nodo destino
			
			if( b2.raiz!=null ) {
				VerticeAdyacente i=b2.raiz;
				for(;i.sig!=null;i=i.sig);
				i.sig=n1;		
			}
			else
				b2.raiz=n1;
			
		}
	
	}

	
	// muestra la informacion del grafo
	public String toString() {
		// muestra la infortmacion de cada nodo y la regresa en un STring
		String cad="";
		for(Vertice i=Raiz; i!=null ; i=i.sig  ) {
			cad+=i.Name;
			cad+=" :";
			cad+=i.imprime();
			cad+="\n";
		}
		return cad;
	}

// usamos recursion para hacer el recorrido de profundida
	public void dfs( Vertice pos ) {
		pos.vis=true;// lo marcamos como visitado
		Word+=pos.Name+" ";// en word marcarmos el recorrido
		VerticeAdyacente son=pos.raiz;// con son vemos que nodos tiene adyacente y checamos 
		for( ;son!=null;son=son.sig )
			if( BuscarVertice( son.Name ).vis==false )// si no ha sido visitado ese nodo podemos movernos a el
				dfs( BuscarVertice(son.Name) );// llamamos otra vez a dfs
		/// queda obsercar que en son , solo guarda el nombre de los vertices adyacetnes
		// por ello usamos buscarvertice para wque nos regrese un Nodo de la clase Vertice
	}
	
	//// busqueda de profundidad
	public String BusquedaProfundidad( String sujeto ) {
		Word="";
		// marcamos todos como no visitados
		for(Vertice i=Raiz;i!=null;i=i.sig)
			i.vis=false;
		/// vemox si existe el nodo
		Vertice pos=BuscarVertice( sujeto );
		if( pos==null )// si no existe nos salimos
			return Word;
		dfs( pos );/// llamos a dfs para hacer el recorrido
		return Word;// regresamos  la word 
	}
	
	
	//regresa el string con la explicacion de la amplitud
	public String BusquedaAmplitud( String sujeto ) {
		Word="nodo \t distancia \n";
		/// marcamos los nodos como no visitados
		for(Vertice i=Raiz;i!=null;i=i.sig)
			i.vis=false;
	
		// vemos si el nodo inicial existe
		Vertice pos=BuscarVertice( sujeto );
		if( pos==null )// sino nos salimos
			return Word;
	
		/// en nivel guarfamos la altura de cada nodo dentro de nuestro arbol de amplitus
		int[]  nivel=new int[1010];
		/// una cola para la buqueda
		Vertice[] cola=new Vertice[1010];
		int ini=1;
		int fin=1;
		//metemos el primer nodo a la cola
		cola[1]=BuscarVertice( sujeto );
		nivel[1]=0;
		
		// mientras existan elemetos en la cola 
		while( ini<=fin ) {
			//System.out.println(ini+" "+fin+"\n" );
			
			/// yo es el nodo de enfrente en la cola
			Vertice yo=cola[ini++];
			if( yo.vis==true )// si ya fue visitado no hacemos nada
				continue;
			// lo marcamos como visitado
			yo.vis=true;
			/// guardamos la informacion en word
			Word+=yo.Name+" \t "+nivel[ini]+"\n";
			// con son vemos los nodos adyacentes de "yo"
			VerticeAdyacente son=yo.raiz;
			for( ;son!=null;son=son.sig )
				// si aun no han sido visitados los metemos a la cola
				if( BuscarVertice( son.Name ).vis==false ) {
					//queda observar que usamos buscarVertice como en la funcion DFS
					cola[ ++fin ]=BuscarVertice( son.Name );
					nivel[ fin ]=nivel[ini-1]+1;
				}
			
		}
		return Word;//regresamos la informacion
	}

	
	
	/// el dijstra construye los caminos minimos desde un nodo origen
	public String dijkstra(String origen,String destino) {
		int min=0;
		
		Vertice pos=BuscarVertice(origen);
		/// vemos si existe el nodo origen
		if( pos==null )
			return "no existe el nodo";
		
		
		pos.dist=0;
		Arista tem=new Arista(pos.Name," ",0);
		// construimos nuestra cola de prioridad y le metemos una arista para empezar el recorrido
		Cola queue=new Cola(1000);
		queue.Insertar( tem );
		
		int Suma=0;
		
		//miestras hay elementos en la cola trabaja
		while( queue.tot>=1 ) {
			// tomamos la arista minima
			tem=queue.Ver();
			//la sacamos de la cola para trabajar con ella
			queue.Eliminar();
			//pos es el nodo que nos regreso la cola
			pos= BuscarVertice(tem.Nod1);
			
			//si el camino que nos muestra la cola es mayor a otros caminos que han llegado antes a el nodo pos
			// ya no hacemos nada porque ya hay mejores caminos minimos
			if( tem.Dis>pos.dist )
				continue;
			
			// actualizamos la distancia del mejor camino para ese nodo 
			pos.dist=tem.Dis;
			/// y de que nodo viene
			pos.dad=tem.Nod2;
			
			
			//siii el nodo pos es el destino rompemos el ciclo
			if( pos.Name.equals( destino )==true ) {
				//guardamos la distancia total
				Suma=tem.Dis;
				break;
			}
			/// checamos los nodos adyacenes
			VerticeAdyacente vis=pos.raiz;
			while( vis!=null ) {// recorremos la sublista del nodo, sobre sus nodos vecinos
				int t1=tem.Dis+vis.Dis;// calculamos la distancia acumulada mas la arista que los conecta
				Vertice posible=BuscarVertice( vis.Name );//tomamos la informacion del nodo posiblee
				if( posible.dist>t1 ) // si la distancia del nodo es mayor a lo que proponemos
					// podemos meter la arista a la cola
					queue.Insertar( new Arista(posible.Name , pos.Name ,t1) );
				vis=vis.sig;// avanza el nodo que recorre los vertices adyacentes
			}
						
		}		
		/// construimos el camino minimo
		String word="dis="+Suma+"\n";
		pos=BuscarVertice( destino );
		/// pos es el ultimo nodo
		/// y de va a ir regresando conforme a su nodo padre hasta llegar al origna
		while( pos!=null ) {
			word+=pos.Name+" ";// guardamos la informacion
			pos=BuscarVertice( pos.dad );/// nos movemos al nodo padre
		}
		word+="\n";
			
		return word;// regresamos el resultado
		
		
	}
	// construye el arbol de expansion minima
	public String prims(String origen) {
		
		Vertice yo=BuscarVertice(origen);
		VerticeAdyacente pos=yo.raiz; 
		
		// usamos una cola de priorida para ir conectando las aristas de menor peso 
		Cola queue= new Cola(1010);
		while( pos!=null ) {//metemos todas las aristas de nuestro nodo origen para comenzar con el proces
			queue.Insertar( new Arista( pos.Name , yo.Name , pos.Dis ) );
			pos=pos.sig;
		}
		
		//marcamoes el origen como visitado 
		yo.vis=true; 
		/// mientras hay aristas en la cola 
		while( queue.tot>=1 ) {
			Arista tem=queue.Ver();
			queue.Eliminar();// tomamos la informacion de la arista minima de la cola y la sacamos de la cola
			
			Vertice ult=BuscarVertice( tem.Nod1 );// vemos que vertice es 
			// si no ha sido visitado significa que no hay un camino entre el nodo y el arbol
			/// por ello lo tienes que conectar
			if( ult.vis==false ) {
				ult.vis=true;// lo marcamos como conectado
				Word+=tem.Nod1 + "-"+ tem.Nod2 +" dis="+tem.Dis+"\n";// guardamos la informacion de la arista 
				pos=ult.raiz;// pos es la raiz de la sublista del nuevo nodo
				
				while( pos!=null ) {// y metemos todas la aristas de los nodos adyacentes con respecto al ultimo nodo agregado
					queue.Insertar( new Arista( pos.Name , ult.Name , pos.Dis ) );// se mete la arista
					pos=pos.sig;
				}
			}
		}
		
		return Word;/// regresamos la informacion
	}
}