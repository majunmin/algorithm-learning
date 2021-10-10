package com.majm.offer;

/**
 * 剑指 Offer 14- I. 剪绳子 </br>
 * https://leetcode-cn.com/problems/jian-sheng-zi-lcof/
 *
 * @author majunmin
 * @description
 * @datetime 2021-09-18 09:59
 * @since
 */
public class Offer14_1 {

    /**
     * 动态规划
     *
     * @param n
     * @return
     */
    public int cuttingRope(int n) {
        // 1. 定义状态
        // dp[i] 长度为 i 的绳子 剪裁后的最大乘积
        // 2. 状态转译
        // dp[i] = max(dp[i], j * (i  - j), j * dp[i - j])
        if (n == 2 || n == 1) {
            return n;
        }
        int[] dp = new int[n + 1];
        for (int i = 3; i < dp.length; i++) {
            for (int j = 2; j < i; j++) {
                dp[i] = Math.max(dp[i], j * (i - j));
                dp[i] = Math.max(dp[i], j * dp[i - j]);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        final Offer14_1 offer = new Offer14_1();
        System.out.println(offer.cuttingRope(12));
        System.out.println(offer.cuttingRope(10));
    }
}
