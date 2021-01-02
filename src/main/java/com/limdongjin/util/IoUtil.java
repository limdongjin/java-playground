package com.limdongjin.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class IoUtil {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
        public FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        
        public Double nextDouble(){
            return Double.parseDouble(next());
        }

        private String next(){
            
            try {
                while(st == null || !st.hasMoreElements()){
                    st = new StringTokenizer(br.readLine());
                }
            } catch (Exception e) {
                //TODO: handle exception
                e.printStackTrace();
                System.out.println("exc");
            }
            
            return st.nextToken();
        }

        public void close() throws IOException{
            if(br != null) br.close();
        }

    }
}