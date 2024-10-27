package com.example.interfaces;
import java.util.Iterator;


public interface CustomList<E> {
    boolean add(E element);
    void clear();
    boolean contains(Object o);
    boolean equals(Object o);
    E get(int index);
    boolean isEmpty();
    Iterator<E> iterator();
    boolean remove(Object o);
    int size();
    Object[] toArray();
}
