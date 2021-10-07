package com.majm.leetcode;

import com.majm.Solution;

/**
 * 371. 两整数之和 </br>
 *
 * @author majunmin
 * @description
 * @datetime 2021-09-26 17:02
 * @since
 */
public class LeetCode_0371 implements Solution {


    /**
     * 位运算
     * 0 ^ 0 = 0
     * 1 ^ 0 = 1
     * 0 ^ 1 = 1
     * 1 ^ 1 = 0
     * <p>
     * a+b 拆分为  (a b 的无进位结果) + (a b 的进位结果)
     * 无进位加法有异或操作得出
     * 进位结果 由 & 和 移位运算 得出
     * 循环此过程,直到进位 = 0
     *
     * @param a
     * @param b
     * @return
     */
    @Override
    public int getSum(int a, int b) {
        while (b != 0) {
            int carry = a & b << 1;
            a = a ^ b;
            b = carry;
        }
        return a;
    }

}
