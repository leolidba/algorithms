package com.codersmart.algorithms.common;

import java.util.*;

/**
 *
 */
public class ValidParentheses {
    public static void main(String[] args){
        System.out.println(new ValidParentheses().isValid("()"));
    }
    /**
     *
     * @param s: Input string containes only '(', ')', '{', '}', '[', ']'.
     * @return true if parentheses closed correctly.
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>(){{
            put('(', ')');
            put('[', ']');
            put('{', '}');
        }};

        for(char c : s.toCharArray()){
            if(map.containsKey(c)){
                stack.push(c);
            }else{
                if(stack.size() == 0) return false;
                if(c != map.get(stack.pop())){
                    return false;
                }
            }
        }
        return stack.size() == 0;
    }
}
