package org.limdongjin.data_structure;

class FixedCapacityStackOfString {
    private String[] items;
    private int numOfElement;
    private int capacity;

    public FixedCapacityStackOfString(int capacity){
        this.capacity = capacity;
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