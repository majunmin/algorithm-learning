package com.majm.leetcode;

import com.majm.Solution;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @author majunmin
 * @description
 * @datetime 2020/11/6 2:50 下午
 * @since
 */
public class LeetCode_0046 implements Solution {

    @Override
    public List<List<Integer>> permute(int[] nums) {
        return backTraceSolution2(nums);
    }

    /**
     *
     * @param nums
     * @return
     */
    private List<List<Integer>> backTraceSolution2(int[] nums) {
        // 边界条件
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        backTrace2(0, new ArrayList<Integer>(), visited, nums, result);
        return result;
    }

    private void backTrace2(int level, List<Integer> path, Set<Integer> visited, int[] nums, List<List<Integer>> result) {
        // terminate
        if (level == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        // for choice in choiceList
        for (int num : nums) {
            if (visited.contains(num)) {
                continue;
            }
            path.add(num);
            visited.add(num);
            backTrace2(level + 1, path, visited, nums, result);
            visited.remove(num);
            path.remove(path.size() - 1);
        }
    }


    /**
     * 回溯算法
     *
     * @param nums
     * @return
     */
    private List<List<Integer>> backTraceSolution(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backTrace(0, new ArrayList<>(), nums, result);
        return result;
    }

    private void backTrace(int level, List<Integer> path, int[] nums, List<List<Integer>> result) {
        if (level == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        // for choice int choiceList
        for (int i = 0; i < nums.length; i++) {
            // do choice
            // 剪枝
            if (path.contains(nums[i])) {
                continue;
            }
            path.add(nums[i]);
            backTrace(level + 1, path, nums, result);

            // revert choice
            path.remove(new Integer(nums[i]));
        }
    }


    private List<List<Integer>> solution2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        solution(nums, new ArrayList<>(), result);
        return result;
    }

    private void solution(int[] nums, List<Integer> path, List<List<Integer>> result) {

        // terminate
        if (path.size() == nums.length) {
            result.add(path);
            return;
        }

        // forEach choice in choiceList
        //
        for (int i = 0; i < nums.length; i++) {
            if (!path.contains(nums[i])) {
                path.add(nums[i]);
                solution(nums, path, result);
                path.remove(path.size() - 1);
            }
        }


    }


    /**
     * 回溯算法
     * 时间复杂度：O(N×N!)
     * 空间复杂度： O(N×N!)。
     * - 递归树深度 logN ;
     * - 全排列个数 N! 每个全排列占空间 N。取较大者。
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> solution1(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new LinkedList<>();

        backtrack(nums, path, result);
        return result;
    }


    /**
     * @param nums   数字总集
     * @param path   已经选择的
     * @param result 用于存放结果集
     */
    private void backtrack(int[] nums, List<Integer> path, List<List<Integer>> result) {
        // 终止条件 返回
        if (path.size() == nums.length) {
            result.add(new LinkedList<>(path));
            return;
        }
        List<Integer> choiceList = new ArrayList<>();
        for (int num : nums) {
            if (!path.contains(num)) {
                choiceList.add(num);
            }
        }

        // for choice in choiceList
        for (Integer choice : choiceList) {
            path.add(choice);
            backtrack(nums, path, result);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        final Solution leetCode = new LeetCode_0046();
        System.out.println(leetCode.permute(new int[]{-1, 1, 2, 3}));
    }
}
