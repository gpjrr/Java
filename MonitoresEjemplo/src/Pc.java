class Pc extends ABCs implements Runnable {
	Letra letra;
	public Pc(Letra letra){
		this.letra=letra;
	}
	public void run () {
		while (true) {
			try {
				Thread.sleep(800);
			} catch (InterruptedException e){
				e.printStackTrace();
			}
			letra.LetraC();
		}
	}
}