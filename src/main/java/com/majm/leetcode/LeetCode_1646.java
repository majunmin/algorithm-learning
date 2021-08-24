package com.majm.leetcode;

import com.majm.Solution;

import java.util.Arrays;

/**
 * 1646. 获取生成数组中的最大值 </br>
 * https://leetcode-cn.com/problems/get-maximum-in-generated-array/
 *
 * @author majunmin
 * @description
 * @datetime 2021-08-23 23:18
 * @since
 */
public class LeetCode_1646 implements Solution {

    /**
     * 奇数偶数判断
     * nums[2n] = nums[n]
     * nums[2n+1] = nums[n] + nums[n+1]
     *
     * @param n
     * @return
     */
    public int getMaximumGenerated(int n) {
        if (n == 0) {
            return 0;
        }
        int[] nums = new int[n + 1];
        nums[1] = 1;
        for (int i = 2; i < nums.length; i++) {
            // 奇偶数判断
            nums[i] = ((i & 1) == 0 ? 0 : nums[i / 2 + 1]) + nums[i / 2];
        }
        return Arrays.stream(nums).max().getAsInt();
    }

    public static void main(String[] args) {
        final LeetCode_1646 leetCode = new LeetCode_1646();
        System.out.println(leetCode.getMaximumGenerated(7));
    }
}


