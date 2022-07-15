
public class Proceso {
	String Nombre;
	int T,Tll;
	int Tlive;
	int Ta,Tf,Tret,Tans,Tw,Tesp;
	float Tpen;
	Proceso(String name,int raf,int llegada) {
		Nombre=name;
		T=raf;
		Tll=llegada;
		Ta=-1;
		Tlive=raf;
	}
	void Finalizar(int tiempo) 	 {
		Tf=tiempo+1;
		Tret=Tf-Ta;
		Tans=Tf-Tll;
		Tw=Tans-T;
		Tpen=(float)Tans/T;
		Tesp=Ta-Tll;
		Mostrar();
		Resultado();
	}
	void Mostrar() {
		System.out.println("Name="+Nombre+" T="+T+" Tll="+Tll);
		System.out.println(" Tlive="+Tlive);
	}
	void Resultado() {
		System.out.println(" T="+T+" Ta="+Ta+" TF="+Tf+" Tr="+Tret);
		System.out.println(" Tres="+Tans+" Tdes="+Tw+" Tp="+Tpen+" Te="+Tesp );

	}
	
}
