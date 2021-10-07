package com.majm.leetcode;

import com.majm.Solution;

/**
 * 154. 寻找旋转排序数组中的最小值 II </br>
 * https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii/
 *
 * @author majunmin
 * @description
 * @datetime 2021-07-03 11:49
 * @since
 */
public class LeetCode_0154 implements Solution {

    @Override
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] <= nums[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return nums[left];
    }
}
