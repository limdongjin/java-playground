package com.limdongjin.ps.s.p1181;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<String> strings = new ArrayList<>();

        for (int i = 0; i < n; i++) strings.add(br.readLine());

        strings.stream().distinct().sorted().sorted(Comparator.comparing(String::length)).forEach(System.out::println);
    }
}
