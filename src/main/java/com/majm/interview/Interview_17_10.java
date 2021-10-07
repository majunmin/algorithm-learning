package com.majm.interview;

import com.majm.Solution;

import java.util.HashMap;
import java.util.Map;

/**
 * 面试题 17.10. 主要元素 </br>
 * https://leetcode-cn.com/problems/find-majority-element-lcci/
 *
 * @author majunmin
 * @description
 * @datetime 2021-07-09 22:19
 * @since
 */
public class Interview_17_10 implements Solution {


    public int majorityElement(int[] nums) {

        // 摩尔投票算法  - 了解一下
        int cnt = 0;
        int candidate = -1;
        for (int num : nums) {
            // 修改候选数
            if (cnt == 0) {
                candidate = num;
            }
            cnt = candidate == num ? cnt + 1 : cnt - 1;
//            if (candidate == num) {
//                cnt++;
//            } else {
//                cnt--;
//            }
        }
        cnt = 0;
        for (int num : nums) {
            if (num == candidate) {
                cnt++;
            }
        }
        if (cnt * 2 > nums.length) {
            return candidate;
        }
        return -1;
    }
}
