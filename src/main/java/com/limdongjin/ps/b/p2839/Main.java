package com.limdongjin.ps.b.p2839;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int solve(int n, int depth, int[] cache){
        if(n < 0) return 99999;
        if(cache[n] != 0 && cache[n] != 99999) return cache[n];
        if(n == 0) return depth;
        if(n % 5 == 0) {
            cache[n] = depth + (n / 5);
            return cache[n];
        }

        cache[n] = Math.min(solve(n - 5, depth + 1, cache), solve(n-3, depth + 1, cache));
        return cache[n];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] cache = new int[n + 10];
        int ret = solve(n, 0, cache);
        System.out.println(ret == 99999 ? -1 : ret);
    }
}
