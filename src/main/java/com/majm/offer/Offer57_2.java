package com.majm.offer;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer 57 - II. 和为s的连续正数序列 </br>
 * https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/
 *
 * @author majunmin
 * @description
 * @datetime 2021-10-07 23:44
 * @since
 */
public class Offer57_2 {


    public int[][] findContinuousSequence(int target) {
        // init
        int left = 1;
        int right = 1;
        int sum = 1;

        List<int[]> result = new ArrayList<>();
        while (right <= target / 2 + 1) {
            if (right > left && sum == target) {
                // fill result
                addRes(result, left, right);
                sum -= left;
                left++;
            } else if (sum < target) {
                right++;
                sum += right;
            } else {
                sum -= left;
                left++;
            }
        }
        return result.toArray(new int[0][]);
    }

    private void addRes(List<int[]> result, int left, int right) {
        int[] path = new int[right - left + 1];
        int index = 0;
        for (int i = left; i <= right; i++) {
            path[index++] = i;
        }
        result.add(path);
    }

}
