package com.majm.leetcode;

import com.majm.Solution;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * 217. 存在重复元素 </br>
 *
 * @author majunmin
 * @description
 * @datetime 2021-08-28 00:25
 * @since
 */
public class LeetCode_0217 implements Solution {

    @Override
    public boolean containsDuplicate(int[] nums) {
        return solution2(nums);
    }

    /**
     * hash表
     *
     * @param nums
     * @return
     */
    private boolean solution2(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
        }
        return false;
    }

    private boolean solution1(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return true;
            }
        }
        return false;
    }

}
