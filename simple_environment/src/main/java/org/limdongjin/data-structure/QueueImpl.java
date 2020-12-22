package org.limdongjin.data_structure;

import java.util.Iterator;

class QueueImpl<Item> implements Queue<Item>{
    Node<Item> head;
    Node<Item> tail;
    int n;

    public QueueImpl(){
        head = null;
        tail = null;
        n = 0;    
    }
    public void enqueue(Item item){
        Node<Item> node = new Node(item, null);
        if(isEmpty()){
            head = tail = node;
            n = 1;
            return;
        }
        tail.next = node;
        tail = node;
        n++;
    }
    public Item dequeue(){
        Item oldHeadItem = head.item;
        
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
    public Iterator<Item> iterator(){
        return new QueueIterator(head);
    }
    private class Node<Item> {
        Item item;
        Node<Item> next;
        public Node(Item item, Node<Item> next){
            this.item = item;
            this.next = next;
        }
    }
    private class QueueIterator<Item> implements Iterator<Item> {
        Node<Item> current;
        public QueueIterator(Node<Item> node){
            this.current = node;
        }
        public boolean hasNext(){
            return current != null;
        }  
        public Item next(){
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}
