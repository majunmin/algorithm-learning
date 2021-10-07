package com.majm.leetcode;

import com.majm.Solution;

/**
 * 一句话功能简述 </br>
 *
 * @author majunmin
 * @description
 * @datetime 2021-07-03 10:19
 * @since
 */
public class LeetCode_0278 implements Solution {

    @Override
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;

        while (left < right) {
            int mid = left + (right - left) / 2; //中间偏左
//            int mid = left + (right - left + 1) >> 1; //中间偏右
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        // 退出循环时 left == right 成立
        if (isBadVersion(left)) {
            return left;
        }
        return -1;
    }

    private boolean isBadVersion(int version) {
        return version >= 7;
    }

    public static void main(String[] args) {
        final LeetCode_0278 leetCode = new LeetCode_0278();
        System.out.println(leetCode.firstBadVersion(10));
    }

}
