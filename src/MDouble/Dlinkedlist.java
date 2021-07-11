package MDouble;

import java.util.Iterator;
import java.util.NoSuchElementException;





public class Dlinkedlist<E> {

    private static class Node<E> implements Marker<E> {
        private E element;
        private Node<E> prev;
        private Node<E> next;
        
        public Node(E e, Node<E> prev, Node<E> next){
            this.element = e;
            this. prev = prev;
            this.next = next;

        }


        public E getElement() throws IllegalStateException {

            if(next == null)
                throw new IllegalStateException("Postion is no longer valid");
            return element;
        }

        public Node<E> getPrev(){
            return prev;
        }

        public Node<E> getNext(){
            return next;
        }

        public void setElement(E e){
            this.element = e;
        }

        public void setPrev(Node<E> p){
            this.prev = p;
        } 
        
        public void setNext(Node<E> n){
            this.next = n;
        }

    }

    private Node<E> header;
    private Node<E> trailer;
    private int size;

    public Dlinkedlist(){
        header = new Node<>(null, null, null);
        trailer = new Node<>(null, header, null);
        header.setNext(trailer);

    }

    private Node<E> validator(Marker<E> m){
        if(!(m instanceof Node)){
            throw new IllegalArgumentException("Invalid Parameter. Its not the instance of the node");
        }
        Node<E> node = (Node<E>)(m);
        if(node.getNext()==null){
            throw new IllegalArgumentException("Argument is no longer in the Linked list");
        }

        return node;

    } 
    private Marker<E> marker(Node<E> node){
        if(node==header||node==trailer){
            return null;
        }

        return node;
    }

    
    public int len() {
        
        return size;
    }

    
    public boolean isEmpty() {
        
        return (size==0);
    }

    
    public Marker<E> first() {
        if (size == 0){
            return(null);
        }
        return marker(header.getNext());
    }

    
    public Marker<E> last() {
        if(size==0){
            return null;
        }
        return marker(trailer.getPrev());
    }

    
    public Marker<E> before(Marker<E> p) throws IllegalArgumentException {
        Node<E> n = validator(p);
        return marker(n.getPrev());
    }

    
    public Marker<E> after(Marker<E> p) throws IllegalArgumentException {
        Node<E> n = validator(p);
        return marker(n.getNext());
    }

    private Marker<E> addBetween(E e, Node<E> pred, Node<E> succ){
        Node<E> n= new Node<>(e, pred, succ);
        pred.setNext(n);
        succ.setPrev(n);
        size++;
        return marker(n);
    }
    public Marker<E> addFirst(E e) {
        return addBetween(e, header, header.getNext());
    }

    
    public Marker<E> addLast(E e) {
        return addBetween(e, trailer.getPrev(), trailer);
    }

    
    public Marker<E> addBefore(Marker<E> p, E e) throws IllegalArgumentException {
        Node<E> n = validator(p);
        return addBetween(e, n.getPrev(), n );
    }

    
    public Marker<E> addAfter(Marker<E> p, E e) throws IllegalArgumentException {
        Node<E> n = validator(p);
        return addBetween(e, n, n.getNext());
    }

    
    public E set(Marker<E> p, E e) throws IllegalArgumentException {
        Node<E> n  = validator(p);
        E value = n.getElement();
        n.setElement(e);
        return value;
    }

    
    public E remove(Marker<E> p) throws IllegalArgumentException {
        Node<E> n = validator(p);
        Node<E> prev = n.getPrev();
        Node<E> succ = n.getNext(); 
        prev.setNext(succ);
        succ.setPrev(prev);
        E value = n.getElement();
        size--;
        n.setElement(null);
        n.setPrev(null);
        n.setNext(null);
        return value;
    }



    private class LinkedListIterator implements Iterator<Marker<E>>{

        private Marker<E> lead = first();
        private Marker<E> recent = null;

        @Override
        public boolean hasNext() {

            return (lead != null);
        }

        @Override
        public Marker<E> next() throws NoSuchElementException {
            if(lead == null) throw new NoSuchElementException("Element doesn't exist");
            recent = lead;
            lead = after(lead);
            return(recent);
        }

        public void remove()throws IllegalStateException{
            if(recent == null) throw new IllegalStateException("Empty Element");
            Dlinkedlist.this.remove(recent);
        }

    }

    private class LinkedListIterable implements Iterable<Marker<E>>{

        @Override
        public Iterator<Marker<E>> iterator() {
            return new LinkedListIterator();
        }

    }

    
    public Iterable<Marker<E>> positions() {
        
        return new LinkedListIterable();
    }
    
   
}
