package com.limdongjin.ps.boj.silver.p2805;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        long m = Long.parseLong(st.nextToken());

//        List<Long> trees = new ArrayList<>();
        long[] trees = new long[n];
        long maxHeight = -1;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            long val =  Long.parseLong(st.nextToken());
//            trees.add(val);
            trees[i] = val;
            maxHeight = Math.max(val, maxHeight);
        }

        long bottom = 1;
        long top = maxHeight;

        while (bottom <= top){
            long mid = bottom + (top - bottom) / 2;
            long sum = 0;
            for (int i = 0; i < n; i++) {
//                long treeHeight = trees.get(i);
                long treeHeight = trees[i];
                sum += (treeHeight > mid) ? treeHeight - mid : 0;
            }
            if(sum < m) top = mid - 1;
            else bottom = mid + 1;
        }
        bw.write(top+"\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
