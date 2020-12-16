package org.limdongjin.book_study;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class OneOneChap {
    public static void main(String[] args) {
        
        BiConsumer assertEqual = (expected, actual) -> {
            System.out.println("=start=");
             System.out.printf("expected: "+expected +",actual: "+actual +"\n");
            if (expected.equals(actual)) {
                System.out.println("Pass");
            }else {
                System.out.println("Fail");
                throw new RuntimeException("Fail!!");
            }
            System.out.println("=end=");
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

        // 1.1.3 skip
    }
}