import java.util.Scanner;
import java.util.concurrent.Semaphore;
import java.util.Random;

public class Main {	

	public static void main(String[] args ) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Dame la capacidad del teleferico");	
		Teleferico tele=new Teleferico(1,0, sc.nextInt() );
		Thread nor= new Thread( new Norte( tele) );
		Thread sur= new Thread( new Sur( tele) );
		nor.start();
		sur.start();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e){
			e.printStackTrace();
		}
		nor.stop();
		sur.stop();
	}
}
