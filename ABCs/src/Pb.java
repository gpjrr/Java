class Pb extends ABCs implements Runnable {
//Pb(){
// System.out.println("Creando Thread B");
//}
	public void run () {
		while (true) {
			try{
				//Thread.sleep(800);
				//P(C); P(sum);
				C.acquire(); sum.acquire();
				System.out.print("B");
				System.out.flush();
				//V(B);
				B.release();
			}
			catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}