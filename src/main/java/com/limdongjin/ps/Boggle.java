package com.limdongjin.ps;

public class Boggle {
    private char[][] board;

    static final int[] dx = {0, 1, 1, 1,0,-1,-1,-1};
    static final int[] dy = {-1, -1, 0, 1,1,1,0,-1};
    public Boggle(char[][] board){
        this.board = board;
    }

    public boolean hasWord(int y, int x, final String word){
        if(!isRange(y, x))
            return false;
        if(word.charAt(0) != board[y][x])
            return false;
        if(word.length() == 1)
            return true;

        for(int direction = 0; direction < 8; direction++){
            int nextY = y + dy[direction], nextX = x + dx[direction];
            if(hasWord(nextY, nextX, word.substring(1))) return true;
        }

        return false;
    }

    private boolean isRange(int y, int x) {
        return y >= 0 && y <= 4 && x >= 0 && x <= 4;
    }
}
