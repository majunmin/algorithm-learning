package com.majm.leetcode;

import com.majm.Solution;

/**
 * 感觉这道题就是得考虑各种情况
 *
 *
 *
 * @author majunmin
 * @description
 * @datetime 2020/11/3 4:03 下午
 * @since
 */
public class LeetCode_0941 implements Solution {

    @Override
    public boolean validMountainArray(int[] A) {
        return solution1(A);
    }

    public boolean solution1(int[] A) {
        int len = A.length;
        if (len < 3) {
            return false;
        }
        int i = 0;
        // 单调增
        while(i < len - 1 && A[i+1] > A[i]) {
            ++i;
        }

        if (i == 0 || i == len - 1){
            return false;
        }

        // 单调减
        while(i < len - 1 && A[i + 1] < A[i]) {
            i++;
        }

        return i == len - 1;
    }
}
