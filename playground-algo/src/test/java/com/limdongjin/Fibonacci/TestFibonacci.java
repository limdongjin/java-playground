package com.limdongjin.Fibonacci;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Collectors;
import com.limdongjin.Fibonacci.Fib;





public class TestFibonacci {

    Fib fib;
    private static final Logger logger = LogManager.getLogger(TestFibonacci.class);
    
    @BeforeEach
    public void initialize(){
        fib = new Fib();
    }

    @Test
    public void testBigOrMinusCase(){
        assertThrows(IllegalArgumentException.class, () -> {
            fib.fibo(-1);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            fib.fibo(-100);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            fib.fibo(93);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            fib.fibo(100);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            fib.fibo(1000000000);
        });
    }

    @Test
    public void testBoundaryCase(){
        assertEquals(0, fib.fibo(0));
        assertEquals(1, fib.fibo(1));
        logger.info(fib.fibo(2));
        assertEquals(2880067194370816120L, fib.fibo(90));
        assertEquals(4660046610375530309L, fib.fibo(91));
        assertEquals(7540113804746346429L, fib.fibo(92));
    }  

    @Test 
    public void testFullcase(){
        
        List<Long> fibResults;
        
        fibResults = IntStream.range(0, 93).boxed().map(fib::fibo).collect(Collectors.toList());
        assertEquals(0, fibResults.get(0).longValue());
        assertEquals(1, fibResults.get(1).longValue());
        
        for(int i = 2; i < fibResults.size(); i++){
            assertEquals(true, fibResults.get(i).longValue() > 0);
	        assertEquals(fibResults.get(i - 2).longValue() + fibResults.get(i - 1).longValue(), fibResults.get(i).longValue());
        }
    }

}
