package MDouble;

import java.util.Comparator;

public abstract class AbstractPriorityQueue<K,V>  {
    protected static class PQEntry<K,V> implements Entry<K,V>{
        private K k;
        private V v;

        public PQEntry(K key, V value){
            k = key;
            v = value;
        }

        @Override
        public K getKey() {
            return k;
        }

        @Override
        public V getValue() {
            return v;
        }

        public void setKey(K key){
            k = key;
        }

        public void setValue(V value){
            v = value;
        }

    }

   

    private Comparator<K> measure;
    
    // Creates an empty priority queue using the given comparator to order keys.
    protected AbstractPriorityQueue(Comparator<K> z) {
        measure = z;
    }

    /** Creates an empty priority queue based on the natural ordering of its keys. */
    protected AbstractPriorityQueue() { 
        this(new defaultmeasure<K>()); 
    }
   
     // Determine if the key is valid
    public boolean checkKey(K key) throws IllegalArgumentException{
        try {
            return (measure.compare(key, key) == 0); // see if key can be compared to itself
        } catch (ClassCastException e) {
            throw new IllegalArgumentException("Incompatible key");
        }
    }
         /** Creates an empty priority queue based on the natural ordering of its keys. */
    
   
    protected int compare(Entry<K,V> a,Entry<K,V> b){
        return measure.compare(a.getKey(), b.getKey());

    }
    public boolean isEmpty() {
        return (size() == 0);
    }

    abstract public int size();

   

}