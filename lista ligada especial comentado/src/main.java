import java.util.Scanner;
import java.io.*;

public class main {
	
	public static void main(String[] args) {
		int opc=0;
		int opc2;
		int valx;
		int newpos;
		ListaDobleLigada Lista=new ListaDobleLigada();// contruimos la lista
		while( opc!=6 ) {
			
			Scanner sc=new Scanner( System.in );
			//motramos el menu
			System.out.println("1) insertar elemento \n ");
			System.out.println("2) borrar elemento \n ");
			System.out.println("3) mostrar lista ligada \n ");
			System.out.println("4) invertir lista \n ");
			System.out.println("5) unir listas \n ");
			System.out.println("6) salir \n ");
			opc=sc.nextInt();// leemos la opcion deseada
			
				if(opc== 1) {
					///mostramos el submenu
					menuinsertar();
			
					opc2=sc.nextInt();// leemos su nueva desicion
					switch( opc2 ) {
						case 1:
							System.out.println("dar el valor a insertar \n ");//leemos el valor y lo mandamos a insertar
							//juntos con la posicion donde va a entrar el valor
							Lista.Insertar( sc.nextInt(),1 );
							break;
						case 2:
							System.out.println("dar el valor a insertar \n ");
							//leemos el valor y lo mandamos a insertar
							//juntos con la posicion donde va a entrar el valor
							Lista.Insertar( sc.nextInt(),Lista.n+1 );
							break;
						case 3:
							// usamos el while para pedir el valor de x hasta encontrar un valor real en la lista 
							valx=-1;
							while( valx==-1 ) {
								System.out.println(Lista.toString()+" \n ");
								System.out.println("dar el valor de x \n ");
								///la funcion buscar regresa la posicion de x o -1 si no existe
								valx=Lista.buscar( sc.nextInt() );							
							}
							
							System.out.println("dar el valor a insertar \n ");
							//leemos el valor y lo mandamos a insertar
							//junto con la posicion de x  
							Lista.Insertar( sc.nextInt(),valx+1 );
							break;
						case 4:
							// todo es muy parecido al caso de arriba 
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
							/// popo guarda	 la posicion para mostrar
							int popo=Lista.n +1;
							System.out.println("dar la posicion [1,"+ popo+"] \n ");
							newpos=sc.nextInt();							
							/// leemos el valor y llamamos a insertar 
							System.out.println("dar el valor a insertar \n ");
							Lista.Insertar( sc.nextInt(), newpos );
							break;
						case 6:
							//leemos el valor lo metemos a la lista en la posicion 1
							System.out.println("dar el valor a insertar \n ");
							Lista.Insertar( sc.nextInt(),1 );
							// ordenamos los valores de la lista
							Lista.Resort();
							break;		
						
				};
				// mostramos el cambio despues de alguna desicion tomada
				System.out.println("Lista: \n"+Lista.toString());
			}
			else
			if( opc==2 ) {
				// mostramos el submenu para eliminar datos
				menuEliminar();
				/// leemos la opcion
				opc2=sc.nextInt();
				if( opc2==1 )
					/// borramos la posicion 1
					Lista.Borrar(1);
				else
				if( opc2==2 )
					/// borramos el ultimo de la lista
					Lista.Borrar( Lista.n );
				else// agrupamos la opcion cuando nos referimos a un valor de x
				if( 3<=opc2 && opc2<=4 ) {
					valx=-1;
					/// en un ciclo leemos x hasta que todo este en orden  y el valor sea real en la lista
					while( valx==-1 ) {
						System.out.println(Lista.toString()+" \n ");
						System.out.println("dar el valor de x \n ");
						// la funcion buscar regresa el valor de la posicion de x 
						valx=Lista.buscar( sc.nextInt() );							
					}
					if( opc2==3 )/// aqui solo decidimos cual se va a borrar
						// el de la izquierda o derecha
					Lista.Borrar( valx+1 );
					else
					Lista.Borrar( valx-1 );
				}
				else 
				if( opc2==5 ) {
					//mostramos los valores
					System.out.println("Lista: \n"+Lista.toString());
					newpos=-1;								
					int popo=Lista.n;
					//y pedimos la posicion del valor que se va a borrar
					System.out.println("dar la posicion [1,"+ popo+"] \n ");
					newpos=sc.nextInt();							
					/// aqui borramos el valor de la posicion que leimos 
					Lista.Borrar( newpos );
				}
				else/// agrupamos las decisiones para eliminar a los valores de tipo x
				if( 6<=opc2 && opc2<=7 ){
					int dead=0;
					valx=-1;
					// leemos el valor de x y lo validamos como lo hicimos arriba
					while( valx==-1 ) {
						System.out.println(Lista.toString()+" \n ");
						System.out.println("dar el valor de x \n ");
						dead=sc.nextInt();
						valx=Lista.buscar( dead );							
					}
					/// si solo es un valor va a borrar el primer x de izquierda a derecha
					if( opc2==6 )
						Lista.Borrar( valx );
					else // el ciclo va a funcionar hasta que ya no exista ningun x
						while( valx!=-1 ) {
							// borra un x dando la posicion
							Lista.Borrar( valx );
							/// busca nuevamente otro x si no existe otro regresa -1
							valx=Lista.buscar( dead );
						}
					
				}				
				///mostramos la lista despues del cambio
				System.out.println("Lista: \n"+Lista.toString());
			}
			else
			if( opc==3 ) // mostramos la lista 
				System.out.println("Lista: \n"+Lista.toString());			
			else/// volteamos el orden de la lista , ejemplo [1,2,3,4]=[4,3,2,1]
			if( opc==4 ) {
				
				int[] arr=new int[300];
				int tam=Lista.n+1-1;
				// guardamos los valores en un arreglo
				for(int i=1;i<=Lista.n;i++) 
					arr[i]=Lista.ValorPos(i);
				/// borramos nuestra lista 
				Lista=new ListaDobleLigada();
				// metemos los valores del arreglo en el nuevo orden
				for(int i=1;i<=tam;i++)
					Lista.Insertar( arr[i] , 1 );
				/// mostramos la lista
				System.out.println("Lista: \n"+Lista.toString());
			}
			else
			if( opc==5 ) {/// pide 2 listas y las junta en una nueva donde seran ordenadas 
				ListaDobleLigada LigaT= new ListaDobleLigada();
				// definimos una lista temporal 
				int n1,n2;
				/// pedimos el total de datos de la primer lista
				System.out.println("dar el tamano de la primer lista \n");
				n1=sc.nextInt(); /// se guarda en n1
				System.out.println("inserte los "+ n1 +" datos\n");
				// leemos los datos de la primer lista y los metemos en una lista temporal
				for(int i=1;i<=n1;i++) 
					LigaT.Insertar(sc.nextInt(),i );
				/// pedimos el total de datos de la segunda lista
				System.out.println("dar el tamano de la segunda l1ista \n");
				n2=sc.nextInt();// guardamos el dato en n22
				
				System.out.println("inserte los "+ n2 +" datos\n");
				for(int i=1;i<=n2;i++) // leemos los n2 datos y los guardamos en la misma lista temporal,
					LigaT.Insertar(sc.nextInt(),i+n1 );// el orden de como se guardan no importa puesto que se van a ordenar
				LigaT.Resort();/// ordenamos la lista
				System.out.println( "Lista: \n"+LigaT.toString() );// mostramos el resultado
				
				
			}
			else /// en caso de que se equivoque el usuario 
				System.out.println("opcion incorrecta \n ");
			
						

		}
	}
	
	/// la funcion que muestra el submenu para insertar valores
	  static void menuinsertar(){
		System.out.println("1) al inicio de la lista \n ");
		System.out.println("2) al final de la lista \n ");
		System.out.println("3) a la derecha del elemento x \n ");
		System.out.println("4) a la izquierda del elemento x \n ");
		System.out.println("5) en la i-esima posicion \n ");
		System.out.println("6) de forma ordenada ascendentemente \n ");		
	  }
	  /// la funcion que muestra el submenu para eliminar valores
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





















