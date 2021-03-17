package com.limdongjin.ps.boj.silver.p1436;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int ret = 0;
        int i = 1;
        while(ret != n){
            if(isJNum(i)) ret++;
            i++;
        }
        System.out.println(i - 1);
    }

    private static boolean isJNum(int n) {
        while(n != 0){
            if(n %1000 == 666) return true;
            n /= 10;
        }
        return false;
    }
}
