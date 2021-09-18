package com.majm.leetcode;

import com.majm.Solution;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author majunmin
 * @description
 * @datetime 2020/11/6 8:38 下午
 * @since
 */
public class LeetCode_0051 implements Solution {


    /**
     * when n ==1 result=[["Q"]]
     *
     * @param n 棋盘边长
     * @return
     */
    @Override
    public List<List<String>> solveNQueens(int n) {
        return solution2(n);
    }

    private List<List<String>> solution2(int n) {
        List<List<String>> result = new ArrayList<>();
        List<String> path = new ArrayList<>();
        Set<Integer> cols = new HashSet<>();
        // 在同一撇的两个皇后  row + col = const
        Set<Integer> pie = new HashSet<>();
        // 在同一捺的两个皇后  row - col = const (index = col - row + n)
        Set<Integer> na = new HashSet<>();
        int row = 0;

        dfs(path, row, n, cols, pie, na, result);
        return result;
    }

    private void dfs(List<String> path, int row, int n, Set<Integer> cols, Set<Integer> pie, Set<Integer> na, List<List<String>> result) {
        // terminate
        if (row == n) {
            result.add(new ArrayList<>(path));
            return;
        }
        // forEach choice in choiceList
        for (int col = 0; col < n; ++col) {
            if (cols.contains(col) || pie.contains(row + col) || na.contains(row - col)) {
                continue;
            }
            cols.add(col);
            pie.add(col + row);
            na.add(row - col);
            path.add(buildQueueLine(col, n));

            // process 下探
            dfs(path, row + 1, n, cols, pie, na, result);

            // reset status
            cols.remove(col);
            pie.remove(row + col);
            na.remove(row - col);
            path.remove(path.size() - 1);
        }

    }

    private String buildQueueLine(int col, int n) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            builder.append(i == col ? "Q" : ".");
        }
        return builder.toString();
    }


    /**
     * 回溯算法
     * 时间复杂度: O(N!)
     * 空间复杂度: O(N)  皇后的数量
     *
     * @param n
     * @return
     */
    public List<List<String>> solution1(int n) {
        // '.' 表示空，'Q' 表示皇后，初始化空棋盘。
        List<List<String>> result = new ArrayList<>();

        char[][] chess = new char[n][n];
        //初始化数组 棋盘
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                chess[i][j] = '.';
            }
        }

        backtrace(chess, 0, result);
        return result;
    }

    /**
     * @param chess  棋盘
     * @param row    递归层数
     * @param result 结果集
     */
    private void backtrace(char[][] chess, int row, List<List<String>> result) {
        // 终止条件，最后一行都走完了，说明找到了一组，把它加入到集合res中
        if (row == chess.length) {
            result.add(construct(chess, result));
            return;
        }

        for (int col = 0; col < chess.length; col++) {
            if (valid(chess, row, col)) {
                // 当前位置 放置皇后(进行选择)
                chess[row][col] = 'Q';
                // 递归下探
                backtrace(chess, row + 1, result);
                // 清空状态
                chess[row][col] = '.';
            }
        }


        // for choice in choiceList
        //    add choice
        //    recurse()
        //    reset choice
    }

    private boolean valid(char[][] chess, int row, int col) {
        //判断当前列有没有皇后,因为他是一行一行往下走的，
        //我们只需要检查走过的行数即可，通俗一点就是判断当前
        //坐标位置的上面有没有皇后
        for (int i = 0; i < row; i++) {
            if (chess[i][col] == 'Q') {
                return false;
            }
        }

        /**
         * 判断当前 坐标右上角有没有皇后
         */
        for (int i = row - 1, j = col + 1; i >= 0 && j < chess.length; i--, j++) {
            if (chess[i][j] == 'Q') {
                return false;
            }
        }
        /**
         * 判断当前坐标左上角是否有皇后
         */
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chess[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    //
    private List<String> construct(char[][] chess, List<List<String>> result) {
        List<String> path = new ArrayList<>();
        for (int i = 0; i < chess.length; i++) {
            path.add(new String(chess[i]));
        }
        return path;
    }

}
