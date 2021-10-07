package com.majm.leetcode;

import com.majm.Solution;

/**
 * 一句话功能简述 </br>
 *
 * @author majunmin
 * @description
 * @datetime 2021-07-03 10:37
 * @since
 */
public class LeetCode_0153 implements Solution {


    @Override
    public int findMin(int[] nums) {

        if (nums == null || nums.length == 0) {
            return -1;
        }
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (nums[mid] > nums[left]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }

    public int findMax(int[] nums) {

        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (nums[mid] > nums[left]) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return nums[left - 1];
    }

    public static void main(String[] args) {
        final LeetCode_0153 leetCode = new LeetCode_0153();
        System.out.println(leetCode.findMin(new int[]{4, 5, 6, 7, 1, 2, 3}));
    }


}
