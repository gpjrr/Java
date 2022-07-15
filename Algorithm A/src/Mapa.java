import java.util.Arrays; 
import java.util.Random;
import java.util.Scanner; 		
import java.io.*;

public class Mapa {
	int[][] mt=new int[100][100];
	int n,m;
	int i1,j1,i2,j2;
	int[][] vis=new int[100][100];
	int[][] vpi=new int[100][100];
	int[][] vpj=new int[100][100];
	int[][] mov= { {-1,0},
				   {1,0},
				   {0,1},
				   {0,-1}
				};
	
	public Mapa(){
		for(int i=0;i<99;i++)
			for(int j=0;j<99;j++) {
				mt[i][j]=0;
				vis[i][j]=1010;
			}
			
	}
	
	public void Construir( String titulo ) throws IOException{
		File f=new File( titulo );
		FileReader rf=new FileReader(f);
		BufferedReader br=new BufferedReader( rf );
		String s=br.readLine();
		String[] arr = s.split(" "); 
		
		n=Integer.parseInt( arr[0] );
		m=Integer.parseInt( arr[1] );
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				String txt=br.readLine();
				char ltr=txt.charAt(0);
				if( ltr=='C' )
					mt[i][j]=0;
				else
				if( ltr=='P' )
					mt[i][j]=1;
				if( ltr=='I' ) {
					mt[i][j]=3;
					i1=i; j1=j;
				}
				else
				if( ltr=='F' ) {
					mt[i][j]=4;
					i2=i; j2=j;
				}	
				
			}
		}
	}
	
	public String Mostrar() {
		String ans="";
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++)
				ans+=mt[i][j];
			ans+="\n";
		}
		return ans;
	}
	
	public String Build() {
		String ans="";
		int x,y;
		x=i2; y=j2;
		while( x!=i1 || y!=j1 ) {
			ans+=x+" "+y+"\n";
			int t1,t2;
			t1=vpi[x][y];
			t2=vpj[x][y];
			x=t1;
			y=t2;
		}
		ans+=x+" "+y+"\n";
		ans+="Costo: "+vis[i2][j2];
		return ans;
	}
	
	public boolean check(int x,int y,int ds) {
		if( Math.min(x, y)<0 || x>=n || y>=m )
			return false;
		if( mt[x][y]==1 )
			return false;
		if( vis[x][y]<ds )
			return false;
		return true;
	}
	
	public String Solve() {
		String ans="";
		Cola pq=new Cola(1000);
		pq.Insertar( new State(i1,j1,0,0) );
		vis[i1][j1]=0;
		
		while( pq.tot>=1 ) {
			State act=pq.Ver();
			pq.Eliminar();
			int x=0,y=0,val;
			if( act.vi==i2 && act.vj==j2 ) {
				vis[i2][j2]=act.Con;
				ans=Build();
				break;
			}
			for(int i=0;i<4;i++) {
				x=act.vi+mov[i][0];
				y=act.vj+mov[i][1];
				val=Math.abs( i2-x )+Math.abs( j2-y );
				val+=act.Dis;
				int ncn=act.Con+1;
				if( check( x,y,val )==true ) {
					vis[x][y]=val;
					vpi[x][y]=act.vi;
					vpj[x][y]=act.vj;
					pq.Insertar(new State(x,y,val,ncn)  );
				}
			}
		}
		return ans;
	}
}
























