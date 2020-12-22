package org.limdongjin.data_structure;

public interface Queue<Item> extends Iterable<Item> {
    void enqueue(Item item);
    Item dequeue();
    boolean isEmpty();
    int size();
}