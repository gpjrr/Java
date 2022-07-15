
public class Nitrogeno extends Main implements Runnable{
	public void run() {
		int con=1;
		while( true ) {
		
				try {
					Thread.sleep(90);
					System.out.println("N="+con);
					con++;
					Nitr.release();
					
				}
				catch(InterruptedException e ) {
					// TODO Auto-generated catch block
					e.printStackTrace(); 
				}
		}
		
		
	}
	

}
