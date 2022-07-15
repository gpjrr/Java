
public class Cuadrado extends FigGeo {

	
	public Cuadrado( double l ) {
		super(l,l);
	}
	public void area() {
		area=base*altura;	
	}
	public void perimetro() {
		peri=4*base;
	}
	
}
