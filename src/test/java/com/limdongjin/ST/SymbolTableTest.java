package com.limdongjin.ST;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
// import static org.mockito.Mockito.mock;
// import static org.mockito.Mockito.verify;
// import static org.mockito.Mockito.when;
// import static org.mockito.Mockito.doNothing;
//import static org.mockito.doNo
import com.limdongjin.ST.BinarySearchST;
import com.limdongjin.ST.SymbolTable;

public class SymbolTableTest {
    SymbolTable<String, Integer> st;
    
     @Before public void initialize() {
        st = new BinarySearchST<String, Integer>(5);
        st.put("one", 1);
    }
    
    @Test
    public void get_one_expect_1(){                  
        // st.put("one", 1);
        
        assertEquals((int)st.get("one"), 1);
    }
    
    @Test
    public void size_expect_1(){
        assertEquals(st.size(), 1);
    }
    
    @Test
    public void veri(){
        //ymbolTable<String, Integer> st = mock(SymbolTable.class);
        //st.contains("one");
        //when(st.get("two")).thenReturn(2);
        // when(st.get("one")).thenCallRealMethod(1);
        //doNothing().when(st).isEmpty();
        //System.out.println(st.get("two"));
        assertEquals(1, 1);
        //verify(st).get("two");
        //verify(st).isEmpty();
    }
    //@Test
    //public void fail_test(){
    //    assertEquals(1, 2); 
    //}
    
}
