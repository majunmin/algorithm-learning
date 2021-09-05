package com.majm.leetcode;

import com.majm.Solution;

/**
 * 221. 最大正方形 </br>
 *
 * @author majunmin
 * @description
 * @datetime 2021-09-05 18:02
 * @since
 */
public class LeetCode_0221 implements Solution {

    @Override
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int maxSide = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        // 1. 状态定义
                        // dp[i][j] : 以i,j 为右下角的 最大的正方形的边长
                        // 2. 状态转移方程
                        // dp[i][j] = min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1])
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    }
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }
        return maxSide * maxSide;
    }
}
