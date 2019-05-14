/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyTDAs;

/**
 *
 * @author Cristian Meoño
 */
public class DoubleCircularLinkedList<T> {
    // Encabezado
    private DoubleNode<T> inicio;
    //Final
    private DoubleNode<T> ultimo;
    // Tamaño
    private int size;
    
    /**
     * Constructor #1
     */
    public void Lista(){
        inicio = null;
        ultimo = null;
        size = 0;
    }
    
    /**
     * Verifica si las lista esta vacia
     * @return true si el primer nodo apunta a null
     */
    public boolean isEmpty(){
        return inicio == null;
    }
    
    /**
     * Busca si existe un valor en la lista.
     * @param refValue Valor a buscar.
     * @return true si existe el valor.
     */
    public boolean Search(T refValue){
        DoubleNode<T> aux = inicio;
        boolean encontrado = false;
        // Recorre la lista hasta encontrar el elemento o llegar al final
        while(aux != null && encontrado != true){
            if (refValue == aux.getValue()){
                encontrado = true;
            }
            else{
                aux = aux.getNext();
            }
        }
        return encontrado;
    }
    
    /**
     * Elimina la lista
     */
    public void DeleteList(){
        inicio = null;
        ultimo=null;
        size = 0;
    }
    
    /**
     * Agrega un nodo al final de la lista
     * @param value Valor a agregar.
     */
    public void addEnd(T value){
        // Crea el nodo y asigna su valor
        DoubleNode<T> nuevo = new DoubleNode();
        nuevo.setValue(value);
        // Verifica si esta vacia
        if (isEmpty()) {
            // Si esta vacia incializa la lista y asigna el encabezado
            inicio = nuevo;
            ultimo= nuevo;
            ultimo.setNext(inicio);
            ultimo.setPrevious(inicio);
        }
        // Se inserta en el ultimo espacio de la lista
        else{
            nuevo.setPrevious(ultimo);
            ultimo.setNext(nuevo);
            nuevo.setNext(inicio);
            ultimo=nuevo;
        }
        // Incrementa el contador del tamaño de la lista
        size++;
    }
    
    /**
     * Agrega un nodo al inicio de la lista.
     * @param valor Valor a agregar.
     */   
    public void addBegin(T valor){
        // Crea el nodo y asigna su valor
        DoubleNode<T> nuevo = new DoubleNode();
        nuevo.setValue(valor);
        // Verifica si esta vacia
        if (isEmpty()) {
            // Si esta vacia incializa la lista y asigna el encabezado
            inicio = nuevo;
            ultimo=nuevo;
            ultimo.setNext(inicio);
        } 
        // Se inserta en el primer espacio de la lista
        else{
            // Se agrega y se establece como el encabezado
            nuevo.setNext(inicio);
            nuevo.setPrevious(ultimo);
            inicio = nuevo;
            ultimo.setNext(inicio);
        }
        // Incrementa el contador del tamaño de la lista.
        size++;
    }
        
    /**
     * Imprimi contenido de la lista
     */
    public void getContent(){
        if (!isEmpty()) {
            DoubleNode<T> aux = inicio;
            int i = 0;
            // Recorre la lista hasta el final.
            while(aux != null){
                System.out.print(i + ".[ " + aux.getValue() + " ]" + " ->  ");
                aux = aux.getNext();
                i++;
            }
        }
    }
    
    /**
     * Retorna cuantos elementos existen dentro de la lista
     * @return Numero de elementos que contiene
     */
    public int getSize(){
        return size;
    }
    
    /**
     * Obtiene el valor de un nodo en la posición indicada.
     * @param posicion del nodo que se desea obtener su valor.
     * @return El valor del nodo en la posicion indicada
     * @throws Exception
     */
    public T getValue(int posicion) throws Exception{
        // Verifica que la posicion este en el rango
        if(posicion>=0 && posicion<size){
            if (posicion == 0) {
                return inicio.getValue();
            }else{
                DoubleNode<T> aux = inicio;
                // Recorre la lista hasta la posición indicada.
                for (int i = 0; i < posicion; i++) {
                    aux = aux.getNext();
                }
                return aux.getValue();
            }
        } else {
            throw new Exception("¡POSICION NO EXISTE!");
        }
    }
    
    /**
     * Obtiene la posicion del nodo con el valor indicado
     * @param refValue Valor del nodo a buscar.
     * @return Posición del nodo. 
     * @throws Exception 
     */
    public int getPosition(T refValue) throws Exception{
        if (Search(refValue)) {
            DoubleNode<T> aux = inicio;
            int cont = 0;
            while(refValue != aux.getValue()){
                cont ++;
                aux = aux.getNext();
            }
            return cont;
        } else {
            throw new Exception("VALOR NO EXISTE");
        }
    }
    
    /**
     * Edita el valor de un nodo segun el valor indicado
     * @param refValue valor del nodo el cual se desea actualizar.
     * @param valor nuevo valor para el nodo.
     */
    public void editByValue(T refValue, T valor){
        if (Search(refValue)) {
            DoubleNode<T> aux = inicio;
            while(aux.getValue() != refValue){
                aux = aux.getNext();
            }
            // Se edita
            aux.setValue(valor);
        }
    }
    
    /**
     * Actualiza el valor del nodo en la posicion indicada
     * @param posicion en la cual se encuentra el nodo a actualizar.
     * @param valor nuevo valor para el nodo.
     */
    public void editByPosition(int posicion , T valor){
        // Verifica si la posición este en el rango
        if(posicion>=0 && posicion<size){
            //Si es el primero
            if(posicion == 0){
                inicio.setValue(valor);
            }
            else{
                DoubleNode aux = inicio;
                // Recorre la lista hasta llegar a la posicion indicada
                for (int i = 0; i < posicion; i++) {
                    aux = aux.getNext();
                }
                // Actuliza el valor
                aux.setValue(valor);
            }
        }
    }
    
    /**
     * Elimina el nodo con el valor indicado
     * @param refValue valor del nodo que se desea eliminar.
     */
    public void removeByValue(T refValue){
        if (Search(refValue)) {
            // Si es el primero
            if (inicio.getValue() == refValue) {
                // Se desenlanza
                inicio = inicio.getNext();
                inicio.setPrevious(ultimo);
                ultimo.setNext(inicio);
            } else{
                DoubleNode<T> aux = inicio;
                // Recorre hasta llegar al anterior del nodo con refValue
                while(aux.getNext().getValue() != refValue){
                    aux = aux.getNext();
                }
                if (aux.getNext() == ultimo) {
                    aux.setNext(inicio);
                    inicio.setPrevious(aux);
                    ultimo = aux;
                }
                else {
                    DoubleNode siguiente = aux.getNext();
                    aux.setNext(siguiente.getNext());  
                    siguiente.getNext().setPrevious(aux);
                }  
            }
            // Disminuye el contador de tamaño.
            size--;
        }
    }
    
    /**
     * Elimina un nodo que se encuentre en la posicion indicada
     * @param posicion en la cual se encuentra el nodo a eliminar.
     */
    public void removerPorPosicion(int posicion){
        // Verifica si la posición esta en el rango.
        if(posicion>=0 && posicion<size){
            //Si es el primero
            if(posicion == 0){
                inicio = inicio.getNext();
                ultimo.setNext(inicio);
            }
            else{
                DoubleNode<T> aux = inicio;
                // Recorre la lista hasta lleger al nodo anterior al eliminar.
                for (int i = 0; i < posicion-1; i++) {
                    aux = aux.getNext();
                }
                if (aux.getNext() == ultimo) {
                    aux.setNext(inicio);
                    inicio.setPrevious(aux);
                    ultimo = aux;;
                }
                else {
                    DoubleNode siguiente = aux.getNext();
                    aux.setNext(siguiente.getNext());  
                    siguiente.getNext().setPrevious(aux);
                }
            }
            // Disminuye el contador de tamaño.
            size--;
        }
    }
    
}
