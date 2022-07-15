
public class Consumidor extends main implements Runnable   {

	public void run () {
		int con=1;
		while(true) {
			try{
				Thread.sleep(200);
				System.out.println("Se ha Consumido un producto "+con);
				Disp.acquire();
				Clnt.acquire();
				con++;
			}
			catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
		
		
		
		
	}
	
}
