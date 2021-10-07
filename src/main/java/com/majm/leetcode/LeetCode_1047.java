package com.majm.leetcode;

import com.majm.Solution;

import java.util.ArrayDeque;

/**
 * 1047. 删除字符串中的所有相邻重复项 </br>
 *
 * @author majunmin
 * @description
 * @datetime 2021-06-24 00:11
 * @since
 */
public class LeetCode_1047 implements Solution {

    @Override
    public String removeDuplicates(String s) {
        StringBuilder sBuilder = new StringBuilder();
        int top = -1; // 表示 stack is empty
        for (char c : s.toCharArray()) {
            if (top == -1 || sBuilder.charAt(top) != c) {
                sBuilder.append(c);
                top++;
            } else {
                sBuilder.deleteCharAt(top);
                top--;
            }

        }
        return sBuilder.toString();
    }

    /**
     * Stack 解法
     *
     * @param s
     * @return
     */
    private String stackSolution(String s) {
        final ArrayDeque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (stack.isEmpty() || c != stack.peek()) {
                stack.push(c);
            } else {
                stack.pop();
            }
        }

        String result = "";
        while (!stack.isEmpty()) {
            final Character c = stack.pop();
            result = c + result;
        }
        return result;
    }

}
