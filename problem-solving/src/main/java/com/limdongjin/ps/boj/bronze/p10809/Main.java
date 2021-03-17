package com.limdongjin.ps.boj.bronze.p10809;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int[] alpha = new int[26];
        Arrays.fill(alpha, -1);
        int c;

        for(int i = 0; i < s.length(); i++){
            c = s.charAt(i) - 'a';
            if(alpha[c] == -1) alpha[c] = i;
        }

        System.out.println(Arrays.stream(alpha)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" ")));
    }
}
