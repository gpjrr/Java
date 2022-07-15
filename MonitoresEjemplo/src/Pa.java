import java.io.*;
import java.util.*;
import java.lang.*;
class Pa extends ABCs implements Runnable {
	Letra letra;
	public Pa(Letra letra){
		this.letra = letra;
	}
	public void run() {
		while (true) {
			try {
				Thread.sleep( 800 );
			} catch (InterruptedException e){
				e.printStackTrace();
			}
			letra.LetraA();
		}
	}
}