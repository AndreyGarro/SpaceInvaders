package com.andrews.estructuras;


public class ListaCircularDoble<T> extends Lista {


    // Atributos de la Clase
    private NodoCircularDoble<T> primero;
    private NodoCircularDoble<T> ultimo;
    private int tamaño;

    public ListaCircularDoble() {
        this.primero = null;
    }

    /**
     * Devuelve el tamaño de la lista.
     *
     * @return int con el tamaño
     */
    public int getTamaño() {
        return this.tamaño;
    }

    /**
     * Revisa si la lista esta vacia o no.
     *
     * @return True o False
     */
    public boolean isEmpty() {
        if (this.primero == null) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Elimina todos los datos de la lista.
     */
    public void eliminarTodo() {
        this.primero = null;
        this.tamaño = 0;
    }

    /**
     * Agrega un nodo al inicio de la lista.
     *
     * @param dato
     *            dato a agregar.
     */
    public void agregarAlInicio(T dato) {
        NodoCircularDoble<T> nuevo = new NodoCircularDoble<T>();
        nuevo.setDato(dato);
        if (this.primero == null) {
            this.primero = nuevo;
            this.ultimo = nuevo;
            primero.setSiguiente(ultimo);
            ultimo.setSiguiente(primero);
            this.tamaño++;
        } else {
            nuevo.setSiguiente(this.primero);
            this.primero.setAnterior(nuevo);
            this.ultimo.setSiguiente(nuevo);
            nuevo.setAnterior(ultimo);
            primero = nuevo;
            this.tamaño++;
        }
    }

    /**
     * Agrega un nodo al final de la lista.
     *
     * @param dato
     *            dato a agregar.
     */
    public void agregarAlFinal(T dato) {
        NodoCircularDoble<T> nuevo = new NodoCircularDoble<T>();
        nuevo.setDato(dato);
        if (this.primero == null) {
            this.primero = nuevo;
            this.ultimo = nuevo;
            primero.setSiguiente(ultimo);
            ultimo.setSiguiente(primero);
        } else {
            this.ultimo.setSiguiente(nuevo);
            this.primero.setAnterior(nuevo);
            nuevo.setAnterior(ultimo);
            nuevo.setSiguiente(primero);
            ultimo = nuevo;
        }
        this.tamaño ++;
    }

    /**
     * Devuelve el dato que contiene un nodo.
     *
     * @param pos
     *            posicion del nodo del cual se quiere el dato.
     * @return dato del nodo deseado.
     */
    public T getDato(int pos) {
        NodoCircularDoble<T> aux = this.primero;
        int cont = 0;
        while (cont != pos) {
            aux = aux.getSiguiente();
            cont++;
        }
        return aux.getDato();
    }

    /**
     * Devuelve un nodo de la lista.
     *
     * @param pos
     *            posicion del nodo que se desea.
     * @return el nodo deseado.
     */
    public NodoCircularDoble<T> getNodo(int pos) {
        if (pos == 0) {
            return this.primero;
        } else {
            NodoCircularDoble<T> aux = primero;
            for (int i = 0; i < pos; i++) {
                aux = aux.getSiguiente();
            }
            return aux;
        }
    }

    /**
     * Inserta un nodo en la posicion deseada.
     *
     * @param pos
     *            posicion a insertar el nodo.
     * @param dato
     *            dato que se desea guardar en el nodo.
     */
    public void insertarPos(int pos, T dato) {
        if (pos >= 0 && pos <= this.tamaño) {
            NodoCircularDoble<T> nuevo = new NodoCircularDoble<T>();
            nuevo.setDato(dato);
            if (pos == 0) {
                this.agregarAlInicio(dato);
            } else {
                if (pos == tamaño) {
                    this.agregarAlFinal(dato);
                } else {
                    NodoCircularDoble<T> aux = this.primero;
                    for (int i = 0; i < pos; i++) {
                        aux = aux.getSiguiente();
                    }
                    aux.getAnterior().setSiguiente(nuevo);
                    nuevo.setAnterior(aux.getAnterior());
                    aux.setAnterior(nuevo);
                    nuevo.setSiguiente(aux);
                    tamaño ++;
                }
            }
            this.tamaño++;
        }
    }

    /**
     * Elmina el nodo de la posicion dada.
     *
     * @param pos
     *            posicion que se desea eliminar.
     */
    public void eliminarPos(int pos) {
        if (pos >= 0 && pos < this.tamaño) {
            if (pos == 0) {
                ultimo.setSiguiente(primero.getSiguiente());
                primero.getSiguiente().setAnterior(primero.getAnterior());
            } else {
                NodoCircularDoble<T> aux = primero;
                for (int i = 0; i < pos; i++) {
                    aux = aux.getSiguiente();
                }
                aux.getAnterior().setSiguiente(aux.getSiguiente());
                aux.getSiguiente().setAnterior(aux.getAnterior());
            }
            this.tamaño--;
        }
    }

}
