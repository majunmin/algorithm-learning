package com.majm.leetcode;

import com.majm.Solution;

/**
 * 122. 买卖股票的最佳时机 II </br>
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 *
 * @author majunmin
 * @description
 * @datetime 2021-08-01 15:25
 * @since
 */
public class LeetCode_0122 implements Solution {


    private int result;

    @Override
    public int maxProfit(int[] prices) {
        // 定义好状态 0 持有现金 1. 持有股票
        int cash = 0;
        int hold = -prices[0];
        int preCash = cash;
        int preHold = hold;
        for (int i = 1; i < prices.length; i++) {
            cash = Math.max(preCash, preHold + prices[i]);
            hold = Math.max(preHold, preCash - prices[i]);
            preCash = cash;
            preHold = hold;
        }
        return cash;
    }


    /**
     * 解法2 相对于解法1 优化空间
     * 不用数组表示,而是使用  变量表示
     *
     * @param prices
     * @return
     */
    private int solution3(int[] prices) {
        int len = prices.length;
        int cash = 0;
        int hold = -prices[0];
        int preCrash = cash;
        int preHold = hold;
        for (int i = 0; i < len; i++) {
            cash = Math.max(preCrash, hold + prices[i]);
            hold = Math.max(preHold, cash - prices[i]);
        }
        return cash;
    }

    /**
     * 解法1.2
     *
     * @param prices
     * @return
     */
    private int solution2(int[] prices) {
        int len = prices.length;
        int[] crash = new int[len];
        int[] hold = new int[len];
        crash[0] = 0;
        hold[0] = -prices[0];
        for (int i = 1; i < len; i++) {
            crash[i] = Math.max(crash[i - 1], hold[i - 1] + prices[i]);
            hold[i] = Math.max(hold[i - 1], crash[i - 1] - prices[i]);
        }
        return crash[len - 1];
    }

    /**
     * 解法1.1
     *
     * @param prices
     * @return
     */
    private int solution1(int[] prices) {
        // 每天结束交易后, 状态为 手里有股票, 和手里没股票
        // dp[i][0] 表示第i天交易后,手里没有股票的最大收益  (前一天卖出的 或者 今天卖出)
        // dp[i][0] = max(d[i-1][0], dp[i-1][1] + prices[i])
        // dp[i][1] 表示第i天交易后,手里持有股票的 买入的状态 (前一天买入的 或者是 今天买入)
        // dp[i][1] = max(dp[i-1][1], dp[i-1][0] - prices[i])
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            // 今天卖出持有现金最大值
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            // 今天买入持有现金最大值
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[dp.length - 1][0];
    }

    public static void main(String[] args) {
        final LeetCode_0122 leetCode = new LeetCode_0122();
        System.out.println(leetCode.maxProfit(new int[]{5, 2, 3, 2, 6, 6, 2, 9, 1, 0, 7, 4, 5, 0}));
        System.out.println(leetCode.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));

        System.out.println(leetCode.maxProfit(new int[]{1, 2, 3, 4, 5}));
    }
}
