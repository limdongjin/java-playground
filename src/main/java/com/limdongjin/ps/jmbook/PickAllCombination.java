package com.limdongjin.ps.jmbook;

import java.util.ArrayList;
import java.util.List;

public class PickAllCombination {
    public static void pick(int n, List<Integer> picked, int toPick){
        if(toPick == 0) {
            for(Integer element : picked)
                System.out.print(element + " ");
            System.out.println();
            return;
        }

        int smallest = picked.isEmpty() ? 0 : picked.get(picked.size() - 1);
        for(int next = smallest; next < n; ++next){
            picked.add(next);
            pick(n, picked, toPick - 1);
            picked.remove(picked.size() - 1);
        }
    }
    public static void main(String[] args) {
        pick(5, new ArrayList<>(), 3);
    }
}
