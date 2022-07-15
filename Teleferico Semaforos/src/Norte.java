
import java.util.concurrent.ThreadLocalRandom;
public class Norte extends Main implements Runnable {
	public void run() {
		///System.out.println("La cap desde Norte es"+Cap);
		while(true) {
			try {
				Thread.sleep(250);
				Norte.acquire();
				//System.out.println("Norte "+"Cap="+Cap+"Pers="+Personas);
				int nuevas= ThreadLocalRandom.current().nextInt( Cap-Personas);
				Personas+=nuevas;
				System.out.println("Hay "+nuevas+" personas esperando");
				System.out.println("teleferico N-S con "+Personas+" personas");
				int Salir=rand.nextInt( Personas );
				Personas-=Salir;
				System.out.println(Salir+" personas se bajaron en la estacion sur");
				//System.out.println("Norte "+"Cap="+Cap+" Pers="+Personas);
				Sur.release();
			}
			catch (InterruptedException e) {
				// TODO Auto-generated catch block
							e.printStackTrace();
			}
			
		}
	}
}
