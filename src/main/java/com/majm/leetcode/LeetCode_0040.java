package com.majm.leetcode;

import com.majm.Solution;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/**
 * 40. 组合总和 II </br>
 * https://leetcode-cn.com/problems/combination-sum-ii/
 *
 * @author majunmin
 * @description
 * @datetime 2021-07-12 22:48
 * @since
 */
public class LeetCode_0040 implements Solution {

    @Override
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates.length == 0) {
            return result;
        }
        Arrays.sort(candidates);
        backTrace(0, new ArrayDeque<>(), target, candidates, result);
        return result;
    }

    private void backTrace(int begin, Deque<Integer> path, int target, int[] candidates, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        // for choice in choiceList
        for (int i = begin; i < candidates.length; i++) {
            if (target - candidates[i] < 0) {
                break;
            }
            // 同一层不允许重复
            if (i > begin && candidates[i] == candidates[i - 1]) {
                continue;
            }
            path.addLast(candidates[i]);
            backTrace(i + 1, path, target - candidates[i], candidates, result);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        Solution leetCode = new LeetCode_0040();
        final List<List<Integer>> result = leetCode.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
        System.out.println(result);
    }
}
