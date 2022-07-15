
public class main  extends Object{
	public static void main(String[] args) {
		Acido nitrico=new Acido(0,1,0);

		Thread oxi = new Thread(new Oxigeno( nitrico ));
		Thread hid = new Thread(new Hidrogeno( nitrico ));
		Thread nit = new Thread(new Nitrogeno( nitrico ));
		Thread mol = new Thread(new Molecula( nitrico ));
		oxi.start();
		hid.start();
		mol.start();
		nit.start();
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e){
			e.printStackTrace();
		}
		oxi.stop();	hid.stop(); mol.stop();	nit.stop();
		System.exit(0);
	}
}
