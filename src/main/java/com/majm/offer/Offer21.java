package com.majm.offer;

/**
 * 剑指 Offer 21. 调整数组顺序使奇数位于偶数前面 </br>
 * https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/
 *
 * @author majunmin
 * @description
 * @datetime 2021-09-25 16:03
 * @since
 */
public class Offer21 {


    /**
     * @param nums
     * @return
     */
    public int[] exchange(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            while (left < right && nums[left] % 2 == 1) {
                left++;
            }
            while (left < right && nums[right] % 2 == 0) {
                right--;
            }
            if (left < right) {
                swap(nums, left, right);
            }
        }
        return nums;
    }

    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
