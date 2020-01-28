package com.codersmart.algorithms.common;

public class StringToInteger {
    public static void main(String[] args){
        System.out.println(new StringToInteger().atoi("-1213434867687"));
        System.out.println(new StringToInteger().atoi("1234 with words"));
        System.out.println(new StringToInteger().atoi(""));
        System.out.println(new StringToInteger().atoi("+"));
        System.out.println(new StringToInteger().atoi("-"));
        System.out.println(new StringToInteger().atoi("  987665"));
        System.out.println(new StringToInteger().atoi(String.valueOf(Integer.MAX_VALUE))+ " : " + Integer.MAX_VALUE);
        System.out.println(new StringToInteger().atoi(String.valueOf(Integer.MIN_VALUE)) + " : " + Integer.MIN_VALUE );
    }

    public Integer atoi(String s){
        String trimmed = s.trim();
        if(trimmed.length() == 0) return 0;
        int unit = 1;
        String signRemoved = trimmed;
        if(trimmed.charAt(0) == '+'){
            signRemoved = trimmed.substring(1);
        }
        if(trimmed.charAt(0) == '-'){
            unit = -1;
            signRemoved = trimmed.substring(1);
        }
        if(signRemoved.length() == 0) return 0;
        if(signRemoved.charAt(0) > '9' || signRemoved.charAt(0)  < '0'){
            return 0;
        }
        int i = 0;
        while(i < signRemoved.length() && signRemoved.charAt(i) >= '0' && signRemoved.charAt(i) <= '9'){
            i ++;
        }
        String token = signRemoved.substring(0, i);
        return atoiInternal(unit, token);
    }

    private Integer atoiInternal(int unit, String token) {
        double value = 0L;
        for(int i =0; i < token.length(); i++){
            value = value * 10 + (token.charAt(i) - '0') ;
            if(value * unit <= Integer.MIN_VALUE){
                return Integer.MIN_VALUE;
            }
            if(value * unit >= Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }
        }
        return (int)value * unit;
    }
}
