package com.majm.offer;

/**
 * 剑指 Offer 47. 礼物的最大价值 </br>
 * https://leetcode-cn.com/problems/li-wu-de-zui-da-jie-zhi-lcof/
 *
 * @author majunmin
 * @description
 * @datetime 2021-09-21 19:33
 * @since
 */
public class Offer47 {

    /**
     * @param grid
     * @return
     */
    public int maxValue(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            throw new IllegalArgumentException();
        }
        int rowSize = grid.length;
        int colSize = grid[0].length;
        int[][] dp = new int[rowSize][colSize];
        // init
        dp[0][0] = grid[0][0];
        for (int i = 1; i < colSize; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < rowSize; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        // dp
        for (int i = 1; i < rowSize; i++) {
            for (int j = 1; j < colSize; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[rowSize - 1][colSize - 1];
    }
}
