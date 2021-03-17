package com.limdongjin.ps.boj.silver.p10773;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        Deque<Integer> deque = new LinkedList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int K = Integer.parseInt(br.readLine());

        for (int i = 0; i < K; i++) {
            int input = Integer.parseInt(br.readLine());
            if(input == 0) deque.removeFirst();
            else deque.addFirst(input);
        }
        int sum = 0;
        while(!deque.isEmpty())
            sum += deque.removeFirst();

        bw.write(sum + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
