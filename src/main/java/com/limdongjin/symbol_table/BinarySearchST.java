package com.limdongjin.symbol_table;

import com.limdongjin.symbol_table.SymbolTable;
import java.lang.Comparable;
import java.util.Arrays;

public class BinarySearchST<Key extends Comparable<Key>, Value> implements SymbolTable<Key, Value>{
    private Key[] _keys;
    private Value[] _values;
    private int _n;
    
    public BinarySearchST(int compacity){
        _keys = (Key[]) new Comparable[compacity];
        _values = (Value[]) new Object[compacity];
    }
    
    @Override
    public int size(){
        return _n;
    }
    
    @Override
    public void delete(Key key){
        
    }
    
    @Override
    public boolean isEmpty(){
        return _n == 0;    
    }

    @Override
    public boolean contains(Key key){
        // 
        return true;
    }
    
    @Override
    public Iterable<Key> keys(){
        return Arrays.asList(_keys);    
    }

    private int _rank(Key key){ 
        // key 보다 작은 key 의 숫자를 리턴한다. 즉 해당 key의 keys[i]의 i 를 뜻하게된다 
        int lo = 0, hi = this._n - 1;
        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;
            int cmp = key.compareTo(_keys[mid]);
            System.out.println(key);
                
            System.out.println(_keys[mid]);
            
            System.out.println(cmp);
            if(cmp < 0) hi = mid - 1;
            else if(cmp > 0) lo = mid + 1;
            else return mid;
        }
        return lo;
    }

    @Override
    public Value get(Key key){
        if(isEmpty()) return null;
        int i = _rank(key);
        if(i < _n && _keys[i].compareTo(key) == 0) 
            return _values[i];
        else
            return null;
    }

    @Override
    public void put(Key key, Value val){
        int i = _rank(key);
        if (i < _n && _keys[i].compareTo(key) == 0){
            _values[i] = val; return;
        }
        
        _ShiftRightOne(_keys, _values, i, _n);
        
        _keys[i] = key; _values[i] = val; 
        _n++;
    }
    
    private void _ShiftRightOne(Key[] keys, Value[] values, int from, int to){
        for(int i = to; i > from; i--){
            _keys[i] = _keys[i - 1]; 
            _values[i] = _values[i - 1];
        }
    }
}
