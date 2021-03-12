package com.limdongjin.ps.b.p2798;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] cards = new int[n];
        boolean[] isSelect = new boolean[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solve(m, cards, isSelect, 0, 0));
    }

    private static int solve(int m, int[] cards, boolean[] isSelect, int selectCount, int curSum) {
        if(selectCount == 3) return curSum;

        int ret = -1;
        for(int i = 0; i < cards.length; i++){
            if(isSelect[i]) continue;
            if(m - cards[i] < 0) continue;
            isSelect[i] = true;
            ret = Math.max(ret, solve(m - cards[i], cards, isSelect,selectCount + 1, curSum + cards[i]));
            isSelect[i] = false;
        }
        return ret;
    }
}
