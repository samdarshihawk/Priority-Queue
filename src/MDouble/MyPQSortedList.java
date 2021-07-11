package MDouble;

import java.util.Comparator;

public class MyPQSortedList<K,V> extends AbstractPriorityQueue<K,V> {
    private Dlinkedlist<Entry<K,V>> list = new Dlinkedlist<>();

    public MyPQSortedList(){
        super();
    }

    public MyPQSortedList(Comparator<K> z){
        super(z);
    }

    public Entry<K,V> insert(K key, V value){
        checkKey(key);
        Entry<K,V> newest = new PQEntry<>(key, value);
        Marker<Entry<K,V>> current = list.last();
        while(current != null && compare(newest, current.getElement()) < 0){
            current = list.before(current);
        }
        if(current == null){
            list.addFirst(newest);
        }else{
            list.addAfter(current, newest);
        }
        return newest;
        
    }

    public Entry<K,V> min(){
        if(list.isEmpty())
            return null;
        return list.first().getElement();
    }

    public Entry<K,V> removeMin(){
        if(list.isEmpty())
            return null;
        return list.remove(list.first());
    }

    public int size(){
        return list.len();
    }
    
}
