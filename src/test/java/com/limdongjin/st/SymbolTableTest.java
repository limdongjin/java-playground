package com.limdongjin.st;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SymbolTableTest {
    SymbolTable<String, Integer> st;
    
     @BeforeEach public void initialize() {
        st = new BinarySearchST<>(5);
        st.put("one", 1);
    }
    
    @Test
    public void get_one_expect_1(){
        assertEquals((int)st.get("one"), 1);
    }
    
    @Test
    public void size_expect_1(){
        assertEquals(st.size(), 1);
    }
}
