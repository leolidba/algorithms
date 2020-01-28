package com.codersmart.algorithms.common;

import java.util.*;

/**
 * Longest Common Subsequence
 */
public class LongestCommonSubsequence {
    public enum TRACE{
        UNDEFINED, LEFT, UP_LEFT, UP
    }
    static int matrix[][];
    static TRACE trace[][];

    public static void main(String[] args)
    {
        String a = "ABCDEFGHIHKDF";
        String b = "BCDGIXDH";
        Integer length = GetLcsLength(a, b);

        System.out.println("LCS length is : " + length);
        printLcs(a,b);
        printMatrix();
        System.out.println();
    }

    private static void printMatrix() {
        int m = 0;
        while(m < matrix.length){
            int n = 1;
            while (n < matrix[0].length){
                System.out.print(" " + matrix[m][n++]);
            }
            System.out.println();
            m++;
        }
    }

    private static void printLcs(String a, String b) {
        List<Character> list = new LinkedList<>();
        int m = b.length();
        int n = a.length();
        while(m > 0 && n > 0){
            switch (trace[m][n]){
                case LEFT:
                    n--;
                    break;
                case UP_LEFT:
                    list.add(0, b.charAt(m-1));
                    m --; n--;
                    break;
                case UP:
                    m --;
                    break;
            }
        }
        list.forEach(x-> System.out.println(x));
    }

    private static Integer GetLcsLength(String first, String second) {
        int N = first.length();
        int M = second.length();
        matrix = new int[M+1][N+1];
        trace = new TRACE[M+1][N+1];
        for(int i = 0; i <= M; i++) matrix[i][0] = 0;
        for(int i = 0; i <= N; i++) matrix[0][i] = 0;
        for(int m = 0; m < M; m++){
            for (int n = 0; n < N; n++){
                if(second.charAt(m) == first.charAt(n)){
                    matrix[m + 1][n + 1] = 1 + matrix[m][n];
                    trace[m + 1][n + 1] = TRACE.UP_LEFT;
                }
                else if (matrix[m][n+1] > matrix[m+1][n]){
                    matrix[m + 1][n + 1] = matrix[m][n+1];
                    trace[m + 1][n + 1] = TRACE.UP;
                }else{
                    matrix[m + 1][n + 1] = matrix[m+1][n];
                    trace[m + 1][n + 1] = TRACE.LEFT;
                }
            }
        }
        return matrix[M][N];
    }
}
