
public class Empleados extends Personas {
	int Salario;
	String Turno;

	public Empleados(String name, int dia) {
		super(name, dia);		
	}	
	public void  llenar(int sal,Personas Sujeto ,String turn) {
		Salario=sal;
		super.a�o=Sujeto.a�o;
		super.Curp=Sujeto.Curp;
		Turno=turn;
	}
	public String MostrarDatos() {
		String cad=this.datos();
		cad+="salario="+Salario+"\n";
		cad+="turno="+Turno+"\n";

		return cad;
	}
	
}
