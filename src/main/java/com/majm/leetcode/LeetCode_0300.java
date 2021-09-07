package com.majm.leetcode;

import com.majm.Solution;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 300. 最长递增子序列 </br>
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/
 * 1. 暴力搜索递归解法
 * 2. 添加 hashMap , 记忆化搜索
 *
 * @author majunmin
 * @description
 * @datetime 2021-07-14 21:08
 * @since
 */
public class LeetCode_0300 implements Solution {


    /**
     * 动态规划方程
     * 1. dp[i] = max(dp[j])+1  condition: 0 <= j < i && nums[i] > nums[j]
     *
     * @param nums
     * @return
     */
    @Override
    public int lengthOfLIS(int[] nums) {
        if (nums == null) {
            return 0;
        }
        final int len = nums.length;
        if (len == 0 || len == 1) {
            return len;
        }

        // dp[i] 以 i结尾的  最长递增子序列的长度
        int[] dp = new int[len];
        dp[0] = 1;
        int result = dp[0];
        for (int i = 1; i < len; i++) {
            int maxLen = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    maxLen = Math.max(maxLen, dp[j] + 1);
                }
            }
            dp[i] = maxLen;
            result = Math.max(result, maxLen);
        }
        return result;
    }


    private int dpSolution(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
        }
        int maxLen = dp[0];
        for (int i = 1; i < dp.length; i++) {
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }


    Map<Integer, Integer> cache = new HashMap<>();

    /**
     * 递归暴力解法, 可通过 cache 提高性能(记忆化搜索,防止重复计算)
     *
     * @param nums
     * @return
     */
    private int solution1(int[] nums) {
        int maxLen = 1;
        for (int i = 0; i < nums.length; i++) {
            maxLen = Math.max(maxLen, length(nums, 0, new HashMap<>()));
        }
        return maxLen;
    }

    private int length(int[] nums, int idx, Map<Integer, Integer> cache) {
        if (idx == nums.length - 1) {
            return 1;
        }
        if (cache.containsKey(idx)) {
            return cache.get(idx);
        }
        int maxLen = 1;
        for (int i = idx + 1; i < nums.length; i++) {
            maxLen = Math.max(maxLen, i);
        }
        // fill cache
        cache.put(idx, maxLen);
        return maxLen;
    }

    public static void main(String[] args) {
        final Solution leetCode = new LeetCode_0300();
        System.out.println(leetCode.lengthOfLIS(new int[]{1, 3, 6, 7, 9, 4, 10, 5, 6}));
    }
}
