package com.majm.offer;

/**
 * 剑指 Offer 13. 机器人的运动范围 </br>
 *
 * @author majunmin
 * @description
 * @datetime 2021-09-26 19:53
 * @since
 */
public class Offer13 {

    private int[][] directions = new int[][]{
            {0, 1},
            {0, -1},
            {-1, 0},
            {1, 0},
    };

    public int movingCount(int m, int n, int k) {
        // paramCheck
        if (m <= 0 || n < 0) {
            throw new IllegalArgumentException();
        }
        // 记录已经能访问过的节点
        boolean[] visited = new boolean[m * n];
        return dfs(0, 0, m, n, k, visited);
    }

    private int dfs(int row, int col, int m, int n, int k, boolean[] visited) {
        // terminate
        int visitIdx = row * n + col;
        if (visited[visitIdx]) {
            return 0;
        }
        visited[visitIdx] = true;

        int cnt = 0;
        if (parseSum(row, col) > k) {
            return cnt;
        }
        cnt++;

        // for choice in choiceList
        for (int[] direction : directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];
            if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n) {
                cnt += dfs(newRow, newCol, m, n, k, visited);
            }
        }
//        visited[visitIdx] = false;
        return cnt;
    }

    private int parseSum(int num1, int num2) {
        int result = 0;
        while (num1 > 0) {
            result += num1 % 10;
            num1 /= 10;
        }
        while (num2 > 0) {
            result += num2 % 10;
            num2 /= 10;
        }
        return result;
    }

    public static void main(String[] args) {
        Offer13 offer = new Offer13();
        System.out.println(offer.parseSum(234, 13));
        System.out.println(offer.movingCount(2, 3, 16));
    }
}
