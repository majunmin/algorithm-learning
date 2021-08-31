package com.majm.leetcode;

import com.majm.Solution;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/**
 * 264. 丑数 II </br>
 *
 * @author majunmin
 * @description
 * @datetime 2021-08-31 13:12
 * @since
 */
public class LeetCode_0264 implements Solution {

    @Override
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int p2 = 0;
        int p3 = 0;
        int p5 = 0;
        for (int i = 1; i < n; i++) {
            dp[i] = Math.min(Math.min(dp[p2] * 2, dp[3] * 3), dp[5] * 5);
            // 包含了去重
            if (dp[i] == dp[p2] * 2) {
                p2++;
            }
            if (dp[i] == dp[p3] * 3) {
                p3++;
            }
            if (dp[i] == dp[p5] * 5) {
                p5++;
            }
        }
        return dp[n - 1];
    }


    /**
     * 优先级队列 解法
     * PriorityQueue
     * <p>
     * 每次将 结果集中的 数 n  对应的 2n  3n 5n  放入结果集
     * 利用优先级队列
     *
     * @param n
     * @return
     */
    private int solutionPq(int n) {
        int[] factors = new int[]{2, 3, 5};
        Queue<Long> pq = new PriorityQueue<>();
        pq.offer(1L);
        Set<Long> visited = new HashSet<>();
        visited.add(1L);
        int ugly = 1;
        for (int i = 0; i < n; i++) {
            long curr = pq.poll();
            ugly = (int) curr;
            for (int factor : factors) {
                long next = factor * curr;
                if (visited.add(next)) {
                    pq.offer(next);
                }
            }
        }
        return ugly;
    }

    public static void main(String[] args) {
        Solution leetCode = new LeetCode_0264();
        System.out.println(leetCode.nthUglyNumber(1407));
        System.out.println(leetCode.nthUglyNumber(1));
        System.out.println(leetCode.nthUglyNumber(5));
        System.out.println(leetCode.nthUglyNumber(9));
        System.out.println(leetCode.nthUglyNumber(8));
        System.out.println(leetCode.nthUglyNumber(7));
    }
}
