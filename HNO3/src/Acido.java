
public class Acido {
	private int h,o,n,m;
	int nh,no,nn,nm;
	public Acido( int hid,int oxi,int nit ) {
		h=hid;
		o=oxi;
		n=nit;
		m=0;
		nh=no=nn=nm=0;
	}
	public synchronized void Poxigeno() {
		while( o==0 ) 
			try {
				//System.out.println("oxigeno espera por semaforo");
				wait();
			} 
			catch (InterruptedException e) {
				System.err.println("interrupted out of wait");
			}
		o--;
		no++;
		System.out.println("O="+no);
		if( no%3==1 ) 
			n++;
		else
		if( no%3==2 ) 
			h++;
		else
		if( no%3==0 ) 
			m++;
		notify();
		notify();
		notify();	
		while( m==1 )
			try {
				//System.out.println("oxigeno espera por molecula");
				wait();
			} 
			catch (InterruptedException e) {
				System.err.println("interrupted out of wait");
			}	
	}
	
	
	public synchronized void Phidrogeno() {
		while( h==0 ) 
			try {
				//System.out.println("oxigeno espera por semaforo");
				wait();
			} 
			catch (InterruptedException e) {
				System.err.println("interrupted out of wait");
			}
		h--;
		nh++;
		System.out.println("H="+nh);
		o++;
		notify();
		notify();
		notify();	
		while( m==1 )
			try {
				//System.out.println("oxigeno espera por molecula");
				wait();
			} 
			catch (InterruptedException e) {
				System.err.println("interrupted out of wait");
			}	
	}
	public synchronized void Pnitrogeno() {
		while( n==0 ) 
			try {
				//System.out.println("oxigeno espera por semaforo");
				wait();
			} 
			catch (InterruptedException e) {
				System.err.println("interrupted out of wait");
			}
		n--;
		nn++;
		System.out.println("N="+nn);
		o++;
		notify();
		notify();
		notify();	
		while( m==1 )
			try {
				//System.out.println("oxigeno espera por molecula");
				wait();
			} 
			catch (InterruptedException e) {
				System.err.println("interrupted out of wait");
			}	
	}
	public synchronized void Pmolecula() {
		while( m==0 ) 
			try {
				//System.out.println("oxigeno espera por semaforo");
				wait();
			} 
			catch (InterruptedException e) {
				System.err.println("interrupted out of wait");
			}
		m--;
		nm++;
System.out.println("HNO3 #"+nm+" H="+nh+" N="+nn+" O1="+(no-2)+" O2="+(no-1)+" O3="+no);
		o++;
		notify();
		notify();
		notify();	
	}
	
	
}

