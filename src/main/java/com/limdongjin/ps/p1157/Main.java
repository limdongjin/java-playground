package com.limdongjin.ps.p1157;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int[] alpha = new int[26];
        for(int i = 0; i < s.length(); i++){

            if((int)s.charAt(i)  <= (int)'Z')
                alpha[(int)s.charAt(i) - (int)'A'] += 1;
            else
                alpha[(int)s.charAt(i) - (int)'a'] += 1;
        }

        int frequentIdx = 0;
        boolean isTwoMore = false;
        for(int i = 0; i < 26;i++) {
            if (alpha[i] > alpha[frequentIdx]) {
                frequentIdx = i;
                isTwoMore = false;
            }else if(i != frequentIdx && alpha[frequentIdx] == alpha[i]) {
                isTwoMore = true;
            }
        }
        if(isTwoMore)
            System.out.println("?");
        else
            System.out.println((char)(frequentIdx + (int)'A'));
    }
}