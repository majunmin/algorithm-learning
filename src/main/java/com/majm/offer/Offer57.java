package com.majm.offer;

import com.majm.structor.tree.SegmentTree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 剑指 Offer 57. 和为s的两个数字 </br>
 * https://leetcode-cn.com/problems/he-wei-sde-liang-ge-shu-zi-lcof/
 *
 * @author majunmin
 * @description
 * @datetime 2021-09-25 16:09
 * @since
 */
public class Offer57 {


    public int[] twoSum(int[] nums, int target) {
        // 双指针解法
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int leftVal = nums[left];
            int rightVal = nums[right];
            if (leftVal + rightVal == target) {
                return new int[]{leftVal, rightVal};
            } else if (leftVal + rightVal > target) {
                right--;
            } else {
                left++;
            }
        }
        return new int[2];
    }

    /**
     * 两数之和
     *
     * @param nums
     * @param target
     * @return
     */
    private int[] solution1(int[] nums, int target) {
        int[] result = new int[2];
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(target - num)) {
                return new int[]{target - num, num};
            }
            set.add(num);
        }
        return result;
    }
}
