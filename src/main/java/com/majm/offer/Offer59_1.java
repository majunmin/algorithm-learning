package com.majm.offer;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 剑指 Offer 59 - I. 滑动窗口的最大值 </br>
 * https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof/
 *
 * @author majunmin
 * @description
 * @datetime 2021-10-10 15:35
 * @since
 */
public class Offer59_1 {

    /**
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {

        // param check
        if (nums == null || k < 0 || k > nums.length) {
            throw new IllegalArgumentException("");
        }
        int len = nums.length;

        if (k == 1) {
            return nums;
        }
        if (len == 0) {
            return new int[0];
        }

        // 单调递减栈解法
        int[] result = new int[len - k + 1];
        int index = 0;

        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            putElement(stack, i, nums);
        }
        result[index++] = nums[stack.peekLast()];

        for (int i = k; i < len; i++) {
            // 将 窗口外的值移除
            if (stack.getLast() <= i - k) {
                stack.removeLast();
            }
            putElement(stack, i, nums);
            result[index++] = nums[stack.peekLast()];
        }

        return result;
    }

    private void putElement(Deque<Integer> stack, int i, int[] nums) {
        while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
            stack.pop();
        }
        stack.push(i);
    }

    public static void main(String[] args) {
        final Offer59_1 offer = new Offer59_1();
        System.out.println(Arrays.toString(offer.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
    }
}
