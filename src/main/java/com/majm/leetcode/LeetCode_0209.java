package com.majm.leetcode;

import com.majm.Solution;

/**
 * leetcode 209 </br>
 *
 * @author majunmin
 * @description
 * @datetime 2021-06-28 00:19
 * @since
 */
public class LeetCode_0209 implements Solution {

    @Override
    public int minSubArrayLen(int target, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int winSum = 0, left = 0, right = 0;
        int len = nums.length;
        int result = len;
        while (right < len) {
            winSum += nums[right];
            while (left < right && winSum - nums[left] >= target) {
                winSum -= nums[left++];
            }

            if (winSum >= target) {
                result = Math.min(result, right - left + 1);
            }
            right++;
        }
        if (winSum < target){
            return 0;
        }
        return result;
    }
}
