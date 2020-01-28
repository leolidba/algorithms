package com.codersmart.algorithms.common;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    public static void main(String[] args){
        System.out.println(new RomanToInteger().romanToInt("MMCMXCV")); // 2995
        System.out.println(new RomanToInteger().romanToInt("III")); // 3
        System.out.println(new RomanToInteger().romanToInt("IV")); // 4
        System.out.println(new RomanToInteger().romanToInt("IX")); // 9
        System.out.println(new RomanToInteger().romanToInt("XL")); // 40
        System.out.println(new RomanToInteger().romanToInt("CM")); // 900
    }
    static Map<Object, Integer> map = new HashMap(){{
        put('I', 1);
        put('V', 5);
        put('L', 50);
        put('D', 500);
        put('X', 10);
        put('C', 100);
        put('M', 1000);
    }};
    public int romanToInt(String s) {
        int i = 0;
        int sum = 0;
        char pre = 'Z';
        while(i < s.length()){
            char curr = s.charAt(i);
            if(curr == 'V' && pre == 'I') sum += 3;
            else if(curr == 'X' && pre == 'I') sum += 8;
            else if(curr == 'L' && pre == 'X') sum += 30;
            else if(curr == 'C' && pre == 'X') sum += 80;
            else if(curr == 'D' && pre == 'C') sum += 300;
            else if(curr == 'M' && pre == 'C') sum += 800;
            else sum += map.get(curr);
            pre = curr;
            i ++;
        }
        return sum;
    }
}
