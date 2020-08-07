package com.limdongjin.symbol_table;

public interface SymbolTable<Key extends Comparable<Key>, Value> {
    void put(Key key, Value val);
    Value get(Key key);
    void delete(Key key);
    boolean contains(Key key);
    boolean isEmpty();
    int size();
    Iterable<Key> keys();
    
}

// public interface ISt<Key extends Comparable<Key>, Value> { 
//     // Symbol Table 의 인터페이스
    
// }