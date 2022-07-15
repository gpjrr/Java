
public class Oxigeno extends Main implements Runnable{
	public void run () {
		int con=1;
		int it=0;
		while(true ) {
			try {
				Thread.sleep(30);
				System.out.println("O="+con+" it="+it);
				con++;
				//0 1 2 3
				//0 1 2 0 1 2 0 1 2 0 1 2 0 1 2 0 1 2 
				Oxi[it++].release();
				it%=3;
			}
			catch(InterruptedException e ) {
				// TODO Auto-generated catch block
				e.printStackTrace(); 
			}
			
		}

		
	}
	
}
