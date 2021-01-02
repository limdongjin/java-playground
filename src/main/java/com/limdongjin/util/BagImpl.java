package com.limdongjin.util;

import java.util.Iterator;
import java.util.NoSuchElementException;
class BagImpl<Item> implements Bag<Item> {
    Node<Item> head;
    int n;

    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
        Node(Item item, Node<Item> next){
            this.item = item;
            this.next = next;
        }
    }

    public BagImpl(){
        head = null;
        n = 0;
    }

    public void add(Item item){
        Node<Item> old = head;
        head = new Node<>(item, old);
        increaseN();
    }

    public boolean isEmpty(){
        return head == null;
    }

    public int size(){
        return this.n;
    }

    private void increaseN(){
        this.n = this.n + 1;
    }

    @Override
    public Iterator<Item> iterator() {
        return new LinkedIterator(head);
    }
    private class LinkedIterator implements Iterator<Item> {
        Node<Item> current;
        
        public LinkedIterator(Node<Item> node){
            current = node;
        }

        @Override
        public boolean hasNext() {
            
            return current != null;
        }
        
        @Override
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next; 
            return item;
        }
        
    }
}