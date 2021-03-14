package com.limdongjin.ps.s.p4949;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Deque<Character> stack = new LinkedList<>();

        String s;
        while ((s = br.readLine()) != null){
            if(s.compareTo(".") == 0) break;
            boolean flag = true;
            for (char c : s.toCharArray()) {
                if(c == '(' || c == '[') {
                    stack.addFirst(c);
                }else if(c == ')' && !stack.isEmpty() && stack.getFirst() == '(' ){
                    stack.removeFirst();
                }else if(c == ']' && !stack.isEmpty() && stack.getFirst() == '[' ){
                    stack.removeFirst();
                }else if(c == ']' || c == ')'){
                    flag = false;
                    break;
                }
            }
            if(!stack.isEmpty()){
                flag = false;
                while (!stack.isEmpty()) stack.pop();
            }
            bw.write(flag ? "yes\n" : "no\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
