import java.util.Scanner;
public class menu {
	public static void main(String[] args) {
		Scanner entrada =new Scanner( System.in );
		int n,m;
		/// n es el numero de filas 
		System.out.print("dar n ");
		n= entrada.nextInt();
		// m es el numero de columnas
		System.out.print("dar m ");
		m= entrada.nextInt();
		
		[ fila ][ columna ]
		[ i ][ j ]
		int[][] mat=new int[200][200];
		
		int con=1;
		
		for(int j=1;j<=m;j++) {
			for(int i=1;i<=n;i++) {
				mat[i][j]=con++;
			}
		}		
	
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=m;j++) {
				System.out.print(mat[i][j] +" " );
			}
			System.out.print("\n" );
		}
		
		
	
	}
}


//// listas ligadas


