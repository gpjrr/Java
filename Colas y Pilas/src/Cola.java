public class Cola {
	int[] arr;
	int ini,fin;
	int tam;
	public Cola( ) {
		ini=1;
		fin=0;
		tam=0;
		arr=new int[300];
	}
	public void Insertar( int val ) {
		fin++;
		arr[fin]=val;
		tam++;
	}
	public void Eliminar( ) {
		ini++;
		tam--;
	}
	public int top() {
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
