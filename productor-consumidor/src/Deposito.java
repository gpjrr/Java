
public class Deposito extends main implements Runnable   {

	public void run () {
		while(true) {
			try{
				Thread.sleep(100);
				System.out.println("Nuevo Producto Disponible");
				Depo.acquire();
				Disp.release();
				
			}
			catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		
		
	}
	
}
