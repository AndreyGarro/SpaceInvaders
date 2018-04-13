package com.andrews.estructuras;

import com.andrews.sprites.Enemigo;

/**
 * Crea listas simples a partir de los nodos simples.
 * @author andrey
 *
 * @param <T> Recibe de que tipo ser� la lista
 */
public class ListaSimple<T> extends Lista {
	
	//Atributos
    private NodoSimple<T> primero;
    private int tama�o;
    //
    
    /**
     * Inicia una lista vacia nueva.
     */
    public ListaSimple(){
        this.primero = null;
    }
    //Fin del Constructor

    /**
     * Revisa si la lista est� vac�a
     * @return true o false
     */
    public boolean isEmpty(){
        return primero == null;
    }

    
    /**
     * Devuelve el tama�o de la lista
     * @return tama�o
     */
    public int getTama�o(){
        return tama�o;
    }

    
    /**
     * Agrega un nodo al final de la lista 
     * @param valor el dato que se desea colocar al final
     */
    public void agregarAlFinal(T valor){
    	NodoSimple<T> nuevo = new NodoSimple<T>();
        nuevo.setDato(valor);

        if(this.isEmpty()){
            this.primero = nuevo;
        }
        else{
        	NodoSimple<T> aux = primero;
            while (aux.getSiguiente() != null){
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(nuevo);
                    }
        tama�o += 1;
    }

    
    /**
     * Agrega un nodo al inicio de la lista 
     * @param dato el dato que se desea colocar al inicio
     */
    public void agregarAlInicio(T dato) {
    	NodoSimple<T> nuevo = new NodoSimple<T>();
        nuevo.setDato(dato);

        if (this.isEmpty()) {
            this.primero = nuevo;
        } else {
            nuevo.setSiguiente(this.primero);
            this.primero = nuevo;
        }
        tama�o += 1;
    }
    
    /**
     * Devuelve el dato en la posicion dada
     * @param pos posicion en donde se encuentra el dato
     * @return el dato en la posicion solicitada
     */
    public T getDato(int pos) {
    	NodoSimple<T> aux = this.primero;
    	int cont = 0;
    	while(cont != pos) {
    		aux = aux.getSiguiente();
    		cont ++;
    	}
    	return aux.getDato();
    }
    
    /**
     * Devuelve todos los valores que contiene la lista dentro.
     * @return un string con todos los datos
     */
    @Override
    public String toString() {
        String lista = new String();
        NodoSimple<T> aux = new NodoSimple<T>();
        aux = primero;
        for(int i = 0; i<this.tama�o; i ++){
                lista += aux.getDato() + ", ";
                aux = aux.getSiguiente();
        }
        return lista;
    }
    
    public NodoSimple<T> getNodo(int pos){
    	if(pos == 0) {
    		return this.primero;
   		}
   		else {
   			NodoSimple<T> aux = primero;
   			for(int i = 0; i < pos-1; i++) {    				
   				aux = aux.getSiguiente();
    		}
    		return aux;
    	}
    }
    
    public void insertarPos(int pos, T dato) {
    	if(pos>= 0 && pos<=this.tama�o) {
    		NodoSimple<T> nuevo = new NodoSimple<T>();
    		nuevo.setDato(dato);
    		if(pos == 0) {
    			this.agregarAlInicio(dato);
    		}
    		else {
    			if(pos == tama�o) {
    				this.agregarAlFinal(dato);
    			}
    			else {
    				NodoSimple<T> aux = this.primero;
    				for(int i = 0; i <(pos - 1); i++) {
    					aux = aux.getSiguiente();
    				}
    				NodoSimple<T> siguiente = aux.getSiguiente();
    				aux.setSiguiente(nuevo);
    				nuevo.setSiguiente(siguiente);
    			}
    		}
    	this.tama�o ++;
    	}
    }
    
    public void eliminarPos(int pos, ListaSimple<Enemigo> lista) {
    	if(pos>=0 && pos < this.tama�o) {
    		if (pos == 0) {
    			this.primero = primero.getSiguiente();
    		}
    		else {
    			NodoSimple<T> aux = primero;
    			for(int i = 0; i < pos-1; i++) {
    				aux = aux.getSiguiente();
    			}
    			NodoSimple<T> siguiente = aux.getSiguiente();
    			this.mover(siguiente, lista);
    			aux.setSiguiente(siguiente.getSiguiente());
    		}
    		this.tama�o --;
    	}  	
    }
    
    public void mover(NodoSimple<T> nodo, ListaSimple<Enemigo> lista) {
    	NodoSimple<T> aux = this.primero;
    	int cont = 0;
    	while(aux!=nodo) {
    		lista.getDato(cont).getBordes().x += 37;
    		aux = aux.getSiguiente();
    		cont ++;
    	}
    	while(cont < lista.tama�o) {
    		lista.getDato(cont).getBordes().x -= 37;
    		cont ++;
    	}
    }
    
    public void eliminarTodo() {
    	this.primero = null;
    	tama�o = 0;
    }


}
