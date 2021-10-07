package com.majm.leetcode;

import com.majm.Solution;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * 200. 岛屿数量 </br>
 * https://leetcode-cn.com/problems/number-of-islands/
 *
 * @author majunmin
 * @description
 * @datetime 2021-08-04 00:14
 * @since
 */
public class LeetCode_0200 implements Solution {

    // 遍历方向:
    private int[][] directs = new int[][]{
            {0, 1},
            {0, -1},
            {-1, 0},
            {1, 0}
    };


    @Override
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        CustomUnionFind unionFind = new CustomUnionFind(n * m);

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    grid[i][j] = '0';
                    for (int[] direct : directs) {
                        int newRow = i + direct[0];
                        int newCol = j + direct[1];
                        if (0 <= newRow && newRow < n && 0 <= newCol && newCol < m && grid[newRow][newCol] == '1') {
                            unionFind.union(i * m + j, newRow * m + newCol);
                        }
                    }
                }
            }
        }
        return unionFind.count();
    }


    /**
     * 并查集数组实现
     * 并查集的压缩:
     * 1. 按秩合并
     * 2. 路径压缩
     */
    private class CustomUnionFind {
        private int count;
        private int[] parents;

        public CustomUnionFind(int size) {
            parents = new int[size];
            for (int i = 0; i < size; i++) {
                parents[i] = i;
            }
            count = size;
        }

        private int count() {
            return count;
        }

        private void union(int i, int j) {
            if (find(i) == find(j)) {
                return;
            }
            count++;
            int p = find(i);
            int q = find(j);
            parents[p] = q;
        }

        private int find(int i) {
            if (parents[i] != i) {
                int p = find(parents[i]);
                parents[i] = p;
                return p;
            }
            return i;
        }
    }


    /**
     * 并查集
     */
    private void solution3() {


    }


    /**
     * 时间复杂度:
     * 空间复杂度:
     *
     * @param grid
     * @return
     */
    private int dfsSolution(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int cnt = 0;
        for (int i = 0; i < m * n; i++) {
            int row = i / m;
            int col = i % m;
            if (grid[row][col] == '1') {
                cnt++;
                dfs(grid, row, col);
            }
        }
        return cnt;
    }

    /**
     * dfs 遍历 将与陆地相连的陆地-重置为海洋
     *
     * @param grid
     * @param row
     * @param col
     */
    private void dfs(char[][] grid, int row, int col) {
        grid[row][col] = '0';
        for (int[] direct : directs) {
            int newRow = row + direct[0];
            int newCol = col + direct[1];
            if (0 <= newRow && newRow < grid.length && 0 <= newCol && newCol < grid[0].length && grid[newRow][newCol] == '1') {
                dfs(grid, newRow, newCol);
            }
        }
    }


    /**
     * BFS解法
     * 时间复杂度:
     * 空间复杂度:
     *
     * @param grid
     * @return
     */
    private int bfsSolution2(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[] visited = new boolean[n * m];

        int cnt = 0;
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n * m; i++) {
            int row = i / m;
            int col = i % m;
            visited[row * n + col] = true;
            if (grid[row][col] == '0') {
                continue;
            }

            cnt++;
            // bfs 将陆地打平为 海洋
            queue.push(i);
            while (!queue.isEmpty()) {
                for (int j = 0; j < queue.size(); j++) {
                    int idx = queue.poll();
                    row = idx / m;
                    col = idx % m;
                    // 把陆地打平
                    grid[row][col] = '0';
                    for (int[] direct : directs) {
                        int newRow = direct[0] + row;
                        int newCol = direct[1] + col;
                        int newIdx = newRow * m + newCol;
                        if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && !visited[newIdx] && grid[newRow][newCol] == '1') {
                            visited[newIdx] = true;
                            queue.push(newIdx);
                        }
                    }
                }
            }
        }

        return cnt;
    }


    /**
     * 通常的解法  BFS
     *
     * @param grid
     * @return
     */
    private int BFSsolution1(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        Map<Integer, Boolean> visited = new HashMap<>();

        int cnt = 0;
        int rowSize = grid.length;
        int colSize = grid[0].length;
        final Deque<Integer> stack = new ArrayDeque<>();
        // 矩阵每个位置的编号  i * rowSize  + j
        for (int pos = 0; pos < rowSize * colSize; pos++) {
            if (visited.containsKey(pos)) {
                continue;
            }
            int row = pos / colSize;
            int col = pos % colSize;
            if (grid[row][col] == '0') {
                continue;
            }

            cnt++;
            stack.offer(pos);
            while (!stack.isEmpty()) {
                for (int i = 0; i < stack.size(); i++) {
                    int posi = stack.pop();
                    row = posi / colSize;
                    col = posi % colSize;
                    visited.put(posi, Boolean.TRUE);
                    if (grid[row][col] == '0') {
                        continue;
                    }
                    // 将岛屿打平
                    grid[row][col] = '0';
                    for (int[] d : directs) {
                        int newRow = row + d[0];
                        int newCol = col + d[1];
                        if (newRow < rowSize && newRow >= 0 && newCol >= 0 && newCol < colSize && !visited.containsKey(newRow * colSize + newCol)) {
                            stack.offer(newRow * colSize + newCol);
                        }
                    }
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Solution leetCode = new LeetCode_0200();
        System.out.println(leetCode.numIslands(new char[][]{{'1'}}));
        System.out.println(leetCode.numIslands(new char[][]{{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}}));
        System.out.println(leetCode.numIslands(new char[][]{{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}}));
    }
}
