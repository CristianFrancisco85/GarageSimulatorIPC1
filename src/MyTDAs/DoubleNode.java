package MyTDAs;

/**
 *
 * @author Cristian Meoño
 */
public class DoubleNode<T> {
    
    private T value;
    private DoubleNode<T> next;
    private DoubleNode<T> previous;
 
    /**
     * Contructor Puro
     */
    public DoubleNode(){
        next=null;
        previous=null;
     }
 
    /**
     * Constructor con dato
     * @param p 
     */
    public DoubleNode(T p){
        next=null;
        previous=null;
        value = p;
    }
 
    /**
     * Constructor con dato,  nodo siguiente y anterior.
     * @param t Dato a insertar.
     * @param siguiente Nodo siguiente.
     * @param anterior Nodo anterior.
     */
    public DoubleNode(T t, DoubleNode<T> siguiente,DoubleNode<T> anterior){
        this.next=siguiente;
        this.previous=anterior;
        value = t;
    }
    
     
    public T getValue() {
        return value;
    }
 
    public void setValue(T dato) {
        this.value = dato;
    }
 
    public DoubleNode<T> getNext() {
        return next;
    }
 
    public void setNext(DoubleNode<T> siguiente) {
        this.next = siguiente;
    }
    
    public DoubleNode<T> getPrevious() {
        return previous;
    }
 
    public void setPrevious(DoubleNode<T> anterior) {
        this.previous = anterior;
    }
     
}
