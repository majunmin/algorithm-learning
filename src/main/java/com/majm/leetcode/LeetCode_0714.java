package com.majm.leetcode;

import com.majm.Solution;

/**
 * 714. 买卖股票的最佳时机含手续费 </br>
 *
 * @author majunmin
 * @description
 * @datetime 2021-08-28 12:15
 * @since
 */
public class LeetCode_0714 implements Solution {

    @Override
    public int maxProfit(int[] prices, int fee) {
        return 0;
    }

    /**
     * 动态规划 ,优化空间的写法
     *
     * @param prices
     * @param fee
     * @return
     */
    private int dpSolution2(int[] prices, int fee) {
        int cash = 0;
        int stock = -fee - prices[0];
        // 无后效性, dp[i][x] 仅与 dp[i-1][x] 有关
        for (int i = 1; i < prices.length; i++) {
            int preCash = cash;
            int preStock = stock;
            cash = Math.max(preCash, preStock + prices[i]);
            stock = Math.max(preStock, preCash - prices[i] - fee);
        }
        return cash;
    }


    private int dpSolution(int[] prices, int fee) {
        // dp[i][0] : 持有现金的现金最大值, (cash)
        // dp[i][1] : 持有股票时的现金最大值, (stock)
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = prices[0] - fee;
        for (int i = 1; i < prices.length; i++) {
            // 卖出
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i] - fee);
        }
        return dp[dp.length - 1][0];
    }
}
