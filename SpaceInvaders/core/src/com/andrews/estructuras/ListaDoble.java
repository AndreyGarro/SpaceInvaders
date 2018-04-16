package com.andrews.estructuras;

import com.andrews.sprites.SpriteForEnemy;

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
	
	public void eliminarTodo() {
		this.primero = null;
		this.tama�o = 0;
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
    
    public void eliminarPos(int pos) {
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
    			this.mover(siguiente);
    			aux.setSiguiente(siguiente.getSiguiente());
    		}
    		this.tama�o --;
    	}
    }
    
    public void mover(NodoDoble<T> nodo) {
    	NodoDoble<T> aux = this.primero;
    	int cont = 0;
    	while(aux!=nodo) {
    		((SpriteForEnemy) this.getDato(cont)).getBordes().x += 37;
    		aux = aux.getSiguiente();
    		cont ++;
    	}
    	while(cont < this.tama�o) {
    		((SpriteForEnemy) this.getDato(cont)).getBordes().x -= 37;
    		cont ++;
    	}
    }
   
    public void reemplazar(int pos, NodoDoble<T> reemplazo) {
        NodoDoble<T> pivote = this.primero;
        for(int i = 0; i <= pos; i ++) {
            if (i == pos) {
                if(pivote != this.primero && i != this.tama�o - 1) {
                    reemplazo.setAnterior(pivote.getAnterior());
                    reemplazo.setSiguiente(pivote.getSiguiente());
                    pivote.getAnterior().setSiguiente(reemplazo);
                    pivote.getSiguiente().setAnterior(reemplazo);
                    break;
                }
                else if(pivote == this.primero){
                    reemplazo.setSiguiente(pivote.getSiguiente());
                    pivote.getSiguiente().setAnterior(reemplazo);
                    primero = reemplazo;
                    break; 
                }
                else if(i == this.tama�o - 1){
                    reemplazo.setAnterior(this.getNodo(this.tama�o-1).getAnterior());
                    pivote.getAnterior().setSiguiente(reemplazo);
                    break;
                }
            }
            pivote = pivote.getSiguiente();
        }

    }
    
}
