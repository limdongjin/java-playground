package com.limdongjin.ps.s.p7568;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

class Person {
    final int weight;
    final int height;
    int rank;
    Person(final int weight, final int height){
        this.weight =weight;
        this.height =height;
        this.rank = 0;
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        List<Person> people = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            people.add(new Person(Integer.parseInt(st.nextToken()) , Integer.parseInt(st.nextToken())));
        }

       String ret = people.stream()
                            .map(p -> people.stream()
                                            .filter(s -> s.weight > p.weight && s.height > p.height)
                                            .count() + 1)
                            .map(String::valueOf)
                            .collect(Collectors.joining(" "));
        bw.write(ret);
        bw.flush();
        bw.close();
    }
}
