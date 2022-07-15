import java.util.Stack;

import java.util.LinkedList;
import java.util.Queue;

import java.util.*;
public class menu {
	public static void main(String[] args) {
  
		
		Queue<Integer> q= new LinkedList<>();
		
		Queue<Nodo> ColaNodos= new LinkedList<>();
		ColaNodos.add( new Nodo() );
	
		if( q.isEmpty()==true )
			System.out.print("esta vacia\n");
		
		q.add( 3 );
		q.add( 1 );
		q.add( 5 );
		q.add( 9 );
		q.add( 10 );
	
		//q.clear();
		int tam=q.size();
		System.out.print("el tam es "+tam+ "\n" );
		
	
		while( q.isEmpty()==false || q.size()>=1 ) {
			int front=q.peek();
			System.out.print("el primer valor es "+front+ "\n" );
			q.remove();
		}
		
		System.out.print("ahora probamos nuestra propia cola\n");
		Cola fila=new Cola();
		
		if( fila.IsEmpty()==true ) 
			System.out.print("esta vacia\n");
		
		fila.Insertar( 3 );
		fila.Insertar(  1);
		fila.Insertar( 5 );
		fila.Insertar( 9 );
		fila.Insertar( 10 );
		fila.clear();
		System.out.print("el tam es "+ fila.size() + "\n" );
		while( fila.IsEmpty()==false ) {
			int tem=fila.top();
			System.out.print("el primer valor es "+ tem + "\n" );
			fila.Eliminar();
		}
		
		
		/*
		System.out.print("ahora probamos la pila\n");
		Stack<Integer> pila = new Stack<>();		
		
		
		Stack<Nodo> pilaNodos= new Stack<>();
		
		if( pila.isEmpty()==true )
			System.out.print("esta vacia\n");
		pila.add( 3  );
		pila.add( 1 );
		pila.add( 5 );
		pila.add( 9 );
		pila.add( 10 );
	
		//pila.clear();
		tam=pila.size();
		System.out.print("el tam es "+tam+ "\n" );
		while( pila.isEmpty()==false  ) {
			int num=pila.peek();
			System.out.print("el primer valor es "+num+ "\n" );	
			pila.pop();
		}
		
		Queue<Integer> pq = new PriorityQueue<>();
		System.out.print("ahora probamos la cola de prioridad\n");
		
		if( pq.isEmpty()==true )
			System.out.print("esta vacia\n");
		
		pq.add( 7 );
		pq.add( 1 );
		pq.add( 30 );
		pq.add( 15 );
		pq.add( 4 );
		
		//pq.clear();
		while( pq.size()>=1 ) {
			int num=pq.peek();
			System.out.print("el primer valor es "+num+ "\n" );
			pq.remove();
		}
		*/
	
	}
}
