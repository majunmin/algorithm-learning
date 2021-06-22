package com.majm.leetcode;

import com.majm.Solution;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author majunmin
 * @description
 * @datetime 2020/11/11 5:31 下午
 * @since
 */
public class LeetCode200 implements Solution {

    @Override
    public int numIslands(char[][] grid) {
        return solution2(grid);
    }

    /**
     * 广度优先搜索
     * 时间复杂度:
     * 空间复杂度:
     *
     * @param grid
     * @return
     */
    private int solution2(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int rowSize = grid.length;
        int colSize = grid[0].length;
        int numOfIsland = 0;

        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                if (grid[i][j] == '1') {
                    ++numOfIsland;
                    Queue<Integer> queue = new LinkedList<>();
                    queue.add(i * colSize + j);
                    while (!queue.isEmpty()) {
                        int size = queue.size();
                        while (size-- > 0) {
                            // curNum = (row * colSize + col) 可以保存 行列 信息 (学到了 很强  😄)
                            Integer curNum = queue.poll();
                            int row = curNum / colSize;
                            int col = curNum % colSize;
                            if (grid[row][col] == '0') {
                                continue;
                            }
                            grid[row][col] = '0';

                            if (row + 1 < rowSize && grid[row + 1][col] == '1') {
                                queue.offer((row + 1) * colSize + col);
                            }
                            if (row - 1 >= 0 && grid[row - 1][col] == '1') {
                                queue.offer((row - 1) * colSize + col);
                            }
                            if (col + 1 < colSize && grid[row][col + 1] == '1') {
                                queue.offer(row * colSize + col + 1);
                            }
                            if (col - 1 >= 0 && grid[row][col - 1] == '1') {
                                queue.offer(row * colSize + col - 1);
                            }
                        }
                    }
                }
            }
        }
        return numOfIsland;
    }


    /**
     * 深度优先搜索
     * <p>
     * 时间复杂度: O(MN)
     * 空间复杂度: O(MN)
     *
     * @param grid
     * @return
     */
    public int solution1(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int rowSize = grid.length;
        int colSize = grid[0].length;
        int numOfIsland = 0;
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                if (grid[i][j] == '1') {
                    ++numOfIsland;
                    dfs(i, j, rowSize, colSize, grid);
                }
            }
        }
        return numOfIsland;
    }

    /**
     * 找到 一个陆地之后 将 与该陆地相连的均陆地打平
     * (通过dfs的方式)
     *
     * @param row
     * @param col
     * @param rowSize
     * @param colSize
     * @param grid
     */
    private void dfs(int row, int col, int rowSize, int colSize, char[][] grid) {
        if (grid[row][col] == '0') {
            return;
        }
        grid[row][col] = '0';

        if (row < rowSize - 1) {
            dfs(row + 1, col, rowSize, colSize, grid);
        }
        if (col < colSize - 1) {
            dfs(row, col + 1, rowSize, colSize, grid);
        }
        if (row > 0) {
            dfs(row - 1, col, rowSize, colSize, grid);
        }
        if (col > 0) {
            dfs(row, col - 1, rowSize, colSize, grid);
        }
    }
}
