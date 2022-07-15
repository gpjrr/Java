
public class Agua {
	private int h,o,m;
	int nh,no,nm;
	public Agua(int hi,int ox,int mo) {
		h=hi; o=ox; m=mo;
		nh=no=nm=0;
	}
	
	public synchronized void Phidrogeno() {
		while( h==0 ) 
			try {
				//System.out.println("hidrogeno espera por semaforo");
				wait();
			} 
			catch (InterruptedException e) {
				System.err.println("interrupted out of wait");
			}
		h--;
		nh++;
		System.out.println("H="+nh);
		
		
		if( nh%2==1  ) 
			o++;
		else
			m++;
		notify();
		notify();
		while( m==1 )
			try {
				//System.out.println("hidrogeno espera por molecula");
				wait();
			} 
			catch (InterruptedException e) {
				System.err.println("interrupted out of wait");
			}	
//		notify();
		
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
		h++;
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
				//System.out.println("molecula espera por semaforo");
				wait();
			} 
			catch (InterruptedException e) {
				System.err.println("interrupted out of wait");
			}
		m--;
		nm++;
		System.out.println("H2O #"+nm+" H1="+(nh-1)+" O="+no+" H2="+nh);
		h++;
		notify();
		notify();
	}
	
}
