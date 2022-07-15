
public class Cola {// simulamos una cola de prioridad para usarla en el dijkstra
	Arista arr[]=new Arista[2010];/// en un arreglo de aristas simulamos un arbol binario
	int tot;// total de elementos el la lista
	
	
	// cambia el valor de 2 nodos dentro de nuestra cola
	public void Cambiar(int p1,int p2) {
		// recibe la posicion de los 2 nodos y les cambia el valor con tem 
		Arista tem=arr[p1];
		arr[p1]=arr[p2];
		arr[p2]=tem;
	}
	
	// el constructor de la cola 
	// recibe un tamano y construye los espacios de los arrgloes
	public Cola(int er) {
		tot=0;
		for(int i=1;i<=er;i++)/// lo llena de aristas vacias 
			arr[i]=new Arista(" "," ",0);
	}
	
	// inserta una arista en la cola
	public void Insertar( Arista nuevo  ) {
		arr[ ++tot ]=nuevo;// lo mete al final del arbol , siendo una hoja
		
		int pos=tot/2;//pos es el padre del nuevo nodo 
		int ant=tot;// ant apunta al nodo nuevo
		
		/// en el ciclo subiran simultaneamente para realizar las comparaciones y reordenar los valores 
		while( pos>=1 ) {// aquie vamos a ir subiendo en el arbol hasta la raiz
			if( arr[ant].Dis<arr[pos].Dis ) {// comparamos los valores si el hijo es menor al padre
				Cambiar( ant,pos );/// el hijo sube y el padre baja
				
				// aquie los subimos a los 2 
				ant/=2;
				pos/=2;
			}
			else
				break;
		}
		
	}

	public Arista Ver() {// te regresa la arista de menor distancia en toda la cola 
		return arr[1];// el menor siempre anda en la raiz
	}
	
	//elimina el valor mas pequeno de la cola que se encuentra en arr[1]
	public void Eliminar(  ) {
		arr[1]=arr[ tot ];/// el ultimo valor agregado, sera el nuevo valor en la raiz
		arr[tot--]=new Arista(" "," ",0);
		int pos=1;
		while( pos*2<=tot ){// se hace un ajuste en el arbol
			// con pos recorremos el arbol desde la raiz hacia abajo
			int v1=arr[pos*2].Dis;
			if( pos*2+1<=tot )// comparamos los nodos hijos de pos 
				v1=Math.min( v1 , arr[pos*2+1].Dis );
			
			if( arr[pos].Dis>v1 ) {// debemos confirmar que uno de los 2 hijos sea menor al valor en pos
				if( v1==arr[pos*2].Dis ) {
					//sii el hijo izquiero es menor, ent sube el hijo
					Cambiar( pos*2,pos );
					pos*=2;/// bajamos a la izquierda para repetir el procesi
				}
				else {
					//sii el hijo derecho es menor, ent sube el hijo
					Cambiar( pos*2+1,pos );
					pos=pos*2+1;/// bajamos a la derecho para repetir el procesi
				}
			}
			else//si el valor en pos ya es el menor terminoo de organizar el arbol
				break;
		}
		
	}
	/// muestra la infromacion de la cola y de las aristas que contiene
	public String tostring() {
		String Wrd="";
		for(int i=1;i<=tot;i++)
			Wrd+=arr[i].Dis+" ";
		return Wrd;
	}
}