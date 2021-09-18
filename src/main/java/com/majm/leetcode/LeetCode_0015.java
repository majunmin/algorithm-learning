package com.majm.leetcode;

import com.majm.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author majunmin
 * @description
 * @datetime 2020/10/21 9:46 上午
 * @since
 */
public class LeetCode_0015 implements Solution {

    @Override
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 3) {
            return result;
        }
        // 排序 + 双指针
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            //
            if (nums[i] > 0) {
                break;
            }
            // 不允许重复
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // 双指针
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                if (nums[i] + nums[j] + nums[k] == 0) {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    while (nums[j] == nums[++j] && j < k) {
                    }
                    while (nums[k] == nums[--k] && k > j) {
                    }
                } else if (nums[i] + nums[j] + nums[k] < 0) {
                    j++;
                } else {  // (nums[i] + nums[j] + nums[k] > 0)
                    k--;
                }
            }
        }

        return result;
    }

    /**
     * @param nums
     * @return
     */
    private List<List<Integer>> solution_1(int[] nums) {

        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }
        //         用于去重
        Set<List<Integer>> res = new HashSet<>();

//         1. 暴力解法 (超出时间限制) ()
//         Arrays.sort  O(n log(n))
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; ++i) {
            for (int j = i + 1; j < nums.length - 1; ++j) {
                for (int k = j + 1; k < nums.length; ++k) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    }
                }
            }
        }

        return new ArrayList<>(res);
    }

    /**
     * 排序 + 双指针 => 夹逼算法
     * 时间复杂度:
     * 空间复杂度:
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> solution1(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int len = nums.length;
        Arrays.sort(nums);

        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) {
                return result;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = len - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[++left]) {
                    }
                    while (left < right && nums[right] == nums[--right]) {
                    }
                } else if (sum < 0) {
                    while (left < right && nums[left] == nums[++left]) {
                    }
                } else {
                    while (left < right && nums[right] == nums[--right]) {
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        final Solution leetCode = new LeetCode_0015();
        int[] arr1 = new int[]{-1, 0, 1, 2, -1, -4};
        int[] arr2 = new int[]{-1, 0, 1, 2, -1, -4,};
        System.out.println(leetCode.threeSum(arr1));
        System.out.println(leetCode.threeSum(arr1));
        System.out.println(leetCode.threeSum(arr1));
    }

}