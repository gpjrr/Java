
public class Lista {
	Nodo Raiz;
	int Tot;
	String Nombre;
	public Lista() {
		Raiz=null;
		Tot=0;
		Nombre="";
	}
	public void Insertar( String name,int Dis ) {
		Tot++;
		Nodo nuevo=new  Nodo( name,Dis );
		
		if( Raiz==null ) 
			Raiz=nuevo;
		else {
			nuevo.Sig=Raiz;
			Raiz=nuevo;
		}
		

		
	}
	public String Imprimir() {
		String cad="";
		Nodo pos;
		pos=Raiz;
		while(  pos!=null ) {
			cad+="["+pos.Nombre+","+pos.dis+"]";
			cad+=" ";
			///System.out.print( cad+"\n" );
			pos=pos.Sig;

		}		
		cad+="\n";
		return cad; 
	}
		
	public int  Buscar( String palabra ) {
		Nodo pos;
		int con=0;
		pos=Raiz;
		
		while( pos!=null ) {
			
	//System.out.print(con +" "+pos.Nombre+" "+palabra  + "\n" );
			if( pos.Nombre .compareTo( palabra )==0 ) {		
				return con;
			}
			pos=pos.Sig;
			con++;
		}
		return -1;
	}
	public void Eliminar( String palabra ) {
		int posDeNodoMuerto=this.Buscar(palabra);

		if( posDeNodoMuerto==-1 )
			return;
		
		if( posDeNodoMuerto==0   ) {
			/// vamos  a quitar la raiz
			Raiz=Raiz.Sig;
		}
		else {
			int con=0;
			Nodo pos=this.Raiz;
			while( con +1 <posDeNodoMuerto  ) {
				con++;
				pos=pos.Sig;
			}
			
			///termina el ciclo 
		//		pos esta atras de nodo muerto
			Nodo muerto=pos.Sig;
	
			pos.Sig=muerto.Sig;
			
		}
		Tot--;
	}	
	
	
	
}




