/// es los nodos a los que se puede mover un nodo del grafo
public class VerticeAdyacente {
	String Name;// nombre del nodo
	VerticeAdyacente sig;/// el siguiente dentro de la lista
	int Dis;// la distancia que hay entre los nodos adayacentes
	public VerticeAdyacente( String nomb,int diss ) {// recibe el nombre y la distancia
		Name=nomb;
		sig=null;
		Dis=diss;
	}
}