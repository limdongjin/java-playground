package com.limdongjin.util;

public class Assert {

    public static void assertEqual(Object expect, Object actual) {
        if (!expect.equals(actual))
            throw new AssertionError("expect : " + expect + ", but actual : " + actual);
    }
}