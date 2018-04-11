package com.andrews.estructuras;

public class NodoCircular<T> {
	
	private T dato;
	private NodoCircular<T> siguiente;

	public NodoCircular() {
		this.dato = null;
		this.siguiente = null;
	}

	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}

	public NodoCircular<T> getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(NodoCircular<T> siguiente) {
		this.siguiente = siguiente;
	}
	
	
}
