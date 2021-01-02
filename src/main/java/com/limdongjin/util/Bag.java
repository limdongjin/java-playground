package com.limdongjin.util;

public interface Bag<Item> extends Iterable<Item> {
    void add(Item item);
    boolean isEmpty();
    int size();
}