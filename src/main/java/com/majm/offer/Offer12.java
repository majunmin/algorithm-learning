package com.majm.offer;

/**
 * 剑指 Offer 12. 矩阵中的路径 </br>
 *
 * @author majunmin
 * @description
 * @datetime 2021-09-26 16:11
 * @since
 */
public class Offer12 {

    private int[][] directions = new int[][]{
            {0, 1},
            {0, -1},
            {-1, 0},
            {1, 0},
    };


    /**
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        if (board == null) {
            return false;
        }
        int rowSize = board.length;
        int colSize = board[0].length;
        boolean[] visited = new boolean[rowSize * colSize];
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                if (backTrace(i, j, rowSize, colSize, 0, word, board, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backTrace(int row, int col, int rowSize, int colSize, int k, String word, char[][] board, boolean[] visited) {
        int visitedIdx = row * colSize + col;
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


        // for choice in choiceList
        for (int[] direction : directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];
            if (newRow >= 0 && newRow < rowSize && newCol >= 0 && newCol < colSize && !visited[newRow * colSize + newCol]) {
                if (backTrace(newRow, newCol, rowSize, colSize, k + 1, word, board, visited)) {
                    return true;
                }
            }
        }
        // reset
        visited[visitedIdx] = false;
        return false;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'},
        };
        final Offer12 offer = new Offer12();
        System.out.println(offer.exist(board, "ABCCEC"));
    }
}
