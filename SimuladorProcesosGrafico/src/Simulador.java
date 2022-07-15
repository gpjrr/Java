
public class Simulador {
	int n;//total procesos
	int Time=0;// tiempo total
	int esp=0;	//espera en la cola
	int ini,fin;// cola indices
	int cont=0;// cuantos ya terminaron
	int Tipo=0; int Quantum;
	boolean Start;
	int activados=0;
	Proceso[] arr=new Proceso[200];
	Proceso[] cola=new Proceso[200];	
	Registro[] Mem=new Registro[10000];
	int ITM;
	int vidaQuantum;
	int seleccionado=-1;
	Simulador(int tipo,int qua){
		Tipo=tipo;
		Quantum=qua;
		Start=false;
		esp=0; ITM=0; n=0; ini=0; fin=0;Time=0;
		for(int i=0;i<100;i++) {
			//cola[i]=new Proceso(" ",0,0);
			arr[i]=new Proceso(" ",0,0);
			cola[i]=new Proceso(" ",0,0);
			
		}
		for(int i=0;i<500;i++) {
			Mem[i]=new Registro();
		}
		vidaQuantum=0;
		seleccionado=-1;
	}	
	
	void Insertar( Proceso nuevo ){
		arr[n++]=new Proceso( nuevo.Nombre,nuevo.T,nuevo.Tll  );
		Ordenar();
	}
	void OrdenarNombre() {
		for(int i=0;i<n;i++)
			for(int j=i+1;j<n;j++)
				if( cola[j].Nombre.compareTo(cola[i].Nombre)<0   ){
			Proceso tem=cola[i];
			
			//tem= new Proceso(cola[i].Nombre,cola[i].T,cola[i].Tll   );
			cola[i]=cola[j];
			cola[j]=tem;
				}
	}
	void Ordenar() {
		for(int i=0;i<n;i++)
			for(int j=i+1;j<n;j++)
				if( arr[i].Tll>arr[j].Tll   ){
					Proceso tem;
			tem= new Proceso(arr[i].Nombre,arr[i].T,arr[i].Tll   );
			arr[i]=new Proceso(arr[j].Nombre,arr[j].T,arr[j].Tll );
			arr[j]=new Proceso(tem.Nombre,tem.T,tem.Tll   );
				}
	}
	
	public void Fifo() {
		System.out.println("Tiempo="+Time);
		Registro Nuevo= new Registro();
		if( arr[ esp].Tll==Time ) {/// Posible Apuntador
			//arr[esp].Mostrar();
			//System.out.println("Nuevo Proceso");
			cola[fin]= new Proceso( arr[esp].Nombre,arr[esp].T,arr[esp].Tll); 
			cola[fin].Mostrar();
			fin++;
			Nuevo.SetLLego( arr[esp].Nombre );
			esp++;
			//System.out.println("Cola Rango ini="+ini+"fin="+fin);
		}
		Nuevo.Time=Time;
		if( ini<fin ) {
			Nuevo.SetProceso( cola[ini].Nombre );
			cola[ini].Tlive-=1;
			if(  cola[ini].Ta==-1 ) 
				 cola[ini].Ta=Time;
	
			if( cola[ini].Tlive==0 ) {
				cola[ini].Finalizar( Time );
				Nuevo.PFin=true;
				Nuevo.Muerto=Nuevo.Proceso;
				cont++;
				ini++;
			}
		}
		Time++;
		Mem[ITM++]=Nuevo;
	//	System.out.println("Proceso="+(Nuevo.Proceso)+" LLego="+Nuevo.PLLego);
	}
	
	public void RoundRobin() {
		System.out.println("Tiempo="+Time);
		Registro Nuevo= new Registro();
		if( arr[esp].Tll==Time ) {/// Posible Apuntador
			arr[esp].Mostrar();
			System.out.println("Nuevo Proceso");
			cola[fin]= new Proceso( arr[esp].Nombre,arr[esp].T,arr[esp].Tll); 
			cola[fin].Mostrar();
			fin++; activados++;
			Nuevo.SetLLego( arr[esp].Nombre );
			esp++;
			//System.out.println("Cola Rango ini="+ini+"fin="+fin);
		}
		Nuevo.Time=Time;
		if( vidaQuantum==0 ) {
			if( fin>0 && cont<n ) {
				seleccionado++;
				if( seleccionado==fin )
					seleccionado=0;
				while( cola[seleccionado].Tlive==0 ) {
					seleccionado++;
					if( seleccionado==fin )
						seleccionado=0;
				}
				vidaQuantum=Quantum;
			}
		}
		
		if( vidaQuantum!=0 ){
			Nuevo.SetProceso( cola[seleccionado].Nombre );
			cola[seleccionado].Tlive--;
			vidaQuantum--;
			if(  cola[seleccionado].Ta==-1 ) 
				 cola[seleccionado].Ta=Time;
	
			if( cola[seleccionado].Tlive==0 ) {
				System.out.println("Murio alguien");
				cola[seleccionado].Mostrar();
				cola[seleccionado].Finalizar( Time );
				activados--;
				Nuevo.PFin=true;
				Nuevo.Muerto=Nuevo.Proceso;
				cont++;
				vidaQuantum=0;
			}
		}		
		Time++;
		Mem[ITM++]=Nuevo;
//		System.out.println("Proceso="+(Nuevo.Proceso)+" vidaquantum="+vidaQuantum);	
	}
	void Paso(){
		if( YaFinalizo()==true )
			return;
		if( Tipo==1 )
			Fifo();
		else
			RoundRobin();
	}
	boolean YaFinalizo() {
		if( cont==n )
			return true;
		return false;
	}

}
//1 2 7 5 3