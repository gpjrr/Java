
public class Main  extends Object{
	public static void main(String[] args) {
		Agua agua=new Agua(1, 0, 0);
		Thread oxi = new Thread(new Oxigeno(agua));
		Thread hid = new Thread(new Hidrogeno(agua));
		Thread mol = new Thread(new Molecula(agua));
		oxi.start();
		hid.start();
		mol.start();
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e){
			e.printStackTrace();
		}
		oxi.stop();	hid.stop(); mol.stop();
		System.exit(0);
	}
}
