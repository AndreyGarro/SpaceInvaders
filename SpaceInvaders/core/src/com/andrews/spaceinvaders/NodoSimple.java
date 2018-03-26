package com.andrews.spaceinvaders;

public class NodoSimple<T> {

	private T dato;
	private NodoSimple<T> siguiente;

	public NodoSimple(){
	    this.dato = null;
	    this.siguiente = null;
	}
	
	public T getDato() {
	    return dato;
	}
	
	public void setDato(T dato) {
	    this.dato = dato;
	}
	
	public NodoSimple<T> getSiguiente() {
	    return siguiente;
	}
	
	public void setSiguiente(NodoSimple<T> siguiente) {
	    this.siguiente = siguiente;
	}
	

	
}
