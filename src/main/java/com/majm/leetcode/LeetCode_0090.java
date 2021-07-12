package com.majm.leetcode;

import com.majm.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 90. 子集 II </br>
 *
 * @author majunmin
 * @description
 * @datetime 2021-07-12 23:26
 * @since
 */
public class LeetCode_0090 implements Solution {

    @Override
    public List<List<Integer>> subsetsWithDup(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backTrace(0, new ArrayList<>(), nums, result);
        return result;
    }

    private void backTrace(int begin, List<Integer> path, int[] nums, List<List<Integer>> result) {
        // terminate
        result.add(new ArrayList<>(path));

        for (int i = begin; i < nums.length; i++) {
            // 同一层不允许重复
            if (i > begin && nums[i] == nums[i - 1]) {
                continue;
            }
            path.add(nums[i]);
            backTrace(i + 1, path, nums, result);
            path.remove(new Integer(nums[i]));
        }
    }

    public static void main(String[] args) {
        Solution leetCode = new LeetCode_0090();
        final List<List<Integer>> result = leetCode.subsetsWithDup(new int[]{1, 2, 2});
        System.out.println(result);
    }
}
