  

public class Nodo {
	int dato;

	Nodo nxt;
	public Nodo(int cosa) {
		dato=cosa;
		nxt=null;
		//System.out.print( dato.getClass().getName() +" ");
	}
	public String toString() {
		String cad="";
		cad+=dato;
		return cad;
	}
}