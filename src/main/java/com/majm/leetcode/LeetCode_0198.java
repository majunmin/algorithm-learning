package com.majm.leetcode;

import com.majm.Solution;

/**
 * 198. 打家劫舍 </br>
 * https://leetcode-cn.com/problems/house-robber/
 *
 * @author majunmin
 * @description
 * @datetime 2021-07-24 23:15
 * @since
 */
public class LeetCode_0198 implements Solution {

    @Override
    public int rob(int[] nums) {

        return dpSolution2(nums);
    }

    /**
     * 优化空间
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     *
     * @param nums
     * @return
     */
    private int dpSolution2(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        // 优化空间 dp
        int p = 0;
        int q = nums[0];
        int ret = nums[0];
        for (int i = 2; i <= nums.length; i++) {
            ret = Math.max(p + nums[i - 1], q);
            p = q;
            q = ret;
        }
        return ret;
    }

    /**
     * 基础版本的动态规划
     *
     * @param nums
     * @return
     */
    private int solution11(int[] nums) {
        final int len = nums.length;
        int[][] dp = new int[len][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][1], dp[i - 1][0]);
            dp[i][1] = dp[i - 1][0] + nums[i];
        }
        return Math.max(dp[len - 1][0], dp[len - 1][1]);
    }

    /**
     * 动态规划 1   常规的动态规划 求最大值
     *
     * @param nums
     * @return
     */
    private int arrDpSolution(int[] nums) {
        if (nums.length == 1) {
            return nums[1];
        }
        // dp[i] = max(dp[i-1], dp[i-2] + nums[i])  i >= 2
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[1], dp[0]);
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[dp.length - 1];
    }

    /**
     * 用两个数组实现动态规划
     *
     * @param nums
     * @return
     */
    private int solution1(int[] nums) {
        int[] dp0 = new int[nums.length]; //偷的最大金额
        int[] dp1 = new int[nums.length]; // 不偷的最大金额

        dp0[0] = nums[0];
        dp1[0] = 0;

        for (int i = 1; i < nums.length; i++) {
            dp0[i] = dp1[i - 1] + nums[i];
            dp1[i] = Math.max(dp0[i - 1], dp1[i - 1]);
        }
        return Math.max(dp0[nums.length - 1], dp1[nums.length - 1]);
    }

    public static void main(String[] args) {
        final LeetCode_0198 leetCode = new LeetCode_0198();
        System.out.println(leetCode.rob(new int[]{5}));
        System.out.println(leetCode.rob(new int[]{1, 2, 3, 1}));
        System.out.println(leetCode.rob(new int[]{2, 1, 1, 2}));
        System.out.println(leetCode.rob(new int[]{2, 7, 9, 3, 1}));
    }
}
