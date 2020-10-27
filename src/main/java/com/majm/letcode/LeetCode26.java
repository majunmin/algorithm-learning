package com.majm.letcode;

import com.majm.Solution;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author majunmin
 * @description
 * @datetime 2020/10/27 7:42 下午
 * @since
 */
public class LeetCode26 implements Solution {

    @Override
    public int removeDuplicates(int[] nums) {
        // error
//        if (nums == null || nums.length == 0)
//            return 0;
//
//        Set<Integer> set = new HashSet<>();
//        int cur = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if (set.contains(i) || cur == i) {
//                continue;
//            } else {
//                nums[cur++] = nums[i];
//                set.add(nums[i]);
//            }
//        }
//        return set.size();

        /**
         * 时间复杂度 O(n)
         * 空间复杂度 O(1)
         */
//        if (nums == null || nums.length == 0) {
//            return 0;
//        }
//        int cur = 0;
//        for (int i = 1; i < nums.length; i++) {
//            if (nums[cur] != nums[i]){
//                nums[++cur] = nums[i];
//            }
//        }
//        return cur;

        // 解法优化  当 q-p > 1 时，才进行复制，减少复制的次数

        if (nums == null || nums.length == 0) {
            return 0;
        }
        int cur = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[cur] != nums[i]) {
                if (i- cur > 1) {
                    nums[++cur] = nums[i];
                } else {
                    ++cur;
                }
            }
        }
        return cur;
    }
}
