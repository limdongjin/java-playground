package com.limdongjin.ps.jmbook;

import java.util.Hashtable;

// given k. find numOfPairs with given difference
// ex) [1,7, 5, 9, 2, 12, 3], k = 2
// return (1,3), (3, 5), (5,7), (7,9) 
class FindNumOfPair {
    public static int run(int[] arr, final int diff){
        int res = 0;
        Hashtable<Integer, Boolean> hashtable = new Hashtable<>();
        int lengthOfArr = arr.length;
        
        for(int i = 0; i < lengthOfArr; i++){
            hashtable.put(arr[i], true);
        }
        
        for(int i = 0; i < lengthOfArr; i++){
            if(hashtable.get(arr[i] - diff) != null) res++;
            if(hashtable.get(arr[i] + diff) != null) res++;
        }
        res = res / 2;
        return res;
    }
}