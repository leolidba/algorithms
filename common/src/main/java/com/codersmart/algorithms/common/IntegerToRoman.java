package com.codersmart.algorithms.common;

import java.util.HashMap;
import java.util.Map;

public class IntegerToRoman {
    public static void main(String[] args){
        System.out.println(new IntegerToRoman().toRoman(3999));
        System.out.println(new IntegerToRoman().toRoman(3));
        System.out.println(new IntegerToRoman().toRoman(4));
        System.out.println(new IntegerToRoman().toRoman(9));
        System.out.println(new IntegerToRoman().toRoman(58));
    }

    public String toRoman(int number) {
        Map<String, Integer> map = new HashMap(){{
            put(1, "I");
            put(4, "IV");
            put(5, "V");
            put(9, "IX");
            put(10, "X");
            put(40, "XL");
            put(50, "L");
            put(90, "XC");
            put(100, "C");
            put(400, "CD");
            put(500, "D");
            put(900, "CM");
            put(1000, "M");
        }};
        StringBuilder sb = new StringBuilder();
        int[] scales = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        for(int scale: scales) {
            while (number >= scale) {
                sb.append(map.get(scale));
                number -= scale;
            }
        }
        return sb.toString();
    }
}
