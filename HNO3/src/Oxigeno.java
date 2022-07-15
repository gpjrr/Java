
public class Oxigeno extends main implements Runnable{
	Acido Nitro;
	public Oxigeno(  Acido nitro) {
		this.Nitro=nitro;
	}
	public void run() {
		while(true) {
			try {
				Thread.sleep(800);
			} catch (InterruptedException e){
				e.printStackTrace();
			}
			Nitro.Poxigeno();
		}
		
	}
	
}
