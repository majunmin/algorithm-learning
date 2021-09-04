package com.majm.leetcode;

import com.majm.Solution;

import java.util.Arrays;

/**
 * 1314. 矩阵区域和 </br>
 *
 * @author majunmin
 * @description
 * @datetime 2021-09-04 17:38
 * @since
 */
public class LeetCode_1314 implements Solution {


    @Override
    public int[][] matrixBlockSum(int[][] mat, int k) {
        return solution2(mat, k);
    }

    /**
     * 利用技巧  二维矩阵前缀和
     * mat[m][n]
     * 得到一个 sum矩阵
     * sum[m+1][n+1]
     *
     * @param mat
     * @param k
     * @return
     */
    private int[][] solution2(int[][] mat, int k) {
        int rowSize = mat.length;
        int colSize = mat[0].length;
        int[][] preSum = new int[rowSize + 1][colSize + 1];
        // 画图会更好理解
        for (int i = 1; i <= rowSize; i++) {
            for (int j = 1; j <= colSize; j++) {
                preSum[i][j] = preSum[i - 1][j] + preSum[i][j - 1] - preSum[i - 1][j - 1] + mat[i - 1][j - 1];
            }
        }

        int[][] result = new int[rowSize][colSize];
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                // 大框边界
                int ux = Math.min(i + k + 1, rowSize);
                int uy = Math.min(j + k + 1, colSize);
                // 小框边界
                int dx = Math.max(i - k, 0);
                int dy = Math.max(j - k, 0);
                result[i][j] = preSum[ux][uy] - preSum[dx][uy] - preSum[ux][dy] + preSum[dx][dy];
            }
        }
        return result;
    }


    /**
     * 暴力解法
     *
     * @param mat
     * @param k
     * @return
     */
    private int[][] solution1(int[][] mat, int k) {
        int rowSize = mat.length;
        int colSize = mat[0].length;
        int[][] result = new int[rowSize][colSize];

        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                int sum = 0;
                for (int m = i - k; m <= i + k; m++) {
                    for (int n = j - k; n <= j + k; n++) {
                        if (m >= 0 && m < rowSize && n >= 0 && n < colSize) {
                            sum += mat[m][n];
                        }
                    }
                }
                result[i][j] = sum;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution leetCode = new LeetCode_1314();
        int[][] result = leetCode.matrixBlockSum(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        }, 1);
        System.out.println(Arrays.toString(result));
    }
}
