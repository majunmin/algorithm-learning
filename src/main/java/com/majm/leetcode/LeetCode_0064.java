package com.majm.leetcode;

import com.majm.Solution;

/**
 * 64. 最小路径和 </br>
 *
 * @author majunmin
 * @description
 * @datetime 2021-09-05 17:25
 * @since
 */
public class LeetCode_0064 implements Solution {

    @Override
    public int minPathSum(int[][] grid) {
        return dpSolution2(grid);
    }


    /**
     * 动态规划 优化空间
     * <p>
     * 空间复杂度O(N)
     * 时间复杂度 O(m*n)
     *
     * @param grid
     * @return
     */
    private int dpSolution2(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] dp = new int[n];
        // init
        for (int i = 0; i < n; i++) {
            dp[i] = (i == 0) ? grid[0][i] : grid[0][i] + dp[i - 1];
        }
        for (int i = 1; i < m; i++) {
            dp[0] = dp[0] + grid[i][0];
            for (int j = 1; j < n; j++) {
                dp[j] = Math.min(dp[j - 1], dp[j]) + grid[i][j];
            }
        }
        return dp[n - 1];
    }

    /**
     * 空间复杂度 O(m*n)
     * 时间复杂度 O(m*n)
     *
     * @param grid
     * @return
     */
    private int dpSolution1(int[][] grid) {
        // 参数校验
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            throw new IllegalArgumentException();
        }
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        Solution leetCode = new LeetCode_0064();
        System.out.println(leetCode.minPathSum(new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1},
        }));
    }
}
