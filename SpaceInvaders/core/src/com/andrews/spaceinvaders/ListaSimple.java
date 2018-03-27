package com.andrews.spaceinvaders;


/**
 * Crea listas simples a partir de los nodos simples.
 * @author andrey
 *
 * @param <T> Recibe de que tipo ser� la lista
 */
public class ListaSimple<T> {
	
	//Atributos
    private NodoSimple<T> primero;
    private int tama�o;
    //
    
    /**
     * Inicia una lista vacia nueva.
     */
    public ListaSimple(){
        primero = null;
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
        	NodoSimple<T> aux = new NodoSimple<T>();
            aux = primero;
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


}
