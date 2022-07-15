/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolesbinarios;

/**
 *
 * @author JulioCesar
 */
/* Programa: ArbolBinario.java
 * Muestra el árbol binario de búsqueda como una estructura de datos
 * abstracta */

import java.io.*;
import java.util.*;

class Nodo{
	public int llave;		// clave 
	public double dato;		// data item
	public Nodo hijoIzq;	// referencia al subárbol izquierdo
	public Nodo hijoDer;	// referencia al subárbol derecho

	public Nodo(){
		llave   = -1;
		dato	=  0;
		hijoIzq = null;
		hijoDer = null;
	}
	
	public Nodo(int llave, double dato){
		this.llave = llave;
		this.dato  = dato;
		hijoIzq = null;
		hijoDer = null;
	}
	
	public void muestraNodo(){ // muestra el contenido del nodo
		System.out.println("{" + llave + ", " + dato + "} ");
	}
} // fin de la clase Nodo

////////////////////////////////////////////////////////////////
public class ArbolBinario{
	private Nodo raiz;	// El primer nodo del árbol
// -------------------------------------------------------------
	// árbol sin nodos en este momento
	public ArbolBinario(){ raiz = null; } 
// -------------------------------------------------------------
	/* busca un nodo con una llave determinada
	 * se asume que el árbol no está vacio 		*/
	public Nodo busca(int llave){ 
		Nodo actual = raiz;
		if(actual == null) return null;
		while(actual.llave != llave){  // mientras no sea el nodo buscado		
			if(llave < actual.llave)  	actual = actual.hijoIzq; // ir a la izquierda
			else   						actual = actual.hijoDer; // ir a la derecha
			if(actual == null) 			return null;  // no hay hijo, entonces la llave no existe
		}
		return actual;  // se encontro la llave
	}
// -------------------------------------------------------------
	public Nodo busqueda(int llave){
		return busRec(llave, raiz);
	}
// -------------------------------------------------------------	
	private Nodo busRec(int llave, Nodo raizAct){ 
		if(raizAct==null) return null; // la llave no existe
		if(llave < raizAct.llave) 		return busRec(llave, raizAct.hijoIzq); // a izq.
		else if(llave > raizAct.llave) 	return busRec(llave, raizAct.hijoDer); // a der.
		else return raizAct; // loteria lo encontre
	}	
// -------------------------------------------------------------	
	public void alta(int llave){
		raiz = altaRec(llave, raiz);
	}
// -------------------------------------------------------------	
	private Nodo altaRec(int llave, Nodo raizAct){ 
		if(raizAct==null){ // aqui va el nuevo nodo
			Nodo nvoNodo = new Nodo(llave, llave*100);
			return nvoNodo;
		}
		if(llave < raizAct.llave){ //a izq.
			// si se agrego el nvo nodo por la izq. aqui se 
			// modifica la referencia al hijo izquierdo,
			// solo si se agrego el nuevo nodo a este nodo,
			// de otra forma se deja la misma referencia
			raizAct.hijoIzq = altaRec(llave, raizAct.hijoIzq);
			return raizAct;
		}
		else if(llave > raizAct.llave){ // a der.
				raizAct.hijoDer = altaRec(llave, raizAct.hijoDer);
				return raizAct;
		}
		else return raizAct; // la llave ya existe
	}

// -------------------------------------------------------------	
	private Nodo eli(Nodo muere, Nodo actual){
		if(actual.hijoDer!=null){
			actual.hijoDer = eli(muere, actual.hijoDer);
			return actual;
		}
		muere.llave = actual.llave;
		muere.dato  = actual.dato;
		return actual.hijoIzq;
	}
	
// -------------------------------------------------------------	
	public void baja(int llave){ // llama a baja recursiva
		raiz = bajaRec(llave, raiz); // agrega la ráiz
	}
	
// -------------------------------------------------------------	
	private Nodo bajaRec(int llave, Nodo raizAct){ 
		if(raizAct==null){
			System.out.println("La llave no existe");
			//return null;
			return raizAct;
		}
		if(llave < raizAct.llave){
			raizAct.hijoIzq = bajaRec(llave, raizAct.hijoIzq);
			return raizAct;
		}
		else if(llave > raizAct.llave){
				raizAct.hijoDer = bajaRec(llave, raizAct.hijoDer);
				return raizAct;
		}
		else{ // Se encontro la llave a dar de baja
			if(raizAct.hijoIzq==null && raizAct.hijoDer==null) 
				return null; // baja de nodo sin hijos (hoja)
			else // baja de un nodo con un solo hijo
				  if(raizAct.hijoIzq==null) return raizAct.hijoDer;
			else  if(raizAct.hijoDer==null) return raizAct.hijoIzq;
			else{ // baja de un nodo con sus dos hijos
				raizAct.hijoIzq = eli(raizAct, raizAct.hijoIzq);
			}
		}
		return raizAct;
	}
// -------------------------------------------------------------
	public void insertar(int llave, double dato){
		Nodo nvoNodo = new Nodo();	// se construye un Nodo
		nvoNodo.llave = llave;
		nvoNodo.dato  = dato;

		if(raiz==null) raiz = nvoNodo; // no había datos en el árbol
		else { // ya hay datos en el árbol
			Nodo actual = raiz;
			Nodo padre;

			while(true){
				padre = actual;
				if(llave < actual.llave){ // ir a la izquierda
					actual = actual.hijoIzq;
					if(actual == null){ // si es el final del descenso,
						padre.hijoIzq = nvoNodo;	// se inserta a la izquierda
						return; // retorno despues de insertar a la izquierda
					}
				} else { // ir a la derecha
					actual = actual.hijoDer;
					if(actual == null) { // si es el final del descenso por la derecha
						padre.hijoDer = nvoNodo; // se inserta a la derecha
						return; // retorno despues de insertar a la derecha
					}
				} // fin del else 
			} // fin del while
		} // fin del else si no es la ráiz
	} // fin de insertar()
	
// -------------------------------------------------------------
/* regresa el nodo con el siguiente valor mayor que el del nodo que se 
 * va a eliminar. Va al hijo derecho del nodo que se va a eliminar y 
 * en seguida a los descendentes de la izquierda de este */ 
	private Nodo traeSucesor(Nodo nodoBaja){
		Nodo padreSucesor = nodoBaja;
		Nodo sucesor = nodoBaja;
		Nodo actual = nodoBaja.hijoDer; // va al hijo derecho

		while(actual != null){ // hasta que no halla hijos izquierdos
			padreSucesor = sucesor;
			sucesor = actual;
			actual = actual.hijoIzq;
		}
		if(sucesor != nodoBaja.hijoDer) { // si el sucesor no es el hijo 
			// derecho del nodo a eliminar hacer las conexiones
			padreSucesor.hijoIzq = sucesor.hijoDer;
			sucesor.hijoDer = nodoBaja.hijoDer;
		}
		return sucesor;
}

// -------------------------------------------------------------
	public boolean eliminar(int llave) { // elimina el nodo con la llave indicada
		// Se asume que el árbol no está vacio
		Nodo actual = raiz;
		Nodo padre  = raiz;
		boolean esHijoIzq = true;
		
		while(actual.llave != llave){ // mientras no encuentre la llave
			padre = actual;
			if(llave < actual.llave){ // va hacia la izquierda
				esHijoIzq = true;
				actual = actual.hijoIzq;
			} else { // va hacia la derecha
				esHijoIzq = false;
				actual = actual.hijoDer;
			}
			if(actual == null) return false; // la llave no existe
		} // fin del while
		
		// Se encontro el nodo a eliminar
		// Si no tiene hijos, simplemente se elimina
		if(actual.hijoDer==null && actual.hijoIzq==null)
			if(actual == raiz) raiz = null; // se elimino la raiz sin hijos, el árbol está vacio
			else if(esHijoIzq)	padre.hijoIzq = null; // se elimina el hijo izq.
			else padre.hijoDer = null; // se elimina el hijo derecho
			
		else if(actual.hijoDer==null) // si no tiene hijo derecho, se reemplaza por el hijo izquierdo
				if(actual == raiz) raiz = actual.hijoIzq; // si es la raiz, el hijo izquierdo es la nueva raiz
				else if(esHijoIzq) padre.hijoIzq = actual.hijoIzq;
				else padre.hijoDer = actual.hijoIzq;

		else if(actual.hijoIzq==null) // Si no tiene hijo izquierdo
			if(actual == raiz) raiz = actual.hijoDer;
			else if(esHijoIzq) padre.hijoIzq = actual.hijoDer;
			else padre.hijoDer = actual.hijoDer;
				
		else{ // tiene dos hijo, así que se reemplaza pcon el nodo sucesor enorden
			Nodo sucesor = traeSucesor(actual); // trae el nodo sucesor del nodo a eliminar (actual)
			// Se conecta el padre del nodo actual con el sucesor
			if(actual == raiz) raiz = sucesor;
			else if(esHijoIzq)	padre.hijoIzq = sucesor;
			else padre.hijoDer = sucesor;
			
			sucesor.hijoIzq = actual.hijoIzq; // se hace hijo izq del sucesor igual a hijo izq de actual
											  // el sucesor no tiene hijo izquierdo
		} // fin del else para dos hijos
		return true; // se elimino
	} // fin eliminar()
	
	public void preOrd(){ // lo agregue para usarlo en el main
	// no se necesita fue para demo.
		preOrden(raiz);
	}
	
// -------------------------------------------------------------
	private void preOrden(Nodo raizLocal){
		if(raizLocal != null){
			System.out.print(raizLocal.llave + " ");
			preOrden(raizLocal.hijoIzq);
			preOrden(raizLocal.hijoDer);
		}
	}
	
// -------------------------------------------------------------
	private void enOrdenInv(Nodo raizLocal, int h){
		if(raizLocal != null){
			enOrdenInv(raizLocal.hijoDer, h+1);
			for(int i=1; i<h; i++) System.out.print("\t");
			System.out.println(raizLocal.llave + "\n");
			enOrdenInv(raizLocal.hijoIzq, h+1);
		}
	}
// -------------------------------------------------------------
	private void enOrden(Nodo raizLocal){
		if(raizLocal != null){
			enOrden(raizLocal.hijoIzq);
			System.out.print(raizLocal.llave + " ");
			enOrden(raizLocal.hijoDer);
		}
	}
// -------------------------------------------------------------
	private void postOrden(Nodo raizLocal){
		if(raizLocal != null){
			postOrden(raizLocal.hijoIzq);
			postOrden(raizLocal.hijoDer);
			System.out.print(raizLocal.llave + " ");
			
		}
	}
// -------------------------------------------------------------
	private void NodosInternos(Nodo raizLocal){
		if(raizLocal != null){
			NodosInternos(raizLocal.hijoIzq);
			NodosInternos(raizLocal.hijoDer);
			boolean ban=false;
			if( raizLocal.hijoIzq==raizLocal.hijoDer &&  raizLocal.hijoIzq==null ) 
				ban=true;
			if( raizLocal==raiz )
				ban=true;
			if(ban==false)
				System.out.print(raizLocal.llave + " ");
			
		}
	}
	
// -------------------------------------------------------------
private void Hojas(Nodo raizLocal){
		if(raizLocal != null){
			Hojas(raizLocal.hijoIzq);
			Hojas(raizLocal.hijoDer);
			if( raizLocal.hijoIzq==raizLocal.hijoDer &&  raizLocal.hijoIzq==null ) 
					System.out.print(raizLocal.llave + " ");
		}
	}
	
// -------------------------------------------------------------
private void OrdenDesc(Nodo raizLocal){
	if(raizLocal != null){
		OrdenDesc(raizLocal.hijoDer); 
		System.out.print(raizLocal.llave + " ");
		OrdenDesc(raizLocal.hijoIzq);
	}
}

//-------------------------------------------------------------

	public void recorrido(int tipoRecorrido){
		switch(tipoRecorrido){
			case 1: System.out.println("\nRecorrido Preorden: ");
					 preOrden(raiz);
					 break;
					 
			case 2: System.out.println("\nRecorrido En orden Inverso: ");
					 enOrdenInv(raiz, 1);
					 break;
					 
			case 3: System.out.println("\nRecorrido Postorden: ");
					 postOrden(raiz);
					 break;
			case 4: System.out.println("\nRecorrido En orden: ");
					 enOrden(raiz);
					 break;		
			case 5: System.out.println("\nHojas del arbol: ");
			 		Hojas(raiz);
			 		break;
			case 6: System.out.println("\nNodos Internos: ");
	 				NodosInternos(raiz);
	 				break;
			case 7: System.out.println("\nNodos Internos: ");
				OrdenDesc(raiz);
				break;

			}
		System.out.println();
	}


}
