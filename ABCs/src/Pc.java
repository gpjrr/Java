class Pc extends ABCs implements Runnable {
	//Pc(){
	// System.out.println("Creando Thread C");
	//}
	public void run () {
		while (true) {
			try{
				//Thread.sleep(800);
				//P(B); P(sum);
				B.acquire(); sum.acquire();
				System.out.print("C");
				System.out.flush();
				//V(C);
				C.release();
			}
			catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}