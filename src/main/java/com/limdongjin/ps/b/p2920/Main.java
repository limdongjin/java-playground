package com.limdongjin.ps.b.p2920;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        boolean asc = false;
        boolean mixed = false;
        int prev = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        if(prev < t)
            asc = true;
        prev = t;

        for(int i = 0; i < 6; i++){
            int x = Integer.parseInt(st.nextToken());
            if(prev < x){
                if(!asc) {
                    mixed = true;
                    break;
                }
            }else if(prev > x){
                if(asc){
                    mixed = true;
                    break;
                }
            }
            prev = x;
        }

        if(mixed)
            System.out.println("mixed");
        else if(asc)
            System.out.println("ascending");
        else
            System.out.println("descending");
    }
}
