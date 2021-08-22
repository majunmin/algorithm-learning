package com.majm.leetcode;

import com.majm.Solution;

/**
 * 746. 使用最小花费爬楼梯 </br>
 * <p>
 * https://leetcode-cn.com/problems/min-cost-climbing-stairs/
 *
 * @author majunmin
 * @description
 * @datetime 2021-07-23 00:34
 * @since
 */
public class LeetCode_0746 implements Solution {


    @Override
    public int minCostClimbingStairs(int[] cost) {
        int minCost0 = 0;
        int minCost1 = Math.min(cost[0], cost[1]);
        int minCost = minCost1;
        for (int i = 3; i <= cost.length; i++) {
            minCost = Math.min(minCost0 + cost[i - 2], minCost1 + cost[i - 1]);
            minCost0 = minCost1;
            minCost1 = minCost;
        }
        return minCost;
    }

    /**
     * 类似于 爬楼梯,
     * dp[i]: 爬到 第i级台阶的最小花费
     * dp[cost.length] = 0
     * dp[i] = min(dp[i-1], dp[i-2]) + cost[n]
     *
     * @param cost
     * @return
     */
    private int dpSolution(int[] cost) {
        //  f(n) = min(f(n-1), f(n-2)) + cost[n]
        // f(0) = cost[0]
        // f(1) = cost[1]
        final int len = cost.length;
        if (len <= 1) {
            return 0;
        }

        int[] dp = new int[len + 2];
        dp[0] = 0;
        dp[1] = cost[0];
        for (int i = 2; i <= len; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i - 1];
        }
        dp[len + 1] = Math.min(dp[len], dp[len - 1]);
        return dp[len + 1];
    }


    /**
     * 递推公式的找到
     *
     * @param cost
     * @return
     */
    private int solution2(int[] cost) {
        // minCost[i] 表示踏上第i级台阶的 最小花费()
        // minCost[i] = min(minCost[i-1] + cost[i-1] , minCost[i-2] + cost[i-2])
        // 转化为   两个 变量的写法,优化空间
        final int len = cost.length;
        int[] minCost = new int[len + 1];
        minCost[1] = 0;
        minCost[2] = Math.min(cost[0], cost[1]);
        for (int i = 3; i <= len; i++) {
            minCost[i] = Math.min(minCost[i - 2] + cost[i - 2], minCost[i - 1] + cost[i - 1]);
        }
        return minCost[len];
    }

    /**
     * 相对于解法2 优化了空间
     *
     * @param cost
     * @return
     */
    private int solution3(int[] cost) {
        // minCost[i-1] 表示踏上第i级台阶的 最小花费
        // minCost[i] = min(minCost[i-1] + cost[i] , minCost[i-2] + cost[i-1])
        // 转化为   两个 变量的写法,优化空间
        int minCost0 = 0;
        int minCost1 = Math.min(cost[0], cost[1]);
        int minCost = 0;
        for (int i = 2; i < cost.length; i++) {
            minCost = Math.min(minCost1 + cost[i], minCost0 + cost[i - 1]);
            minCost0 = minCost1;
            minCost1 = minCost;
        }
        return minCost;
    }

    public static void main(String[] args) {
        final Solution leetCode = new LeetCode_0746();
        System.out.println(leetCode.minCostClimbingStairs(new int[]{10, 15, 20}));
        System.out.println(leetCode.minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
    }
}
