
public class CoverSet {
	int n;
	int MaskAll;
	Set[] SubSets=new Set[1000];
	String[] NRes=new String[100];int conR;
	String[] NBus=new String[100]; int conN;
	int resmin;
	int con=0;
	public CoverSet() {
		conN=0;
		for(int i=0;i<100;i++) {
			NBus[i]="";
			NRes[i]="";
		}
		resmin=1000000;
	}
	public void buscar(String yo){
		for(int i=0;i<n;i++ )
			if( SubSets[i].names[0].compareTo(yo) ==0 )
				SubSets[i].Mostrar();
	}
	public void InsertarSet( Set nuevo ) {
		SubSets[n++]=nuevo;
		int pot=(int) Math.pow(2, n);
		MaskAll=pot-1;
	}
	public void Copiar() {
		for(int i=0;i<conN;i++)
			NRes[i]=new String(NBus[i]);
		conR=conN;
	}
	public void solve(int pos,int mask,int suma) {
		if( mask==MaskAll ) {
			if( suma<resmin ) { 
				Copiar();
				resmin=suma;
			}
			return;
		}
		if( pos >=n )
			return;
	
	
			
		solve( pos+1,mask,suma );
		NBus[conN++]=new String ( SubSets[pos].names[0] );
		suma+=SubSets[pos].Costo;
		for( int i=0;i<SubSets[pos].Tn;i++ ) {
			int tem=(int)SubSets[pos].names[i].charAt(0)-'A';
			mask|=( 1<<tem );
		}
		solve( pos+1,mask,suma );
		conN--;
	}

}
