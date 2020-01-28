package com.codersmart.algorithms.common;

import java.util.Arrays;

/**
 * Longest Increasing Sequence
 */
public class LIS {
    public static void main(String[] args){
        int[] data = {3,5, 6, 9, 8, 20, 40, 12, 17, 20};
        System.out.println(new LIS().getLisLength(data));
    }

    public int getLisLength(int[] data)
    {
        int len = 0;
        int[] dp = new int[data.length];

        for(int num: data){
            int index = Arrays.binarySearch(dp, 0, len, num);
            if(index < 0){
                index = - (index + 1);
            }
            dp[index] = num;
            if(index == len){
                len ++;
            }
        }

        return len;
    }
}
