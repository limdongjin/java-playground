package com.limdongjin.ps.boj.silver.p1920;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        HashMap<Integer, Boolean> map = new HashMap<>();
        for (int i = 0; i < n; i++)
            map.put(Integer.parseInt(st.nextToken()), true);

        int m = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++)
            bw.write((map.get(Integer.parseInt(st.nextToken())) != null) ? "1\n" : "0\n");

        bw.flush();
        br.close();
        bw.close();

//        int[] arr = new int[n];
//
//        for (int i = 0; i <n; i++)
//            arr[i] = (Integer.parseInt(st.nextToken()));
//
//        int m = Integer.parseInt(br.readLine());
//        st = new StringTokenizer(br.readLine());
//        int[] target = new int[m];
//        for (int i = 0; i < m; i++)
//            target[i] = Integer.parseInt(st.nextToken());
//        Arrays.sort(arr);
//        for (int i = 0; i < m; i++) {
//            if(Arrays.binarySearch(arr, target[i]) >= 0)
//                bw.write("1\n");
//            else
//                bw.write("0\n");
//        }
    }
}
