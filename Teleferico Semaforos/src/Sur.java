
public class Sur  extends Main implements Runnable{
	public void run() {
		//System.out.println("La cap desde Sur es"+Cap);
		while(true){
			try {
				Thread.sleep(250);
				Sur.acquire();
				//System.out.println("Sur "+"Cap="+Cap+"Pers="+Personas);
				int nuevas=rand.nextInt( Cap-Personas);
				Personas+=nuevas;				
				System.out.println("Hay "+nuevas+" personas esperando");
				System.out.println("teleferico S-N con "+Personas+" personas");
				int Salir=rand.nextInt( Personas );
				Personas-=Salir;
				System.out.println(Salir+" personas se bajaron en la estacion Norte");
				//System.out.println("Sur "+"Cap="+Cap+"Pers="+Personas);
				Norte.release();
			}
			catch (InterruptedException e) {
				// TODO Auto-generated catch block
							e.printStackTrace();
			}
				
			
		}
	}
	
	
}
