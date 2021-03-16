package com.limdongjin.ps.boj.silver.p10816;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        HashMap<Integer, Integer> countMap = new HashMap<>();

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int inputNum = Integer.parseInt(st.nextToken());
            if(countMap.containsKey(inputNum)) countMap.put(inputNum, countMap.get(inputNum) + 1);
            else countMap.put(inputNum, 1);
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        List<String> ret = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int inputNum = Integer.parseInt(st.nextToken());
            Integer val = countMap.get(inputNum);
            if(val == null) val = 0;

            ret.add(String.valueOf(val));
        }

        bw.write(String.join(" ", ret));

        bw.flush();
        br.close();
        bw.close();
    }
}
