class ABCs extends Object{
	public static void main(String[] args) {
		int B=1, C=0, suma=0;
		Letra letra=new Letra(suma, B, C);
		Thread pa = new Thread(new Pa(letra));
		Thread pb = new Thread(new Pb(letra));
		Thread pc = new Thread(new Pc(letra));
		pa.start(); pb.start(); pc.start();
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e){
			e.printStackTrace();
		}
		pa.stop(); pb.stop(); pc.stop();
		System.out.println();		
		System.exit(0);
	}
}

/* ............... Example compile and run(s)
D:\>javac ABCs.java
D:\>javac letras.java
D:\>java ABCs
*/