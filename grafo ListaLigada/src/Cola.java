public class Cola {
	int[] arr;
	String Names[];
	int ini,fin;
	int tam;
	public Cola( ) {
		ini=1;
		fin=0;
		tam=0;
		arr=new int[300];
		Names=new String[300];
	}
	public void Insertar( int val, String nodo ) {
		fin++;
		arr[fin]=val;
		Names[ fin ]=nodo;
		tam++;
	}
	public void Eliminar( ) {
		ini++;
		tam--;
	}
	public String topNombre() {
		return Names[ ini ];
	}
	public int topValor() {
		return arr[ ini ];
	}
	
	public int size() {
		return tam;
	}
	public Boolean IsEmpty() {
		if( tam==0 )
			return true;	
		return false;
	}
	
	public void clear() {
		ini=1;
		fin=0;
		tam=0;
	}
	
	
}