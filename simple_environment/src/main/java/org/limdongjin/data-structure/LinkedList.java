package org.limdongjin.data_structure;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Function;
import java.util.function.BiFunction;
import java.lang.IndexOutOfBoundsException;

class LinkedList<Item> implements Iterable<Item> {
    private Node<Item> head;
    private Node<Item> tail;
    private int n;
    public LinkedList(){
        this.n = 0;
    }
    public int size(){
        return n;
    }
    private Node<Item> getNode(final int idx){
        if(idx < 0 || idx >= n) throw new IndexOutOfBoundsException();
        Node<Item> current = head;
        
        for(int i = 0; i < idx; i++)
            current = current.next;
        return current;
    }
    // TODO: delete duplication of getNode and find. 
    // using functional interface?
    public int find(final Item item){
        Node<Item> current = head;
        
        int idx = -1;
        for(int i = 0; i < size(); i++){
            if(current.item == item){
                idx = i; break;
            }
            current = current.next;
        }

        return idx;
    }
    public Item get(final int idx){
        Node<Item> node = getNode(idx);

        return node.item;
    }
    public void addFirst(final Item item){
        if(isEmpty()){
            head = new Node(item, null);
            tail = head;
            n++;
            return;
        }
        
        Node<Item> node = new Node(item, head);
        head = node;
        n++;
    }
    
    public Item removeFirst(){
        if(isEmpty()) throw new NoSuchElementException();
        if(size() == 1){
            Node<Item> node = head;
            head = tail = null;
            n = 0;
            return node.item;
        }
        final Item old = head.item;
        head = head.next;
        n--;

        return old;
    }
    public Item remove(){
        if(isEmpty()) throw new NoSuchElementException();
        if(size() == 1){
            Node<Item> node = head;
            head = tail = null;
            n = 0;
            return node.item;
        }
        Node<Item> beforeTail = head;
        for(int i = 0; i < size() - 2; i++){
            beforeTail = beforeTail.next;
        }
        final Node<Item> oldTailItem = tail.item;
        beforeTail.next = null;
        tail = beforeTail;
        n--;
        return oldTailItem;
    }
    public void add(final Item item){
        if(isEmpty()){
            head = new Node(item, null);
            tail = head;
            n++;
            return;
        }
        Node<Item> node = new Node(item, null);
        tail.next = node;
        tail = node;
        n++;
    }
    public boolean isEmpty(){
        return n ==0;
    }
    public Iterator<Item> iterator(){
        return new LinkedIterator(head);
    }
    private class Node<Item> {
        Item item;
        Node<Item> next;
        public Node(Item item, Node<Item> next){
            this.item = item;
            this.next = next;
        }
    }
    private class LinkedIterator<Item> implements Iterator<Item>{
        Node<Item> current;
        public LinkedIterator(Node<Item> node){
            this.current = node;
        }
        public boolean hasNext(){
            return current != null;
        }
        public Item next(){
            Item res = current.item;
            current = current.next;
            return res;
        }
    }
}