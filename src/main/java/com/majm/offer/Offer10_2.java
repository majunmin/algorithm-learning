package com.majm.offer;

import java.sql.Array;

/**
 * 剑指 Offer 10- II. 青蛙跳台阶问题 </br>
 * https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/
 *
 * @author majunmin
 * @description
 * @datetime 2021-09-18 09:40
 * @since
 */
public class Offer10_2 {


    /**
     * 观察规律可以得出  这是一个 斐波那锲数列问题
     * 青蛙 跳到 第 n 级台阶 可以是 从 第(n-1) or (n-2) 级台阶跳过来的
     * f(n) = f(n-1) + f(n-2)   n>=2
     * f(0) = f(1) = 1
     *
     * @param n
     * @return
     */
    public int numWays(int n) {
        return solution2(n);
    }

    private int solution2(int n) {
        return 0;
    }

    /**
     * 自底向上的动态规划解法
     *
     * @param n
     * @return
     */
    private int solution1(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = (int) ((dp[i - 1] + dp[i - 2]) % (1e9 + 7));
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Offer10_2 offer = new Offer10_2();
        System.out.println(offer.numWays(21));
    }

}
