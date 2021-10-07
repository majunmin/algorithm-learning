package com.majm.leetcode;

import com.majm.Solution;

import java.util.Arrays;

/**
 * 62. 不同路径 </br>
 * https://leetcode-cn.com/problems/unique-paths/
 *
 * @author majunmin
 * @description
 * @datetime 2021-09-04 19:18
 * @since
 */
public class LeetCode_0062 implements Solution {

    private int[][] directions = new int[][]{
            {1, 0}, {0, 1}
    };

    @Override
    public int uniquePaths(int m, int n) {
        return dpSolution3(m, n);
    }

    private int dpSolution3(int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        int[] prev = new int[n];
        Arrays.fill(prev, 1);
        // 一行一行填充
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                prev[j] += prev[j - 1];
            }
        }
        return prev[n - 1];
    }


    /**
     * 优化空间
     *
     * @param m
     * @param n
     * @return
     */
    private int dpSolution2(int m, int n) {
        int[] prev = new int[n];
        int[] cur = new int[n];
        Arrays.fill(prev, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    cur[j] = 1;
                } else {
                    cur[j] = cur[j - 1] + prev[j];
                }
            }
            prev = cur;
        }

        return cur[n - 1];
    }

    /**
     * 动态规划 1
     * - 空间优化
     *
     * @param m
     * @param n
     * @return
     */
    private int dpSolution1(int m, int n) {
        int[][] path = new int[m][n];
        Arrays.fill(path[0], 1);
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    path[i][j] = 1;
                } else {
                    path[i][j] = path[i - 1][j] + path[i][j - 1];
                }
            }
        }
        return path[m - 1][n - 1];
    }


    /**
     * 递归解法
     *
     * @param m
     * @param n
     * @return
     */
    private int dfsSolution(int m, int n) {
        if (m == 0 && n == 0) {
            return 0;
        }
        if (m < 0 || n < 0) {
            throw new IllegalArgumentException();
        }
        int[][] memo = new int[m][n];
        return tryUniquePaths(memo, m - 1, n - 1);
    }

    private int tryUniquePaths(int[][] memo, int row, int col) {
        if (row < 0 || col < 0) {
            return 0;
        }
        // terminate
        if (row == 0 || col == 0) {
            return 1;
        }
        if (memo[row][col] != 0) {
            return memo[row][col];
        }
        return tryUniquePaths(memo, row - 1, col) + tryUniquePaths(memo, row, col - 1);
    }

    public static void main(String[] args) {
        Solution leetCode = new LeetCode_0062();
        System.out.println(leetCode.uniquePaths(3, 7));
    }
}
