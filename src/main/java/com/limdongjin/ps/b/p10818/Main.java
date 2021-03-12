package com.limdongjin.ps.b.p10818;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int maxV = -1000001;
        int minV = 1000001;
        int a;
        for(int i = 0; i < n; i++){
            a = Integer.parseInt(st.nextToken());
            maxV = Math.max(maxV, a);
            minV = Math.min(minV, a);
        }
        System.out.println(minV + " " + maxV);
    }
}