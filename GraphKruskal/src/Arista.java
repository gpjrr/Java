
public class Arista implements Comparable<Arista>{
	String  Nod1,Nod2;
	int Dis;
	
	public Arista(String n1,String n2,int ds) {
		Nod1=n1;
		Nod2=n2;
		Dis=ds;
	}
	
	public int compareTo(Arista arg0) {
		if( this.Dis < arg0.Dis )
		return -1;
		else
		return 1;
	}
	
}