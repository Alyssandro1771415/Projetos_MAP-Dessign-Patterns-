package com.example;

import com.example.interfaces.CustomList;
import java.util.*;

public class MapToListAdapter<K, V> implements CustomList<V>, Iterable<V> { 
    private Map<K, V> map;

    public MapToListAdapter() {
        this.map = new LinkedHashMap<>(); // Use LinkedHashMap para manter a ordem
    }

    @Override
    public boolean add(V value) {
        if (value == null) {
            throw new IllegalArgumentException("Value cannot be null");
        }
        int key = map.size();
        map.put((K) Integer.valueOf(key), value);
        return true;
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public boolean contains(Object value) {
        if (value == null) {
            throw new IllegalArgumentException("Value cannot be null");
        }
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
        if (index < 0 || index >= map.size()) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
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
        if (value == null) {
            throw new IllegalArgumentException("Value cannot be null");
        }
        if (!map.containsValue(value)) {
            throw new NoSuchElementException("The value does not exist in the map");
        }
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
