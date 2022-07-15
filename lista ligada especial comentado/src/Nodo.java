  public class Nodo {
	int dato;

	Nodo nxt;
	/// la funcion que construye un nodo 
	//recibe un dato 
	public Nodo(int cosa) {
		dato=cosa;
		nxt=null;
		//System.out.print( dato.getClass().getName() +" ");
	}
	// regresa una cadena para mostrar el contenido del nodo
	public String toString() {
		String cad="";
		cad+=dato;
		return cad;
	}
}