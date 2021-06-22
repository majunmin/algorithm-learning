package com.majm.leetcode;

/**
 * @author majunmin
 * @description
 * @datetime 2021/2/22 8:01 下午
 * @since
 */
public class LeetCode766 {

    public boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int row = m, col = n;
        while (col-- > 0) {
            for (int i = 0, j = col, val = matrix[i++][j++]; i < m && j < n; i++, j++) {
                if (matrix[i][j] != val) {
                    return false;
                }
            }
        }
        while (row-- > 0) {
            for (int i = row, j = 0, val = matrix[i++][j++]; i < m && j < n; i++, j++) {
                if (matrix[i][j] != val) {
                    return false;
                }
            }
        }
        return true;
    }
}
