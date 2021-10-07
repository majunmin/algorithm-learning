package com.majm.leetcode;

import com.majm.Solution;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 每日温度 </br>
 *
 * @author majunmin
 * @description
 * @datetime 2021-06-18 19:39
 * @since
 */
public class LeetCode_0739 implements Solution {

    @Override
    public int[] dailyTemperatures(int[] temperatures) {
        if (temperatures == null) {
            return new int[]{};
        }


        Deque<Integer> stack = new LinkedList<>();
        int[] result = new int[temperatures.length];

        int len = temperatures.length;
        //用一个单调递减栈
        for (int i = len - 1; i >= 0; i--) {
            while (!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) {
                stack.pop();
            }
            result[i] = stack.isEmpty() ? 0 : stack.peek();
            stack.push(i);
        }
        return result;
    }


    /**
     * 每日温度  单调栈解法
     * 时间复杂度:
     * 空间复杂度:
     *
     * @param temperatures
     * @return
     */
    private int[] stackSolution(int[] temperatures) {
        if (temperatures == null) {
            return new int[]{};
        }
        if (temperatures.length == 1) {
            return new int[]{1};
        }

        // 单调栈解决
        int[] result = new int[temperatures.length];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = temperatures.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) {
                stack.pop();
            }
            result[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }
        return result;
    }
}
