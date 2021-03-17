package com.limdongjin.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class TestMinHeap {
    MinHeap<Integer> pq;

    @BeforeEach
    public void initialize() {
        pq = new MinHeap<>(Integer::compare);
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