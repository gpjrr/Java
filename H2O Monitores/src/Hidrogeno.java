
public class Hidrogeno extends Main implements Runnable {
	Agua agua;
	public Hidrogeno(Agua agu) {
		this.agua=agu;
	}
	public void run() {
		while(true) {
			try {
				Thread.sleep(800);
			} catch (InterruptedException e){
				e.printStackTrace();
			}
			agua.Phidrogeno();
		}
		
	}
}
