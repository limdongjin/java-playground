package com.limdongjin.ps.b.p2475;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int sum = 0;
        int a;
        for(int i = 0; i < 5; i++){
            a = Integer.parseInt(st.nextToken());
            sum += a*a;
        }
        System.out.println(sum % 10);
    }
}
