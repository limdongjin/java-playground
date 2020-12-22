package org.limdongjin.book_study.ch1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;
import org.limdongjin.data_structure.BagImpl;

class Stats {
    public static void main(String[] args) {
        Bag<Double> numbers = new BagImpl<Double>();
        FastReader fastReader = new FastReader();
        
        while(fastReader.hasMoreTokens()){
            numbers.add(fastReader.nextDouble());
        }
        final int N = numbers.size();
        
        double sum = 0.0;
        for (Double num : numbers)
            sum += num;
        double mean =  sum / N;

        sum = 0.0;
        for(Double number : numbers)
            sum += (number - mean) * (number - mean);
        
        
        double std = Math.sqrt(sum / (N - 1));
        
        System.out.printf("Mean: %.2f\n", mean);
        System.out.printf("Std dev: %.2f\n", std);
        System.out.println("Success!");
    }

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
            String line;
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

        private boolean hasMoreTokens(){
            if(st == null) return true;

            return st.hasMoreTokens();
        }

        public void close() throws IOException{
            if(br != null) br.close();
        }

    }
}