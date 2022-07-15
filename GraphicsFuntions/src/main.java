import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t1,t2,t3,t4;
		int blobo;
		/*
		System.out.print("Dar los valores de A B y C en la ecuacion Ax^2+Bx+c=0\n");
		System.out.println("Dar A");
		t1=sc.nextInt();
		System.out.println("Dar B");
		t2=sc.nextInt();
		System.out.println("Dar C");
		t3=sc.nextInt();
		Funtion fun=new Funtion(t1,t2,t3);
		System.out.println("Dar la dimension del bloque");
		blobo=sc.nextInt();
		System.out.println("Dar el limite de la integral en [0,x']");
		t4=sc.nextInt();
		VentanaPrincipal window=new VentanaPrincipal(fun,blobo,t4);
		*/
		Funtion fun=new Funtion(1,0,0);
		VentanaPrincipal window=new VentanaPrincipal(fun,1,7);
	}
	

}
