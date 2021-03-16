package com.limdongjin.ps.boj.bronze.p11050;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final int LIMIT = 11;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] cache = new int[LIMIT][LIMIT];
        for(int i = 0; i<LIMIT;i++)
            cache[i][i] = 1;
        for(int i = 0; i<LIMIT;i++)
            cache[i][0] = 1;

        System.out.println(binomial(n, k, cache));
    }

    private static int binomial(int n, int k, int[][] cache) {
        if(cache[n][k] != 0) return cache[n][k];

        cache[n][k] = binomial(n -1,k, cache) + binomial(n-1, k-1, cache);

        return cache[n][k];
    }
}
