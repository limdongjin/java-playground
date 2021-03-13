package com.limdongjin.ps.s.p1018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // y
        int m = Integer.parseInt(st.nextToken()); // x
        char[][] board = new char[n][m];

        for(int y = 0; y < n; y++){
            String s = br.readLine();
            for(int x = 0; x < m; x++) {
                board[y][x] = s.charAt(x);
            }
        }
        int ret = 99999;
        for(int startY = 0; startY <= n - 8; startY++){
            for(int startX = 0; startX <= m - 8; startX++){
                int count = 0;
                for(int y = startY; y < startY + 8; y++){
                    for(int x = startX; x < startX + 8; x++){
                        if((y % 2) == (x % 2)){
                            if(board[y][x] == 'B') count++;
                        }else{
                            if(board[y][x] == 'W') count++;
                        }
                    }
                }
                ret = Math.min(count, ret);
                ret = Math.min(64-count, ret);
            }
        }

        System.out.println(ret);
    }
}
