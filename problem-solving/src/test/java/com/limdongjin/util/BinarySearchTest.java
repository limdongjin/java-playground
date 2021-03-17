package com.limdongjin.util;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {
    @Test
    public void test1(){
        List<Integer> integers = new ArrayList<>();
        integers.add(15);
        integers.add(27);
        integers.add(37);
        integers.add(46);
        integers.add(57);

        assertEquals(1, BinarySearch.apply(integers, 27));
        assertEquals(3, BinarySearch.apply(integers, 46));
    }
}