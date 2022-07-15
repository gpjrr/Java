import java.util.concurrent.Semaphore;
import java.util.Scanner;
public class main {
	static Semaphore Oxig = new Semaphore(0);
	static Semaphore Hid1 = new Semaphore(0);
	static Semaphore Hid2 = new Semaphore(0);
	public static void main(String[] args) {
		Thread oxi=new Thread( new Oxigeno() );
		Thread hid=new Thread( new Hidrogeno() );
		Thread mol=new Thread( new Molecula() );
		oxi.start();
		hid.start();
		mol.start();
		try {// used sleep for context switching
			Thread.sleep(9000);
		} catch (InterruptedException e) {
			//TODO Auto-generated catch block
			e.printStackTrace();
		}	
		oxi.stop();
		hid.stop();
		mol.stop();
	}
}
