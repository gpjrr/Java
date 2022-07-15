import java.util.concurrent.Semaphore;
public class Main {
	static Semaphore[] Oxi;
	static Semaphore Hidr=new Semaphore(0);
	static Semaphore Nitr=new Semaphore(0);
	public static void main(String[] args) {
		Oxi=new Semaphore[3];
		for(int i=0;i<3;i++)
			Oxi[i]=new Semaphore(0);
		Thread oxi=new Thread(new Oxigeno() );
		Thread hid=new Thread(new Hidrogeno() );
		Thread nit=new Thread(new Nitrogeno() );
		Thread mol=new Thread( new Molecula() );
		oxi.start();
		hid.start();
		nit.start();
		mol.start();
		try {// used sleep for context switching
			Thread.sleep(9000);
		} catch (InterruptedException e) {
			//TODO Auto-generated catch block
			e.printStackTrace();
		}	
		oxi.stop();
		hid.stop();
		nit.stop();
		mol.stop();
	}
	
}
