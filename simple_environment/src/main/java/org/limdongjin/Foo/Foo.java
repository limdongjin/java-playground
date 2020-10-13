package org.limdongjin.Foo;
import java.util.Scanner;
class Foo {
  static boolean isCoprime(int a, int b){
    int tmp;
    tmp = 1;
    if(a < b){
      tmp = a;
      a = b;
      b = tmp;
    }
    while(b != 0){
     tmp = a % b;
     a = b;
     b = tmp;
    }
    return a == 1;
  }
  public static void main(String[] args){
    int N = 20;
    System.out.println( (1 == 1) == true );
    boolean[][] arr = new boolean[N][N];
    for(int i = 0; i < N; i++){
      for(int j = 0;j <N;j++){
        if(isCoprime(i, j)){
          arr[i][j] = true;
          continue;
        }
        arr[i][j] = false;
      }
    }
    
    Scanner sc = new Scanner(System.in);
    int n1 = sc.nextInt();
    int n2 = sc.nextInt();
    System.out.println(arr[n1][n2]);
 }
}
