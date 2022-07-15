
public class Sur extends Main implements Runnable  {
	Teleferico TLF;
	public Sur( Teleferico tele ){
		TLF=tele;
	}
	public void run() {
		while(true) {
			try {
				Thread.sleep(1000);
			} 
			catch (InterruptedException e){
				e.printStackTrace();
			}
			TLF.Psur();
			///System.out.println("HOlaaa---------------");
		}
		
	}
}
