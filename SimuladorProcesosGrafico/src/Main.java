
public class Main {
	public static void main(String[] args) {
		Simulador Sim1=new Simulador(2,3);
		
		Sim1.Insertar( new Proceso("A",8,0)  );
		Sim1.Insertar( new Proceso("B",12,1)  );
		Sim1.Insertar( new Proceso("C",5,3)  );
		Sim1.Insertar( new Proceso("D",4,2)  );	
		VentanaSeleccion VInicio=new VentanaSeleccion(Sim1); 
	}
}
