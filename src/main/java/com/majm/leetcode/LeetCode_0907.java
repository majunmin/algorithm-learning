package com.majm.leetcode;

import com.majm.Solution;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 子数组 </br>
 *
 * @author majunmin
 * @description
 * @datetime 2021-06-24 23:29
 * @since
 */
public class LeetCode_0907 implements Solution {

    @Override
    public int sumSubarrayMins(int[] arr) {
        return solution1(arr);
    }

    /**
     * 单调栈解法
     * <p>
     * 排列组合的思想,  左边第一个比 cur 小的索引 left, 右边第一个比cur  大的索引
     * sum +=  cur * (curIdx - left)*(right - curIdx)
     *
     * @param arr
     * @return
     */
    private int solution1(int[] arr) {
        int len = arr.length;
        int[] left = new int[len];
        int[] right = new int[len];

        // 单调递增栈
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                left[i] = -1;
            } else {
                left[i] = stack.peek();
            }
            stack.push(i);
        }

        stack.clear();
        for (int i = len - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                right[i] = len;
            } else {
                right[i] = stack.peek();
            }
            stack.push(i);
        }

        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += arr[i] * (i - left[i]) * (right[i] - i);
        }
        return sum % 1_000_000_007;

    }


    /**
     * 暴力解法
     * 时间复杂度: O(N)
     * 空间复杂度: O(N)
     *
     * @param arr
     * @return
     */
    private int solution(int[] arr) {
        int sum = 0;
        for (int right = 0; right < arr.length; right++) {
            for (int left = right; left >= 0; left--) {
                sum += min(arr, left, right);
            }
        }
        return sum % (1_000_000_007);
    }

    private int min(int[] arr, int left, int right) {
        int minVal = arr[left];
        for (int i = left + 1; i <= right; i++) {
            minVal = Math.min(minVal, arr[i]);
        }
        return minVal;
    }


    public static void main(String[] args) {
        final LeetCode_0907 leetCode = new LeetCode_0907();
        System.out.println(leetCode.sumSubarrayMins(new int[]{71, 55, 82, 55}));
    }
}
