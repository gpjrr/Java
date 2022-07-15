
public class Norte extends Main implements Runnable {
	Teleferico TLF;
	public Norte( Teleferico tele ){
		TLF=tele;
	}
	public void run() {
		while(true) {
			try {
				Thread.sleep(800);
			} 
			catch (InterruptedException e){
				e.printStackTrace();
			}
			TLF.Pnorte();
		}
		
	}
	
}
