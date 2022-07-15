
public class ListaDobleLigada {
	// solo sabemos donde inicia y donde termina la lista
	Nodo ini;
	Nodo fin;
	int n;// n es el total de nodos
	// en el constructor de la lista definimos los valores
	public ListaDobleLigada() {
		ini=null;
		fin=null;
		Insertar( -100,0 );// metemos un nodo de mentis que representa la posicion 0
		n=0;
	}
	// la funcion insertar le damos el valor a insertar y la posicion
	public void Insertar(int  cosa,int pos) {
		int con=0;
		// construimos el nodo
		Nodo nov=new Nodo(cosa);
		if( ini==null ) {// si la lista esta vacia le metemos el primer nodo
			ini=nov;
			fin=nov;
		}
		else {
			/// tem se va a mover una posicion antes de la deseada  para meter el nuevo valor adelantes
			Nodo tem=ini;
			while( con<pos-1 ) {// aqui se desplaza tem
				tem=tem.nxt;// se mueve al sig nod
				con++;// vamos contando en la posicion que se encuentra
			}
			nov.nxt=tem.nxt;// conectamos el nodo nuevo a la lista 
			tem.nxt=nov;
		}// incrementamos n que es el total 
		n++;
		if( n==pos )// si la posicion es la ultima acomdamod al nodo fin
			fin=nov;
		
	}

	
	public int buscar(int val) {// esta funcion busca un valor especial en la lista
		Nodo tem=ini;// tem es el que va a recorrer la lista
		int cont=0;// el contador de la posicion de tem 
		while( tem!=null ) {// aqui se mueve tem
			if( tem.dato==val )/// si encuentra el valor
				return cont;// regresa la posicion 
			cont++;// sinoo avanza de posicion 
			tem=tem.nxt;
		}
		// si llega al final ent 
		System.out.println("el valor "+val+" no existe\n");
		// regresa -1 cuando no encuentra nada
		return -1;
	}
	///esta funcion encuentra el valor que se encuentra en cierta posicion
	public int ValorPos(int pos) {
		Nodo tem=ini;
		int cont=0;// tem recorre el grafo 
		while( cont!=pos ) {// cuando el cont se empata con la pos se rompe el ciclo sino sigue avanzando 
			cont++;
			tem=tem.nxt;
		}
		return tem.dato;// regresa el dato de tem cuando ya esta en la posicion deseada 
	}
	/// muestra la informacion de la lig
	public String toString() {
		String cad="";// regresamos un String de la informacion
		Nodo tem=ini.nxt;// en tem vamos recorriendo la lista
		while( tem!=null ) {// miestra no llegue al final
			cad+=tem.dato;// guardamos la informacion dentro de cad
			cad+=" ";
			tem=tem.nxt;// tem avanza
		}
		// regresamos el string 
		return cad;
	}
	
	public void Resort() {
		/// esta funcion ordena los valores de la lista de menos a mayor 
		/// el ordenamiento es bubble sort, n^2
		for(int k=1;k<=n;k++) {/// se repite el ordenamiento n veces 
			Nodo i=ini.nxt;
			// i va a a recorrer la lista
			while( i.nxt!=null ) {
				// si el valor de i es mayor al que tiene adelante, ent se intercambian 
				if( i.dato>i.nxt.dato ) {
					// en valo es una variable temporal para no perder la informacion
					// cambiamos los valores
					int valo=i.dato;
					i.dato=i.nxt.dato;
					i.nxt.dato=valo;
				}
				// avanza i 
				i=i.nxt;
			}
			
		}
		
	
	}
/// borramos el valor de cierta posicion  	
	public void Borrar(int pos) {
		int con=0;
		Nodo tem=ini;// tem avanza hasta una posicion antes del valor a borrar 
		while( con+1<pos ) {
			tem=tem.nxt;// se mueve tem
			con++;// con incrementa que es para saber la posicion
		}
		
		tem.nxt=tem.nxt.nxt;// dejamos de apuntar a su sig , y ya queda fuera de la lista
		if( pos==n ) {// si borramos el ultimo valor ent actualizamos el nodo del fin
			fin=tem.nxt;
			//fin.nxt=null;
		}		
		n--;// le restamos 1 al total de nodos 
	}
}

