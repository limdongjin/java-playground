package com.limdongjin.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TestStack {

    IStack<Integer> stack;

    @BeforeEach
    public void initialize(){
        stack = new ResizingArrayStack<>();
    }
    @Test
    public void testEmptyStackCase(){
        assertEquals(true, stack.isEmpty());
        assertThrows(NoSuchElementException.class, ()->{
            stack.peek();
        });
        assertThrows(NoSuchElementException.class, ()->{
            stack.pop();
        });
    }
    
    @Test
    public void testPush(){
        assertEquals(true, stack.isEmpty());
        stack.push(1);
        assertEquals(Integer.valueOf(1), stack.peek());
        assertEquals(1, stack.size());
        assertEquals(false, stack.isEmpty());
    }

    @Test
    public void testOrderOfPoll(){
        stack.push(1);
        stack.push(12);
        stack.push(13);
        
        assertEquals(Integer.valueOf(13), stack.peek());
        assertEquals(3, stack.size());
        
        assertEquals(Integer.valueOf(13), stack.pop());
        assertEquals(2, stack.size());
        
        assertEquals(Integer.valueOf(12), stack.peek());
        assertEquals(2, stack.size());

        stack.push(10);
        assertEquals(3, stack.size());

        assertEquals(Integer.valueOf(10), stack.peek());
        assertEquals(Integer.valueOf(10), stack.pop());
        assertEquals(2, stack.size());

        assertEquals(Integer.valueOf(12), stack.pop());
        assertEquals(1, stack.size());
        assertEquals(Integer.valueOf(1), stack.pop());
        assertEquals(0, stack.size());

        assertEquals(true, stack.isEmpty());

        testEmptyStackCase();
    }

    @Test
    public void testOrderOfIterator(){
        final int FIRSTPUSH = 0;
        final int LASTPUSH = 9;
        for(int i = FIRSTPUSH; i <= LASTPUSH; i++ ){
            stack.push(i);
        }
        int i = LASTPUSH;
        for(var v : stack){
            assertEquals(i--, v.intValue());
        }
    }
}