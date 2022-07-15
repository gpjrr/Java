import java.util.Scanner;


public class main {

	public static void main(String[] args) {
		Scanner sc=new Scanner( System.in );
		Cuadrado c1= new Cuadrado(3);
		Triangulo t1=new Triangulo( 4,2 );
	c1.area(); c1.perimetro();
	t1.area(); t1.perimetro();
	System.out.print( c1.area+" "+c1.peri+"\n" );
	System.out.print( t1.area+" "+t1.peri+"\n" );
	
	}
///
	en c
	a=4
	b=a
	==> b=4
	b=*2;
	==> a=4 b=4
	
	en java
	a=4
	b=a
	==> b=4
	b*=2
	b=8 a=8
	
	
	copiar(a,b);
	b=a;
	
			
			
	
}
