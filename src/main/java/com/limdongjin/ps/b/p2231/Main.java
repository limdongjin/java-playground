package com.limdongjin.ps.b.p2231;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        assert isConstructorNumber(245, 256);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int ret = -1;
        for(int i = 1; i < n; i++){
            if(isConstructorNumber(i, n)){
                ret = i;
                break;
            }
        }
        System.out.println((ret != -1) ? ret : 0);
    }

    private static boolean isConstructorNumber(int M, int n) {
        int ret = M;

        while(M > 0){
            ret += M % 10;
            M /= 10;
        }

        return ret == n;
    }
}
