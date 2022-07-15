
public class Molecula extends Main implements Runnable{
	public void run() {
		int con=1;
		/*
		#1 1 2 3
		#2 4 5 6
		#3 7 8 9
		   3*(con-1) 3*(con-1)+1 3*(con-1)+2*/
		while( true ) {
			try {
				Thread.sleep(100);
				int vlx=3*(con-1);
	System.out.println("#1 HNO3= N="+con+" H="+con+" O1="+(vlx+1)+" O2="+(vlx+2)+" O3="+(vlx+3) );
				Hidr.acquire();
				Nitr.acquire();
				con++;
				for(int i=0;i<3;i++)
					Oxi[i].acquire();
			}
			catch(InterruptedException e ) {
				// TODO Auto-generated catch block
				e.printStackTrace(); 
			}

		}
	}

}
