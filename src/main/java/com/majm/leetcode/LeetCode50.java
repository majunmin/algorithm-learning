package com.majm.leetcode;

import com.majm.Solution;

/**
 * @author majunmin
 * @description
 * @datetime 2020/11/7 9:37 上午
 * @since
 */
public class LeetCode50 implements Solution {

    @Override
    public double myPow(double x, int n) {
        if (x == 0 && n != 0) {
            throw new IllegalArgumentException();
        }
        return n > 0 ? customPow2(x, n) : 1 / customPow2(x, -n);
    }


    /**
     * 快速幂 + 迭代
     *
     * @param x
     * @param n
     * @return
     */
    private double customPow2(double x, int n) {
        double res = 1.0;
        double contribute = x;
        while (n > 0) {
            if (n % 2 == 1) {
                res *= contribute;
            }
            contribute *= contribute;
            n /= 2;
        }
        return res;
    }


    /**
     * 递归
     * 时间复杂度: O(logN)  递归的层数
     * 空间复杂度: O(logN)  递归的层数
     * <p>
     * x128^ -> x^64 -> x^32 -> x^16 -> x^8 -> x^4 -> x^2
     *
     * @param x
     * @param n
     * @return
     */
    private double customPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        double val = customPow(x, n / 2);
        return (n & 1) == 0 ? val * val : val * val * x;
    }
}
