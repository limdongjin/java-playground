package com.limdongjin.ps.boj.silver.p1764;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String, Boolean> isNotSeen = new HashMap<>();
//        Map<String, Boolean> ret = new HashMap<>();
        List<String> ret  = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            isNotSeen.put(br.readLine(), true);
        }
        for (int i = 0; i < m; i++) {
            String person = br.readLine();
            if(isNotSeen.containsKey(person))
                ret.add(person);
        }
        ret.sort(Comparator.naturalOrder());

        int size = ret.size();
        bw.write(size + "\n");

        for (int i = 0; i < size; i++) {
            bw.write(ret.get(i) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
