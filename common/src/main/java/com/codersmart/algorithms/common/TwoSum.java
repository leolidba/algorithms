package com.codersmart.algorithms.common;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] data, int sum){
        Map<Integer, Integer> map = new HashMap(); // value : Index
        for(int i = 0; i < data.length; i ++){
            int comp = sum - data[i];
            if(map.containsKey(comp)){
                return new int[]{map.get(comp), i};
            }else{
                map.put(data[i], i);
            }
        }
        return null;
    }
}
