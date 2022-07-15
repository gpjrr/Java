
public class ListaDobleLigada {
	Nodo ini;
	Nodo fin;
	int n;
	
	public ListaDobleLigada() {
		ini=null;
		fin=null;
		Insertar( -100,0 );
		n=0;
	}
	
	public void Insertar(int  cosa,int pos) {
		int con=0;
		Nodo nov=new Nodo(cosa);
		if( ini==null ) {
			ini=nov;
			fin=nov;
		}
		else {
			Nodo tem=ini;
			while( con<pos-1 ) {
				tem=tem.nxt;
				con++;
			}
			nov.nxt=tem.nxt;
			tem.nxt=nov;
		}
		n++;
		if( n==pos )
			fin=nov;
		
	}

	
	public int buscar(int val) {
		Nodo tem=ini;
		int cont=0;
		while( tem!=null ) {
			if( tem.dato==val )
				return cont;
			cont++;
			tem=tem.nxt;
		}
		System.out.println("el valor "+val+" no existe\n");
		return -1;
	}
	public int ValorPos(int pos) {
		Nodo tem=ini;
		int cont=0;
		while( cont!=pos ) {
			cont++;
			tem=tem.nxt;
		}
		return tem.dato;
	}
	
	public String toString() {
		String cad="";
		Nodo tem=ini.nxt;
		while( tem!=null ) {
			cad+=tem.dato;
			cad+=" ";
			tem=tem.nxt;
		}
		return cad;
	}
	
	public void Resort() {
		
		for(int k=1;k<=n;k++) {
			Nodo i=ini.nxt;
			while( i.nxt!=null ) {
				if( i.dato>i.nxt.dato ) {
					int valo=i.dato;
					i.dato=i.nxt.dato;
					i.nxt.dato=valo;
				}
				i=i.nxt;
			}
			
		}
		
	
	}

	public void Borrar(int pos) {
		int con=0;
		Nodo tem=ini;
		while( con+1<pos ) {
			tem=tem.nxt;
			con++;
		}
		tem.nxt=tem.nxt.nxt;
		if( pos==n ) {
			fin=tem.nxt;
			//fin.nxt=null;
		}		
		n--;
	}
}

