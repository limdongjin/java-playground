package org.limdongjin.book_study.ch1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.stream.IntStream;
import java.util.Arrays;
public class OneOneChap {
    public static void main(String[] args) {
        
        BiConsumer assertEqual = (expected, actual) -> {
            if (expected.equals(actual)) {
                System.out.println("Pass");
            }else {
                System.out.printf("expected: "+expected +",actual: "+actual +"\n");
                System.out.println("Fail");
                throw new RuntimeException("Fail!!");
            }
        };
        
        // 1.1.1
        assertEqual.accept(7, (0+15)/2);
        assertEqual.accept(200.0000002, 2.0e-6 * 100000000.1);
        assertEqual.accept(true, true && false || true && true);
        
        // 1.1.2
        assertEqual.accept(Double.class.isInstance((1+2.236)/2), true);
        assertEqual.accept(Double.class.isInstance(1+2+3+4.0), true);
        assertEqual.accept(Boolean.class.isInstance(4.1 >= 4), true); 
        assertEqual.accept(String.class.isInstance(1+2+"3"), true);

        // 1.1.3
        p_1_1_3();

        // 1.1.4
        // a, b, d Syntax Wrong

        // 1.1.5
        areBiggerZeroAndSmallerOne(0.5, 0.6);
        areBiggerZeroAndSmallerOne(1.0, 0.6);
        
        // 1.1.11
        p_1_1_11();

        // 1.1.13
        p_1_1_13();
        


    }

    public static void p_1_1_3(){
        try(
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in))
            ){
            System.out.print("input(three int): ");
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[3];
            for(int i=0;i<3;i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            
            if(arr[0] == arr[1] &&  arr[1] == arr[2]){
                System.out.println("equal");
            }else {
                System.out.println("not equal\n");
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public static void printTwoDimensionArray(int[][] b){
        for(int i = 0; i < b[0].length; i++){
            System.out.printf("%4d", i);
        }

        System.out.printf("\n");
        for(int rowNo = 0; rowNo< b.length; rowNo++){
            System.out.printf("%d", rowNo);
            System.out.printf("%3d", b[rowNo][0]);
            for(int colNo = 1; colNo < b[rowNo].length; colNo++){
                
                System.out.printf("%4d", b[rowNo][colNo]);
            }
            System.out.printf("\n");
        }
    }
    public static void p_1_1_11(){
        boolean[][] b = {{true, false, true}, {true, true, true}, {false, false, true}};
        
        BiConsumer<Boolean, String> printStarIfTrue = (value, format) -> {
             if(value) System.out.printf(format, "*");
             else System.out.printf(format," ");
        };

        for(int i = 0; i < b[0].length; i++){
            System.out.printf("%4d", i);
        }

        System.out.printf("\n");
        for(int rowNo = 0; rowNo< b.length; rowNo++){
            System.out.printf("%d", rowNo);
            printStarIfTrue.accept(b[rowNo][0], "%3s");
            for(int colNo = 1; colNo < b[rowNo].length; colNo++){
                printStarIfTrue.accept(b[rowNo][colNo], "%4s");
            }
            System.out.printf("\n");
        }
    }
    public static void p_1_1_13(){
        // swap a[i][j] , a[j][i] for all i, j
        int[][] a = {{1,2,3}, {4,5,6}, {7,8,9}};
        int tmp;
        for(int rowNo = 0; rowNo < (a.length); rowNo++){
            for(int colNo = rowNo; colNo < (a[rowNo].length); colNo++){
                tmp = a[rowNo][colNo];
                a[rowNo][colNo] = a[colNo][rowNo];
                a[colNo][rowNo] = tmp;
            }
        }
        
        printTwoDimensionArray(a);
    }
    public static void areBiggerZeroAndSmallerOne(double d1, double d2){
        System.out.println(d1 > 0 && d1 < 1 && d2 > 0 && d2 < 1);
    }
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        private String next(){
            while(st == null || !st.hasMoreElements()){
                try {
                    st = new StringTokenizer(br.readLine());
                } catch(IOException e){
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        int nextInt(){
            return Integer.parseInt(next());
        }
        double nextDouble(){
            return Double.parseDouble(next());
        }
    }
}
