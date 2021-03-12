package com.limdongjin.ps.b.p2577;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int ret = Integer.parseInt(br.readLine())*Integer.parseInt(br.readLine())*Integer.parseInt(br.readLine());
        int[] count = new int[10];
        while(ret != 0){
            count[ret % 10]++;
            ret /= 10;
        }
        for(int i = 0; i < 10; i++)
            System.out.println(count[i]);

    }
}
