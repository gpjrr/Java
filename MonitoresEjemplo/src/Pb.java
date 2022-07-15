class Pb extends ABCs implements Runnable {
	Letra letra;
	public Pb(Letra letra){
		this.letra=letra;
	}
	public void run () {
		while (true) {
			try {
				Thread.sleep(800);
			} catch (InterruptedException e){
				e.printStackTrace();
			}
			letra.LetraB();
		}
	}
	
}