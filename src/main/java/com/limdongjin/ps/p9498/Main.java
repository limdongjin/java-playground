package com.limdongjin.ps.p9498;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());
        String ret;
        if(a >= 90) ret = "A";
        else if(a >= 80) ret = "B";
        else if(a >= 70) ret = "C";
        else if(a >= 60) ret = "D";
        else ret = "F";

        System.out.println(ret);

    }
}
