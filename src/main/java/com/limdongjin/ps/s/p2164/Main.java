package com.limdongjin.ps.s.p2164;

import java.io.*;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        LinkedList<Integer> list = new LinkedList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        br.close();

        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        int size = n;
        for(int i = 0; i < n; i++){
            // n times
            if(size == 1){
                bw.write(list.getFirst() + "\n");
                break;
            }
            list.remove();
            list.add(list.remove());
            size--;
        }

        bw.flush();
        bw.close();
    }
}
