package com.majm.leetcode;

import com.majm.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 39. 组合总和 </br>
 * <p>
 * 解决思路为 是以树状图, 回溯解决
 *
 * @author majunmin
 * @description
 * @datetime 2021-07-12 22:13
 * @since
 */
public class LeetCode_0039 implements Solution {

    @Override
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backTrace3(0, new ArrayList<>(), candidates, target, result);
        return result;
    }

    private void backTrace3(int begin, List<Integer> path, int[] candidates, int target, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        if (target < 0) {
            return;
        }
        // for choice in choiceList
        for (int i = begin; i < candidates.length; i++) {
            path.add(candidates[i]);
            backTrace3(i, path, candidates, target - candidates[i], result);
            path.remove(path.size() - 1);
        }
    }


    private List<List<Integer>> backTraceSolution(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates.length == 0) {
            return result;
        }
        Arrays.sort(candidates);
        // 确定根节点
        backTrace2(result, candidates, target, new ArrayList<>(), 0);
        return result;
    }

    private void backTrace2(List<List<Integer>> result, int[] candidates, int target, List<Integer> path, int begin) {
        if (target == 0) {
            result.add(new ArrayList<>(path));
        }
        if (target < 0) {
            return;
        }

        for (int i = begin; i < candidates.length; i++) {
            // do choice
            path.add(candidates[i]);
            backTrace2(result, candidates, target - candidates[i], path, i);
            // revert choice
            path.remove(new Integer(candidates[i]));
        }
    }

    /**
     * 1. 每次要求和, 这个过程可以用减法省略掉, 比较巧妙
     *
     * @param result     result
     * @param candidates
     * @param target     没选择一个元素,目标值变小
     * @param path       当前的选择
     */
    private void backTrace(List<List<Integer>> result, int[] candidates, int target, List<Integer> path, int begin) {
        // terminate
        if (sum(path) == target) {
            result.add(new ArrayList<>(path));
        }

        // for choice in choiceList  + 剪枝
        for (int i = begin; i < candidates.length; i++) {
            // 剪枝
            if (sum(path) + candidates[i] > target) {
                continue;
            }
            // do choice
            path.add(candidates[i]);
            backTrace(result, candidates, target, path, i);
            // revert choice
            path.remove(new Integer(candidates[i]));
        }
    }

    private int sum(List<Integer> path) {
        int sum = 0;
        for (int i = 0; i < path.size(); i++) {
            sum += path.get(i);
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new LeetCode_0039();
        final List<List<Integer>> lists = solution.combinationSum(new int[]{2, 3, 6, 7}, 7);
        System.out.println(lists);
    }
}
