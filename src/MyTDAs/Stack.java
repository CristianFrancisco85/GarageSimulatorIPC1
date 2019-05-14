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
public class Stack<T> {
    private SimpleNode<T> inicio;
    private int size;
    
    /**
     * Constructor 1.
     */
    public void Stack(){
        inicio = null;
        size= 0;
    }
    
    /**
     * Consulta si la pila esta vacia.
     * @return true si el primer nodo (inicio), no apunta a otro nodo.
     */
    public boolean esVacia(){
        return inicio == null;
    }
    
    /**
     * Consulta cuantos elementos (nodos) tiene la pila.
     * @return numero que es el numero de elementos
     */
    public int getSize(){
        return size;
    }
    
    /**
     * Agrega un nuevo nodo a la pila.
     * @param valor a agregar.
     */
    public void apilar(T valor){
        // Define un nuevo nodo.
        SimpleNode<T> nuevo = new SimpleNode<T>();
        // Agrega al valor al nodo.
        nuevo.setValue(valor);
        // Consulta si la pila esta vacia.
        if (esVacia()) {
            // Inicializa la pila con el nuevo valor.
            inicio = nuevo;
        }
        else{
            nuevo.setNext(inicio);
            inicio = nuevo;
        }
        // Incrementa el contador del tamaño.
        size++;
    } 
    
    /**
     * Elimina el elemento que se encuentra en el tope de la pila.
     */
    public void retirar(){
        if (!esVacia()) {
            // Asigna como primer nodo al siguiente de la pila.
            inicio = inicio.getNext();
            size--;
        }
    }
    
    /**
     * Consulta el valor del nodo que se encuentra en el tope de la pila
     * @return valor del nodo.
     * @throws Exception 
     */
    public T Tope() throws Exception{
        if(!esVacia()){
            return inicio.getValue();
        } else {
            throw new Exception("La pila esta vacia.");
        }
    }
    
    /**
     * Busca un elemento en la pila.
     * @param referencia valor del nodo a buscar.
     * @return true si el valor de referencia existe en la pila.
     */
    public boolean buscar(T referencia){
        // Crea una copia de la pila.
        SimpleNode<T> aux = inicio;
        boolean existe = false;
        // Recorre la pila hasta llegar encontrar el nodo o llegar al final.
        while(existe != true && aux != null){
            if (referencia == aux.getValue()) {
                existe = true;
            }
            else{
                aux = aux.getNext();
            }
        }
        return existe;
    }
    
    /**
     * Elimina un nodo de la pila ubicado por su valor.
     * @param referencia valor de referencia para ubicar el nodo.
     */  
    public void remover(T referencia){
        // Consulta si el valor existe en la pila.
        if (buscar(referencia)) {
            // Crea una pila auxiliar para guardar los valores que se vayan desapilando.
            SimpleNode<T> pilaAux = null;
            // Recorre la pila hasta llegar al nodo que tenga el valor.
            while(referencia != inicio.getValue()){
                // Crea un nodo temporal para agregarlos a la pila auxiliar.
                SimpleNode<T> temp = new SimpleNode<T>();
                temp.setValue(inicio.getValue());

                if(pilaAux == null){
                    pilaAux = temp;
                }
                else{
                    temp.setNext(pilaAux);
                    pilaAux = temp;
                }
                // Elimina el nodo del tope de la pila hasta llegar al nodo a eliminar.
                retirar();
            }
            // Elimina el nodo que coincide.
            retirar();
            // Regresa los valores de la pila auxiliar a la pila original
            while(pilaAux != null){
                apilar(pilaAux.getValue());
                pilaAux = pilaAux.getNext();
            }
            pilaAux = null;
        }
    }    
    
    /**
     * Actualiza el valor de un nodo en la pila.
     * @param referencia valor del nodo para ubicar el que se desea actualizar.
     * @param valor por el cual se desea remplazar el valor del nodo.
     */
    public void editar(T referencia, T valor){
        // Consulta si el nodo existe en la pila
        if (buscar(referencia)) {
            SimpleNode<T> pilaAux = null;
            // Recorre la pila hasta llegar al nodo que tenga el valor.
            while(referencia != inicio.getValue()){
                SimpleNode<T> temp = new SimpleNode<T>();
                temp.setValue(inicio.getValue());
               
                if(pilaAux == null){
                    // Inicializa la pila auxiliar.
                    pilaAux = temp;
                }
                else{
                    temp.setNext(pilaAux);
                    pilaAux = temp;
                }
                // Elimina el nodo del tope de la pila hasta llegar al nodo a eliminar
                retirar();
            }
            // Actualiza el valor del nodo.
            inicio.setValue(valor);
            // Regresa los valores de la pila auxiliar a la pila original
            while(pilaAux != null){
                apilar(pilaAux.getValue());
                pilaAux = pilaAux.getNext();
            }
            pilaAux = null;
        }
    }
    
    /**
     * Elimina la pila
     */
    public void eliminar(){
        // Elimina el valor y la referencia a los demas nodos.
        inicio = null;
        // Reinicia el contador a 0.
        size = 0;
    }
    
    /**
     * Despliega en pantalla los elementos de la pìla.
     */
    public void listar(){
        // Crea una copia de la pila.
        SimpleNode<T> aux = inicio;
        // Recorre la pila hasta el ultimo nodo.
        while(aux != null){
            System.out.println("|\t" + aux.getValue() + "\t|");
            System.out.println("-----------------");
            aux = aux.getNext();
        }
    }

}
