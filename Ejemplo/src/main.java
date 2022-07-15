
public class main {
	public static void main(String[]  args) {
		System.out.println("Hola como estas");
		
		int Contador=0;
		String palabra="hola";
		float decimales=(float) 3.2;
		double presicion= (double)3.1416;
		long numerotes=(long)11324213;
		char letra='U';
		System.out.println("Contador="+Contador+"\n");
		System.out.println("palabra="+palabra+"\n");
		System.out.println("decimalesr="+decimales+"\n");
		System.out.println("presicion="+presicion+"\n");
		System.out.println("numerotes="+numerotes+"\n");
		if( 1>=2 )
			System.out.println("letra="+letra+"\n");
		else
			System.out.println("no se puede\n");
		//int[] Arr;
		//Arr=new int[100];
		int[] Arr=new int[100];
		for(int i=0;i<10;i++)
			Arr[i]=i*2+4;
		
		for(int i=0;i<10;i++)
			System.out.println("arr["+i+"]="+Arr[i]+"\n");
		int tem=Arr[2];
			System.out.println("tem="+tem+"\n");
		tem+=2;
			System.out.println("tem="+tem+"\n");
		for(int i=0;i<10;i++)
			System.out.println("arr["+i+"]="+Arr[i]+"\n");
		int[][] Mat=new int[100][100];
		for(int i=0;i<10;i++)
			for(int j=0;j<10;j++)
				Mat[i][j]=i*j;
		for(int i=0;i<10;i++) {
			for(int j=0;j<10;j++)
				System.out.print(Mat[i][j]+" ");

			System.out.println("\n");
		}
		
		
		
	}
}














