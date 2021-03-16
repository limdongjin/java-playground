package com.limdongjin.ps.boj.silver.p18111;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n, m, numOfBlocks;
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        numOfBlocks = Integer.parseInt(st.nextToken());
        int[][] gameMap = new int[n][m];
        int maxHeight = -1;
        int minHeight = Integer.MAX_VALUE;
        for (int y = 0; y < n; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < m; x++) {
                gameMap[y][x] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight, gameMap[y][x]);
                minHeight = Math.min(minHeight, gameMap[y][x]);
            }
        }
        int ansTime = Integer.MAX_VALUE;
        int ansHeight = -1;
        for (int height = minHeight; height <= maxHeight; height++) {
            int time = flatten(gameMap, height, numOfBlocks);
            if(time <= ansTime){
                ansTime = time;
                ansHeight = height;
            }
        }
        bw.write(ansTime + " " + ansHeight);
        bw.flush();
        br.close();
        bw.close();
    }

    private static int flatten(int[][] gameMap, int height, int numOfBlocks) {
        int time = 0;

        // cutting
        // 땅을 자른는 작업을 먼저함으로써 블록이 부족해지는 상황을 막
        for (int y = 0; y < gameMap.length; y++) {
            for (int x = 0; x < gameMap[0].length; x++) {
                if(gameMap[y][x] > height){
                    time += 2*(gameMap[y][x] - height);
                    numOfBlocks += gameMap[y][x] - height;
                }
            }
        }

        // fill
        for (int y = 0; y < gameMap.length; y++) {
            for (int x = 0; x < gameMap[0].length; x++) {
                if(gameMap[y][x] < height){
                    if(numOfBlocks < height - gameMap[y][x]) return Integer.MAX_VALUE;
                    time += (height - gameMap[y][x]);
                    numOfBlocks -= height - gameMap[y][x];
                }
            }
        }

        return time;
    }
}
