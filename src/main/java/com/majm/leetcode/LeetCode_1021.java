package com.majm.leetcode;

import com.majm.Solution;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author majunmin
 * @description
 * @datetime 2020/10/29 12:18 上午
 * @since
 */
public class LeetCode_1021 implements Solution {

    @Override
    public String removeOuterParentheses(String s) {
        /**
         * 时间复杂度: O(N)
         * 空间复杂度: O(N)
         */
        StringBuilder result = new StringBuilder();
        Deque<Character> stack = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                if (!stack.isEmpty()) {
                    result.append(c);
                }
                stack.push(c);
            } else {
                stack.pop();
                if (!stack.isEmpty()) {
                    result.append(c);
                }
            }
        }
        return result.toString();
    }

    /**
     * 指针法 遍历
     *
     * @param s
     * @return
     */
    private String solution2(String s) {
        int count = 0;
        StringBuilder sBuilder = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '('){
                if (count++ > 0){
                    sBuilder.append(c);
                }
            } else {
                if (count-- > 1){
                    sBuilder.append(c);
                }
            }
        }
        return sBuilder.toString();
    }

    /**
     * 栈
     * <p>
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     *
     * @param s
     * @return
     */
    private String solution1(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        StringBuilder sBuilder = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                if (!stack.isEmpty()) {
                    sBuilder.append(c);
                }
                stack.push(c);
            } else {
                stack.pop();
                if (!stack.isEmpty()) {
                    sBuilder.append(c);
                }
            }

        }
        return sBuilder.toString();
    }
}
