package com.majm.leetcode;

import com.majm.Solution;

import java.util.Arrays;

/**
 * 350. 两个数组的交集 II </br>
 * https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/
 *
 * @author majunmin
 * @description
 * @datetime 2021-08-29 21:56
 * @since
 */
public class LeetCode_0350 implements Solution {

    @Override
    public int[] intersect(int[] nums1, int[] nums2) {
        return hashSolution(nums1, nums2);
    }


    /**
     * 锻炼思维
     * https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/solution/liang-ge-shu-zu-de-jiao-ji-ii-by-leetcode-solution/
     *
     * @param nums1
     * @param nums2
     * @return
     */
    private int[] hashSolution(int[] nums1, int[] nums2) {
        return new int[0];
    }


    /**
     * 排序 + 双指针
     *
     * @param nums1
     * @param nums2
     * @return
     */
    private int[] solution1(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int l1 = 0;
        int l2 = 0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int[] result = new int[Math.max(len1, len2)];
        int index = 0;
        while (l1 < len1 && l2 < len2) {
            if (nums1[l1] == nums2[l2]) {
                result[index++] = nums1[l1];
                // 短的 数组++
                l1++;
            } else if (nums1[l1] < nums2[l2]) {
                l1++;
            } else {
                l2++;
            }
        }
        return Arrays.copyOfRange(result, 0, index);
    }
}
