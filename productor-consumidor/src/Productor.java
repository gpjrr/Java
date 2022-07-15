
public class Productor extends main implements Runnable   {
	public void run () {
		int con=1;
		while( true ) {
			try{
				System.out.println("Producto#"+con+" Creado");
				Prod.acquire();
				//System.out.println("semprod="+Prod);
				Depo.release();
				con++;
			}
			catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
	}
	
}
