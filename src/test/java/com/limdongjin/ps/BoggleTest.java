package com.limdongjin.ps;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoggleTest {
    @Test
    public void testSamples(){
        Boggle boggle = new Boggle(new char[][]{
                {'N','N', 'N', 'N','S'},
                {'N','E', 'E', 'E','N'},
                {'N','E', 'Y', 'E', 'N'},
                {'N','E','E','E','N'},
                {'A','B','C','D','E'}
        });

        assertTrue(boggle.hasWord(2, 2, "YES"));
        assertTrue(boggle.hasWord(2, 2, "YECEN"));
        assertTrue(boggle.hasWord(0, 0, "NEEEB"));
        assertTrue(boggle.hasWord(1,2, "EYEEABCDE"));
        assertFalse(boggle.hasWord(0,0,"NNY"));
    }
}