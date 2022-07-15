
public class Gerente extends Personas{
	
	int Salario;
	String Turno, departamento;
	
	
	public Gerente(String name,int dia ,int sal,int a,String cur ) {
		super(name, dia);
		Salario=sal;
		super.año=a;
		super.Curp=cur;
		departamento="empaquetado ";
	}
	
}
