package com.limdongjin.ps.boj.silver.p1978;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        int ret = 0;
        for (int i = 0; i < n; i++) {
            if(isPrime(arr[i])) ret++;
        }

        bw.write(ret+"\n");

        bw.flush();
        bw.close();

        br.close();
    }

    private static boolean isPrime(int num) {
        if(num == 1) return false;
        if(num == 2 || num == 3) return true;

        for (int i = 2; i < num; i++) {
            if(num % i == 0) return false;
        }

        return true;
    }
}
