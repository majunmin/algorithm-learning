package com.majm.offer;

/**
 * 剑指 Offer 16. 数值的整数次方 </br>
 * https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof/
 *
 * @author majunmin
 * @description
 * @datetime 2021-10-09 00:15
 * @since
 */
public class Offer16 {

    public double myPow(double x, int n) {
        return solution2(x, n);
    }


    /**
     * 快速幂解法
     * 数学公式推导
     * https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof/solution/mian-shi-ti-16-shu-zhi-de-zheng-shu-ci-fang-kuai-s/
     *
     * @param x
     * @param n
     * @return
     */
    private double solution2(double x, int n) {
        if (n == 0) {
            return 1;
        }
        double result = 1;
        long b = n;
        if (b < 0) {
            x = 1 / x;
            b = -b; // b 恢复正数
        }
        while (b > 0) {
            if (((b & 1) == 1)) {
                result *= x;
            }
            x = x * x;
            b >>= 1;
        }
        return result;
    }

    private double normalSolution(double x, int n) {
        double result = 1;
        int i = 0;
        int cnt = Math.abs(n);
        while (i < cnt) {
            result *= x;
            i++;
        }
        return n >= 0 ? result : 1 / result;
    }

}
