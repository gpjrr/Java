public class Set {
	String[] names=new String[100];
	int Tn;
	int Costo;
	int ID;
	public Set() {
		Tn=0;
		Costo=0;
	}
	public void Insertar(String Nodo,int plus){
		Costo+=plus;
		names[Tn++]=Nodo;
	}
	public void Mostrar() {
		for(int i=0;i<Tn;i++)
			System.out.print( names[i]+" ");
		System.out.println( "Costo="+Costo );
	}
}
