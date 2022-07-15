
public class Molecula extends main implements Runnable{
	public void run() {
		int con_mo=1;
		int con_ox=1;
		int con_hi=1;
		while(true) {
			try {
				Thread.sleep(200);
			System.out.println(con_mo+"# H2O={ h1="+con_hi+" O="+con_ox+" h2="+(con_hi+1)+" }" );
				con_mo++;
				con_ox++;
				con_hi+=2;
				Oxig.acquire();
				Hid1.acquire();
				Hid2.acquire();
			}
			catch( InterruptedException e ) {
				e.printStackTrace();
			}
		}
		
	}
}
