package com.limdongjin.ps.s.p11866;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Deque<String> deque = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            deque.addLast(String.valueOf(i));
        }
        List<String> ret = new ArrayList<>();
        while(!deque.isEmpty()){
            for (int i = 0; i < k - 1; i++)
                deque.addLast(deque.removeFirst());
            ret.add(deque.removeFirst());
        }

        bw.write("<");
        bw.write(String.join(", ", ret));
        bw.write(">\n");

        bw.flush();
        br.close();
        bw.close();
    }
}
