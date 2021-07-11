package MDouble;

import java.util.Comparator;

public class defaultmeasure<E> implements Comparator<E> {
   
        /**
         * Compares two elements.
         *
         * 
         */
        
    public int compare(E a, E b) throws ClassCastException {
        return ((Comparable<E>) a).compareTo(b);
    }
}
