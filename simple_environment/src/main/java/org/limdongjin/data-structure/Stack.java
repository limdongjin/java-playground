package org.limdongjin.data_structure;

public interface Stack<Item> extends Iterable<Item>{
    void push(Item item);
    Item pop();
    Item peek();
    boolean isEmpty();
    int size();
}