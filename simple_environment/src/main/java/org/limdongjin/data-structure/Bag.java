package org.limdongjin.data_structure;

public interface Bag<Item> extends Iterable<Item> {
    void add(Item item);
    boolean isEmpty();
    int size();
}