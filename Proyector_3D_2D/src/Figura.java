public class Figura {
	int ValZ;
	double Base;
	int TLados;
	int ang;
	double Apotema;
	double Diagonal;
	Punto Punta;
	Punto Centro;
	Punto[] arr=new Punto[100];
	Figura(int bas,int lados){
		Base=bas;
		TLados=lados;
		ValZ=10;
		Centro=new Punto( 50,50,10 );
		Construir();
		Puntos();
	}
	public void Construir() {
		ang=360/TLados;
		System.out.println("angulo interno="+ang);
		double rad=Math.toRadians(ang/2);
		double tn=Math.tan( rad );
		Apotema=Base/(2*tn);
		double MLado=Base/2;
		Diagonal= Math.sqrt( (MLado*MLado)+(Apotema*Apotema) );
		System.out.println("Lado/2="+MLado);
		System.out.println("Apotema="+Apotema);
		System.out.println("Diagonal="+ Diagonal );
		System.out.println("____________________" );
		System.out.println("Lado/2="+(MLado*MLado) );
		System.out.println("Apotema="+(Apotema*Apotema) );
		System.out.println("Diagonal="+ (Diagonal*Diagonal) );
	}
	public void Puntos() {
		int dir=90;
		for(int i=0;i<TLados;i++) {
		
			
			arr[i]=new Punto(rx,ry,ValZ);
			dir+=ang;
			dir%=360;
		}
	}
		
	
}
