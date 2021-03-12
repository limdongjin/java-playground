package com.limdongjin.ps.b.p2908;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        a = reverseDigits(a);
        b = reverseDigits(b);

        System.out.println(Math.max(a, b));
    }
    public static int reverseDigits(int x){
        int ret = 0;

        while(x != 0){
            ret = ret*10 + x%10;
            x = x / 10;
        }

        return ret;
    }
}
