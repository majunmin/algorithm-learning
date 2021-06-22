package com.majm.common;

/**
 * https://leetcode-cn.com/problems/climbing-stairs/ </br>
 *
 * @author majunmin
 * @description
 * @datetime 2021-06-09 22:41
 * @since
 */
public class Leetcode_0070 {


    public int climbStairs(int n) {
        return solution2(n);
    }

    /**
     * 时间复杂度  O(1)
     * 时间复杂度  O(N)
     * 因为需要暂存前两次的 结果, 可以使用两个 数字记录(减少空间)
     *
     * 1   1    2   3   5
     * p   q
     * ==>pq 右移  ==>  p, q = q, p+q
     *
     * @param n
     * @return
     */
    private int solution2(int n) {
        if (n == 1) {
            return 1;
        }
        int p = 1;
        int q = 1;
        for (int i = 2; i < n; i++) {
            int temp = q;
            q = p + q;
            p = q;

        }
        return q;
    }


    // 时间复杂度  O(N)
    // 时间复杂度  O(N)
    // 通过 一个数组缓存, f(n) = f(n-1) + f(n-2)
    private int solution1(int n) {
        int[] path = new int[n];
        path[0] = 1;
        path[1] = 1;
        for (int i = 2; i < n; i++) {
            path[i] = path[i - 1] + path[i - 2];
        }
        return path[n - 1];
    }

}
