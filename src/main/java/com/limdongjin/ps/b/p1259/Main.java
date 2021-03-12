package com.limdongjin.ps.b.p1259;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while((s = br.readLine()) != null){
            if(s.compareTo("0") == 0) break;

            boolean isPalindrome = true;
            for(int i = 0; i < s.length() / 2; i++){
                if(s.charAt(i) != s.charAt(s.length() - i - 1)){
                    isPalindrome = false;
                    break;
                }
            }
            System.out.println((isPalindrome) ? "yes" : "no");
        }

    }
}
