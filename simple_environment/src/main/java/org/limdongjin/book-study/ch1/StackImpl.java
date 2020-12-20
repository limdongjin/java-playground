package org.limdongjin.book_study.ch1;

import java.util.Iterator;
import java.util.NoSuchElementException;

class StackImpl<Item> implements Stack<Item> {
    Node<Item> top;
    int n;
    private class Node <Item> {
        Item item;
        Node<Item> next;
        public Node(Item item, Node<Item> next){
            this.item = item;
            this.next = next;
        }
    }
    public StackImpl(){
        this.n = 0;
        this.top = null;
    }
    public void push(Item item){
        Node<Item> old = top;
        Node<Item> newItem = new Node(item, old);
        this.top = newItem;
        this.n++;
    }
    public Item peek(){
        if(isEmpty()) throw new NoSuchElementException();

        return this.top.item;
    }
    public Item pop(){
        if(isEmpty()) throw new NoSuchElementException();

        Node<Item> node = this.top;
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
    public Iterator<Item> iterator(){
        return new LinkedIterator(top);
    }
    private class LinkedIterator implements Iterator<Item>{
        Node<Item> current;

        public LinkedIterator(Node<Item> item){
            current = item;
        }

        @Override
        public boolean hasNext(){
            return current != null;
        }
        
        @Override
        public Item next(){
            if(!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}