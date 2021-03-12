package com.limdongjin.ps.b.p1546;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        int max = -1;
        for(int i =0;i<n;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if(arr[i] > max) max = arr[i];
        }

        double sum = 0;
        for(int i = 0; i<n;i++)
            sum += ((double)arr[i] / max)*100;

        System.out.println(sum / n);
    }
}
