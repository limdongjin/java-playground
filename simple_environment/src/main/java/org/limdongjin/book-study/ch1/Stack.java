package org.limdongjin.book_study.ch1;

public interface Stack<Item> extends Iterable<Item>{
    void push(Item item);
    Item pop();
    Item peek();
    boolean isEmpty();
    int size();
}