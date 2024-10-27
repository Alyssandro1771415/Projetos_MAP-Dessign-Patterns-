package com.example;
import java.util.*;
import com.example.interfaces.CustomMap;

public class ListToMapAdapter<K, V> implements CustomMap<Integer, V> {
    private List<V> list;

    public ListToMapAdapter(List<V> list) {
        this.list = list;
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public boolean containsKey(Object key) {
        if (!(key instanceof Integer)) return false;
        int index = (Integer) key;
        return index >= 0 && index < list.size();
    }

    @Override
    public boolean containsValue(Object value) {
        return list.contains(value);
    }

    @Override
    public boolean equals(Object o) {
        return list.equals(o);
    }

    @Override
    public V get(Object key) {
        if (key instanceof Integer) {
            int index = (Integer) key;
            if (index >= 0 && index < list.size()) return list.get(index);
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public V put(Integer key, V value) {
        while (key >= list.size()) list.add(null);
        return list.set(key, value);
    }

    @Override
    public V remove(Object key) {
        if (key instanceof Integer) {
            int index = (Integer) key;
            if (index >= 0 && index < list.size()) return list.remove(index);
        }
        return null;
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public Collection<V> values() {
        return list;
    }

    // Outros métodos da interface Map podem ser implementados com exceções ou como não suportados.
}
