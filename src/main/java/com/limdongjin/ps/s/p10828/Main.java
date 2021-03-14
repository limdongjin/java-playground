package com.limdongjin.ps.s.p10828;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Deque<String> stack = new LinkedList<>();

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String operation = st.nextToken();
//            bw.write(operation);
            switch (operation){
                case "push":
                    stack.addFirst(st.nextToken());
                    break;
                case "top":
                    if(stack.isEmpty())
                        bw.write("-1\n");
                    else
                        bw.write(stack.getFirst()+"\n");
                    break;
                case "empty":
                    if(stack.isEmpty())
                        bw.write("1\n");
                    else
                        bw.write("0\n");
                    break;
                case "pop":
                    if(stack.isEmpty())
                        bw.write("-1\n");
                    else
                        bw.write(stack.removeFirst()+"\n");
                    break;
                case "size":
                    bw.write(stack.size() + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}