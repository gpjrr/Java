import java.util.concurrent.Semaphore;
class ABCs {
	static Semaphore B = new Semaphore(0); // are static
	static Semaphore C = new Semaphore(1); // Pa, Pb,
	static Semaphore sum = new Semaphore(0); // them
	public static void main(String[] args) {
		Thread pa = new Thread(new Pa());
		Thread pb = new Thread(new Pb());
		Thread pc = new Thread(new Pc());
		pa.start(); pb.start(); pc.start();
		
		try {// used sleep for context switching
			Thread.sleep(9000);
		} catch (InterruptedException e) {
			//TODO Auto-generated catch block
			e.printStackTrace();
		}
		pa.stop();
		pb.stop();
		pc.stop();
		System.out.println();
		System.out.println("B=" + B + ", C=" + C + ", sum="+ sum.toString());
		System.exit(0);
}
}