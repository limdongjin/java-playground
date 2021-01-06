package com.limdongjin.ps;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TestFindAnagram {
    @ParameterizedTest
    @MethodSource("provideDataSet")
    public void testDatas(String pattern, String text, List<Integer> expected){
        var actual = FindAnagram.run(pattern, text);
        
        assertEquals(expected, actual);
    }

    private static Stream<Arguments> provideDataSet(){
        return Stream.of(
            Arguments.of("abbc", "cbabadcbbabbcbabaabccbabc", List.of(0, 6, 9, 11, 12, 20, 21)),
            Arguments.of("ABCD", "BACDGABCDA", List.of(0, 5, 6)),
            Arguments.of("AABA", "AAABABAA", List.of(0, 1, 4))
        );
    }
}