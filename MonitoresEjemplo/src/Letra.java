class Letra{
	private int suma = 0, B=0,C=0;
	public Letra(int suma, int B, int C){
		this.suma=suma;
		this.B=B;
		this.C=C;
	}
	public synchronized void LetraA() {
		suma++; //
		System.out.print("A");
		notify();
	}
	
	public int getSuma(){
		return suma;
	}
	public synchronized void LetraB() {
		while (suma == 0)
			try {	
					wait();
				} 
			catch (InterruptedException e) {
				System.err.println("interrupted out of wait");
			}
		B--;
		suma--;
		while (B < 0)
			try {
				wait();
			} 
			catch (InterruptedException e) {
				System.err.println("interrupted out of wait");
			}
			System.out.print("B");
			C++;
		if (C == 0) 
			notify(); //< since it might be waiting
	}
	
	public int getB(){
		return B;
	}
	public synchronized void LetraC() {
		while (suma == 0)
			try {
				wait();
			} 
			catch (InterruptedException e) {
				System.err.println("interrupted out of wait");
			}
		suma--;
		C--;
		while (C < 0)
			try {
				wait();
			} catch (InterruptedException e) {
				System.err.println("interrupted out ofwait");
			}
		System.out.print("C");
		B++;
		if (B == 0) { 
			System.out.println("idk\n");
			notify(); //< since it might be waiting
		}
	}
	public int getC(){
		return C;
	}
}