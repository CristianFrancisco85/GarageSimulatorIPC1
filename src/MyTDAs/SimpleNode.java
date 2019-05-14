package MyTDAs;

/**
 * 1
 */

/**
 *
 * @author Cristian Meoño
 */

public class SimpleNode<T> {
    
    private T value;
    private SimpleNode<T> next;
 
    public SimpleNode(){
        next=null;
     }
 
    /**
     * Constructor con dato
     * @param p 
     */
    public SimpleNode(T p){
        next=null;
        value = p;
    }
 
    /**
     * Constructor con dato y siguiente
     * @param t Dato a insertar
     * @param siguiente Nodo siguiente
     */
    public SimpleNode(T t, SimpleNode<T> siguiente){
        this.next=siguiente;
        value = t;
    }
     
    public T getValue() {
        return value;
    }
 
    public void setValue(T dato) {
        this.value = dato;
    }
 
    public SimpleNode<T> getNext() {
        return next;
    }
 
    public void setNext(SimpleNode<T> siguiente) {
        this.next = siguiente;
    }
     
}
