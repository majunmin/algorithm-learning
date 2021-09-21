package com.majm.offer;

/**
 * 剑指 Offer 10- I. 斐波那契数列 </br>
 * https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof/
 *
 * @author majunmin
 * @description
 * @datetime 2021-09-21 00:03
 * @since
 */
public class Offer10_1 {


    public int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int p = 0;
        int q = 1;
        for (int i = 2; i <= n; i++) {
            int tmp = q;
            q = (int) ((p + q) % (1e9 + 7));
            p = tmp;
        }
        return q;
    }
}
