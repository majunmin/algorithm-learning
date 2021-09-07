package com.majm.leetcode;

import com.majm.Solution;

/**
 * 376. 摆动序列 </br>
 *
 * @author majunmin
 * @description
 * @datetime 2021-09-07 14:28
 * @since
 */
public class LeetCode_0376 implements Solution {


    @Override
    public int wiggleMaxLength(int[] nums) {

        return dpSolution2(nums);
    }


    /**
     * 优化空间的写法
     *
     * @param nums
     * @return
     */
    private int dpSolution2(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return len;
        }
        int up = 1;
        int down = 1;
        for (int i = 1; i < len; i++) {
            if (nums[i] > nums[i - 1]) {
                up = Math.max(down + 1, up);
            } else if (nums[i] < nums[i - 1]) {
                down = Math.max(up + 1, down);
            }
        }
        return Math.max(up, down);
    }


    /**
     * @param nums
     * @return
     */
    private int dpSolution1(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return len;
        }

        int[] up = new int[len];
        int[] down = new int[len];
        up[0] = 1;
        down[0] = 1;
        for (int i = 1; i < len; i++) {
            if (nums[i] > nums[i - 1]) {
                up[i] = Math.max(up[i - 1], down[i - 1] + 1);
                down[i] = down[i - 1];
            } else if (nums[i] < nums[i - 1]) {
                down[i] = Math.max(down[i - 1], up[i - 1] + 1);
                up[i] = up[i - 1];
            } else {
                down[i] = down[i - 1];
                up[i] = up[i - 1];
            }
        }
        return Math.max(up[len - 1], down[len - 1]);
    }

}
