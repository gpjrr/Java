
public class Personas{
	String Nombre,Curp;
	int DiaCumple;
	int a�o;
	public Personas(String name,int dia) {
		Nombre=name;
		Curp="";
		Curp+=name.charAt( 0 );
		DiaCumple=dia;
	}
	public String datos() {
		String cad="";
		cad+="nombre="+Nombre+"\n";
		cad+="dia cumple="+DiaCumple+"\n";
		cad+="a�o="+a�o+"\n";
		return cad;
	}
	public String MostrarDatos() {
		String cad;		
		return cad;
	}
	
	
}
