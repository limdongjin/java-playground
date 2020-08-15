package com.limdongjin.symbol_table;
import java.lang.UnsupportedOperationException;
import java.security.Key;

import com.limdongjin.symbol_table.SymbolTable;
import java.lang.Comparable;
import java.util.Arrays;
import com.limdongjin.symbol_table.KeyNotFoundException;

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
        int i = _rank(key);
        if (!_isExistKey(key, i)){
            throw new KeyNotFoundException();
        }
        
        _ShiftLeft(i, _n, 1);
        assignKeyValueWithIdx(_n, null, null);
        _n--;
    }
    
    @Override
    public boolean isEmpty(){
        return _n == 0;
    }

    @Override
    public boolean contains(Key key){
        // 
        throw new UnsupportedOperationException("no");
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
        if(_isExistKey(key, i))
            return _values[i];
        else
            return null;
    }

    @Override
    public void put(Key key, Value value){
        int i = _rank(key);
        if (_isExistKey(key, i)){
            _values[i] = value; return;
        }
        
        _ShiftRight(i, _n, 1);
        
        assignKeyValueWithIdx(i, key, value);
        
        _n++;
    }
    
    private void _ShiftRight(int from, int to, int amount){
        for(int i = to; i > from; i--){
            if(i - amount < 0){
                assignKeyValueWithIdx(i, _keys[0], _values[0]);
            }    
            assignKeyValueWithIdx(i, _keys[i - amount], _values[i - amount]);
        }
    }
    
    private void _ShiftLeft(int from, int to, int amount){
        for(int i = from; i < to; i++){
            if(_keys[i + amount] == null){
                assignKeyValueWithIdx(i, null, null);
                break;
            }
            assignKeyValueWithIdx(i, _keys[i + amount], _values[i + amount]);
        }
    }
    
    private boolean _isExistKey(Key key, int idx){
        return idx < _n && _keys[idx].compareTo(key) == 0;
    }
    
    private void assignKeyValueWithIdx(int idx, Key key, Value value){
        _keys[idx] = key; _values[idx] = value;
    }
}
