package com.limdongjin.util;

import java.util.Iterator;

class QueueImpl<E> implements Queue<E>{
    Node head;
    Node tail;
    int n;

    public QueueImpl(){
        head = null;
        tail = null;
        n = 0;    
    }
    public void enqueue(E item){
        Node node = new Node(item, null);
        if(isEmpty()){
            head = tail = node;
            n = 1;
            return;
        }
        tail.next = node;
        tail = node;
        n++;
    }
    public E dequeue(){
        E oldHeadItem = head.item;
        
        if(size() == 1){
            head = tail = null;
            n = 0;
            return oldHeadItem;
        }
        head = head.next;
        n--;
        
        return oldHeadItem;
    }
    public int size(){
        return n;
    }
    public boolean isEmpty(){
        return n == 0;
    }
    public Iterator<E> iterator(){
        return new QueueIterator(head);
    }
    private class Node {
        E item;
        Node next;
        public Node(E item, Node next){
            this.item = item;
            this.next = next;
        }
    }
    private class QueueIterator implements Iterator<E> {
        Node current;
        public QueueIterator(Node node){
            this.current = node;
        }
        public boolean hasNext(){
            return current != null;
        }  
        public E next(){
            E item = current.item;
            current = current.next;
            return item;
        }
    }
}
