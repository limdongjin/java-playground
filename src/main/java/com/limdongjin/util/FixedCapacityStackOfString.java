package com.limdongjin.util;

class FixedCapacityStackOfString {
    private String[] items;
    private int numOfElement;
    
    public FixedCapacityStackOfString(int capacity) {
        this.numOfElement = 0;
        items = new String[capacity + 1];
    }

    void push(String item){
        items[++numOfElement] = item;
    }
    String pop(){
        return items[numOfElement--];
    }
    int size(){
        return numOfElement;
    }
    String peek(){
        return items[numOfElement];
    }
    boolean isEmpty(){
        return numOfElement == 0;
    }
}