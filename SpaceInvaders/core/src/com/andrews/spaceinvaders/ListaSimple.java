package com.andrews.spaceinvaders;

public class ListaSimple<T> {
    private NodoSimple<T> primero;
    private int tama�o;

    public ListaSimple(){
        primero = null;
    }

    public boolean isEmpty(){
        return primero == null;
    }

    public int getTama�o(){
        return tama�o;
    }

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
    
    public T getDato(int pos) {
    	NodoSimple<T> aux = this.primero;
    	int cont = 0;
    	while(cont != pos) {
    		aux = aux.getSiguiente();
    		cont ++;
    	}
    	return aux.getDato();
    }

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
