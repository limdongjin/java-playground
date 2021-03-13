package com.limdongjin.ps.s.p1920;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i <n; i++)
            arr[i] = (Integer.parseInt(st.nextToken()));

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] target = new int[m];
        for (int i = 0; i < m; i++)
            target[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        for (int i = 0; i < m; i++) {
            if(Arrays.binarySearch(arr, target[i]) >= 0)
                bw.write("1\n");
            else
                bw.write("0\n");
        }

        bw.flush();

        br.close();
        bw.close();
    }
}
