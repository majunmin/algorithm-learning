package com.majm.leetcode;

import com.majm.Solution;

/**
 * 123. 买卖股票的最佳时机 III </br>
 *
 * @author majunmin
 * @description
 * @datetime 2021-08-30 00:38
 * @since
 */
public class LeetCode_0123 implements Solution {


    @Override
    public int maxProfit(int[] prices) {
        // 定义状态
        // dp[i][j][k]
        // i: 第i天
        // j: 0,1,2 第j次交易
        // k: 0，1 1 持有股票
        int len = prices.length;
        int[][][] dp = new int[len][3][2];
        // init
        dp[0][0][0] = 0;
        dp[0][0][1] = 0; // 不可能
        dp[0][1][0] = 0;
        dp[0][1][1] = -prices[0];
        dp[0][2][0] = 0;// 不可能
        dp[0][2][1] = Integer.MAX_VALUE; // 不可能
        // dp
        for (int i = 1; i < len; i++) {
            dp[i][1][0] = Math.max(dp[i - 1][1][0], dp[i - 1][1][1] + prices[i]);
            dp[i][1][1] = Math.max(dp[i - 1][1][1], -prices[i]);
            dp[i][2][0] = Math.max(dp[i - 1][2][0], dp[i - 1][2][1] + prices[i]);
            dp[i][2][1] = Math.max(dp[i - 1][2][1], dp[i - 1][1][0] - prices[i]);
        }
        return Math.max(dp[len - 1][1][0], dp[len - 1][2][0]);
    }
}
