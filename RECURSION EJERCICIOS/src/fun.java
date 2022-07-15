
public class fun {
	int[] mem= new int[200];
	public fun() {
		for(int i=0;i<=150;i++)
			mem[i]=-1;
	}
	
	
	public int Sumatoria(int pos ) {
		if( pos==0 )
			return 0;
		if( mem[pos]>-1 )
		return mem[pos];
		
		System.out.print("pos="+pos+"\n" );				
		mem[pos]=Sumatoria( pos-1 )+pos;
		return mem[pos];	
	}
 	public int pot(int base,int p) {
		if( p==0 )
			return 1;
		
		return pot( base,p-1 )*base;	
	}
}
