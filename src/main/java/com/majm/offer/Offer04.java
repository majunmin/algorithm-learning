package com.majm.offer;

/**
 * 剑指 Offer 04. 二维数组中的查找 </br>
 * https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/
 *
 * @author majunmin
 * @description
 * @datetime 2021-09-17 17:38
 * @since
 */
public class Offer04 {

    /**
     * 有序数组的查找,  一般就是二分查找
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rowSize = matrix.length;
        int colSize = matrix[0].length;
        for (int i = 0; i < rowSize; i++) {
            if (matrix[i][0] > target) {
                break;
            }
            if (binarySearch(matrix[i], target)) {
                return true;
            }
        }
        return false;
    }

    private boolean binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return arr[left] == target;
    }


    /**
     * 线性查找 , 根据  左下角 和 右上角的特性 进行查找
     *
     * @param matrix
     * @param target
     * @return
     */
    private boolean lineSearch(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int rowSize = matrix.length;
        int colSize = matrix[0].length;
        int row = rowSize - 1;
        int col = 0;
        while (row >= 0 && col < colSize) {
            if (matrix[row][col] > target) {
                row--;
            } else if (matrix[row][col] < target) {
                col++;
            } else {
                return true;
            }
        }
        return false;
    }
}
