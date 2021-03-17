package com.limdongjin.ps.boj.bronze.p4153;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a, b, c;
        String s;
        while((s = br.readLine()) != null){
            StringTokenizer st = new StringTokenizer(s);
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            if(a == 0 && b == 0 && c == 0) break;
            System.out.println( ( (a*a + b*b == c*c) || (a*a + c*c == b*b) || (b*b+c*c == a*a)) ? "right" : "wrong");
        }
    }
}
