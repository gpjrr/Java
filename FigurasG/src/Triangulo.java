
public class Triangulo extends FigGeo {

	public Triangulo( double al, double ba) {
		super(al,ba);	
		/*
		p=(2*l)+(2*h);
		super.area=ar;
		super.peri=p;
		*/
	}
	
	public void area() {
		area=base*altura;
		area/=2;
	}
	public void perimetro() {
		peri=base;
		double c=Math.pow( (base/2) , 2 )+Math.pow( altura , 2 );
		c=Math.sqrt( c );
		peri+=2*c;

	}
	
	

}
