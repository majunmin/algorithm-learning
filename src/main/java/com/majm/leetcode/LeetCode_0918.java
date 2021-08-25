package com.majm.leetcode;

import com.majm.Solution;

/**
 * 918. 环形子数组的最大和 </br>
 * https://leetcode-cn.com/problems/maximum-sum-circular-subarray/
 *
 * @author majunmin
 * @description
 * @datetime 2021-07-30 22:27
 * @since
 */
public class LeetCode_0918 implements Solution {

    /**
     * 分情况讨论
     * 1. 最大和在nums中,            其实就是 {@link LeetCode_0053} 的方法  Kanada算法
     * 2. 最大和在 nums 环形数组中,   那么最大和一定会包含头尾,所以计算出1 nums[1:N-1]的最小和 minSum, (total - minSum) 即为结果
     * <p>
     * Math.min(res1, res2);
     *
     * @param nums
     * @return
     */
    @Override
    public int maxSubarraySumCircular(int[] nums) {
        int maxSubArr = nums[0];
        int total = 0;
        int sum = 0;
        for (int num : nums) {
            sum = Math.max(num, sum + num);
            maxSubArr = Math.max(maxSubArr, sum);
            total += num;
        }

        int minSubArr = 0;
        sum = 0;
        for (int i = 1; i < nums.length; i++) {
            sum = Math.min(nums[i], nums[i] + sum);
            minSubArr = Math.min(minSubArr, sum);
        }

        return Math.max(maxSubArr, total - minSubArr);
    }

    /**
     * 优化解法一 仅遍历一遍数组
     *
     * @param nums
     * @return
     */
    private int solution2(int[] nums) {

        int total = 0;
        int maxSum = nums[0];
        int curMax = 0;
        int minSum = nums[0];
        int curMin = 0;

        for (int num : nums) {
            curMax = Math.max(num, num + curMax);
            maxSum = Math.max(maxSum, curMax);
            curMin = Math.min(num, num + curMin);
            minSum = Math.min(minSum, curMin);
            total += num;
        }
        return maxSum > 0 ? Math.max(maxSum, total - minSum) : maxSum;
    }


    /**
     * 复杂度分析:
     * <p>
     * 时间复杂度:O(N)，这里 NN 是数组的长度, 遍历了数组 2遍
     * 空间复杂度:O(1)
     *
     * @param nums
     * @return
     */
    private int solution1(int[] nums) {
        int cur = nums[0];
        int subMax = nums[0];
        int sum = nums[0];
        int N = nums.length;
        // 先根据  kannada 算法 算出 一个数组的最大子数组和
        for (int i = 1; i < N; i++) {
            sum += nums[i];
            cur = Math.max(nums[i], nums[i] + cur);
            subMax = Math.max(cur, subMax);
        }

        // 2. 算出 nums[1:n-1]  最小字段和, 用 sum - minSunArraySum ==> 最大字段和(包含两边的)
        // 溢出了
//        int subMin = nums[1];
//        cur = nums[1];
//        for (int i = 2; i < N - 1; i++) {
//            cur = Math.min(nums[i], nums[i] + cur);
//            subMin = Math.min(subMin, cur);
//        }
        int subMin = 0;
        cur = 0;
        for (int i = 1; i < N - 1; i++) {
            cur = Math.min(nums[i], nums[i] + cur);
            subMin = Math.min(subMin, cur);
        }

        return Math.max(subMax, sum - subMin);
    }

    private int maxSubArrayHelper(int[] nums) {
        int cur = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            cur = Math.max(nums[i], nums[i] + cur);
            max = Math.max(max, cur);
        }
        return max;
    }


    public static void main(String[] args) {
        final LeetCode_0918 leetCode = new LeetCode_0918();
        System.out.println(leetCode.maxSubarraySumCircular(new int[]{-2, 4, -5, 4, -5, 9, 4})); // 15
        System.out.println(leetCode.maxSubarraySumCircular(new int[]{5, -3, 5})); // 10
        System.out.println(leetCode.maxSubarraySumCircular(new int[]{1})); // 1
        System.out.println(leetCode.maxSubarraySumCircular(new int[]{-2})); // 1
        System.out.println(leetCode.maxSubarraySumCircular(new int[]{1, -2, 3, -2})); // 3
        System.out.println(leetCode.maxSubarraySumCircular(new int[]{-2, -3, -4})); // -2
    }
}
