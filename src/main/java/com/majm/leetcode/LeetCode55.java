package com.majm.leetcode;

import com.majm.Solution;

/**
 * @author majunmin
 * @description
 * @datetime 2020/11/14 2:56 下午
 * @since
 */
public class LeetCode55 implements Solution {


    @Override
    public boolean canJump(int[] nums) {
        return solution1(nums);
    }


    /**
     * 贪心算法比较简单(算法比较巧妙，比较不容易想到)
     *
     * 时间复杂度 O(N)
     * 空间复杂度 O(1
     *
     * @param nums
     * @return
     */
    public boolean solution1(int[] nums) {
        int len = nums.length;
        int canReachable = len - 1;
        for (int i = len - 1; i >= 0; i--) {
            if (nums[i] + i >= canReachable) {
                canReachable = i;
            }
        }
        return canReachable == 0;
    }
}
