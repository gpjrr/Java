import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Teleferico {
	int Norte,Sur;
	int Cap=0;
	int Personas=0;
	Random rand = new Random();
	Teleferico(int Snor,int Ssur,int cap){
		Norte=Snor;
		Sur=Ssur;
		Cap=cap;
	}
	public synchronized void Pnorte() {
		while( Norte==0 ) 
			try {
				//System.out.println("hidrogeno espera por semaforo");
				wait();
			} 
			catch (InterruptedException e) {
				System.err.println("interrupted out of wait");
			}
			Norte=0;
			int nuevas= ThreadLocalRandom.current().nextInt( Cap-Personas);
			Personas+=nuevas;
			System.out.println("Hay "+nuevas+" personas esperando");
			System.out.println("teleferico N-S con "+Personas+" personas");
			int Salir=rand.nextInt( Personas );
			Personas-=Salir;
			System.out.println(Salir+" personas se bajaron en la estacion sur");
			Sur=1;
			notify();
			notify();
	}
	
	public synchronized void Psur() {
		while( Sur==0 ) 
			try {
				//System.out.println("hidrogeno espera por semaforo");
				wait();
			} 
			catch (InterruptedException e) {
				System.err.println("interrupted out of wait");
			}
		
		Sur=0;
		//System.out.println("Sur "+"Cap="+Cap+"Pers="+Personas);
		int nuevas=rand.nextInt( Cap-Personas);
		Personas+=nuevas;				
		System.out.println("Hay "+nuevas+" personas esperando");
		System.out.println("teleferico S-N con "+Personas+" personas");
		int Salir=rand.nextInt( Personas );
		Personas-=Salir;
		System.out.println(Salir+" personas se bajaron en la estacion Norte");
		//System.out.println("Sur "+"Cap="+Cap+"Pers="+Personas);
		Norte=1; 
		notify();
		notify();
		

	}
}	
