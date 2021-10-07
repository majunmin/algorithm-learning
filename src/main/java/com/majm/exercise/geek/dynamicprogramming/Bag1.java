package com.majm.exercise.geek.dynamicprogramming;

/**
 * 0-1 背包🎒简单版 </br>
 *
 * @author majunmin
 * @description
 * @datetime 2021-09-11 22:03
 * @since
 */
public class Bag1 {


    /**
     * 对于一组不同重量、不可分割的物品，我们需要选择一些装入背包，在满足背包最大重量限制的前提下，背包中物品总重量的最大值是多少呢?
     *
     * @return
     */
    public int maxWeight(int[] weight, int w) {
        return dpSolution(weight, w);
    }

    /**
     * 1. 状态定义 dp[i][j]  索引= i 的 是否可以组成重量= j
     * 2. 状态转移 dp[i][j] = dp[i-1][j] || w[i] +  == j
     *
     * @param weight
     * @param w
     * @return
     */
    private int dpSolution(int[] weight, int w) {
        int len = weight.length;
        boolean[][] dp = new boolean[len][w + 1];
        dp[0][0] = true;
        if (weight[0] < w) {
            dp[0][weight[0]] = true;
        }
        for (int i = 1; i < len; i++) {
            // 不把第i个物品放入 背包
            for (int j = 0; j <= w; j++) {
                dp[i][j] = dp[i - 1][j];
            }
            // 不把第i个物品放入 背包
            for (int j = 0; j <= w; j++) {
                if (dp[i][j] && j + weight[i] <= w) {
                    dp[i][j + weight[i]] = true;
                }
            }
        }
        for (int i = w; i >= 0; i--) {
            if (dp[len - 1][i]) {
                return i;
            }
        }
        return 0;
    }

    private int backTraceSolution(int[] weight, int w) {
        int len = weight.length;
//        return backTrace(0, 0, len, w, weight);
        int[] visited = new int[len];
        return backTrace2(0, 0, len, w, weight, visited);
    }

    /**
     * @param cw     当前背包重量
     * @param idx    物品索引
     * @param len    物品数目
     * @param w      背包承重
     * @param weight 物品重量数组
     * @return
     */
    private int backTrace(int cw, int idx, int len, int w, int[] weight) {
        // terminate
        if (cw == w || idx == len) {
            return cw;
        }

        // for choice in choiceList: doChoice
        int maxWeight = backTrace(cw, idx + 1, len, w, weight);
        if (cw + weight[idx] <= w) {
            maxWeight = Math.max(maxWeight, backTrace(cw + weight[idx], idx + 1, len, w, weight));
        }
        return maxWeight;
    }

    /**
     * @param cw
     * @param idx
     * @param len
     * @param w
     * @param weight
     * @return
     */
    private int backTrace2(int cw, int idx, int len, int w, int[] weight, int[] memo) {
        // terminate
        if (cw == w || idx == len) {
            return cw;
        }

        if (memo[idx] > 0) {
            return memo[idx];
        }
        // for choice in choiceList: doChoice
        int maxWeight = backTrace(cw, idx + 1, len, w, weight);
        if (cw + weight[idx] <= w) {
            maxWeight = Math.max(maxWeight, backTrace(cw + weight[idx], idx + 1, len, w, weight));
        }
        memo[idx] = maxWeight;
        return maxWeight;
    }

    public static void main(String[] args) {
        final Bag1 bag = new Bag1();
        System.out.println(bag.maxWeight(new int[]{2, 2, 4, 6, 3}, 9));
    }
}
