package com.limdongjin.ps.boj.bronze.p2292;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int tmp = 1;
        int i;
        for(i = 0; i < n; i++){
            tmp = tmp + 6*i;
            if(tmp >= n) break;
        }

        System.out.println(i + 1);
    }
}
