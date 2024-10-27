package com.example;
import com.example.interfaces.CustomList;
import java.util.*;

public class MapToListAdapter<K, V> implements CustomList<V>, Iterable<V> { // Adicione Iterable<V>
    private Map<K, V> map;

    public MapToListAdapter() {
        this.map = new LinkedHashMap<>(); // Use LinkedHashMap para manter a ordem
    }

    @Override
    public boolean add(V value) {
        int key = map.size();
        map.put((K) Integer.valueOf(key), value);
        return true;
    }

    @Override //O caso de teste será verificando se o map está vazia.
    public void clear() {
        map.clear();
    }

    @Override
    public boolean contains(Object value) {
        return map.containsValue(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true; 
        if (o == null || getClass() != o.getClass()) return false; 
    
        MapToListAdapter<?, ?> that = (MapToListAdapter<?, ?>) o;
        return map.equals(that.map);
    }
    

    @Override
    public V get(int index) {
        return map.get((K) Integer.valueOf(index));
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public Iterator<V> iterator() {
        return map.values().iterator();
    }

    @Override
    public boolean remove(Object value) {
        return map.values().remove(value);
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public Object[] toArray() {
        return map.values().toArray();
    }
}
