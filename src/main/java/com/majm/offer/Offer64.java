package com.majm.offer;

/**
 * 剑指 Offer 64. 求1+2+…+n </br>
 * https://leetcode-cn.com/problems/qiu-12n-lcof/
 *
 * @author majunmin
 * @description
 * @datetime 2021-10-07 19:21
 * @since
 */
public class Offer64 {

    public int sumNums(int n) {
        if (n == 1) {
            return 1;
        }
        return sumNums(n - 1) + n;
    }

}
