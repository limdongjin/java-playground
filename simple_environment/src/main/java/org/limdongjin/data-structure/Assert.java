package org.limdongjin.data_structure;

import java.util.Comparator;

public class Assert {
    
    public static void assertEqual(Object expect, Object actual){
        if(!expect.equals(actual))
            throw new AssertionError("expect : " + expect + ", but actual : " +actual);
    }
}