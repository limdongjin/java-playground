package com.limdongjin.LinkedList;

public class LinkedList<T>{
    private Node _head;
    private Node _tail;
    private int _size; 
    
    public LinkedList(T data){
        Node targetNode = new Node(data);
        _head = targetNode;
        _tail = targetNode;
        _size = 1;
    }
    public LinkedList(){
        _head = null;
        _tail = null;
        _size = 0;
    }
    public void append(T data){
        Node targetNode = new Node(data);
        if(_size == 0){
            _head = _tail = targetNode;
            _size = 1;
            return;
        }
        _tail._next = targetNode;
        _tail = targetNode;
        _size++;
    }
    
    public T get(int idx){
        assert idx < _size;
        int cur = 0;
        Node curNode = _head;
        
        while(cur < idx){
            curNode = curNode._next;
            cur++;
        }
        return curNode._data;
    }
    public int size(){
        return _size;
    }
    class Node{
        T _data;
        Node _next;
        
        public Node(T data){
            _data = data;
            _next = null;
        }
        
        public Node(T data, Node next){
            _data = data;
            _next = next;
        }
    }
    
}