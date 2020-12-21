package org.limdongjin.book_study.ch1;
import java.util.Iterator;
import java.lang.Object;
class ResizingArrayStack<Item> implements Stack<Item> {
    private Item[] array;
    private int n;

    public ResizingArrayStack(){
        this.array = (Item[]) new Object[1];
        this.n = 0;
    }

    public void push(Item item){
        if(array.length <= n) resize(2 * array.length);

        array[n++] = item;
    }
    private void resize(int max){
        Item[] tmp = (Item[]) new Object[max];
        for(int i = 0; i < n; i++)
            tmp[i] = array[i];
        array = tmp;
    }
    public Item pop(){
        Item item = array[--n];
        array[n] = null;
        if(n > 0 && n <= array.length / 4) resize(array.length / 2);
        
        return item;
    }
        
    public Item peek(){
        return array[n - 1];
    }

    public int size(){
        return n;
    }

    public boolean isEmpty(){
        return n == 0;
    }
    public Iterator<Item> iterator(){
        return new ReverseArrayIterator(n);
    }
    private class ReverseArrayIterator implements Iterator<Item> {
        private int i;
        public ReverseArrayIterator(int i){
            this.i = i;
        }
        public boolean hasNext(){
            return i > 0;
        }
        public Item next(){
            return array[--i];
        }
    }
    
}