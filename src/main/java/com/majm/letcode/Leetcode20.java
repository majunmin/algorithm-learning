package com.majm.letcode;

import com.majm.Solution;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 1. 暴力求解
 * 2. 利用栈的特点 stack
 * @author majunmin
 * @description
 * @datetime 2020/10/26 7:36 下午
 * @since
 */
public class Leetcode20 implements Solution {


    /**
     * 1. 栈的方式  时间复杂度 O(n)
     * @param s
     * @return
     */
    @Override
    public boolean isValid(String s) {
//        if (s == null || "".equals(s)){
//            return false;
//        }
//        int len = s.length();
//        if (len % 2 == 1) return false;
//
//        Map<Character, Character> map = new HashMap<>();
//        map.put(')', '(');
//        map.put(']', '[');
//        map.put('}', '{');
//
//        Stack<Character> stack = new Stack<>();
//
//        for (int i = 0; i < len; i++) {
//            Character c = s.charAt(i);
//
//            if (map.containsKey(c)){
//                if (stack.isEmpty() || !stack.peek().equals(map.get(c))) {
//                    return false;
//                }
//                stack.pop();
//            } else {
//                stack.push(c);
//            }
//        }
//
//        return stack.isEmpty();

        // 2.
//        if (s == null || "".equals(s)){
//            return false;
//        }
//        int len = s.length();
//        if (len % 2 == 1) return false;
//
//        Map<Character, Character> map = new HashMap<>();
//        map.put(')', '(');
//        map.put(']', '[');
//        map.put('}', '{');
//
//        Stack<Character> stack = new Stack<>();
//
//        for (int i = 0; i < len; i++) {
//            Character c = s.charAt(i);
//            if (map.containsKey(c)){
//                stack.push(map.get(c));
//            } else if (stack.isEmpty() || !stack.peek().equals(c)) {
//                return false;
//            } else {
//                stack.pop();
//            }
//
//        }
//
//        return stack.isEmpty();

        // 3.
        while (s.contains("()") || s.contains("[]") || s.contains("{}")){
            s = s.replace("()", "");
            s = s.replace("[]", "");
            s = s.replace("{}", "");
        }
        return s.isEmpty();

    }

}
