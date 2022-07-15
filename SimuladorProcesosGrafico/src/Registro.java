
public class Registro {
	String Proceso;
	int Time;
	boolean PFin;
	String PLLego;
	String Muerto;
	Registro(){
		Proceso="";
		Time=0;
		PFin=false;
		PLLego="";
	}
	void SetProceso( String nombre ) {
		Proceso=nombre;
	}
	void SetLLego(String nombre) {
		PLLego=nombre;
	}
	
}
