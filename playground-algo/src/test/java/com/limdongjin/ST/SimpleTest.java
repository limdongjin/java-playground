package com.limdongjin.ST;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.limdongjin.ST.SymbolTable;
import com.limdongjin.ST.BinarySearchST;
import com.limdongjin.ST.KeyNotFoundException;

public class SimpleTest {
    SymbolTable<String, Integer> st;
    
     @BeforeEach
    public void initialize() {
        st = new BinarySearchST<String, Integer>(5);
        
    }
    
    @Test
    public void get_one_expect_1(){                  
        // st.put("one", 1);
        st.put("one", 1);    
        assertEquals(1, (int)st.get("one"));
        assertEquals(1, 1);
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
    @Test
    public void delete_not_existed_element() throws KeyNotFoundException{
        Exception exception = assertThrows(KeyNotFoundException.class, () -> {
            st.delete("two");
        });
        assertNotNull(exception);
    }
    
    @Test
    public void get_not_Exist_key_test(){
        st.put("a", 1);
    }
    
}
