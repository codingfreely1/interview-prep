package datastructures;

import java.util.*;

/**
 * Created by yael on 04/01/17.
 */
public class MyHashMap<K, V> {
    private static final int ARRAY_SIZE = 10;
    private List<Entry<K,V>>[] array;

    public MyHashMap(){
        array = new List[ARRAY_SIZE];
    }

    private int hashFunction(K key){
        return (key.hashCode() % ARRAY_SIZE);
    }

    public void put(K key, V val){
        Entry<K,V> entry = getEntry(key);
        if(entry != null){
            entry.setValue(val);
        } else {
            int inx = hashFunction(key);
            if(array[inx] == null ){
                array[inx] = new ArrayList<>();
            }
            array[inx].add(new Entry<>(key, val));
        }
    }

    private Entry<K,V> getEntry(K key){
        int inx = hashFunction(key);
        if(array[inx] != null){
            for(Entry<K,V> e: array[inx]){
                if(e.getKey().equals(key)){
                    return e;
                }
            }
        }
        return null;
    }

    public V get(K key){
        Entry<K,V> entry = getEntry(key);
        if(entry != null){
            return entry.getValue();
        }
        return null;
    }

    public boolean containsKey(K key) {
        return get(key) != null;
    }

    public boolean containsValue(V val) {
        for(int i = 0; i< array.length; i++ ){
            if(array[i] != null) {
                List<Entry<K,V>> list = array[i];
                for (Entry<K,V> e: list){
                    if(e.getValue().equals(val)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public V remove(K key){
        int inx = hashFunction(key);
        if(array[inx] != null ){
            Entry<K,V> entryToRemove = null;
            for(Entry<K,V> e: array[inx]){
                if(e.getKey().equals(key)){
                    entryToRemove = e;
                }
            }
            if(entryToRemove != null) {
                array[inx].remove(entryToRemove);
            }
        }
        return null;
    }

    public int size(){
        int size = 0;
        for(int i = 0; i<array.length; i++ ){
            if(array[i] != null){
                size += array[i].size();
            }
        }
        return size;
    }

    public void putAll(Map<? extends K, ? extends V> m){
        Set<? extends K> keys = m.keySet();
        for (K k : keys){
            put(k, m.get(k));
        }
    }

}