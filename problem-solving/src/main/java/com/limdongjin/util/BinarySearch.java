package com.limdongjin.util;

import java.util.List;

public class BinarySearch {
    public static <E extends Number> int apply(List<E> numbers, E target){
        // @requires isSorted(numbers)
        // @ensures ( (-1 == result && !isContain(numbers, target)) ||
        //            (0 <= result) && (result <= numbers.size() -1) && numbers.get(result) == target))

        // lo(inclusive) ~ hi(exclusive)
        int lo = 0, hi = numbers.size();

        int mid;
        while(lo < hi){
            // @loop_invariant 0 <= lo && lo <= hi && hi <= n
            // @loop_invariant lo == 0 || numbers.get(lo - 1) < target
            // @loop_invariant hi == n || numbers.get(hi) > target

            mid = lo + (hi - lo) / 2;
            E midValue = numbers.get(mid);
            if(midValue.equals(target)) return mid;
            else if(midValue.longValue() < target.longValue()) lo = mid + 1;
            else hi = mid;
        }
        return -1;
    }
}
