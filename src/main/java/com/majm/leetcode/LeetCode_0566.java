package com.majm.leetcode;

import com.majm.Solution;

/**
 * 566. 重塑矩阵 </br>
 *
 * @author majunmin
 * @description
 * @datetime 2021-08-31 08:45
 * @since
 */
public class LeetCode_0566 implements Solution {

    @Override
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        // 如果具有给定参数的 reshape 操作是可行且合理的，则输出新的重塑矩阵；否则，输出原始矩阵。
        int rowNum = mat.length;
        int colNum = mat[0].length;
        if (rowNum * colNum != r * c || rowNum == r) {
            return mat;
        }

        int[][] result = new int[r][c];
        int index = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                result[index / c][index % c] = mat[i][j];
                ++index;
            }
        }
        return result;
    }
}
