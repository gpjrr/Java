
public class Heap {
	Estado[] Arr=new Estado[2000];
	int n;
	public Heap( ) {
		for(int i=1;i<=150;i++)
			Arr[i]=new Estado("",0 ); 
		n=0;
	}
	
	public void Insert(String name,int dis) {
		System.out.print(name+"------------"+dis+"\n" );
		if( n==0 ) {
			n++;
			Arr[n]=new Estado(name ,dis);
			return ;
		}
		n++;
		Arr[n]=new Estado(name ,dis);
		int pos,dad;
		pos=n;
		dad=pos/2;
		while( pos!=1 ) {
			if( Arr[ pos ].Dis< Arr[dad].Dis ) {
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
		int tem=Arr[p1].Dis;
		String ntem=Arr[p1].Name;
		Arr[p1].Name=Arr[p2].Name;
		Arr[p1].Dis=Arr[p2].Dis;
		Arr[p2].Dis=tem;
		Arr[p2].Name=ntem;
	}
	
	public void Print() {
		System.out.print(  Arr[1].Name+" "+Arr[1].Dis +"\n");
	}
	public Estado EstadoTop() {
		return Arr[1];
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
			
	if( pos*2<=n  &&  Arr[pos*2].Dis<Arr[pos].Dis  )
		izq=Arr[pos*2].Dis;
	else
		izq=10000000;
	
	if( pos*2+1<=n  &&  Arr[pos*2+1].Dis<Arr[pos].Dis )
		der=Arr[pos*2+1].Dis;
	else
		der=10000000;
 
		if(  izq<der &&  izq<Arr[pos].Dis ) {
			Swap( pos,pos*2 );
			pos*=2;
		}
		
		if(  der<izq &&  der<Arr[pos].Dis ) {
			Swap( pos,pos*2+1 );
			pos*=2;
			pos++;
		}
		if( izq==der && izq==10000000 )
			break;
	
		}
		
		
		
	}
	
	
}
