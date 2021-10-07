package com.majm.leetcode;

import com.majm.Solution;

/**
 * 79. 单词搜索 </br>
 *
 * @author majunmin
 * @description
 * @datetime 2021-09-16 23:14
 * @since
 */
public class LeetCode_0079 implements Solution {

    private int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    @Override
    public boolean exist(char[][] board, String word) {
        int rowSize = board.length;
        int colSize = board[0].length;
        boolean[] visited = new boolean[rowSize * colSize];

        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                if (dfs(i, j, 0, visited, board, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int row, int col, int k, boolean[] visited, char[][] board, String word) {
        // terminate
        int visitedIdx = row * board[0].length + col;
        if (visited[visitedIdx]) {
            return false;
        }
        if (word.charAt(k) != board[row][col]) {
            return false;
        }
        if (k == word.length() - 1) {
            return true;
        }

        visited[visitedIdx] = true;
        // dfs
        for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            if (newRow < 0 || newRow >= board.length || newCol < 0 || newCol >= board[0].length) {
                continue;
            }
            if (dfs(newRow, newCol, k + 1, visited, board, word)) {
                return true;
            }
        }
        visited[visitedIdx] = false;
        return false;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'},
        };
        char[][] board2 = new char[][]{
                {'A'},
        };
        Solution leetCode = new LeetCode_0079();
        System.out.println(leetCode.exist(board, "ABCB"));
    }
}
