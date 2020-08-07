package com.limdongjin.symbol_table;

import org.junit.Test;
import static org.junit.Assert.*;
import com.limdongjin.symbol_table.SymbolTable;
import com.limdongjin.symbol_table.BinarySearchST;

public class SymbolTableTest {
     @Test
    public void simple_test_put_get() {
        assertEquals(1, 1);            
        SymbolTable<String, Integer> st;
        
        st = new BinarySearchST<String, Integer>(5);
        
        st.put("one", 1);
        
        assertEquals((int)st.get("one"), 1);
        
    }
    
    
}
