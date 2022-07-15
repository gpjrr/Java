import java.util.Scanner;
public class menu {
		public static void main(String[] args) {

			Heap tree=new Heap();
			tree.Insert( 30 );  //30	
			tree.Insert( 15 ); //1
			tree.Insert( 25 );//15
			tree.Insert( 10 );//10
			tree.Insert( 7 );
			tree.Insert( 4 );
			
			System.out.print( tree.Top() +"\n");
			
			Scanner sc=new Scanner(System.in );
			int tem=sc.nextInt();
			Heap copy=new Heap();
		    while(  tree.n>=1 ) {
				 
				 int num=tree.Top();
				 tree.Eliminar();
				 if( num!=tem ) {
					 copy.Insert( num );
				 }
			}
			 
			while( copy.n>=1 ) {
				 tree.Insert( copy.Top() );
				 copy.Eliminar();
			}
			 
			System.out.print("eliminacion..............\n");
			while( tree.n>=1 ) {
				
				System.out.print( tree.Top() +"\n");
				tree.Eliminar();
			}
			
			
		}
}
