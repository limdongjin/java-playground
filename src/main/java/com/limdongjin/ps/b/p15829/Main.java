package com.limdongjin.ps.b.p15829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());
        String s = br.readLine();
        final long modNum = 1234567891;
        long sum = 0;
        long powRet = 1L;
        for(int i = 0; i < s.length(); i++){
            long num = s.charAt(i) - 'a' + 1;
            sum += (powRet*num)%modNum;

            powRet = (powRet * 31) % modNum;
        }

        System.out.println(sum % modNum);
    }
}
