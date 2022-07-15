package empresaejemplo;

public class empleado extends Perfil{
	String Turno;
	public empleado(String turno , Perfil sujeto ) {
		super( sujeto.Name , sujeto.Age  );
		Turno=turno;
		

		
	}
	
	
}
