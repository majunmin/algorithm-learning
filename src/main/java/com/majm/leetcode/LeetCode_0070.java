package com.majm.leetcode;

import com.majm.Solution;

/**
 * @author majunmin
 * @description
 * @datetime 2020/11/2 12:43 下午
 * @since
 */
public class LeetCode_0070 implements Solution {

    @Override
    public int climbStairs(int n) {

        if (n == 1 || n == 2) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];

    }

    /**
     * 动态规划
     * 时间复杂度: O(N)
     * 空间复杂度: O(1)
     *
     * @param n
     * @return
     */
    public int solution3(int n) {
        int p = 1;
        int q = 1;
        int res = 1;
        for (int i = 1; i < n; i++) {
            res = p + q;
            p = q;
            q = res;
        }
        return res;
    }

    /**
     * 带缓存的遍历
     * 时间复杂度: O()
     * 空间复杂度: O()
     *
     * @return
     */

    public int solution2(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int[] cache = new int[n + 1];
        cache[0] = cache[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            cache[i] = cache[i - 1] + cache[i - 2];
        }
        return cache[n];
    }

    /**
     * 递归 (超时)  (可以使用带缓存的递归)
     * 时间复杂度: O(2^n)
     * 空间复杂度: O()
     *
     * @param n
     * @return
     */
    public int solution1(int n) {
        if (n == 1 || n == 0) {
            return 1;
        }
        return solution1(n - 1) + solution1(n - 2);
    }
}
