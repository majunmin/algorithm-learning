package com.majm.leetcode;

import com.majm.Solution;

/**
 * 1567. 乘积为正数的最长子数组长度 </br>
 * <p>
 * https://leetcode-cn.com/problems/maximum-length-of-subarray-with-positive-product/
 *
 * @author majunmin
 * @description
 * @datetime 2021-08-26 18:07
 * @since
 */
public class LeetCode_1567 implements Solution {


    @Override
    public int getMaxLen(int[] nums) {
        return dpSolution2(nums);
    }

    /**
     * 动态规划的 第二种写法
     *
     * @param nums
     * @return
     */
    private int dpSolution2(int[] nums) {

        // dp[*][0] 表示 以* 为结尾的 乘积正数的个数
        // dp[*][1] 表示 以* 为结尾的 乘积负数的个数
        int[][] dp = new int[nums.length][2];
        dp[0][0] = nums[0] > 0 ? 1 : 0;
        dp[0][1] = nums[0] < 0 ? 1 : 0;

        int result = dp[0][0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0) {
                dp[i][0] = dp[i - 1][0] + 1;
                // dp[i - 1][1] > 0  : 存在 表示 以 i-1 为结尾的 乘积为负数的(负数 * 正数)， 否则 就是 0
                dp[i][1] = dp[i - 1][1] > 0 ? dp[i - 1][1] + 1 : 0;
            } else if (nums[i] < 0) {
                dp[i][1] = dp[i - 1][0] + 1;
                // 与上边一个道理, 看 以i-1即为结尾的是否包含乘积为负数(负数 * 负数)
                dp[i][0] = dp[i - 1][1] > 0 ? dp[i - 1][1] + 1 : 0;
            }
            result = Math.max(result, dp[i][0]);
        }
        return result;
    }

    /**
     * 动态 规划
     *
     * @param nums
     * @return
     */
    private int solution1(int[] nums) {
        // 贪心算法   动态规划
        int[] positiveArr = new int[nums.length];
        int[] negativeArr = new int[nums.length];
        positiveArr[0] = nums[0] > 0 ? 1 : 0;
        negativeArr[0] = nums[0] < 0 ? 1 : 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0) {
                positiveArr[i] = positiveArr[i - 1] + 1;
                negativeArr[i] = negativeArr[i - 1] > 0 ? negativeArr[i - 1] + 1 : 0;
            } else if (nums[i] < 0) {
                negativeArr[i] = positiveArr[i - 1] + 1;
                positiveArr[i] = negativeArr[i - 1] > 0 ? negativeArr[i - 1] + 1 : 0;
            }
        }
        int maxLen = positiveArr[0];
        for (int i = 1; i < positiveArr.length; i++) {
            maxLen = Math.max(maxLen, positiveArr[i]);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        Solution leetCode = new LeetCode_1567();
        System.out.println(leetCode.getMaxLen(new int[]{-1, -2, -3, 0}));
        System.out.println(leetCode.getMaxLen(new int[]{1, 2, 3, 5, -6, 4, 0, 10}));
        System.out.println(leetCode.getMaxLen(new int[]{1, -2, -3, 4}));
        System.out.println(leetCode.getMaxLen(new int[]{-1, 2}));
        System.out.println(leetCode.getMaxLen(new int[]{-1}));
        System.out.println(leetCode.getMaxLen(new int[]{2}));
        System.out.println(leetCode.getMaxLen(new int[]{2, 0, 1}));
    }

}
