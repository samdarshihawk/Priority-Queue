package MDouble;

public interface Marker<E> {
    E getElement() throws IllegalStateException; //Returns the element stored at this position.
    
}
