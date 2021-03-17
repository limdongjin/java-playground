package com.limdongjin.ps.jmbook;

import com.limdongjin.ps.jmbook.BoardCover;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardCoverTest {
    BoardCover boardCover;
    @BeforeEach
    void setUp() {
        boardCover = new BoardCover();
    }

    @Test
    public void testSample(){
        assertEquals(0, BoardCover.apply(3, 7, new int[][]{ {1,0,0,0,0,0,1},
                                                                            {1,0,0,0,0,0,1},
                                                                            {1,1, 0,0,0,1,1}}));
        assertEquals(1, BoardCover.apply(3, 7, new int[][]{ {1,0,0,0,0,0,1},
                                                                            {1,0,0,0,0,0,1},
                                                                            {1,1, 0,0,1,1,1}}));

    }
}