package com.majm.leetcode;

import com.majm.Solution;

/**
 * 931. 下降路径最小和 </br>
 * <p>
 * 1. 从低向上推导
 * 2. dfs 自顶向下
 *
 * @author majunmin
 * @description
 * @datetime 2021-09-02 22:08
 * @since
 */
public class LeetCode_0931 implements Solution {

    @Override
    public int minFallingPathSum(int[][] matrix) {
        // 边界条件
        if (matrix == null || matrix.length == 0) {
            return 0;
        }

        for (int i = 0; i < matrix.length; i++) {

        }

        return solution1(matrix);
    }


    /**
     * 自底向上  动态规划
     * // 1. 定义状态
     * dp[r][c]  从 (r, c) 开始的最小路径和
     * // 2. 状态转移
     * dp[r][c] = min{dp[r-1][c-1], dp[r-1][c], d[[r-1][c+1]}
     *
     * @param matrix
     * @return
     */
    private int solution1(int[][] matrix) {
        final int len = matrix.length;
        for (int i = len - 1; i > 0; i--) {
            int curLen = matrix[i].length;
            for (int j = curLen - 1; j >= 0; j--) {
                int minVal = matrix[i][j];
                if (j - 1 >= 0) {
                    minVal = Math.min(minVal, matrix[i][j - 1]);
                }
                if (j + 1 < curLen) {
                    minVal = Math.min(minVal, matrix[i][j + 1]);
                }
                matrix[i - 1][j] += minVal;
            }
        }
        int min = matrix[0][0];
        for (int i = 1; i < matrix[0].length; i++) {
            min = Math.min(min, matrix[0][i]);
        }
        return min;
    }

    public static void main(String[] args) {
        Solution leetCode = new LeetCode_0931();
        int[][] demo1 = new int[][]{
                {2, 1, 3},
                {6, 5, 4},
                {7, 8, 9}
        };
        System.out.println(leetCode.minFallingPathSum(demo1));
    }

}
