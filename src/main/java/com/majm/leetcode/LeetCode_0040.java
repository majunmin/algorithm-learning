package com.majm.leetcode;

import com.majm.Solution;
import sun.jvm.hotspot.types.CIntegerField;

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


    /**
     * 1. 组合  不重复就按顺序搜索
     * 2. 剪枝
     *
     * @param candidates
     * @param target
     * @return
     */
    @Override
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        return solution2(candidates, target);
    }


    /**
     * @param candidates
     * @param target
     * @return
     */
    private List<List<Integer>> solution2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backTraceSolution(candidates, 0, new ArrayList<>(), target, result);
        return result;
    }

    /**
     * 1. 不重复的处理
     * 2. 同一层之间 不允许有重复的数字
     *
     * @param candidates
     * @param begin
     * @param path
     * @param target
     * @param result
     */
    private void backTraceSolution(int[] candidates, int begin, List<Integer> path, int target, List<List<Integer>> result) {
        // terminate
        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        // for choice in choiceList
        for (int i = begin; i < candidates.length; i++) {
            if (i == begin || candidates[i] != candidates[i - 1]) {
                // 剪枝
                if (target - candidates[i] < 0) {
                    break;
                }
                path.add(candidates[i]);
                backTraceSolution(candidates, i + 1, path, target - candidates[i], result);
                path.remove(path.size() - 1);
            }
        }
    }


    private List<List<Integer>> solution1(int[] candidates, int target) {
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
