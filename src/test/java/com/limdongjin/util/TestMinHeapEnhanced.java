package com.limdongjin.util;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;

public class TestMinHeapEnhanced {
    MinHeapEnhanced<Integer> pq;

    @Before 
    public void initialize() {
        pq = new MinHeapEnhanced<>(Integer::compare);
    }

    @Test
    public void heapsort(){
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
        // assertEquals(1, 2);
    }
}