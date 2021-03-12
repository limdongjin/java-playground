package com.limdongjin.ps.b.p2562;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a;
        int maxValue = -1;
        int maxIdx = -1;
        for(int i = 1; i <= 9; i++){
            a = Integer.parseInt(br.readLine());
            if(maxValue < a){
                maxIdx = i;
                maxValue = a;
            }
        }
        System.out.println(maxValue);
        System.out.println(maxIdx);
    }
}
