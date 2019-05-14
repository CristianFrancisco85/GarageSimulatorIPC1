package MyTDAs;

/**
 *
 * @author Cristian Meoño
 */
public class DoubleLinkedList<T> {
    
    // Encabezado
    private DoubleNode<T> inicio;
    // Tamaño
    private int size;
    
    /**
     * Constructor #1
     */
    public void Lista(){
        inicio = null;
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
        // Crea una copia de la lista.
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
        }
        // Se inserta en el ultimo espacio de la lista
        else{
            DoubleNode<T> aux = inicio;
            // Recorre la lista hasta llegar al ultimo nodo.
            while(aux.getNext() != null){
                aux = aux.getNext();
            }
            // Agrega el nuevo nodo al final.
            nuevo.setPrevious(aux);
            aux.setNext(nuevo);
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
        } 
        // Se inserta en el primer espacio de la lista
        else{
            // Se agrega y se establece como el encabezado
            inicio.setPrevious(nuevo);
            nuevo.setNext(inicio);
            inicio = nuevo;
        }
        // Incrementa el contador del tamaño de la lista.
        size++;
    }
    
    /**
     * Inserta un nuevo nodo despues de otro del nodo con el valor indicado
     * @param refValue valor del nodo anterios al nuevo nodo a insertar.
     * @param valor del nodo a insertar.
     */
    public void addByValue(T refValue, T valor){
        // Se crea nodo y se asigna valor
        DoubleNode<T> nuevo = new DoubleNode();
        nuevo.setValue(valor);
        if (!isEmpty()) {
            if (Search(refValue)) {
                DoubleNode<T> aux = inicio;
                // Se busca el nodo de referencia
                while (aux.getValue() != refValue) {
                    aux = aux.getNext();
                }
                DoubleNode siguiente = aux.getNext();
                // Se enlaza despues del nodo de referencia
                aux.setNext(nuevo);
                nuevo.setPrevious(aux);
                // Se enlaza de nuevo toda la lista               
                nuevo.setNext(siguiente);
                siguiente.setPrevious(nuevo);
                // Incrementa el contador de tamaño.
                size++;
            }
        }
    }
    
    /**
     * Inserta un nuevo nodo en una posición determinada.
     * @param posicion en la cual se va a insertar el nuevo nodo.
     * @param valor valor del nuevo nodo de la lista.
     */
    public void addByPosition(int posicion, T valor){
        // Verifica si la posición esta en el rango
        if(posicion>=0 && posicion<=size){
            DoubleNode<T> nuevo = new DoubleNode();
            nuevo.setValue(valor);
            // Si es al inicio
            if(posicion == 0){
                inicio.setPrevious(nuevo);
                nuevo.setNext(inicio);
                inicio = nuevo;
            }
            else{
                // Si es al final
                if(posicion == size){
                    DoubleNode aux = inicio;
                    while(aux.getNext() != null){
                        aux = aux.getNext();
                    }
                    // Se inserta al final
                    aux.setNext(nuevo);
                    nuevo.setPrevious(aux);
                }
                else{
                    DoubleNode<T> aux = inicio;
                    // Se encuentra el nodo anterior a la posicion donde se insertara
                    for (int i = 0; i < (posicion-1); i++) {
                        aux = aux.getNext();
                    }
                    DoubleNode siguiente = aux.getNext();
                    // Inserta el nodo.
                    aux.setNext(nuevo);
                    nuevo.setPrevious(aux);
                    // Se enlaza la toda la lista
                    nuevo.setNext(siguiente);
                    siguiente.setPrevious(nuevo);
                }
            }
            // Incrementa el contador de tamaño.
            size++;
        }
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
     * Edita el valor de un nodo segun la el valor indicado
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
                // Se desenlanza el primer nodo
                inicio = inicio.getNext();
                inicio.setPrevious(null);
            } else{
                DoubleNode<T> aux = inicio;
                // Recorre hasta llegar al anterior nodo del nodo con refValue
                while(aux.getNext().getValue() != refValue){
                    aux = aux.getNext();
                }
                // Se guarda el nodo depues del que se eliminara
                DoubleNode siguiente = aux.getNext().getNext();
                // Enlaza el nodo anterior al de eliminar con el siguiente despues de el
                aux.setNext(siguiente);  
                siguiente.setPrevious(aux);
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
            }
            else{
                DoubleNode<T> aux = inicio;
                // Recorre la lista hasta lleger al nodo anterior al nodo a eliminar.
                for (int i = 0; i < posicion-1; i++) {
                    aux = aux.getNext();
                }
                // Guarda el nodo siguiente al nodo a eliminar.
                DoubleNode siguiente = aux.getNext().getNext();
                // Elimina el nodo apuntando al nodo siguiente.
                siguiente.setPrevious(aux);
                aux.setNext(siguiente);
            }
            // Disminuye el contador de tamaño.
            size--;
        }
    }
    
    
}
