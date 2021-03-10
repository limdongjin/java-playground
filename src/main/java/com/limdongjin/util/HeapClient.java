package com.limdongjin.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HeapClient {

    public void run() {
        MinHeap<Integer> pq = new MinHeap<>(Integer::compare);
        pq.add(15);

        pq.printList();

        pq.add(1);
        pq.add(5);

        pq.printList();

        pq.add(3);
        pq.add(2);
        pq.add(6);
        pq.add(7);

        System.out.println("before. remove2");
        pq.printList();
        pq.remove(2);
        System.out.println("after. remove2");
        pq.printList();

        pq.poll();
        pq.printList();
        pq.add(0);
        pq.remove(3);
        pq.printList();
        pq.poll();

        pq.printList();
        pq.poll();
        pq.printList();
        pq.poll();
        pq.printList();

        System.out.println("//////////////////");

        // pq = new MinHeap<>(Arrays.asList(18, 9, 10, 100, 1, 2, 3, 11, 4, 5, 12, 6, 7,
        // 0, 15, 8, 9, 16), Integer::compare);
        // pq.printList();
    }

    public void sort_test() {
        List<Integer> list = Arrays.asList(18, 9, 20, 10, 100, 1, 2, 3, 11, 4, 5, 12, 6, 7, 0, 15, 8, 9, 16);
        for (var a : list)
            System.out.print(a + " ");
        System.out.println();

        MinHeap<Integer> pq = new MinHeap<>(list, Integer::compare);
        List<Integer> sortedList = new ArrayList<>();
        while (!pq.isEmpty()) {
            sortedList.add(pq.poll());
        }

        for (var a : sortedList)
            System.out.print(a + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        HeapClient app = new HeapClient();
        // app.run();
        app.run();
    }
}