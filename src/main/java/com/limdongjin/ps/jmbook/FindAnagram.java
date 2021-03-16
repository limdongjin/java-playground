package com.limdongjin.ps.jmbook;

import java.util.ArrayList;
import java.util.List;

class FindAnagram {
    private static boolean isEquals(int[] a, int[] b){
        for(int i = 0; i < a.length; i++){
            if(a[i] != b[i]) return false;
        }
        return true;
    }
    // findAnagram
    public static List<Integer> run(String pattern, String text){
        List<Integer> res = new ArrayList<>();

        final int MAX = 256;
        final int PLENG = pattern.length();
        final int TLENG = text.length();

        int[] countP = new int[MAX];
        int[] countT = new int[MAX];
        
        for(int i = 0; i < PLENG; i++){
            countP[pattern.charAt(i)]++;
            countT[text.charAt(i)]++;
        }

        for(int i = PLENG; i < TLENG; i++){
            if(isEquals(countP, countT)){
                res.add(i-PLENG);
            }
            countT[text.charAt(i)]++;
            
            countT[text.charAt(i - PLENG)]--;
            
        }
        if(isEquals(countP, countT)) res.add(TLENG - PLENG);
        return res;
    }
}