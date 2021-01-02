package com.limdongjin.util;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class StackImpl<E> implements Stack<E> {
    Node top;
    int n;
    private class Node {
        E item;
        Node next;
        public Node(E item, Node next){
            this.item = item;
            this.next = next;
        }
    }
    public StackImpl(){
        this.n = 0;
        this.top = null;
    }
    public void push(E item){
        Node old = top;
        Node newItem = new Node(item, old);
        this.top = newItem;
        this.n++;
    }
    public E peek(){
        if(isEmpty()) throw new NoSuchElementException();

        return this.top.item;
    }
    public E pop(){
        if(isEmpty()) throw new NoSuchElementException();

        Node node = this.top;
        this.top = this.top.next;
        this.n--;
        return node.item;
    }
    public boolean isEmpty(){
        return this.top == null;
    }
    public int size(){
        return this.n;
    }
    public Iterator<E> iterator(){
        return new LinkedIterator(top);
    }
    private class LinkedIterator implements Iterator<E>{
        Node current;

        public LinkedIterator(Node item){
            current = item;
        }

        @Override
        public boolean hasNext(){
            return current != null;
        }
        
        @Override
        public E next(){
            if(!hasNext()) throw new NoSuchElementException();
            E item = current.item;
            current = current.next;
            return item;
        }
    }
}