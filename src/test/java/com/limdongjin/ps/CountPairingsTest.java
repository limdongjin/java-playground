package com.limdongjin.ps;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountPairingsTest {
    CountPairings countPairings;
    @BeforeEach
    void setUp() {
        countPairings = new CountPairings(new boolean[][]{{false,true,true,false},{true,false,true,true},{true,true,false,true},{true,true,true,false}}, 4);
    }

    @Test
    public void testSample(){
        assertEquals(3, countPairings.apply(new boolean[10]));
    }
}