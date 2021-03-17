package com.limdongjin.ps.boj.silver.p1654;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        long[] arr = new long[k];
        long max = -1;
        for (int i = 0; i < k; i++) {
            arr[i] = Long.parseLong(br.readLine());
            max = Math.max(arr[i], max);
        }
        long left = 1L, right = max;
        long mid;
        while(left <= right){
            mid = left + (right - left) / 2;
            long sum = 0;
            for (int i = 0; i < k; i++)
                sum += arr[i] / mid;

//            bw.write("left="+left+" && mid="+mid+" && right="+right +" && sum="+sum+"\n");
            if(sum >= n)
                left = mid + 1;
            else
                right = mid - 1;
        }

        bw.write(right+"\n");
        bw.flush();
        br.close();
        bw.close();
    }
}
