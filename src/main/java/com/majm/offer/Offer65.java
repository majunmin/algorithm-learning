package com.majm.offer;

/**
 * 剑指 Offer 65. 不用加减乘除做加法 </br>
 * https://leetcode-cn.com/problems/bu-yong-jia-jian-cheng-chu-zuo-jia-fa-lcof/
 *
 * @author majunmin
 * @description
 * @datetime 2021-10-09 23:12
 * @since
 */
public class Offer65 {
    /**
     * 进位      本位
     * 1 + 1 = 10  (1 & 1     1 ^ 1)
     * 1 + 0 = 01  (1 & 0     1 ^ 0)
     * 0 + 1 = 01  (0 & 1     0 ^ 1)
     * 0 + 0 = 00  (0 & 0     0 ^ 0)
     *
     * @param a
     * @param b
     * @return
     */
//    //进位
//    int c = (a & b) << 1;
//    // 本位
//    int d = (a ^ b) << 1;
//        return c | d;
    public int add(int a, int b) {
        return iterSolution(a, b);
    }

    private int recurSolution(int a, int b) {
        // terminate
        if (a == 0 || b == 0) {
            // a ^ ~0 = a
            return a ^ b;
        }
        //  a ^ b  本位
        //  (a & b) << 1 进位
        return recurSolution(a ^ b, (a & b) << 1);
    }


    private int iterSolution(int a, int b) {
        while (b != 0) {
            int c = a ^ b;
            b = (a & b) << 1;
            a = c;
        }
        return a;
    }
}
