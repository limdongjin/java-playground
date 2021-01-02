package com.limdongjin.util;
import java.util.Iterator;
import java.lang.Object;
import com.limdongjin.util.Stack;

public class ResizingArrayStack<E> implements Stack<E> {
    private E[] array;
    private int n;

    @SuppressWarnings("unchecked")
    public ResizingArrayStack(){
        this.array = (E[]) new Object[1];
        
        this.n = 0;
    }

    public void push(E item){
        if(array.length <= n) resize(2 * array.length);

        array[n++] = item;
    }

    @SuppressWarnings("unchecked")
    private void resize(int max){
        E[] tmp = (E[]) new Object[max];
        for(int i = 0; i < n; i++)
            tmp[i] = array[i];
        array = tmp;
    }
    public E pop(){
        E item = array[--n];
        array[n] = null;
        if(n > 0 && n <= array.length / 4) resize(array.length / 2);
        
        return item;
    }
        
    public E peek(){
        return array[n - 1];
    }

    public int size(){
        return n;
    }

    public boolean isEmpty(){
        return n == 0;
    }
    public Iterator<E> iterator(){
        return new ReverseArrayIterator(n);
    }
    private class ReverseArrayIterator implements Iterator<E> {
        private int i;
        public ReverseArrayIterator(int i){
            this.i = i;
        }
        public boolean hasNext(){
            return i > 0;
        }
        public E next(){
            return array[--i];
        }
    }
    
}