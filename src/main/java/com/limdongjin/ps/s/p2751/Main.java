package com.limdongjin.ps.s.p2751;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> numbers = new ArrayList<>();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i <n; i++)
            numbers.add(Integer.parseInt(br.readLine()));

        Collections.sort(numbers);
        for(Integer num : numbers){
            bw.write(num + "\n");
        }
        bw.flush();
        bw.close();
    }
}
