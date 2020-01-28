package com.codersmart.algorithms.common;

/**
 * This implementation is of O(n^2)
 * O(n) can be achieved by Manacher's Algorithm
 */
public class LongestPalindromicSubstring {
    public static void main(String[] args){
        String stringMaxLength1K = "xbabbaby";
        System.out.println(new LongestPalindromicSubstring().getLps(stringMaxLength1K));
    }

    private String getLps(String s) {
        if(s.length()<= 1) return s;

        int max = 0;
        int maxi = 0;
        int maxj = 0;
        for(int i = 0; i < s.length(); i++){
            int len1 = getMaxPalindromicSubstringLength(s, i, i);
            int len2 = getMaxPalindromicSubstringLength(s, i, i + 1);
            if(len1 > max){
                max = len1;
                maxi = i;
                maxj = i;
            }
            if(len2 > max){
                max = len2;
                maxi = i;
                maxj = i + 1;
            }
        }
        System.out.println(max);
        return getLps(s, max, maxi, maxj);
    }

    private String getLps(String s,int max, int maxi, int maxj) {
        if(maxi == maxj){
            return s.substring(maxi - (max - 1)/2 , maxi + (max - 1)/2 + 1 );
        }else{
            return s.substring(maxi - max /2 + 1 , maxi + max /2 + 1);
        }
    }

    private int getMaxPalindromicSubstringLength(String s, int i, int j) {
        int len = 0;
        int step = 1;
        if(i == j){
            len = 1;
            while( i- step >= 0 && i + step < s.length() && s.charAt(i - step) == s.charAt(i + step)){
                len += 2;
                step ++;
            }
            return len;
        }
        else{
            step = 0;
            while( i- step >= 0 && j + step < s.length() && s.charAt(i - step) == s.charAt(j + step)){
                len += 2;
                step ++;
            }
            return len;
        }
    }
}
