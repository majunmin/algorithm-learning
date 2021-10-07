package com.majm.leetcode;

import com.majm.Solution;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 224. 基本计算器 </br>
 * https://leetcode-cn.com/problems/basic-calculator/
 *
 * @author majunmin
 * @description
 * @datetime 2021-09-24 18:12
 * @since
 */
public class LeetCode_0224 implements Solution {

    private Deque<Character> opStack = new LinkedList<>();
    private Deque<Integer> numStack = new LinkedList<>();

    @Override
    public int calculate(String s) {
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (aChar == ' ') {
                continue;
            }
            if (aChar >= '0' && aChar <= '9') {
                numStack.push(aChar - '0');
            }
            if (aChar == '+' || aChar == '-' || aChar == '(') {
                opStack.push(aChar);
            }
            if (aChar == ')') {

            }
        }
        // todo
        return 0;
    }
}
