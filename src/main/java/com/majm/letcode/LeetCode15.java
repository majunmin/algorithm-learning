package com.majm.letcode;

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
public class LeetCode15 implements Solution {

    @Override
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }

        // 用于去重
        Set<List<Integer>> res = new HashSet<>();

        // 1. 暴力解法 (超出时间限制) ()
        // Arrays.sort  O(n log(n))
//        Arrays.sort(nums);
//        Set<List<Integer>> res = new HashSet<>();
//
//        for (int i = 0; i < nums.length - 2; ++i) {
//            for (int j = i + 1; j < nums.length - 1; ++j) {
//                for (int k = j + 1; k < nums.length; ++k) {
//                    if (nums[i] + nums[j] + nums[k] == 0){
//                        res.add(Arrays.asList(nums[i], nums[j], nums[k]));
//                    }
//                }
//            }
//        }

        // 2. hash表法
//        List<List<Integer>> res = new ArrayList<>();

//        Arrays.sort(nums);
//        for (int i = 0; i < nums.length - 2; i++) {
//            int target = - nums[i];
//            Set<Integer> set = new HashSet<>();
//            for (int j = 0; j < nums.length; j++) {
//                if (set.contains(target - nums[j])){
//                    res.add(Arrays.asList(nums[i], target - nums[j], nums[j]));
//                }
//                set.add(nums[j]);
//            }
//        }
//        return res;

        // 3. 夹逼


        Arrays.sort(nums); // O(nlogn)
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while(left < right) {
                if (nums[left] + nums[right] + nums[i] == 0) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // 去重逻辑应该放在找到一个三元组之后
                    while (right > left && nums[right] == nums[--right]){}
                    while (right > left && nums[left] == nums[++left]){}

//                  找到答案时，双指针同时收缩
                    right--;
                    left++;
                } else if (nums[left] + nums[right] + nums[i] < 0) {
                    while (left < right && nums[left] == nums[--left]) {
                    }
                } else if (nums[left] + nums[right] + nums[i] > 0) {
                    while (left < right && nums[right] == nums[--right]) {
                    }
                }
            }
        }


        return new ArrayList<>(res);
    }
}
