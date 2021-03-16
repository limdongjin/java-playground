package com.limdongjin.ps.boj.silver.p1003;

import java.io.*;

public class Main {
    public static void solve(int n, int[] cache0, int[] cache1){
        if(n == 0 || n == 1) return;
        if(cache0[n] != 0) return;

        if(cache0[n-1] == 0)
            solve(n-1, cache0, cache1);

        if(cache1[n-2] == 0)
            solve(n-2, cache0, cache1);

        cache0[n] = cache0[n-1] + cache0[n-2];
        cache1[n] = cache1[n-1] + cache1[n-2];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());

        int[] cache0 = new int[50];
        int[] cache1 = new int[50];
        cache0[0] = 1;
        cache1[0] = 0;
        cache0[1] = 0;
        cache1[1] = 1;

        for (int i = 0; i < tc; i++) {
            int n = Integer.parseInt(br.readLine());

            solve(n, cache0, cache1);
            bw.write(cache0[n] + " " +cache1[n] + "\n");
        }


        bw.flush();
        bw.close();
        br.close();
    }
}
