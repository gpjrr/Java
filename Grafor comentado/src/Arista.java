/// la  clase arista es eso, una arista jajaja
/// guarda el nombre de los 2 nodos que comparte esa arista 
// y la distancia entre ellos 
public class Arista implements Comparable<Arista>{
	String  Nod1,Nod2;
	int Dis;
	// al constructor le mandamos todos los datos
	public Arista(String n1,String n2,int ds) {
		Nod1=n1;
		Nod2=n2;
		Dis=ds;
	}
	// construimos un comparador de aristas con respecto a la distancia
	// esto lo usamos para la cola de prioridad 
	public int compareTo(Arista arg0) {
		if( this.Dis < arg0.Dis )
		return -1;
		else
		return 1;
	}
	
}