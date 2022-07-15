import java.util.concurrent.Semaphore;
import java.util.Scanner;
public class main {
	static Semaphore Prod; 
	static Semaphore Depo = new Semaphore(0);
	static Semaphore Disp = new Semaphore(0);
	static Semaphore Clnt;
	public static void main(String[] args) {
			Scanner sc=new Scanner( System.in );
			
			System.out.println("Dame el total de productos");
			int totp= sc.nextInt() ;
			int totc=0;
			do {
				System.out.println(" Dame el total de clientes ");	
				totc=sc.nextInt();
				if( totc>totp )
					System.out.println("Error, tienen que existir menos clientes que productos ");
			}
			while( totc>totp );
		
			 Prod= new Semaphore(totp-1);
			 Clnt = new Semaphore( totc-1 );
			 
			 //System.out.println(" prod= "+Prod);
			 //System.out.println(" cliente= "+Clnt);
			
			Thread prod = new Thread(new Productor());
			Thread cons = new Thread(new Consumidor());
			Thread depo = new Thread(new Deposito());
			prod.start(); 
			cons.start(); 
			depo.start();
				
			try {// used sleep for context switching
				Thread.sleep(9000);
			} catch (InterruptedException e) {
				//TODO Auto-generated catch block
				e.printStackTrace();
			}	
			
			prod.stop();
			cons.stop();
			depo.stop();
		}
}
