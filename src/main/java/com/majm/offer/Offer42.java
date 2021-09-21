package com.majm.offer;

/**
 * 剑指 Offer 42. 连续子数组的最大和 </br>
 * https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/
 *
 * @author majunmin
 * @description
 * @datetime 2021-09-21 19:18
 * @since
 */
public class Offer42 {

    /**
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        if (nums == null) {
            return -1;
        }
        // dp[i] : 以 i 为结尾的连续子数组最大和
        // dp[i] = max(dp[i-1] + nums[i], nums[i])
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        int result = nums[0];
        for (int i = 1; i < len; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            result = Math.max(result, dp[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        Offer42 offer = new Offer42();
        System.out.println(offer.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}
