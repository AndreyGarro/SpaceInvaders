package com.andrews.estructuras;

/**
 * Nodo para las listas circular doble
 * 
 * @author andrey
 * @param <T>
 *            Nodo generico que guarda cualquier tipo de dato
 */
public class NodoCircularDoble<T> {

	// Atributos
	private T dato;
	private NodoCircularDoble<T> siguiente;
	private NodoCircularDoble<T> anterior;

	// Constructor
	public NodoCircularDoble() {
		this.dato = null;
		this.siguiente = null;
		this.anterior = null;
	}

	// Getters and Setters
	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}

	public NodoCircularDoble<T> getSiguiente() {
		return this.siguiente;
	}

	public void setSiguiente(NodoCircularDoble<T> siguiente) {
		this.siguiente = siguiente;
	}

	public NodoCircularDoble<T> getAnterior() {
		return anterior;
	}

	public void setAnterior(NodoCircularDoble<T> anterior) {
		this.anterior = anterior;
	}

}
