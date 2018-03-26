package com.andrews.spaceinvaders;


/**
 * Nodo para las listas simples
 * @author andrey
 * @param <T> Nodo generico que guarda cualquier tipo de dato
 */
public class NodoSimple<T> {

	//Atributos 
	private T dato;
	private NodoSimple<T> siguiente;
	//
	
	/**
	 * Inicializa el nuevo nodo
	 */
	public NodoSimple(){
	    this.dato = null;
	    this.siguiente = null;
	}
	//Fin del Constructor
	
	/**
	 * Devuelve el dato guardado en el nodo
	 * @return dato guardado
	 */
	public T getDato() {
	    return dato;
	}
	
	/**
	 * Guarda el dato de cualquier tipo en el nodo
	 * @param dato dato que se desea guardar
	 */
	public void setDato(T dato) {
	    this.dato = dato;
	}
	
	/**
	 * Obtiene el nodo al que está apuntando
	 * @return el nodo que está de siguiente
	 */
	public NodoSimple<T> getSiguiente() {
	    return siguiente;
	}
	
	/**
	 * Coloca como siguiente el nodo solicitado
	 * @param siguiente el nodo al que se quiere apuntar
	 */
	public void setSiguiente(NodoSimple<T> siguiente) {
	    this.siguiente = siguiente;
	}
	

	
}
