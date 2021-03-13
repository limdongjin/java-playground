package com.limdongjin.ps.s.p2108;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] positiveOrZero = new int[4001];
        int[] negative = new int[4001];

        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(br.readLine());
            if(a < 0) negative[a*(-1)]++;
            else positiveOrZero[a]++;
        }

        int sum = 0;
        for (int i = 1; i <= 4000; i++) {
            sum += positiveOrZero[i]*i + negative[i]*(-1)*(i);
        }
        bw.write((int)Math.round((double) sum / n) + "\n");

        int midIdx = n / 2;
        int curIdx = 0;
        boolean flag = false;
        for (int i = 4000; i >= 1; i--) {
            if(curIdx + negative[i] > midIdx){
                bw.write((-1)*i +"\n");
                flag = true;
                break;
            }
            curIdx = curIdx + negative[i];
        }
        if(!flag) {
            for (int i = 0; i <= 4000; i++) {
                if (curIdx + positiveOrZero[i] - 1 >= midIdx) {
                    bw.write(i+"\n");
                    break;
                }
                curIdx = curIdx + positiveOrZero[i];
            }
        }

        int maxCount = 0;
        for (int i = 4000; i > 0; i--) {
            if(negative[i] > maxCount)
                maxCount = negative[i];
        }
        for(int i = 0; i <= 4000; i++){
            if(positiveOrZero[i] > maxCount)
                maxCount = positiveOrZero[i];
        }

        int cnt = 0;
        boolean findFlag = false;
        int modeValue = 9999;
        for (int i = 4000; i > 0; i--) {
            if(cnt == 0 && negative[i] == maxCount){
                modeValue = i * (-1);
                cnt++;
            }
            else if(cnt == 1 && negative[i] == maxCount){
                cnt++;
                modeValue = i * (-1);
                findFlag = true;
                break;
            }
        }
        for (int i = 0; i <= 4000; i++) {
            if(cnt == 0 && positiveOrZero[i] == maxCount){
                modeValue = i;
                cnt++;
            }
            else if(cnt == 1 && positiveOrZero[i] == maxCount){
                modeValue = i;
                findFlag = true;
                break;
            }
        }

        bw.write(modeValue + "\n");

        bw.flush();
        br.close();
        bw.close();
    }
}
