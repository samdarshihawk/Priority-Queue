package MDouble;

import java.util.Comparator;



public class MyPQUnSortedList<K,V> extends AbstractPriorityQueue<K,V> {
    private Dlinkedlist<Entry<K,V>> list = new Dlinkedlist<>();

    public MyPQUnSortedList(){
        super();
    }

    public MyPQUnSortedList(Comparator<K> z){
        super(z);
    }

    private Marker<Entry<K,V>> findMinKey(){
        Marker<Entry<K,V>> lead = list.first();
        for(Marker<Entry<K,V>> a : list.positions()){
            if(compare(a.getElement(), lead.getElement())< 0){
                lead = a;
            }
        }
        return lead;
    }

    public Entry<K,V> insert(K key, V value){
        checkKey(key);
        Entry<K,V> newest = new PQEntry<>(key, value);
        list.addLast(newest);
        return newest;
    }

    public Entry<K,V> min(){
        if(list.isEmpty()){
            return null;
        }
        return findMinKey().getElement();
    }

    public Entry<K,V> removeMin(){
        if(list.isEmpty()){
            return null;
        }
        return(list.remove(findMinKey()));
    }

    public int size(){
        return list.len();
    }

}
