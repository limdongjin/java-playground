package com.limdongjin.Fibonacci;
import java.lang.IllegalArgumentException;

class Fib {
       private final long[] results;
       private final int LIMIT = 92;
       private int calculatedLastIdx = 1;
       public Fib(){
          results = new long[93];
          results[0] = 0;
          results[1] = 1;
       }
       // TODO: upper 90 -> init bigint and return bigint value or throw exception. 
       public long fibo(final int N) throws IllegalArgumentException {
           if(N > LIMIT || N < 0) {
               throw new IllegalArgumentException("Only 0 <= N <= " + LIMIT +" Argument Supported.");
           }
           if(N <= calculatedLastIdx) return results[N];
           
           for(int i = calculatedLastIdx + 1; i <= N; i++)
                results[i] = results[i - 1] + results[i - 2];
            calculatedLastIdx = N; 
            
            return results[N];
       }
}

public class Fibonacci {
        public static void main(final String[] args){
          long result;
          final Fib fib = new Fib(); 
          for (int n = 0; n < 90; n++){
            result = fib.fibo(n);
            // fib[n] = result;
            System.out.println(n + " " + result);
          }
       }
}

