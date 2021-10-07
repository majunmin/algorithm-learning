package com.majm.leetcode;

import com.majm.Solution;

/**
 * 63. 不同路径 II </br>
 * https://leetcode-cn.com/problems/unique-paths-ii/
 *
 * @author majunmin
 * @description
 * @datetime 2021-09-04 19:20
 * @since
 */
public class LeetCode_0063 implements Solution {

    @Override
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rowSize = obstacleGrid.length;
        int colSize = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        int[] dp = new int[colSize];
        for (int i = 0; i < colSize && obstacleGrid[0][i] != 1; i++) {
            dp[i] = 1;
        }
        for (int i = 1; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                // 特殊考虑第一列
                if (obstacleGrid[i][j] == 1) {
                    dp[j] = 0;
                }
                if (obstacleGrid[i][j] != 1 && j > 0) {
                    dp[j] += dp[j - 1];
                }
            }
        }
        return dp[colSize - 1];
    }


    private int solution1(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        // init
        for (int i = 0; i < n && obstacleGrid[0][i] == 0; i++) {
            dp[0][i] = 1;
        }
        for (int i = 0; i < m && obstacleGrid[i][0] == 0; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                    continue;
                }
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    private int solution2(int[][] obstacleGrid) {

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] dp = new int[n];
        if (obstacleGrid[0][0] != 1) {
            dp[0] = 1;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[j] = 0;
                    continue;
                }
                // start from j == 1
                if (j - 1 >= 0 && obstacleGrid[i][j - 1] == 0) {
                    dp[j] += dp[j - 1];
                }
            }
        }

        return dp[m - 1];
    }

    public static void main(String[] args) {
        Solution leetCode = new LeetCode_0063();
        System.out.println(leetCode.uniquePathsWithObstacles(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}));
    }
}
