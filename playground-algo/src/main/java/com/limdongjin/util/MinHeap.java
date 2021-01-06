package com.limdongjin.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class MinHeap<E> {
    private List<E> heap;
    private int NumOfElement;
    private Comparator<? super E> comparator;
    
    public MinHeap(){ 
        initMinHeap();
        comparator = null;
    }

    public MinHeap(final Comparator<? super E> comparator) {
        this();
        this.comparator = comparator;
    }

    public MinHeap(final Collection<? extends E> items){
        initMinHeap(items);
        this.comparator = null;
    }
    
    public MinHeap(final Collection<? extends E> items, final Comparator<? super E> comparator){
        initMinHeap(items);
        this.comparator = comparator;
    }

    private void initMinHeap(final Collection<? extends E> items){
        initMinHeap();
        items.forEach((e) -> {
            add(e);
        });
    }
    public boolean isEmpty(){
        return NumOfElement == 0;
    }
    private void initMinHeap(){
        this.heap = new ArrayList<>();
        this.heap.add(null);
        this.NumOfElement = 0;
    }
    /*
     * @pre e != null
     */
    public void add(final E e){
        heap_add(e);

        shiftUp(NumOfElement);
    }
    /*
     * @pre isEmpty() == false
     */
    public E poll(){
        final E res = heap.get(1);
        //final E m = heap_remove(NumOfElement); 
        final E m = heap.get(NumOfElement);
        NumOfElement--;
        
        if(NumOfElement == 0) 
            return res;
        
        heap.set(1, m);
        shiftDown(1);
        return res;
    }
    
    private void shiftDown(final int idx){
        int cur = idx;
        int leftOrRight;
        while((cur << 1) <= NumOfElement){
            leftOrRight = cur << 1;
            if(cur << 1 != NumOfElement)
                leftOrRight = compare(leftOrRight, leftOrRight + 1) < 0 ? leftOrRight : leftOrRight+1;
            
            if(compare(leftOrRight, cur) < 0){
                exch(leftOrRight, cur);
                cur = leftOrRight;
            }else break;
        }
    }

    private void shiftUp(int idx){
        for(int cur = idx; cur != 1 && compare(cur, cur >> 1) <0; cur = cur >> 1){
            exch(cur, cur >> 1);
        }
    }

    private E heap_remove(int idx){
        NumOfElement--;
        // heap.set()
        return this.heap.remove(idx);
    }

    public void printList(){
        heap.stream().skip(1).forEach(e -> System.out.print(e + " "));
        System.out.println();
    }
    public void remove(E e){
        int idx = heap.indexOf(e);
        if(idx == -1){
            throw new RuntimeException("not contains");
        }
        
        exch(idx, NumOfElement);
        heap_remove(NumOfElement);

        if(idx != 1 && compare(idx, idx >> 1 ) < 0){
            shiftUp(idx);
            return;
        }
        
        int leftOrRight = idx << 1;
        if(leftOrRight + 1 <= NumOfElement)
            leftOrRight = compare(leftOrRight, leftOrRight + 1) < 0 ? leftOrRight : leftOrRight + 1;
        
        if(leftOrRight <= NumOfElement && compare(idx, leftOrRight) > 0)
            shiftDown(idx);
    }

    private void heap_add(E e){
        this.heap.add(e);
        NumOfElement++;
    }
    
    @SuppressWarnings("unchecked")
    private int compare(int left, int right){
        E vLeft = heap.get(left);
        E vRight = heap.get(right);
        
        if(comparator == null){  
            return ((Comparable<? super E>)vLeft).compareTo(vRight);
        }
        return this.comparator.compare(vLeft, vRight);
    }

    private void exch(int a, int b){
        E tmp = heap.get(a);
        heap.set(a, heap.get(b));
        heap.set(b, tmp);
    }

    public int size(){
        return NumOfElement;
    }
    public E peek(){
        return this.heap.get(1);
    }
}