package com.majm.leetcode;

import com.majm.Solution;

import java.util.Arrays;

/**
 * 213. 打家劫舍 II </br>
 * https://leetcode-cn.com/problems/house-robber-ii/
 *
 * @author majunmin
 * @description
 * @datetime 2021-07-25 08:13
 * @since
 */
public class LeetCode_0213 implements Solution {

    /**
     * @param nums
     * @return
     */
    @Override
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        // 偷第一家, 直到倒数第二家
        int ret1 = robHelper(Arrays.copyOfRange(nums, 0, nums.length - 1));
        // 偷第二家, 直到倒数第一家
        int ret2 = robHelper(Arrays.copyOfRange(nums, 1, nums.length));
        return Math.max(ret1, ret2);
    }

    private int robHelper(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }
        return dp[dp.length - 1];
    }

    private int solution1(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        // 两次动态规划
        // dp[i] = max(dp[i-1], dp[i-2] + nums[i]) i>2
        int[] dp = new int[nums.length - 1];
        // 偷第一家, 那么最后一家就不能偷,偷到倒数第二家
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0], nums[1]);
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        int ret1 = dp[dp.length - 1];

        //不 偷第一家,就从第二家开始偷,直到最后一家 那么最后一家就不能偷
        dp[0] = nums[1];
        dp[1] = Math.max(dp[0], nums[2]);
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i + 1]);
        }
        return Math.max(ret1, dp[dp.length - 1]);
    }

    public static void main(String[] args) {
        final Solution leetCode = new LeetCode_0213();
        System.out.println(leetCode.rob(new int[]{2}));
        System.out.println(leetCode.rob(new int[]{2, 3, 2}));
        System.out.println(leetCode.rob(new int[]{1, 2, 3, 2}));
        System.out.println(leetCode.rob(new int[]{1, 2, 3}));
    }

}
