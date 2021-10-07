package com.majm.leetcode;

import com.majm.Solution;

/**
 * 215. 数组中的第K个最大元素 </br>
 *
 * @author majunmin
 * @description
 * @datetime 2021-09-22 11:35
 * @since
 */
public class LeetCode_0215 implements Solution {

    /**
     * @param nums
     * @param k
     * @return
     */
    @Override
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        if (k < 0 || k > len) {
            return -1;
        }
        return quickFind(nums, 0, len - 1, k);
    }

    private int quickFind(int[] nums, int left, int right, int k) {
        // terminate
        int partition = partition(nums, left, right);
        if (partition == k - 1) {
            return nums[partition];
        } else if (partition < k - 1) {
            return quickFind(nums, partition + 1, right, k);
        } else {
            return quickFind(nums, left, partition - 1, k);
        }
    }

    private int partition(int[] nums, int left, int right) {
        int cnt = left;
        // 基准值
        int pivot = nums[right];
        for (int i = left; i < right; i++) {
            if (nums[i] > pivot) {
                swap(nums, i, cnt);
                cnt++;
            }
        }
        swap(nums, cnt, right);
        return cnt;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        Solution leetCode = new LeetCode_0215();
        System.out.println(leetCode.findKthLargest(new int[]{-1, 2, 0}, 3));
    }
}
