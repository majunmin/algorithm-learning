package com.majm.leetcode;

/**
 * https://leetcode-cn.com/problems/longest-mountain-in-array/ </br>
 *
 * @author majunmin
 * @description
 * @datetime 2021-06-08 23:43
 * @since
 */
public class LeetCode_0845 {


    // 时间复杂度:  O(n2)
    // 空间复杂度:  O(1)
    public int longestMountain(int[] arr) {
        int longestMountain = 0;
        for (int i = 1; i < arr.length - 1; i++) {
            int left = i;
            int right = i;
            while (left - 1 >= 0 && arr[left - 1] < arr[left]) {
                left--;
            }
            while (right + 1 < arr.length && arr[right + 1] < arr[right]) {
                right++;
            }
            if (left != i && right != i) {
                longestMountain = Math.max(right - left + 1, longestMountain);
            }
        }
        return longestMountain;
    }
}
