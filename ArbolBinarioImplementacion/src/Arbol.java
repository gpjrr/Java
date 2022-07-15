
public class Arbol {
	Nodo Raiz;
	int tot;
	public Arbol() {
		Raiz=null;
		tot=0;
	}
	public void Insertar( int val ) {
		Nodo nuevo=new Nodo( val );
		System.out.print( "vamos a meter el valor"+val+"\n" );
		if( Raiz==null ) {
			Raiz=nuevo;
		}
		else {	
			Nodo pos=Raiz;
			while( pos!=null  ) {
				System.out.print( "pos "+pos.Dato+"\n" );
				if( nuevo.Dato<= pos.Dato  ) {
					if( pos.Izq==null ) {
						//metemos el nuevo nodo
						pos.Izq=nuevo;
						nuevo.Dad=pos;
						break;
					}
					else
						pos=pos.Izq;
				
				}
				else { 
					if( pos.Der==null ) {
						//metemos el nuevo nodo
						pos.Der=nuevo;
						nuevo.Dad=pos;
						break;
					}
					else
						pos=pos.Der;
				}
			}
		}
		
		
		
	}
	
	public int Buscar(int val) {
		Nodo pos=Raiz;
		int con=1;
		while( pos!=null ) {
			/// si lo encontramos
			if( pos.Dato==val ) {
				return con;
			}
			
			if(  val<=pos.Dato ) {
				pos=pos.Izq;
				con++;
			}
			else {
				pos=pos.Der;
				con++;
			}
		
		}
		return -1;
	}
	public void Preorden(  Nodo pos ) {
	
		if( pos==null )
			return;
	
		Preorden( pos.Izq );
		
		System.out.print( pos.Dato+"\n" );
		Preorden( pos.Der );
		
	}
	
	

	
	
	
}
