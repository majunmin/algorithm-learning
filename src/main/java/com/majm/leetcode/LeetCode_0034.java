package com.majm.leetcode;

import com.majm.Solution;

/**
 * 一句话功能简述 </br>
 *
 * @author majunmin
 * @description
 * @datetime 2021-06-20 22:36
 * @since
 */
public class LeetCode_0034 implements Solution {

    private final static int[] EMPTY_RESULT = new int[]{-1, -1};

    @Override
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return EMPTY_RESULT;
        }

        int left = searchLeft(nums, target);
        if (nums[left] != target){
            return EMPTY_RESULT;
        }
        int right = searchRight(nums, target);
        return new int[]{left, right};
    }

    private int searchRight(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        // 退出循环后有  left == right 成立
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return left;
    }

    private int searchLeft(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        // 退出循环后有  left == right 成立
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
