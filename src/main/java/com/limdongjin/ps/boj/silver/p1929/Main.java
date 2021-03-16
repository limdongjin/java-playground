package com.limdongjin.ps.boj.silver.p1929;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        // 에라토스네스의 체
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int startInclusive = Integer.parseInt(st.nextToken());
        int endInclusive = Integer.parseInt(st.nextToken());

        boolean[] isPrimeNumber = new boolean[endInclusive + 10];
        Arrays.fill(isPrimeNumber, true);
        isPrimeNumber[0] = false;
        isPrimeNumber[1] = false;
        for (int i = 2; i <= endInclusive; i++) {
            if(!isPrimeNumber[i]) continue;
            if(i >= startInclusive) bw.write(i+"\n");
            for (int j = i + i; j <= endInclusive; j += i) {
                isPrimeNumber[j] = false;
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
