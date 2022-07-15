
public class Vertice {// es la clase donde se guarda todo lo del nodo
	String Name;// nombre 
	Vertice sig;// el siguiente de la lista 
	VerticeAdyacente raiz;// y tiene una sublista de sus nodos vecino a los que se conecta directamente
	Boolean vis=false;
	int dist;/// esta variable la usamos para el dijkstra
	String dad;// de igual forma la usamos para el dijkstra
	// con dad construimos el camino mas corto
	
	public Vertice( String titu ) {// le pasamos el nombre y solo llenamos la informcaion 
		Name=titu;
		sig=null;
		raiz=null;
		vis=false;
		dist=1000000;
		dad=" ";
	}	
	/// regresa un string de sus nodos vecinos
	public String imprime() {
		String Cad="";
		/// en este ciclo recorremos sus nodos adyancentes y guardamos la informacion en un string 
		for( VerticeAdyacente i=raiz; i!=null; i=i.sig ) {
			Cad+="["+i.Name+","+i.Dis+"]";
			Cad+=" ";
		}
	
		return Cad;
	}

}