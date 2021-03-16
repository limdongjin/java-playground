package com.limdongjin.ps.jmbook;

public class BoardCover {
    final static int[][][] coverType = {
            {{0,0},{0,1}, {1,1}},
            {{0,0},{1,0},{1,1}},
            {{0,0},{0,1},{1,0}},
            {{0,0},{1,0},{1,-1}}
    };

    static public int apply(int H, int W, int[][] board) {
        int whiteNum = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++)
                if (board[i][j] == 0)
                    whiteNum++;
        }
        if (whiteNum % 3 != 0) return 0;
        int x = -1, y = -1;

        for (int i = 0; i < H; i++){
            for (int j = 0; j < W; j++) {
                if (board[i][j] != 0) {
                    x = j;
                    y = i;
                    break;
                }
            }
            if(y != -1) break;
        }

        // base case: all filled
        if(y != -1) return 1;

        int ret = 0;
        for(int typeOfBlock = 0; typeOfBlock < 4; typeOfBlock++){
            if(setBoard(y, x, board,typeOfBlock, 1))
                ret += apply(H, W,board);
            setBoard(y,x,board,typeOfBlock, -1);
        }
        return ret;
    }

    private static boolean setBoard(int y, int x, int[][] board, int typeOfBlock, int val) {
        boolean ok = true;
        for(int i = 0; i < 3; i++){
            final int nx = x + coverType[typeOfBlock][i][1];
            final int ny = y + coverType[typeOfBlock][i][0];

            if(nx < 0 || ny < 0 || nx >= board[0].length || ny >= board.length){
                ok = false;
            } else{
                board[ny][nx] += val;
                if(board[ny][nx] > 1)
                    ok = false;
            }
        }
        return ok;
    }
}
