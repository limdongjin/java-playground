package com.limdongjin.util.st;

import java.util.Arrays;

public class BinarySearchST<K extends Comparable<K>, V> implements SymbolTable<K, V>{
    private K[] _keys;
    private V[] _values;
    private int _n;
    
    @SuppressWarnings("unchecked")
    public BinarySearchST(int compacity){
        _keys = (K[]) new Comparable[compacity];
        _values = (V[]) new Object[compacity];
    }
    
    @Override
    public int size(){
        return _n;
    }
    
    @Override
    public void delete(K key){
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
    public boolean contains(K key){
        // 
        throw new UnsupportedOperationException("no");
    }
    
    @Override
    public Iterable<K> keys(){
        return Arrays.asList(_keys);    
    }

    private int _rank(K key){ 
        
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
    public V get(K key){
        if(isEmpty()) return null;
        
        int i = _rank(key);
        if(_isExistKey(key, i))
            return _values[i];
        else
            return null;
    }

    @Override
    public void put(K key, V value){
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
    
    private boolean _isExistKey(K key, int idx){
        return idx < _n && _keys[idx].compareTo(key) == 0;
    }
    
    private void assignKeyValueWithIdx(int idx, K key, V value){
        _keys[idx] = key; _values[idx] = value;
    }
}
