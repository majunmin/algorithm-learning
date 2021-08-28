package com.majm.leetcode;

import com.majm.Solution;

/**
 * 309. 最佳买卖股票时机含冷冻期</br>
 *
 * @author majunmin
 * @description
 * @datetime 2021-08-02 22:02
 * @since
 */
public class LeetCode_0309 implements Solution {

    @Override
    public int maxProfit(int[] prices) {
        return dpSolution2(prices);
    }

    /**
     * 优化空间的写法
     *
     * @param prices
     * @return
     */
    private int dpSolution2(int[] prices) {
        int stock = -prices[0];
        int freezeCash = 0;
        int cash = 0;

        int preStock = stock;
        int preFreezeCash = freezeCash;
        int preCash = cash;
        for (int i = 1; i < prices.length; i++) {
            stock = Math.max(preStock, preFreezeCash - prices[i]);
            freezeCash = cash;
            cash = Math.max(preCash, preStock + prices[i]);
            preStock = stock;
            preFreezeCash = freezeCash;
            preCash = cash;
        }
        return Math.max(cash, freezeCash);
    }


    private int dpSolution(int[] prices) {
        // 1. 定义状态
        // 2. 寻找状态转移方程
        int[][] dp = new int[prices.length][3];
        // d[i][0] : 持有股票   (之前没有持有股票, 或者之前处于冷冻期)
        // d[i][1] : 持有现金,处于冷冻期 (之前 刚卖出,持有现金,不处于冷冻期)
        // d[i][2] : 持有现金,不处于冷冻期 (之前就处于持有现金不处于冷冻期, 或者之前持有股票)
        // 状态转译方程
        // 1. dp[i][0] = max(dp[i-1][0], dp[i-1][1] - prices[i])
        // 2. dp[i][1] = dp[i-1][2]
        // 3. dp[i][2] = max(dp[i-1][2], dp[i-1][0] + prices[i])
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        dp[0][2] = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            dp[i][1] = dp[i - 1][2];
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][0] + prices[i]);
        }
        return Math.max(dp[dp.length - 1][1], dp[dp.length - 1][2]);
    }

}
