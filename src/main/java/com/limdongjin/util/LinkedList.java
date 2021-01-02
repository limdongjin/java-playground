package com.limdongjin.util;
import java.util.Iterator;
import java.util.NoSuchElementException;

class LinkedList<E> implements Iterable<E> {
    private Node head;
    private Node tail;
    private int n;
    public LinkedList(){
        this.n = 0;
    }
    public int size(){
        return n;
    }
    private Node getNode(final int idx){
        if(idx < 0 || idx >= n) throw new IndexOutOfBoundsException();
        Node current = head;
        
        for(int i = 0; i < idx; i++)
            current = current.next;
        return current;
    }
    // TODO: delete duplication of getNode and find. 
    // using functional interface?
    public int find(final E item){
        Node current = head;
        
        int idx = -1;
        for(int i = 0; i < size(); i++){
            if(current.item == item){
                idx = i; break;
            }
            current = current.next;
        }

        return idx;
    }
    public E get(final int idx){
        Node node = getNode(idx);

        return node.item;
    }
    public void addFirst(final E item){
        if(isEmpty()){
            head = new Node(item, null);
            tail = head;
            n++;
            return;
        }
        
        Node node = new Node(item, head);
        head = node;
        n++;
    }
    
    public E removeFirst(){
        if(isEmpty()) throw new NoSuchElementException();
        if(size() == 1){
            Node node = head;
            head = tail = null;
            n = 0;
            return node.item;
        }
        final E old = head.item;
        head = head.next;
        n--;

        return old;
    }
    public E remove(){
        if(isEmpty()) throw new NoSuchElementException();
        if(size() == 1){
            Node node = head;
            head = tail = null;
            n = 0;
            return node.item;
        }
        Node beforeTail = head;
        for(int i = 0; i < size() - 2; i++){
            beforeTail = beforeTail.next;
        }
        final E oldTailItem = tail.item;
        beforeTail.next = null;
        tail = beforeTail;
        n--;
        return oldTailItem;
    }
    public void add(final E item){
        if(isEmpty()){
            head = new Node(item, null);
            tail = head;
            n++;
            return;
        }
        Node node = new Node(item, null);
        tail.next = node;
        tail = node;
        n++;
    }
    public boolean isEmpty(){
        return n ==0;
    }
    public Iterator<E> iterator(){
        return new LinkedIterator(head);
    }
    private class Node {
        E item;
        Node next;
        public Node(E item, Node next){
            this.item = item;
            this.next = next;
        }
    }
    private class LinkedIterator implements Iterator<E>{
        Node current;
        public LinkedIterator(Node node){
            this.current = node;
        }
        public boolean hasNext(){
            return current != null;
        }
        public E next(){
            E res = current.item;
            current = current.next;
            return res;
        }
    }
}