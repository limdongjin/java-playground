package com.limdongjin.ps.jmbook;

import java.sql.Struct;

public class CountPairings {
    boolean[][] areFriends;
    int n;

    public CountPairings(boolean[][] areFriends, int n){
        this.areFriends = areFriends;
        this.n = n;
    }

    public int apply(boolean[] taken){
        int firstFree = -1;
        for(int i = 0; i < n; i++){
            if(!taken[i]) {
                firstFree = i;
                break;
            }
        }
        if(firstFree == -1) return 1;
        int ret = 0;

        for(int pairWith = firstFree + 1; pairWith < n; pairWith++){
            if(areFriends[pairWith][firstFree] && !taken[pairWith]){
                taken[firstFree] = taken[pairWith] = true;
                ret += apply(taken);
                taken[firstFree] = taken[pairWith] = false;
            }
        }

        return ret;
    }
}
