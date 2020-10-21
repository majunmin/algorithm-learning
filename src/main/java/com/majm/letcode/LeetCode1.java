package com.majm.letcode;

import com.majm.Solution;

import java.util.HashMap;

/**
 * @author majunmin
 * @description
 * @datetime 2020/10/21 9:09 上午
 * @since
 */
public class LeetCode1 implements Solution {

    @Override
    public int[] twoSum(int[] nums, int target) {
        if (nums != null && nums.length < 2) {
            return null;
        }
//        int[] result = new int[2];
//        // 1. 暴力  O(n^2)
//        for (int i = 0; i < nums.length - 1; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                if (target == nums[i] + nums[j]) {
//                    result[0] = i;
//                    result[1] = j;
//                    return result;
//                }
//            }
//        }
//        return result;

        // 2. hash  O(N)
        // 使用哈希表，可以将寻找 target - x 的时间复杂度降低到从 O(N) 降低到 O(1)。
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            int k = target - nums[i];
            if (hashMap.containsKey(k)){
                return new int[]{hashMap.get(k), i};
            }
            hashMap.put(nums[i], i);
        }
        return new int[]{};

    }
}
