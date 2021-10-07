package com.majm.leetcode;

import com.majm.Solution;

/**
 * 74. 搜索二维矩阵 </br>
 * 二分查找法
 *
 * @author majunmin
 * @description
 * @datetime 2021-08-18 08:11
 * @since
 */
public class LeetCode_0074 implements Solution {

    @Override
    public boolean searchMatrix(int[][] matrix, int target) {
        // 边界条件
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int height = matrix.length;
        int left = 0;
        int right = height - 1;
        // 查找列的位置
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (target < matrix[mid][0]) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        int row = left;
        left = 0;
        right = matrix[row].length - 1;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (target < matrix[row][mid]) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return matrix[row][left] == target;
    }


    /**
     * 一次二分查找
     * 将二维矩阵打平
     *
     * @param matrix
     * @param target
     * @return
     */
    private boolean binSearchSolution1(int[][] matrix, int target) {
        // 边界条件
        if (matrix == null && matrix.length == 0) {
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0;
        int right = m * n - 1;
        int row = 0;
        int col = 0;

        //  二分查找 = 搜索完成后 有 left = right
        while (left < right) {
            int mid = left + (right - left) / 2;
            row = mid / n;
            col = mid % n;
            if (target > matrix[row][col]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        row = left / n;
        col = left % n;
        return matrix[row][col] == target;
    }

//    [[1,3,5,7],[10,11,16,20],[23,30,34,60]]
//            3
//            [[1,3,5,7],[10,11,16,20],[23,30,34,60]]
//            13

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60},
        };

        final Solution leetCode = new LeetCode_0074();

        System.out.println(leetCode.searchMatrix(matrix, 3));
        matrix = new int[][]{
                {1}
        };
        System.out.println(leetCode.searchMatrix(matrix, 3));
    }
}
