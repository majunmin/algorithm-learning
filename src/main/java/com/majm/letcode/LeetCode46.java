package com.majm.letcode;

import com.majm.Solution;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author majunmin
 * @description
 * @datetime 2020/11/6 2:50 下午
 * @since
 */
public class LeetCode46 implements Solution {


    @Override
    public List<List<Integer>> permute(int[] nums) {
        return solution2(nums);
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
            if (!path.contains(nums[i])){
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
     *   - 递归树深度 logN ;
     *   - 全排列个数 N! 每个全排列占空间 N。取较大者。
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
     *
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
            if (!path.contains(num)){
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
}
