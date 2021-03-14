package com.limdongjin.ps.s.p1874;

import java.io.*;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        List<Integer> sequence = new ArrayList<>();
        Deque<Integer> stack = new LinkedList<>();

        for (int i = 0; i < n; i++)
            sequence.add(Integer.parseInt(br.readLine()));
        List<String> histories = new ArrayList<>();

        int seqIdx = 0;
        for (int i = 1; i <= n; i++) {
            stack.addFirst(i);
            histories.add("+");
            while(!stack.isEmpty() && stack.getFirst().equals(sequence.get(seqIdx))){
                stack.removeFirst();
                histories.add("-");
                seqIdx++;
            }
        }

        if(stack.isEmpty())
            bw.write(String.join("\n", histories));
        else
            bw.write("NO");
        bw.flush();
        bw.close();
        br.close();
    }
}
