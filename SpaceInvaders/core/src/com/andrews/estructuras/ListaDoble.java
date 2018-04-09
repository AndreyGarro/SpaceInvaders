package com.andrews.estructuras;

import com.andrews.escenario.Nivel3;
import com.andrews.sprites.Enemigo;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ListaDoble<T> extends Lista {

	private NodoDoble<T> primero;
	private int tama�o;
	
	public ListaDoble(){
		this.primero = null;
	}
	
	public boolean isEmpty() {
		if (this.primero == null) {
			return true;
		}
		else {
			return false;		
		}
	}
	
	public void agregarAlInicio(T dato) {
		NodoDoble<T> nuevo = new NodoDoble<T>();
		nuevo.setDato(dato);
		if(this.primero == null) {
			this.primero = nuevo;
			this.tama�o ++;
		}
		else {
			nuevo.setSiguiente(this.primero);
			this.primero.setAnterior(nuevo);
			this.primero = nuevo;
			this.tama�o ++;
		}
	}
	
	public void agregarAlFinal(T dato) {
		NodoDoble<T> nuevo = new NodoDoble<T>();
		nuevo.setDato(dato);
		if(this.primero == null) {
			this.primero = nuevo;
		}
		else {
			NodoDoble<T> aux = primero;
			while(aux.getSiguiente() != null) {
				aux = aux.getSiguiente();
			}
			aux.setSiguiente(nuevo);
			nuevo.setAnterior(aux);
			this.tama�o ++;
		}
	}
	
	public int getTama�o() {
		return this.tama�o;
	}
	
    public T getDato(int pos) {
    	NodoDoble<T> aux = this.primero;
    	int cont = 0;
    	while(cont != pos) {
    		aux = aux.getSiguiente();
    		cont ++;
    	}
    	return aux.getDato();
    }
    
    public NodoDoble<T> getNodo(int pos){
    	if(pos == 0) {
    		return this.primero;
   		}
   		else {
   			NodoDoble<T> aux = primero;
   			for(int i = 0; i < pos-1; i++) {    				
   				aux = aux.getSiguiente();
    		}
    		return aux;
    	}
    }
    
    public void insertarPos(int pos, T dato) {
    	if(pos>= 0 && pos<=this.tama�o) {
    		NodoDoble<T> nuevo = new NodoDoble<T>();
    		nuevo.setDato(dato);
    		if(pos == 0) {
    			this.agregarAlInicio(dato);
    		}
    		else {
    			if(pos == tama�o) {
    				this.agregarAlFinal(dato);
    			}
    			else {
    				NodoDoble<T> aux = this.primero;
    				for(int i = 0; i <(pos - 1); i++) {
    					aux = aux.getSiguiente();
    				}
    				NodoDoble<T> siguiente = aux.getSiguiente();
    				aux.setSiguiente(nuevo);
    				nuevo.setSiguiente(siguiente);
    				nuevo.setAnterior(aux);
    				siguiente.setAnterior(nuevo);
    			}
    		}
    	this.tama�o ++;
    	}
    }
    
    public void eliminarPos(int pos, ListaDoble<Enemigo> lista) {
    	if(pos>=0 && pos < this.tama�o) {
    		if (pos == 0) {
    			this.primero = primero.getSiguiente();
    		}
    		else {
    			NodoDoble<T> aux = primero;
    			for(int i = 0; i < pos-1; i++) {
    				aux = aux.getSiguiente();
    			}
    			NodoDoble<T> siguiente = aux.getSiguiente();
    			this.mover(siguiente, lista);
    			aux.setSiguiente(siguiente.getSiguiente());
    		}
    		this.tama�o --;
    	}
    }
    
    public void mover(NodoDoble<T> nodo, ListaDoble<Enemigo> lista) {
    	NodoDoble<T> aux = this.primero;
    	int cont = 0;
    	while(aux!=nodo) {
    		lista.getDato(cont).getBordes().x += 25;
    		aux = aux.getSiguiente();
    		cont ++;
    	}
    	while(cont < lista.tama�o) {
    		lista.getDato(cont).getBordes().x -= 25;
    		cont ++;
    	}
    }
    
    public void reemplazar(int random, int posJefe, Nivel3 nivel) {
    	T c1 = this.getDato(posJefe);
    	T c2 = this.getDato(random);
    	this.getNodo(posJefe).setDato(c2);
    	this.getNodo(random).setDato(c1);
    	nivel.tempo = 0;
    }
    
}
