package com.majm.leetcode;

import com.majm.Solution;

/**
 * 53. 最大子序和 </br>
 * https://leetcode-cn.com/problems/maximum-subarray/
 *
 * @author majunmin
 * @description
 * @datetime 2021-07-14 13:08
 * @since
 */
public class LeetCode_0053 implements Solution {

    @Override
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = Math.max(0, nums[0]);
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(0, Math.max(nums[i], nums[i] + dp[i-1]));
            result = Math.max(result, dp[i]);
        }
        return result;
    }

    /**
     * https://leetcode-cn.com/problems/maximum-subarray/solution/hua-jie-suan-fa-53-zui-da-zi-xu-he-by-guanpengchn/
     *
     * @param nums
     * @return
     */
    private int solution3(int[] nums) {
        int result = nums[0];
        int sum = 0;
        // if sum > 0 , 有增益, 保留并加上之前的数字
        // if sum < 0 , 无增益, 需要舍弃
        for (int num : nums) {
            if (sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            result = Math.max(result, sum);
        }
        return result;
    }

    private int maxSubSolution(int[] nums) {

        int result = nums[0];
        int prev = 0;
        for (int num : nums) {
            prev = Math.max(prev + num, num);
            result = Math.max(result, prev);
        }
        return result;
    }

    /**
     * 动态规划解法
     * 空间复杂度: O(N)
     * 时间复杂度: O(N)
     *
     * @param nums
     * @return
     */
    private int dpSolution(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (dp[i - 1] > 0) {
                dp[i] = dp[i - 1] + nums[i];
            } else {
                dp[i] = nums[i];
            }
        }
        int max = dp[0];
        // findMax
        for (int i = 1; i < dp.length; i++) {
            max = Math.max(dp[i], max);
        }
        return max;
    }

    public static void main(String[] args) {
        final LeetCode_0053 leetCode = new LeetCode_0053();
        System.out.println(leetCode.maxSubArray(new int[]{-1}));
        System.out.println(leetCode.maxSubArray(new int[]{-3, 1, 3}));
        System.out.println(leetCode.maxSubArray(new int[]{-3, -2}));
    }
}
