package com.limdongjin.symbol_table;

public class KeyNotFoundException extends RuntimeException {
        public KeyNotFoundException(String message){
            super(message);
        }
    public KeyNotFoundException(){
            super();
        }
}
