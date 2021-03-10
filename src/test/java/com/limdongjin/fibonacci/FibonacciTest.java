package com.limdongjin.fibonacci;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class FibonacciTest {
    Fibonacci fib;

    @BeforeEach
    public void initialize(){
        fib = new Fibonacci();
    }

    @Test
    public void testBigOrMinusCase(){
        assertThrows(IllegalArgumentException.class, () -> fib.apply(-1));
        assertThrows(IllegalArgumentException.class, () -> fib.apply(-100));
        assertThrows(IllegalArgumentException.class, () -> fib.apply(93));
        assertThrows(IllegalArgumentException.class, () -> fib.apply(100));
        assertThrows(IllegalArgumentException.class, () -> fib.apply(1000000000));
    }

    @Test
    public void testFullCase(){

        List<Long> fibResults;

        fibResults = IntStream.range(0, 93).boxed().map(fib::apply).collect(Collectors.toList());
        assertEquals(0, fibResults.get(0).longValue());
        assertEquals(1, fibResults.get(1).longValue());

        for(int i = 2; i < fibResults.size(); i++){
            assertTrue(fibResults.get(i) > 0);
            assertEquals(fibResults.get(i - 2) + fibResults.get(i - 1), fibResults.get(i).longValue());
        }
    }

    @ParameterizedTest
    @MethodSource("provideDataSet")
    public void testBoundary(Long expected, Integer argument){
        assertEquals(expected, fib.apply(argument));
    }

    private static Stream<Arguments> provideDataSet(){
        return Stream.of(
                Arguments.of(0L, 0),
                Arguments.of(1L, 1),
                Arguments.of(1L, 2),
                Arguments.of(2L, 3),
                Arguments.of(3L, 4),
                Arguments.of(2880067194370816120L, 90),
                Arguments.of(4660046610375530309L, 91),
                Arguments.of(7540113804746346429L, 92)
        );
    }
}
