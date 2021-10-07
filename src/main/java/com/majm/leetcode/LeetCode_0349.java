package com.majm.leetcode;

import com.majm.Solution;

import java.util.Arrays;

/**
 * 349. 两个数组的交集 </br>
 *
 * @author majunmin
 * @description
 * @datetime 2021-08-29 22:03
 * @since
 */
public class LeetCode_0349 implements Solution {


    @Override
    public int[] intersection(int[] nums1, int[] nums2) {
        return solution1(nums1, nums2);
    }


    /**
     * 排序加 双指针
     * 或者 用 hashSet 来存储结果
     *
     * @param nums1
     * @param nums2
     * @return
     */
    private int[] solution1(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] result = new int[Math.max(len1, len2)];
        int l1 = 0;
        int l2 = 0;
        int index = 0;
        while (l1 < len1 && l2 < len2) {
            if (nums1[l1] == nums2[l2]) {
                // 加入的元素唯一性
                if (index == 0 || nums1[l1] != result[index - 1]) {
                    result[index++] = nums1[l1];
                }
                ++l1;
                ++l2;
            } else if (nums1[l1] < nums2[l2]) {
                ++l1;
            } else {
                ++l2;
            }
        }
        return Arrays.copyOfRange(result, 0, index);
    }
}
