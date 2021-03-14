package com.limdongjin.ps.s.p10845;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Deque<String> queue = new LinkedList<>();

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String operation = st.nextToken();
            switch (operation){
                case "push":
                    queue.addLast(st.nextToken());
                    break;
                case "front":
                    if(queue.isEmpty())
                        bw.write("-1\n");
                    else
                        bw.write(queue.getFirst()+"\n");
                    break;
                case "empty":
                    if(queue.isEmpty())
                        bw.write("1\n");
                    else
                        bw.write("0\n");
                    break;
                case "pop":
                    if(queue.isEmpty())
                        bw.write("-1\n");
                    else
                        bw.write(queue.removeFirst()+"\n");
                    break;
                case "back":
                    if(queue.isEmpty())
                        bw.write("-1\n");
                    else
                        bw.write(queue.getLast()+"\n");
                    break;
                case "size":
                    bw.write(queue.size() + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}