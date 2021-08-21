package com.majm.leetcode;

import com.majm.Solution;

import java.util.Arrays;

/**
 * 322. 零钱兑换 </br>
 *
 * @author majunmin
 * @description
 * @datetime 2021-07-18 14:48
 * @since
 */
public class LeetCode_0322 implements Solution {

    /**
     * @param coins
     * @param amount
     * @return
     */
    @Override
    public int coinChange(int[] coins, int amount) {
        return dpSolution(coins, amount);
    }

    private int dpSolution(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                // condition
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }


    /**
     * 递归 + 记忆化搜索🔍
     *
     * @param coins
     * @param amount
     * @return
     */
    private int solution1(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        return recurHelper(coins, amount, new int[amount + 1]);
    }

    /**
     * 找到重复子问题
     * 记忆化搜索
     *
     * @param coins
     * @param amount
     * @param cache
     * @return
     */
    private int recurHelper(int[] coins, int amount, int[] cache) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }
        if (cache[amount] != 0) {
            return cache[amount];
        }

        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = recurHelper(coins, amount - coin, cache);
            if (res >= 0 && res < min) {
                min = res + 1;
            }
        }
        // assemble cache
        cache[amount] = min == Integer.MAX_VALUE ? -1 : min;
        return cache[amount];
    }

    /**
     * 超时
     * 递归解法, 非带记忆化递归,很多重复计算
     *
     * @param coins
     * @param amount
     * @return
     */
    private int recurSolution(int[] coins, int amount) {
        // terminate
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = coinChange(coins, amount - coin);
            if (res >= 0) {
                min = Math.min(min, res);
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min + 1;
    }


    public static void main(String[] args) {
        LeetCode_0322 leetCode = new LeetCode_0322();
//        System.out.println(leetCode.coinChange(new int[]{1}, 1));
        System.out.println(leetCode.coinChange(new int[]{2}, 3));
        System.out.println(leetCode.coinChange(new int[]{1, 2, 5}, 10));
        System.out.println(leetCode.coinChange(new int[]{1, 2, 5}, 9));
        System.out.println(leetCode.coinChange(new int[]{1, 2, 5}, 6));
        System.out.println(leetCode.coinChange(new int[]{1, 2, 5}, 11));
//        System.out.println(leetCode.coinChange(new int[]{186, 419, 83, 408}, 6249));
    }

}
