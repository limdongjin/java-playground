package org.limdongjin.data_structure;
import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;
import java.util.Collection;

class MinHeap<E> {
    private final List<E> heap;
    private final Comparator<? super E> comparator;

    /*
     * @pre initialCapacity >= 0
     * 
     * @pre comparator != null
     */
    public MinHeap(final int initialCapacity, final Comparator<? super E> comparator) {
        this.heap = new ArrayList<E>(initialCapacity);
        heap.add(null);
        this.comparator = comparator;
    }

    public MinHeap(final Collection<? extends E> elements, final Comparator<? super E> comparator) {
        this.heap = new ArrayList<>(elements.size() + 1);
        this.heap.add(null);
        this.comparator = comparator;
        buildMinHeap(elements);
    }

    private void buildMinHeap(final Collection<? extends E> elements) {
        for (final var e : elements)
            this.add(e);
    }

    /*
     * @pre element != null;
     */
    public void add(final E element) {
        heap.add(element);
        this.shiftUp(this.size());
    }

    private E get(int idx){
        return this.heap.get(idx);
    }

    public void printList() {
        System.out.println("==print start==");
        
        for(int i = 1; i <= this.size(); i*=2){
            for(int k = i; k <= this.size() && k < i*2; k++){
                System.out.print(this.heap.get(k) + " ");
            }
            System.out.println();
        }

        System.out.println("==print end==");
    }

    // retrieve amd remove
    public E poll() {
        if (this.size() == 0)
            return null;
        if (this.size() == 1) 
            return heap.remove(1);
        
        final E polledElem = get(1);
        heap.set(1, heap.remove(this.size()));

        this.shiftDown(1);
        return polledElem;
    }

    public boolean remove(final E element) {
        if (!contains(element))
            return false;

        final int idx = heap.indexOf(element);
        
        heap.set(idx, heap.remove(this.size()));
       
        int chIdx;

        if (idx * 2 + 1 >= this.size())
            chIdx = this.size();
        else
            chIdx = comparator.compare(get(idx * 2), get(idx * 2 + 1)) < 0 ? idx * 2 : idx * 2 + 1;

        if (comparator.compare(get(idx), get(chIdx)) > 0) 
            this.shiftDown(idx);
        
        if (idx != 1 && comparator.compare(get(idx), get(idx / 2)) < 0) 
            this.shiftUp(idx);
        

        return true;
    }

    /*
     * @pre element != null
     */
    public boolean contains(final E element) {
        return heap.contains(element);
    }

    private void shiftUp(final int idx) {
        int curIdx = idx;

        while (curIdx != 1) {
            if (this.exchIfBiggerRight(curIdx, curIdx / 2)) {
                curIdx = curIdx / 2;
            } else
                break;
        }
    }
    
    private void shiftDown(final int idx) {
        final int lastIdx = this.size();
        
        int curIdx = idx;
        while (curIdx * 2 <= lastIdx) {
            int leftOrRight = (curIdx * 2);
            if (leftOrRight < lastIdx && comparator.compare(get(leftOrRight), get(leftOrRight + 1)) > 0) {
                leftOrRight++;
            }

            if (exchIfBiggerRight(leftOrRight, curIdx)) {
                curIdx = leftOrRight;
            } else
                break;
        }

        if (curIdx * 2 == lastIdx)
            exchIfBiggerRight(lastIdx, curIdx);
    }

    /*
     * @pre f > 0 && s > 0
     */
    private boolean exchIfBiggerRight(final int f, final int s) {
        if (comparator.compare(get(f), get(s)) < 0) {
            this.exch(f, s);
            return true;
        }
        return false;
    }

    private void exch(final int f, final int s) {
        final E oldF = get(f);
        heap.set(f, get(s));
        heap.set(s, oldF);
    }

    // retrieve but not remove
    public E peek(){
        return (this.size() == 0) ? null :  get(1);
    }
    public boolean isEmpty(){
        return size() == 0;
    }
    public int size(){
        // beacause 0th index is just trash value.
        // so, NumOfElement is heap.size - 1
        return heap.size() - 1;
    }
    
}