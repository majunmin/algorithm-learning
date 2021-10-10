package com.majm.offer;

import java.util.Arrays;

/**
 * 剑指 Offer 39. 数组中出现次数超过一半的数字 </br>
 * https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof/
 *
 * @author majunmin
 * @description
 * @datetime 2021-10-10 00:52
 * @since
 */
public class Offer39 {

    public int majorityElement(int[] nums) {
        return solution(nums);
    }

    /**
     * 摩尔投票
     *
     * @param nums
     * @return
     */
    private int solution(int[] nums) {
        int cnt = 1;
        int candidate = nums[0];
        for (int i = 1; i < nums.length; i++) {

            if (candidate == nums[i]) {
                ++cnt;
            } else if (--cnt == 0) {
                candidate = nums[i];
                cnt = 1;
            }
        }

        return candidate;
    }

    /**
     * 排序算法
     * 众数一定在中间
     *
     * @param nums
     * @return
     */
    private int sortSolution(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
