package com.limdongjin.ps.p10871;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>();
        int a;
        for(int i = 0; i < n; i++){
            a = Integer.parseInt(st.nextToken());
            if(a < x) list.add(a);
        }

        System.out.println(list.stream()
                                .map(String::valueOf)
                                .collect(Collectors.joining(" ")));
    }
}
