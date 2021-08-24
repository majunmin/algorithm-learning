package com.majm.leetcode;

import com.majm.Solution;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 一句话功能简述 </br>
 *
 * @author majunmin
 * @description
 * @datetime 2021-07-29 22:39
 * @since
 */
public class LeetCode_0045 implements Solution {

    /**
     * @param nums
     * @return
     */
    @Override
    public int jump(int[] nums) {
        int step = 0;
        int end = 0;
        int maxPosition = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] + i > maxPosition) {
                maxPosition = nums[i] + i;
            }
            if (i == end) {
                end = maxPosition;
                step++;
            }
        }
        return step;
    }


    /**
     * 正搜索
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     *
     * @param nums
     * @return
     */
    private int solution(int[] nums) {
        //边界条件--
        int maxPosition = 0;
        int end = 0; // 边界 (可以计算得出达到这个边界的最小步数)
        int step = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxPosition = Math.max(i + nums[i], maxPosition);
            if (i == end) {
                // 更新边界条件
                end = maxPosition;
                step++;
            }
        }
        return step;
    }


    /**
     * 反向查找出发位置
     * <p>
     * 时间复杂度: O(N^2)
     * 空间复杂度: O(1)
     *
     * @param nums
     * @return
     */
    private int solution1(int[] nums) {
        //  边界条件
        if (nums.length < 2) {
            return 0;
        }

        int end = nums.length - 1;
        int cnt = 0;
        while (end > 0) {
            for (int i = 0; i < end; i++) {
                if (nums[i] + i >= end) {
                    end = i;
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        final LeetCode_0045 leetCode = new LeetCode_0045();
//        System.out.println(leetCode.jump(new int[]{}));
        System.out.println(leetCode.jump(new int[]{4}));
        System.out.println(leetCode.jump(new int[]{2, 3, 0, 1, 4}));
        System.out.println(leetCode.jump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(leetCode.jump(new int[]{2, 3, 0, 0, 4}));
    }

}
