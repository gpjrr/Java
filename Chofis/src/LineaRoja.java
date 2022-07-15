import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Color;
import java.util.Scanner;

public class LineaRoja extends Frame {
public LineaRoja() {
setTitle("Trazado de l�nea recta");
this.setSize(800, 800);
this.setVisible(true);
}
@Override
public void paint(Graphics g) {
g.setColor(Color.RED);
/* g.drawLine(50, 150, 50, 150); */
int dx,dy;
int x1,x2,y1,y2,x,y;
float m, b;

// Coordenadas de inicio y fin de la l�nea recta
x1=50;  y1=200; 
x2=200; y2=600;

 //x1=200; y1=50;
 //x2=600; y2=200;

// C�lculo de la ecuaci�n de la l�nea recta:
dy=y2-y1;
dx=x2-x1;
m = (float)dy/(float)dx;
b = (float)(y1 - (m*x1));
System.out.println("Pendiente: "+ m); 
System.out.println("T�rmino independiente: "+ b); 

// Trazado de la l�nea recta:
for (x=x1;x<=x2;x=x+1)
        {
           y = (int) ((m * x) + b);
       	System.out.println("m==="+ m );
            if (m>=1){

            g.drawLine(x,800-y,x,800-y);
            }
            else
            g.drawLine(y,800-x,y,800-x);
           
         
        }
}
public static void main(String[] args) {
LineaRoja p = new LineaRoja();

}
}