package com.majm.leetcode;

import com.majm.Solution;

/**
 * 1137. 第 N 个泰波那契数 </br>
 * https://leetcode-cn.com/problems/n-th-tribonacci-number/
 *
 * @author majunmin
 * @description
 * @datetime 2021-07-22 01:19
 * @since
 */
public class LeetCode_1137 implements Solution {


    @Override
    public int tribonacci(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        if (n == 2) {
            return 1;
        }

        // init
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1];
        }
        return dp[n];

    }

    public static void main(String[] args) {
        final LeetCode_1137 leetCode = new LeetCode_1137();
        System.out.println(leetCode.tribonacci(4));
        System.out.println(leetCode.tribonacci(25));
    }

}
