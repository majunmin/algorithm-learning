package com.majm.leetcode;

import com.majm.Solution;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * 1. 暴力求解
 * 2. 利用栈的特点 stack
 *
 * @author majunmin
 * @description
 * @datetime 2020/10/26 7:36 下午
 * @since
 */
public class Leetcode20 implements Solution {


    /**
     * 1. 栈的方式  时间复杂度 O(n)
     *
     * @param s
     * @return
     */
    @Override
    public boolean isValid(String s) {

        return solution2(s);

    }


    public boolean solution2(String s) {
        if (s == null || s.length() == 0 || s.length() % 2 == 1) {
            return false;
        }

        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');

        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            if (map.containsKey(sc)) {
                stack.push(sc);
            } else {
                if (stack.isEmpty() || !map.get(stack.peek()).equals(sc)) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    /**
     * 巧妙的求解方法
     *
     * @param s
     * @return
     */
    public boolean solution1(String s) {
        if (s == null || "".equals(s)) {
            return false;
        }
        int len = s.length();
        if (len % 2 == 1) {
            return false;
        }
        while (s.contains("()") || s.contains("[]") || s.contains("{}")) {
            s = s.replace("()", "");
            s = s.replace("[]", "");
            s = s.replace("{}", "");
        }
        return s.isEmpty();
    }

}
