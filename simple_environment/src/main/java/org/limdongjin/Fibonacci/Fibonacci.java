package org.limdongjin.Fibonacci;

class Fib {
       private long[] _fibo;
       public Fib(){
          _fibo = new long[100000];
          _fibo[0] = 0;
          _fibo[1] = 1;
       }
       public long fibo(int N){
         if(N == 0) return 0;
         if(N == 1) return 1;
         if(_fibo[N] != 0){
            return _fibo[N];
         }
         _fibo[N] = _fibo[N - 2] + _fibo[N - 1]; 
         return _fibo[N];
   
       }
}

public class Fibonacci {
        public static void main(String[] args){
          long result;
          Fib fib = new Fib(); 
          for (int n = 0; n < 90; n++){
            result = fib.fibo(n);
            // fib[n] = result;
            System.out.println(n + " " + result);
          }
       }
}

