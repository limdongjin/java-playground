package com.limdongjin.ps;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindNumOfPairTest {

    @ParameterizedTest
    @MethodSource("provideInputAndExpected")
    public void testSamples(int[] arr, int diff, int expected){
        assertEquals(expected, FindNumOfPair.run(arr, diff));
    }

    private static Stream<Arguments> provideInputAndExpected(){
        return Stream.of(
            Arguments.of(new int[]{1, 7, 5, 9, 2, 12, 3}, 2, 4),
            Arguments.of(new int[]{1, 7, 5, 9, 2, 12, 3, 4}, 2, 5),
            Arguments.of(new int[]{5, 20, 3, 2, 50, 80}, 78, 1),
            Arguments.of(new int[]{90, 70, 20, 80, 50}, 45, 0),
            Arguments.of(new int[]{90, 70, 20, 80, 50, 25}, 45, 1)
        );
    }
 
}