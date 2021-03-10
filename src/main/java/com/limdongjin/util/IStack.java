package com.limdongjin.util;

import java.util.NoSuchElementException;

public interface IStack<E> extends Iterable<E>{
    void push(E item);
    E pop() throws NoSuchElementException;
    E peek() throws NoSuchElementException;
    boolean isEmpty();
    int size();
}