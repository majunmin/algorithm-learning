package com.majm.offer;

import java.util.Arrays;

/**
 * 剑指 Offer 61. 扑克牌中的顺子 </br>
 * https://leetcode-cn.com/problems/bu-ke-pai-zhong-de-shun-zi-lcof/
 *
 * @author majunmin
 * @description
 * @datetime 2021-09-28 15:05
 * @since
 */
public class Offer61 {


    /**
     * result = (max - min) < 5
     *
     * @param nums
     * @return
     */
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int min = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                continue;
            }
            if (i != 0 && nums[i] == nums[i - 1]) {
                return false;
            }
            if (min == -1) {
                min = nums[i];
            }
        }
        return (nums[4] - min) < 5;
    }
}
