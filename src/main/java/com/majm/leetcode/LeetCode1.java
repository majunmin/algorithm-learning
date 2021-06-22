package com.majm.leetcode;

import com.majm.Solution;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author majunmin
 * @description
 * @datetime 2020/10/21 9:09 上午
 * @since
 */
public class LeetCode1 implements Solution {

    @Override
    public int[] twoSum(int[] nums, int target) {
        return solution1(nums, target);
    }


    /**
     * 暴力破解
     * 时间复杂度：O(N^2)
     * 空间复杂度：O(1)
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] solution1(int[] nums, int target) {
        if (nums != null && nums.length < 2) {
            return null;
        }

        // 1. 暴力  O(n^2)
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (target == nums[i] + nums[j]) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }


    /**
     * hash 表法
     * 时间复杂度  O(N)
     * 空间复杂度  O(N
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] solution2(int[] nums, int target) {
        if (nums != null && nums.length < 2) {
            return null;
        }
        // 2. hash  O(N)
        // 使用哈希表，可以将寻找 target - x 的时间复杂度降低到从 O(N) 降低到 O(1)。
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            int k = target - nums[i];
            if (hashMap.containsKey(k)) {
                return new int[]{hashMap.get(k), i};
            }
            hashMap.put(nums[i], i);
        }
        return new int[]{};
    }
}
