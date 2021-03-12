package com.limdongjin.ps.b.p3052;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] isExist = new boolean[42];

        for(int i = 0; i<10;i++)
            isExist[Integer.parseInt(br.readLine()) % 42] = true;

        int count = 0;
        for(int i = 0; i<42;i++) {
            if (isExist[i]) count++;
        }
        System.out.println(count);
    }
}
