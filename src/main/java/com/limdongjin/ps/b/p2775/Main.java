package com.limdongjin.ps.b.p2775;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int solve(int k, int n, int cache[][]){
        if(n == 0 || cache[k][n] != 0) return cache[k][n];
        cache[k][n] = solve(k, n-1, cache) + solve(k-1, n, cache);

        return cache[k][n];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        int[][] cache = new int[15][15];
        for (int i = 0; i < 15; i++)
            cache[0][i] = i;

        for (int i = 0; i < tc; i++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            System.out.println(solve(k, n, cache));
        }
    }
}
