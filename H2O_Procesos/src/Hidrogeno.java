
public class Hidrogeno extends main implements Runnable {
	public void run() {
		int con=1;
		int lado=0;
		while(true) {
			try {
				Thread.sleep(90);
				System.out.println("H="+con);
				con++;
				if( lado==0 ) {
					Hid1.release();
					lado=1;
				}
				else {
					Hid2.release();
					lado=0;
				}
	
			}
			catch(InterruptedException e ) {
				// TODO Auto-generated catch block
				e.printStackTrace(); 
			}
		}
	}
}
