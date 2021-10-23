package com.majm.offer;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 剑指 Offer 49. 丑数 </br>
 * https://leetcode-cn.com/problems/chou-shu-lcof/
 *
 * @author majunmin
 * @description
 * @datetime 2021-10-23 15:37
 * @since
 */
public class Offer49 {

    public int nthUglyNumber(int n) {
        return dpSolution(n);
    }

    private int dpSolution(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException();
        }
        int[] dp = new int[n];
        dp[0] = 1;
        int p2 = 0;
        int p3 = 0;
        int p5 = 0;
        for (int i = 0; i < n; i++) {
            int num2 = dp[p2] * 2;
            int num3 = dp[p3] * 3;
            int num5 = dp[p5] * 5;
            int minVal = Math.min(num2, Math.min(num3, num5));
            if (minVal == num2) {
                p2++;
            }
            if (minVal == num3) {
                p3++;
            }
            if (minVal == num5) {
                p5++;
            }
        }
        return dp[n - 1];
    }


    /**
     * 最小堆 + hash表(去重)
     *
     * @param n
     * @return
     */
    private int headSolution(int n) {
        int[] factors = new int[]{2, 3, 5};
        Set<Long> visited = new HashSet<>();
        PriorityQueue<Long> pq = new PriorityQueue<>(Long::compareTo);
        pq.offer(1L);
        long result = 1L;
        for (int i = 0; i < n; i++) {
            result = pq.poll();
            for (int factor : factors) {
                if (visited.add(result * factor)) {
                    pq.offer(result * factor);
                }
            }
        }
        return ((int) result);
    }
}
