package com.majm.leetcode;

import com.majm.Solution;

/**
 * https://leetcode-cn.com/problems/merge-sorted-array/ </br>
 *
 * @author majunmin
 * @description
 * @datetime 2021-06-20 21:54
 * @since
 */
public class LeetCode_0088 implements Solution {

    /**
     * 归并排序的一个步骤 => 合并两个有序数组
     * <p>
     * nums1.length = m + n
     * nums2.length = n
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    @Override
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        solution2(nums1, m, nums2, n);
    }

    private void solution2(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        }

        int[] result = new int[m+n];
        int idx = 0;
        int i = 0;
        int j = 0;
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                result[idx++] = nums1[i++];
            } else {
                result[idx++] = nums2[j++];
            }
        }

        while (i < m) {
            result[idx++] = nums1[i++];
        }
        while (j < n) {
            result[idx++] = nums2[j++];
        }
        for (int k = 0; k < result.length; k++) {
            nums1[k] = result[k];
        }
    }

    /**
     * 暴力解法
     * 时间复杂度  O(N^2)
     * 空间复杂度  O(1)
     *
     * @param nums1
     * @param m
     * @param nums2
     */
    private void solution1(int[] nums1, int m, int[] nums2, int n) {
        int insertIdx = 0;
        for (int curNum : nums2) {
            while (insertIdx < m && nums1[insertIdx] <= curNum) {
                insertIdx++;
            }
            for (int j = m - 1; j >= insertIdx; j--) {
                nums1[j + 1] = nums1[j];
            }
            m++;
            nums1[insertIdx++] = curNum;
        }
    }
}
