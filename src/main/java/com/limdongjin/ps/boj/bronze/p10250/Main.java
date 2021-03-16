package com.limdongjin.ps.boj.bronze.p10250;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            String yy = Integer.toString((n-1)%h + 1);
            String xx = Integer.toString(1+((n-1)/h));
            if(xx.length() == 1) xx = "0"+xx;

            System.out.println(yy+xx);
        }
    }
}
