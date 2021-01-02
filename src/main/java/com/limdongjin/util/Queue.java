package com.limdongjin.util;

public interface Queue<Item> extends Iterable<Item> {
    void enqueue(Item item);
    Item dequeue();
    boolean isEmpty();
    int size();
}