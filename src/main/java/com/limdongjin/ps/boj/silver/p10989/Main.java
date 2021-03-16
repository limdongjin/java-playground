package com.limdongjin.ps.boj.silver.p10989;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        int[] countMap = new int[10001];
        for (int i = 0; i < n; i++) {
            countMap[Integer.parseInt(br.readLine())]++;
        }

        for (int i = 1; i < 10001; i++) {
            bw.write((i+"\n").repeat(countMap[i]));
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
