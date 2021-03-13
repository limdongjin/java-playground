package com.limdongjin.ps.s.p9012;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            int openBracket = 0;
            int closeBracket = 0;

            for (int j = 0; j < s.length(); j++) {
                if(s.charAt(j) == '(') openBracket++;
                else if(s.charAt(j) == ')') {
                    closeBracket++;
                    if(openBracket < closeBracket) break;
                }
            }
            bw.write( (openBracket != closeBracket) ? "NO\n" : "YES\n" );
        }
        bw.flush();
        bw.close();
        br.close();
    }
}