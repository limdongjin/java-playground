package com.limdongjin.ps.b.p8958;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        while(tc-- > 0){
            String s = br.readLine();
            int sum = 0;
            int prevScore = 0;
            for(int i =0;i<s.length();i++){
                if(s.charAt(i) == 'X'){
                    prevScore = 0;
                    continue;
                }else
                    sum += ++prevScore;
            }
            System.out.println(sum);
        }
    }
}
