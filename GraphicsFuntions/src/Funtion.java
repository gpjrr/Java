
public class Funtion {
	int a,b,c;
	Point[] arr;
	int blo;
	long sum;
	int lim;
	float integral(int x) {
		float sum=0;
		sum+=a*( (x*x*x)/3);
		sum+=b*( ( x*x )/2);
		sum+=c*x;
		return sum;
	}
	public Funtion(int v1,int v2,int v3) {
		a=v1;
		b=v2;
		c=v3;
		sum=0;
		arr=new Point[1000];
	}
	Point GetPoint(int x) {
		int sum=a*x*x+b*x+c;
		return new Point(x,sum);
	}
}
