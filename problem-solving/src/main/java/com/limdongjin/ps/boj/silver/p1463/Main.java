package com.limdongjin.ps.boj.silver.p1463;

import java.io.*;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        LinkedList<Integer> queue = new LinkedList<>();
        queue.addFirst(n);

        int cnt = 0;

        boolean flag = false;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int x = queue.removeLast();
                if(x == 1) {
                    flag = true;
                    break;
                }
                if(x%3 == 0)
                    queue.addFirst(x/3);
                if(x%2 == 0)
                    queue.addFirst(x/2);
                queue.addFirst(x - 1);
            }
            if(flag) break;
            cnt++;
        }
        bw.write(cnt+"\n");

        bw.flush();
        br.close();
        bw.close();
    }
}
