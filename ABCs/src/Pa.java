class Pa extends ABCs implements Runnable { //extend ABCs to
//Pa(){
// System.out.println("Creando thread A");
//}
// access semaphore sum
		public void run () {
			while (true) {
				try{
					Thread.sleep(500);
					System.out.print("A");
					System.out.flush();
					//V(sum);
					sum.release();
				} catch (InterruptedException e) {
		// TODO Auto-generated catch block
					e.printStackTrace();
					}
			}
		}
}