
public class Vertice {
	String Name;
	Vertice sig;
	VerticeAdyacente raiz;
	Boolean vis=false;
	int dist;
	String dad;
	
	public Vertice( String titu ) {
		Name=titu;
		sig=null;
		raiz=null;
		vis=false;
		dist=1000000;
		dad=" ";
	}	
	public String imprime() {
		String Cad="";
		for( VerticeAdyacente i=raiz; i!=null; i=i.sig ) {
			Cad+="["+i.Name+","+i.Dis+"]";
			Cad+=" ";
		}
		return Cad;
	}

}