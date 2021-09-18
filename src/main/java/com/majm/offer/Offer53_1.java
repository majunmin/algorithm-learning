package com.majm.offer;

/**
 * 剑指 Offer 53 - I. 在排序数组中查找数字 I </br>
 * <p>
 * https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/
 *
 * @author majunmin
 * @description
 * @datetime 2021-09-16 19:16
 * @since
 */
public class Offer53_1 {

    /**
     * 排序数组的优化 首先想到的就是二分查找  binarySearch
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        int left = searchLeft(nums, target);
        int right = searchRight(nums, target);
        // 没找到 target
        if (nums[left] != target) {
            return 0;
        }
        return right - left + 1;

    }

    private int searchRight(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (nums[mid] <= target) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    private int searchLeft(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        Offer53_1 offer = new Offer53_1();
        System.out.println(offer.search(new int[]{5, 7, 7, 8, 8, 10}, 8));
    }
}
