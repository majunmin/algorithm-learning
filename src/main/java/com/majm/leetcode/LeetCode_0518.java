package com.majm.leetcode;

import com.majm.Solution;

/**
 * 518. 零钱兑换 II </br>
 *
 * @author majunmin
 * @description
 * @datetime 2021-09-09 22:02
 * @since
 */
public class LeetCode_0518 implements Solution {


    /**
     * @param amount
     * @param coins
     * @return
     */
    @Override
    public int change(int amount, int[] coins) {
        return dpSolution1(amount, coins);
    }


    /**
     * 二维数组 动态规划
     * 1. 定义状态
     * f[i][j] : 从 前 i 种硬币中选择,组成总和为 j 的 所有选法集合方案数
     * f[n][amount]: 就表示表示从前n种硬币中选，且总金额恰好为amount的所有选法集合的方案,也就是最后的答案
     * <p>
     * 2. 状态转移
     * 如果 第 i种硬币选 k个
     * f[i][j] = f[i-1][j-coins[i] * k]
     * <p>
     * f[i][j] = f[i-1][j] + f[i-1][j-coins[i]] + f[i-1][j-coins[i]*2]....+ f[i-1][j -coins[i]*k] // coins[i] * k < j
     * <p>
     * 3. init
     * f[0][0] = 1
     *
     * @param amount
     * @param coins
     * @return
     */
    private int dpSolution1(int amount, int[] coins) {
        int len = coins.length;
        int[][] f = new int[len + 1][amount + 1];
        f[0][0] = 1;
        for (int i = 1; i <= len; i++) {
            int v = coins[i - 1];
            for (int j = 0; j <= amount; j++) {
                for (int k = 0; k * v <= j; k++) {
                    f[i][j] += f[i - 1][j - v * k];
                }
            }
        }
        return f[len][amount];
    }


    /**
     * f[i][j] = f[i-1][j] + f[i][j-v]
     * <p>
     * f[j] = f[j] + f[j-v]
     *
     * @param amount
     * @param coins
     * @return
     */
    private int dpSolution2(int amount, int[] coins) {
        int[] f = new int[amount + 1];
        f[0] = 1;
        for (int i = 1; i <= coins.length; i++) {
            int v = coins[i - 1];
            for (int j = v; j <= amount; j++) {
                f[j] += f[j - v];
            }
        }
        return f[amount];
    }

}
