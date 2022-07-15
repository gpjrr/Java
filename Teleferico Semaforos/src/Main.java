import java.util.Scanner;
import java.util.concurrent.Semaphore;
import java.util.Random;

public class Main {
	static Semaphore Norte=new Semaphore(1);
	static Semaphore Sur=new Semaphore(0);
	static int Cap=0;
	static int Personas=0;
	static Random rand = new Random();
	public static void main(String[] args ) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Dame la capacidad del teleferico");
		Cap=sc.nextInt();
		System.out.println("La capacidad es: "+Cap);
		Thread PNorte= new Thread(new  Norte() );
		Thread PSur= new Thread(new Sur() );
		PNorte.start();
		PSur.start();
		
		try {// used sleep for context switching
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			//TODO Auto-generated catch block
			e.printStackTrace();
		}
		PNorte.stop();
		PSur.stop();
	}
}
