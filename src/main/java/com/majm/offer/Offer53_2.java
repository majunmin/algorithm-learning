package com.majm.offer;

/**
 * 剑指 Offer 53 - II. 0～n-1中缺失的数字 </br>
 * https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof/
 *
 * @author majunmin
 * @description
 * @datetime 2021-09-16 19:16
 * @since
 */
public class Offer53_2 {

    /**
     * 二分查找, 找到左边第一个 不满足条件(idx = nums[idx])的 数组 idx
     *
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == mid) {
                // 缺失数字在右边
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        // [0]
        if (nums[left] == left) {
            return left + 1;
        }
        return left;
    }
}
