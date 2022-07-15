
public class Lista {
	Nodo Raiz;
	int Tot;
	public Lista() {
		Raiz=null;
		Tot=0;
	}
	public void Insertar( String palabra ) {
		Tot++;
		Nodo nuevo=new  Nodo( palabra );
		
		if( Raiz==null ) {
			Raiz=nuevo;
		}
		else {
			nuevo.Sig=Raiz;
			Raiz.Ant=nuevo;
			Raiz=Raiz.Ant;
			
		}
		
	}
	public String Imprimir() {
		String cad="";
		Nodo pos;
		pos=Raiz;
		while(  pos!=null ) {
			cad+=pos.Word;
			
			cad+=" ";
			///System.out.print( cad+"\n" );
			pos=pos.Sig;

		}		
		return cad; 
	}
		
	public int  Buscar( String palabra ) {
		Nodo pos;
		int con=0;
		pos=Raiz;
		
		while( pos!=null ) {
			
	System.out.print(con +" "+pos.Word+" "+palabra  + "\n" );
			if( pos.Word.compareTo( palabra )==0 ) {		
				return con;
			}
			pos=pos.Sig;
			con++;
		}
		return -1;
	}
	
	public String  ImprimirDerecho() {
		String cad="";
		Nodo Pos=Raiz;
		while( Pos.Sig!=null ) {
			Pos=Pos.Sig;
		}
		
		
		while( Pos!=null ) {
			cad+= Pos.Word+" ";
			Pos=Pos.Ant;
		}
		
		return cad;
		
	}
	
	public void Eliminar( String palabra ) {
		int posDeNodoMuerto=this.Buscar(palabra);

		if( posDeNodoMuerto==-1 )
			return;
	
		
		if( posDeNodoMuerto==0   ) {
			/// vamos  a quitar la raiz
			Raiz=Raiz.Sig;
			Raiz.Ant=null;
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
			muerto.Sig.Ant=pos;
		}
		Tot--;
	}
	public void Eliminar( int posDeNodoMuerto ) {		
		if( posDeNodoMuerto==0   ) {
			/// vamos  a quitar la raiz
			Raiz=Raiz.Sig;
			Raiz.Ant=null;
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
			muerto.Sig.Ant=pos;
		}
		Tot--;
	}
	
	
}


/* 
funciones basicas
  lista ligada
insertar
mostrar lista ligada

funcion eliminar
paso 1: saber que quiero elminar
paso 2: borrarlo

*/




