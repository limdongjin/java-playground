package com.limdongjin.ps.boj.bronze.p11720;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String s = br.readLine();
        System.out.println(Arrays.stream(s.split("")).mapToInt(Integer::parseInt).sum());
    }
}