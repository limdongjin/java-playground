package com.limdongjin.ps.boj.silver.p10814;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

class User {
    final int age;
    final String name;
    public User(final int age, final String name){
        this.name = name;
        this.age = age;
    }
    public int getAge(){
        return this.age;
    }
    public String getName(){
        return this.name;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        List<User> users = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            users.add(new User(Integer.parseInt(st.nextToken()), st.nextToken()));
        }

        bw.write(users.stream()
                        .sorted(Comparator.comparing(User::getAge))
                        .map(u -> u.getAge() + " " + u.getName())
                        .collect(Collectors.joining("\n")));
        bw.flush();
        bw.close();
    }
}
