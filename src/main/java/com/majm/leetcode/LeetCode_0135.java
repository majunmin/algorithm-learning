package com.majm.leetcode;

import com.majm.Solution;

/**
 * 135. 分发糖果 </br>
 *
 * @author majunmin
 * @description
 * @datetime 2021-08-30 11:36
 * @since
 */
public class LeetCode_0135 implements Solution {

    @Override
    public int candy(int[] ratings) {
        int result = 1;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] < ratings[i - 1]) {

            }
        }
        return result;
    }

}
