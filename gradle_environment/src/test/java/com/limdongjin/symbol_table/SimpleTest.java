package com.limdongjin.symbol_table;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

import com.limdongjin.symbol_table.SymbolTable;
import com.limdongjin.symbol_table.BinarySearchST;
import com.limdongjin.symbol_table.KeyNotFoundException;

public class SimpleTest {
    SymbolTable<String, Integer> st;
    
     @Before public void initialize() {
        st = new BinarySearchST<String, Integer>(5);
        
    }
    
    @Test
    public void get_one_expect_1(){                  
        // st.put("one", 1);
        st.put("one", 1);    
        assertEquals(1, (int)st.get("one"));
        assertEquals(1, 2);
    }
    
    @Test
    public void size_expect_1(){
        st.put("one", 1);
        assertEquals(1, st.size());
    }
    
    @Test
    public void empty(){
        assertEquals(0, st.size());
    }
    @Test 
    public void del(){
        // assertArrayEquals()
        st.put("one", 1);
        st.delete("one");
        assertEquals(0, st.size());
               
    }
     
    @Test 
    public void duplictated_put(){
        st.put("two", 2);
        st.put("two", 3);
        assertEquals(1, st.size());
        assertEquals(3, (int)st.get("two"));
    }
    
    
    @Test
    public void get_delted_element(){
        st.put("one", 1);
        st.put("thr", 33);
        st.delete("one");
        assertEquals(null, st.get("one"));
        assertEquals(33, (int)st.get("thr"));
    }
    @Test(expected = KeyNotFoundException.class)
    public void delete_not_existed_element(){
        st.delete("two");
    }
    
    @Test
    public void get_not_Exist_key_test(){
        st.put("a", 1);
        assertEquals(null, st.get("sa")); 
    }
    
}
