package com.codersmart.algorithms.common;

import java.util.Arrays;
import java.util.Comparator;
import java.util.StringJoiner;

/**
 * Longest Increasing Sequence - 2D
 */
public class LIS2D {
    public static void main(String[] args){
        System.out.println(LIS2D.getLength(new int[][]{{1, 3},{5,4}, {2, 4}, {6,7}, {2,3} , {1, 10} }));
    }

    private static int getLength(int[][] data) {
        Arrays.sort(data, new Comparator<int[]>() {
            @Override
            public int compare(int[] t0, int[] t1) {
                if(t0[0] != t1[0]){
                    return t0[0] - t1[0];
                }else{
                    return t1[1] - t0[1];
                }
            }
        });
        int[] heights = new int[data.length];
        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i][0] + " " + data[i][1]);
            heights[i] = data[i][1];
        }
        return LIS(heights);
    }
    private static int LIS(int[] data)
    {
        int[]dp = new int[data.length];
        int len = 0;
        for(int m = 0; m < data.length; m++){
            int num = data[m];
            int i = Arrays.binarySearch(dp, 0, len, num);
            System.out.println("Binary search for " + num + " in dp[0:" + len + ") get index " + i);
            if(i < 0) {
                int j = i;
                i = - (i + 1);
                System.out.println("    Index (" + j +") < 0, assign index to - (index + 1) = " + i);
            }
            dp[i] = num;
            System.out.println("    dp[" + i + "] = " + num );
            if(i==len){
                len ++;
                System.out.println("    Index == Len =>  len++ => len =" + len);
            }
        }
        return len;
    }
}
