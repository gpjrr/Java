import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.JOptionPane;


public class EjecutaMain {
	public static void main(String[] args) {
		Scanner sc=new Scanner( System.in );
		Personas p1=new Personas("carlos",12);
		Personas p2=new Personas("pepep",34);
		
		
		Empleados emp1=new Empleados(p1.Nombre,p1.DiaCumple);	
		emp1.llenar( 2000  , p1,"matutino");
		
		 Gerente gr1= new Gerente(p2.Nombre,p2.DiaCumple,10000,2009,"asdf");
		 System.out.print( emp1.MostrarDatos() );
		 
	}

}