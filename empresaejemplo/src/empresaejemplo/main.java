package empresaejemplo;
public class main {

	public static void main(String[] args) {
		Perfil profile;	
		profile= new Perfil("carlos", 21);	
		empleado p1;
		p1=new empleado("matutino", new Perfil("erwin",23 )  );
		System.out.print( p1.Name+" "+p1.Age+" "+p1.Turno);

		
	}
}
