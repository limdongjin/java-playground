package com.limdongjin.ps.boj.silver.p11723;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Set<Integer> set = new HashSet<>();
        List<Integer> list20 = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            list20.add(i);
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String op = st.nextToken();
            if(op.equals("all")){
                set.clear();
                set.addAll(list20);
                continue;
            }else if(op.equals("empty")){
                set.clear();
                continue;
            }
            int x = Integer.parseInt(st.nextToken());
            if(op.equals("add")){
                if(set.contains(x)) continue;
                set.add(x);
            }else if(op.equals("remove")){
                if(!set.contains(x)) continue;
                set.remove(x);
            }else if(op.equals("check")){
                bw.write( (set.contains(x)) ? "1\n" : "0\n" );
            }else if(op.equals("toggle")){
                if(set.contains(x)) set.remove(x);
                else set.add(x);
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
