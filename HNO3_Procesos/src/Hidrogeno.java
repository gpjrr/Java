
public class Hidrogeno extends Main implements Runnable{
	public void run() {
		int con=1;
		while( true ) {
			try {
				Thread.sleep(80);
				System.out.println("H="+con);
				con++;
				Hidr.release();
			}
			catch(InterruptedException e ) {
				// TODO Auto-generated catch block
				e.printStackTrace(); 
			}
			
		}
	
		
	}
	

}
