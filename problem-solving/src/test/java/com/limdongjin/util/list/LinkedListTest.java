package com.limdongjin.util.list;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {
    LinkedList<Integer> linkedList;

    @BeforeEach
    void setUp() {
        linkedList = new LinkedList<>();
    }

    @Test
    void appendOne() {
        linkedList.append(10);

        assertEquals(10, linkedList.get(0));
        assertEquals(1, linkedList.size());
    }

    @Test
    void emptyCase() {
        assertEquals(0, linkedList.size());
        assertThrows(IllegalStateException.class, ()->linkedList.get(0));
    }

    @Test
    void size() { }
}