package com.limdongjin.ps;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TestFindRunningMedian {

    @ParameterizedTest
    @MethodSource("provideDataSet")
    public void testDatas(List<Integer> inputs, List<Double> expected){
        var actual = FindRunningMedian.run(inputs);
        
        assertEquals(expected, actual);
    }

    private static Stream<Arguments> provideDataSet(){
        return Stream.of(
            Arguments.of(List.of(12, 4, 5, 3, 8, 7), List.of(12.0,8.0,5.0,4.5,5.0,6.0))
        );
    }

}