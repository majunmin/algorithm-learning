package com.majm.leetcode;

import com.majm.Solution;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * DFS  / BFS </br>
 *
 * @author majunmin
 * @description
 * @datetime 2021-06-20 08:36
 * @since
 */
public class LeetCode_1210 implements Solution {


    @Override
    public int minimumMoves(int[][] grid) {
        if (grid == null || grid.length <= 1 || grid[0].length <= 1) {
            return -1;
        }
        int m = grid.length;
        int n = grid[0].length;
        int[][] snake = new int[][]{{0, 1}, {0, 0}};
        int[][] target = new int[][]{{m - 1, n - 1}, {m - 1, n - 2}};
        Map<int[][], Boolean> visited = new HashMap<int[][], Boolean>(){};
        int res = dfs(snake, grid, target, 0, visited);
        return Math.max(res, -1);
    }

    private int dfs(int[][] snake, int[][] grid, int[][] target, int level, Map<int[][], Boolean> visited) {
        if (Arrays.deepEquals(target, snake)) {
            visited.put(snake, true);
            return level;
        }
        int res1 = -1;
        int res2 = -1;
        int res3 = -1;
        // 处于 水平状态
        if (snake[0][0] == snake[1][0]) {
            if (snake[0][1] + 1 < grid[0].length && grid[snake[0][0]][snake[0][1] + 1] != 1) {
                int[][] newSnake = new int[][]{{snake[0][0], snake[0][1] + 1}, {snake[1][0], snake[1][1] + 1}};
                if (!Boolean.TRUE.equals(visited.get(newSnake))) {
                    visited.put(newSnake, true);
                    System.out.println("右");
                    System.out.println(Arrays.deepToString(newSnake));
                    res1 = dfs(newSnake, grid, target, level + 1, visited);
                }
            }
            if (snake[0][0] + 1 < grid.length && grid[snake[0][0] + 1][snake[0][1]] == 0 && grid[snake[1][0] + 1][snake[1][1]] == 0) {
                // 水平下移
                int[][] newSnake = new int[][]{{snake[0][0] + 1, snake[0][1]}, {snake[1][0] + 1, snake[1][1]}};
                if (!Boolean.TRUE.equals(visited.get(newSnake))) {
                    System.out.println("下");
                    System.out.println(Arrays.deepToString(newSnake));
                    visited.put(newSnake, true);
                    res2 = dfs(newSnake, grid, target, level + 1, visited);
                }
                // 顺时针旋转
                newSnake = new int[][]{{snake[0][0] + 1, snake[0][1] - 1}, {snake[1][0], snake[1][1]}};
                if (!Boolean.TRUE.equals(visited.get(newSnake))) {
                    System.out.println("顺时针");
                    System.out.println(Arrays.deepToString(newSnake));
                    visited.put(newSnake, true);
                    res3 = dfs(newSnake, grid, target, level + 1, visited);
                }
            }
        }

        // 处于 竖直状态
        if (snake[0][1] == snake[1][1]) {
            if (snake[0][0] + 1 < grid.length && grid[snake[0][0] + 1][snake[0][1]] != 1) {
                int[][] newSnake = new int[][]{{snake[0][0] + 1, snake[0][1]}, {snake[1][0] + 1, snake[1][1]}};
                if (!Boolean.TRUE.equals(visited.get(newSnake))) {
                    System.out.println("水平右移");
                    System.out.println(Arrays.deepToString(newSnake));
                    visited.put(newSnake, true);
                    res1 = dfs(newSnake, grid, target, level + 1, visited);
                }
            }
            if (snake[0][1] + 1 < grid[0].length && grid[snake[0][0]][snake[0][1] + 1] == 0 && grid[snake[1][0]][snake[1][1] + 1] == 0) {
                // 右移
                int[][] newSnake = new int[][]{{snake[0][0], snake[0][1] + 1}, {snake[1][0], snake[1][1] + 1}};
                if (!Boolean.TRUE.equals(visited.get(newSnake))) {
                    System.out.println("水平右移");
                    System.out.println(Arrays.deepToString(newSnake));
                    visited.put(newSnake, true);
                    res2 = dfs(newSnake, grid, target, level + 1, visited);
                }
                // 逆时针 旋转
                newSnake = new int[][]{{snake[0][0] - 1, snake[0][1] + 1}, {snake[1][0], snake[1][1]}};
                if (!Boolean.TRUE.equals(visited.get(newSnake))) {
                    visited.put(newSnake, true);
                    // 逆时针
                    System.out.println("逆时针");
                    System.out.println(Arrays.deepToString(newSnake));
                    res3 = dfs(newSnake, grid, target, level + 1, visited);
                }
            }
        }
        return Math.max(Math.max(res1, res2), res3);
    }
}
