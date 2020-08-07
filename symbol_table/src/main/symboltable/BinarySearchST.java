// import jdk.internal.org.objectweb.asm.tree.analysis.Value;
package symbol_table.src.main.symboltable;

import symbol_table.src.main.symboltable.ISt;
import java.lang.Comparable;
import java.util.Arrays;

public class BinarySearchST<Key extends Comparable<Key>, Value> implements ISt<Key, Value> {
    private Key[] _keys;
    private Value[] _values;
    private int _n;
    // private List<Key> keyss;
    
    
    public BinarySearchST(int compacity){
        this._keys = (Key[]) new Comparable[compacity];
        this._values = (Value[]) new Object[compacity];
    }
    
    @Override
    public int size(){
        return this._n;
    }
    
    @Override
    public void delete(Key key){
        
    }
    
    @Override
    public boolean isEmpty(){
        return this._n == 0;    
    }

    @Override
    public boolean contains(Key key){
        // 
        return true;
    }
    
    @Override
    public Iterable<Key> keys(){
        return Arrays.asList(this._keys);    
    }

    private int _rank(Key key){ 
        // key 보다 작은 key 의 숫자를 리턴한다. 즉 해당 key의 keys[i]의 i 를 뜻하게된다 
        int lo = 0, hi = this._n - 1;
        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;
            int cmp = key.compareTo(this._keys[mid]);
            System.out.println(key);
                
            System.out.println(this._keys[mid]);
            
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
        int i = this._rank(key);
        if(i < this._n && this._keys[i].compareTo(key) == 0) 
            return this._values[i];
        else
            return null;
    }

    @Override
    public void put(Key key, Value val){
        int i = this._rank(key);
        if (i < this._n && this._keys[i].compareTo(key) == 0){
            this._values[i] = val; return;
        }
        // for (int j = _n; j > i; j--){ // Shift Right
        //     this._keys[j] = this._keys[j - 1]; 
        //     this._values[j] = this._values[j -1];
        // }
        for(Key s : this.keys()){
           System.out.println(s);         
        }
        
        this._ShiftRightOne(this._keys, this._values, i, this._n);
        
        this._keys[i] = key; this._values[i] = val; 
        this._n++;
    }
    
    private void _ShiftRightOne(Key[] keys, Value[] values, int from, int to){
        for(int i = to; i > from; i--){
            this._keys[i] = this._keys[i - 1]; 
            this._values[i] = this._values[i - 1];
        }
    }
}