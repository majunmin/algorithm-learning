package com.majm.offer;

/**
 * 剑指 Offer 15. 二进制中1的个数 </br>
 * https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof/
 *
 * @author majunmin
 * @description
 * @datetime 2021-10-09 01:18
 * @since
 */
public class Offer15 {

    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int cnt = 0;
        while (n > 0) {
            n = n & (n -1); // n & (n - 1) 将二进制 最后一个 1 清0
            cnt++;
        }
        return cnt;
    }
}
