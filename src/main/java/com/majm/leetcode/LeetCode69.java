package com.majm.leetcode;

import com.majm.Solution;

/**
 * @author majunmin
 * @description
 * @datetime 2020/11/14 3:37 下午
 * @since
 */
public class LeetCode69 implements Solution {

    @Override
    public int mySqrt(int x) {
        return solution2(x);
    }

    /**
     * 牛顿迭代法
     *
     * 时间复杂度
     * 空间复杂度
     *
     * @param x
     * @return
     */
    private int solution2(int x) {

        if (x == 1 || x == 0){
            return x;
        }

        // r >= x 是一个 猜测数，可以任意设置
        long r = x;
        while (r * r > x) {
            r = (r + x/r) / 2;
        }
        return (int)r;
    }

    /**
     * 二分查找法
     *
     * 时间复杂度: O(logN)
     * 空间复杂度: O(1)
     * @param x
     * @return
     */
    private int solution1(int x) {
        if (x == 1 || x == 0){
            return x;
        }
        int left = 0;
        int right = x;
        while (left < right) {
            int mid = (left + right) / 2;
            int curNum = mid * mid;
            if (curNum < x) {
                left = mid + 1;
            } else if (curNum > x) {
                right = mid - 1;
            }
        }
        return right;
    }
}
