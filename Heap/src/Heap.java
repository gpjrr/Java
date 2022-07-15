
public class Heap {
	Nodo[] Arr=new Nodo[2000];
	int n;
	public Heap( ) {
		for(int i=1;i<=150;i++)
			Arr[i]=new Nodo(0 ); 
		n=0;
	}
	
	public void  Insert(int val) {
		Nodo nuevo=new Nodo( val );
		if( n==0 ) {
			n++;
			Arr[n]=nuevo;
			return ;
		}
		n++;
		Arr[n]=nuevo;
		int pos,dad;
		pos=n;
		dad=pos/2;
		while( pos!=1 ) {
			if( Arr[ pos ].dato< Arr[dad].dato ) {
				this.Swap(pos,dad );
				pos=dad;
				dad=pos/2;
			}
			else 
				break;
			
		
		}
		
		return ;
	}
	
	public void Swap(int p1,int p2) {
		int tem=Arr[p1].dato;
		Arr[p1].dato=Arr[p2].dato;
		Arr[p2].dato=tem;
	}
	
	public int Top() {
		return Arr[1].dato;
	}
	public void Eliminar() {
		if( n<1 ) 
			return;
		
		Swap( 1,n );
		n--;
		int pos=1;
		while( pos<=n ) {
			//System.out.print("pos \n");
			int izq,der;
			
	if( pos*2<=n  &&  Arr[pos*2].dato<Arr[pos].dato  )
		izq=Arr[pos*2].dato;
	else
		izq=10000000;
	
	if( pos*2+1<=n  &&  Arr[pos*2+1].dato<Arr[pos].dato  )
		der=Arr[pos*2+1].dato;
	else
		der=10000000;
 
		if(  izq<der &&  izq<Arr[pos].dato ) {
			Swap( pos,pos*2 );
			pos*=2;
		}
		
		if(  der<izq &&  der<Arr[pos].dato ) {
			Swap( pos,pos*2+1 );
			pos*=2;
			pos++;
		}
		if( izq==der && izq==10000000 )
			break;
	
		}
		
		
		
	}
	
	
}
