package org.limdongjin.data_structure;

import org.limdongjin.data_structure.MinHeapEnhanced;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.ArrayList;
import java.util.stream.Collectors;
import org.limdongjin.data_structure.Assert;

class MinHeapTest {
    MinHeapEnhanced<Integer> pq;
    List<Integer> testInts;

    public MinHeapTest(){
        pq = new MinHeapEnhanced<>(Integer::compare);
    }

    public MinHeapTest(List<Integer> list){
        pq = new MinHeapEnhanced<>(list, Integer::compare);
        testInts = list;
    }

    public void testHeapSort(){
        testInts.sort(Integer::compare);
        
        testInts.forEach((t) -> {
            Assert.assertEqual(t, pq.poll());
        });
    }
    public void testHeapSort2(){
        List<Integer> list;
        list = new Random().ints(1, 10000)
                            .parallel()
                            .limit(100)
                            .boxed()
                            .collect(Collectors.toList());
        list.forEach(pq::add);
        list.sort(Integer::compare);
        list.forEach((e)->{
            Assert.assertEqual(e, pq.poll());
        });
    }
    public void testHeapSortRandomList(){
        
        List<Integer> list;
        
        list = new Random().ints(1, 10000000)
                            .parallel()
                            .limit(10000000)
                            .boxed()
                            .collect(Collectors.toList());
        System.out.println("random list make complete");

        long before = System.currentTimeMillis();
        // list.forEach(pq::add);
        int size = list.size();
        list.forEach(pq::add);
        // System.out.println((System.currentTimeMillis() - before) / 1000.0);
        // list.sort(Integer::compare);

        // list.forEach((t) -> {
        //     Assert.assertEqual(t, pq.poll());
        // });
        List<Integer> res = new ArrayList<>();
        while(!pq.isEmpty()){
            res.add(pq.poll());
        }
        long after = System.currentTimeMillis();
        System.out.println((after - before)/1000.0);

        // long before2 = System.currentTimeMillis();
        // // list.sort(Integer::compare);
        // list.sort(Integer::compare);
        // long after2 = System.currentTimeMillis();
        // System.out.println((after2 - before2)/1000.0);

        long before3 = System.currentTimeMillis(); 
        PriorityQueue<Integer> pqReal = new PriorityQueue<>();
        list.forEach(pqReal::add);

        List<Integer> res3 = new ArrayList<>();
        while(!pqReal.isEmpty()){
            res3.add(pqReal.poll());
        }
        long after3 = System.currentTimeMillis();
        System.out.println((after3 - before3)/1000.0);
    }
    
    public static void main(String[] args){
        new MinHeapTest(Arrays.asList(1, 2, 54, 2, 3, 8, 0, 1, 9, 19, 8)).testHeapSort();
        new MinHeapTest().testHeapSort2();
        new MinHeapTest().testHeapSortRandomList();

        System.out.println("Test Success");
    }
}