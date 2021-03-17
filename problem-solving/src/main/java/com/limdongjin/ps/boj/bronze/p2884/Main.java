package com.limdongjin.ps.boj.bronze.p2884;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int h = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int realTime = h*60 + m - 45;
        if(realTime < 0)
            realTime = 60*24 + realTime;

        System.out.println(realTime / 60 + " " + (realTime - (realTime/60)*60));
    }
}
