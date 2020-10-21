package com.majm.letcode;

import com.majm.Solution;

/**
 * @author majunmin
 * @description
 * @datetime 2020/10/20 10:52 下午
 * @since
 */
public class LeetCode283 implements Solution {

    @Override
    public void moveZeroes(int[] nums) {

        if (nums == null || nums.length < 2){
            return;
        }

        // solution1 switch (两层遍历)
//        int len = nums.length;
//        for (int i = 0; i < len - 1; i++) {
//            if (nums[i] == 0) {
//                int j = i + 1;
//                for (; j < len; j++) {
//                    if (nums[j] != 0) {
//                        int tmp = nums[i];
//                        nums[i] = nums[j];
//                        nums[j] = tmp;
//                        break;
//                    }
//                }
//                if (j == len) {
//                    return;
//                }
//            }
//        }

        // 双指针 1
        // 双指针优化

//        int cur = 0;
//        int i = 0;
//        while(i < nums.length){
//            if (nums[i] != 0){
//                nums[cur++] = nums[i];
//            }
//            ++i;
//        }
//        while(cur < nums.length){
//            nums[cur++] = 0;
//        }

        // 双指针 2
        int cur = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] != 0){
                if (nums[cur] == 0){
                    nums[cur] = nums[i];
                    nums[i] = 0;
                }
                cur++;
            }

        }


    }
}
