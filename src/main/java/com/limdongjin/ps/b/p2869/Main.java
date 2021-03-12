package com.limdongjin.ps.b.p2869;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long v = Long.parseLong(st.nextToken());

        long ret = 0;

        if( (v-a) % (a-b) != 0 ) ret = ((v-a) / (a-b)) + 1;
        else ret = (v-a) / (a - b);

        ret++;
        System.out.println(ret);
    }
}
