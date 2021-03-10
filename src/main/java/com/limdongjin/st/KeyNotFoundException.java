package com.limdongjin.st;


public class KeyNotFoundException extends RuntimeException {
        /**
    *
    */
    private static final long serialVersionUID = 1L;

    public KeyNotFoundException(String message) {
            super(message);
        }
    public KeyNotFoundException(){
            super();
        }
}
