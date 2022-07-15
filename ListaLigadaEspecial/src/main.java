import java.util.Scanner;
import java.io.*;

public class main {
	
	public static void main(String[] args) {
		int opc=0;
		int opc2;
		int valx;
		int newpos;
		ListaDobleLigada Lista=new ListaDobleLigada();
		while( opc!=6 ) {
			Scanner sc=new Scanner( System.in );
			System.out.println("1) insertar elemento \n ");
			System.out.println("2) borrar elemento \n ");
			System.out.println("3) mostrar lista ligada \n ");
			System.out.println("4) invertir lista \n ");
			System.out.println("5) unir listas \n ");
			System.out.println("6) salir \n ");
			opc=sc.nextInt();
			
				if(opc== 1) {
					menuinsertar();
			
					opc2=sc.nextInt();
					switch( opc2 ) {
						case 1:
							System.out.println("dar el valor a insertar \n ");
							Lista.Insertar( sc.nextInt(),1 );
							break;
						case 2:
							System.out.println("dar el valor a insertar \n ");
							Lista.Insertar( sc.nextInt(),Lista.n+1 );
							break;
						case 3:
							valx=-1;
							while( valx==-1 ) {
								System.out.println(Lista.toString()+" \n ");
								System.out.println("dar el valor de x \n ");
								valx=Lista.buscar( sc.nextInt() );							
							}
							System.out.println("dar el valor a insertar \n ");
							Lista.Insertar( sc.nextInt(),valx+1 );
							break;
						case 4:
							valx=-1;
							while( valx==-1 ) {
								System.out.println(Lista.toString()+" \n ");
								System.out.println("dar el valor de x \n ");
								valx=Lista.buscar( sc.nextInt() );							
							}
							System.out.println("dar el valor a insertar \n ");
							Lista.Insertar( sc.nextInt(),valx );
							break;
						case 5:
							newpos=-1;								
							int popo=Lista.n +1;
							System.out.println("dar la posicion [1,"+ popo+"] \n ");
							newpos=sc.nextInt();							
							System.out.println("dar el valor a insertar \n ");
							Lista.Insertar( sc.nextInt(), newpos );
							break;
						case 6:
							System.out.println("dar el valor a insertar \n ");
							Lista.Insertar( sc.nextInt(),1 );
							Lista.Resort();
							break;		
						
				};
				System.out.println("Lista: \n"+Lista.toString());
			}
			else
			if( opc==2 ) {
				menuEliminar();
				opc2=sc.nextInt();
				if( opc2==1 )
					Lista.Borrar(1);
				else
				if( opc2==2 )
					Lista.Borrar( Lista.n );
				else
				if( 3<=opc2 && opc2<=4 ) {
					valx=-1;
					while( valx==-1 ) {
						System.out.println(Lista.toString()+" \n ");
						System.out.println("dar el valor de x \n ");
						valx=Lista.buscar( sc.nextInt() );							
					}
					if( opc2==3 )
					Lista.Borrar( valx+1 );
					else
					Lista.Borrar( valx-1 );
				}
				else 
				if( opc2==5 ) {
					System.out.println("Lista: \n"+Lista.toString());
					newpos=-1;								
					int popo=Lista.n;
					System.out.println("dar la posicion [1,"+ popo+"] \n ");
					newpos=sc.nextInt();							
					System.out.println("dar el valor a insertar \n ");
					Lista.Borrar( newpos );
				}
				else
				if( 6<=opc2 && opc2<=7 ){
					int dead=0;
					valx=-1;
					while( valx==-1 ) {
						System.out.println(Lista.toString()+" \n ");
						System.out.println("dar el valor de x \n ");
						dead=sc.nextInt();
						valx=Lista.buscar( dead );							
					}
					if( opc2==6 )
						Lista.Borrar( valx );
					else 
						while( valx!=-1 ) {
							Lista.Borrar( valx );
							valx=Lista.buscar( dead );
						}
					
				}				
				System.out.println("Lista: \n"+Lista.toString());
			}
			else
			if( opc==3 ) 
				System.out.println("Lista: \n"+Lista.toString());			
			else
			if( opc==4 ) {
				int[] arr=new int[300];
				int tam=Lista.n+1-1;
				for(int i=1;i<=Lista.n;i++) 
					arr[i]=Lista.ValorPos(i);
				
				Lista=new ListaDobleLigada();
				for(int i=1;i<=tam;i++)
					Lista.Insertar( arr[i] , 1 );
				System.out.println("Lista: \n"+Lista.toString());
			}
			else
			if( opc==5 ) {
				ListaDobleLigada LigaT= new ListaDobleLigada();
				int n1,n2;
				System.out.println("dar el tamano de la primer lista \n");
				n1=sc.nextInt();
				System.out.println("inserte los "+ n1 +" datos\n");
				for(int i=1;i<=n1;i++) 
					LigaT.Insertar(sc.nextInt(),i );
				
				System.out.println("dar el tamano de la segunda lista \n");
				n2=sc.nextInt();
				System.out.println("inserte los "+ n2 +" datos\n");
				for(int i=1;i<=n2;i++) 
					LigaT.Insertar(sc.nextInt(),i+n1 );
				LigaT.Resort();
				System.out.println( "Lista: \n"+LigaT.toString() );
				
				
			}
			else 
				System.out.println("opcion incorrecta \n ");
			
						

		}
	}
	  static void menuinsertar(){
		System.out.println("1) al inicio de la lista \n ");
		System.out.println("2) al final de la lista \n ");
		System.out.println("3) a la derecha del elemento x \n ");
		System.out.println("4) a la izquierda del elemento x \n ");
		System.out.println("5) en la i-esima posicion \n ");
		System.out.println("6) de forma ordenada ascendentemente \n ");		
	  }
	  static void menuEliminar() {
		System.out.println("1) al inicio de la lista \n ");
		System.out.println("2) al final de la lista \n ");
		System.out.println("3) a la derecha del elemento x \n ");
		System.out.println("4) a la izquierda del elemento x \n ");
		System.out.println("5) el de la i-esima posicion \n ");
		System.out.println("6) el elemento de valor x \n ");
		System.out.println("7) todos los elementos de valor x \n ");
	  }
}





















