package com.majm.leetcode;

import com.majm.Solution;

/**
 * @author majunmin
 * @description
 * @datetime 2020/11/14 4:30 下午
 * @since
 */
public class LeetCode367 implements Solution {

    @Override
    public boolean isPerfectSquare(int num) {
        if (num == 0) {
            return false;
        }
        long left = 0;
        long right = num;
        while (left < right) {
            long mid = (left + right) / 2;
            long curNum = mid * mid;
            if (curNum == num) {
                return true;
            } else if (curNum < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
