package com.majm.leetcode;

import com.majm.Solution;

/**
 * 一句话功能简述 </br>
 *
 * @author majunmin
 * @description
 * @datetime 2021-09-04 18:52
 * @since
 */
public class LeetCode_0304 implements Solution {

}

class NumMatrix {

    private int[][] matrix;

    // 前缀和数组
    private int[][] preSum;

    public NumMatrix(int[][] matrix) {
        // init
        this.matrix = matrix;
        int rowSize = matrix.length;
        int colSize = matrix[0].length;
        preSum = new int[rowSize + 1][colSize + 1];
        for (int i = 1; i <= rowSize; i++) {
            for (int j = 1; j <= colSize; j++) {
                preSum[i][j] = preSum[i - 1][j] + preSum[i][j - 1] - preSum[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (row1 < 0 || row1 >= matrix.length) {
            throw new IllegalArgumentException();
        }
        if (col1 < 0 || col1 >= matrix.length) {
            throw new IllegalArgumentException();
        }
        if (row2 < 0 || row2 >= matrix.length) {
            throw new IllegalArgumentException();
        }
        if (col2 < 0 || col2 >= matrix.length) {
            throw new IllegalArgumentException();
        }
        if (row1 > row2 || col1 > col2) {
            throw new IllegalArgumentException();
        }

        return preSum[row2 + 1][col2 + 1] - preSum[row2 + 1][col1] - preSum[row1][col2 + 1] + preSum[row1][col1];
    }
}

