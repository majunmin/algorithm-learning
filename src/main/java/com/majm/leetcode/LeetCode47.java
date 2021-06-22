package com.majm.leetcode;

import com.majm.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author majunmin
 * @description
 * @datetime 2020/11/7 2:52 下午
 * @since
 */
public class LeetCode47 implements Solution {


    @Override
    public List<List<Integer>> permuteUnique(int[] nums) {
        return solution2(nums);
    }



    private List<List<Integer>> solution2(int[] nums) {
        boolean[] used = new boolean[nums.length];
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Arrays.sort(nums);
        backtrace2(nums, path, used, result);
        return result;
    }

    /**
     * https://leetcode-cn.com/problems/permutations-ii/solution/hui-su-suan-fa-python-dai-ma-java-dai-ma-by-liwe-2/
     *
     * 这个剪枝的逻辑看的我好晕 看了这个图解才看懂
     * @param nums
     * @param path
     * @param used
     * @param result
     */
    private void backtrace2(int[] nums, List<Integer> path, boolean[] used, List<List<Integer>> result) {
        if (path.size() == nums.length) {
            result.add(path);
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            if (used[i] || i > 0 && (nums[i] == nums[i - 1] && !used[i - 1])) {
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            backtrace2(nums, path, used, result);
            //reset status
            used[i] = false;
            path.remove(path.size() - 1);
        }


    }


    /**
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> solution1(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrace(nums, new ArrayList<>(), new ArrayList<>(), result);
        return result;
    }

    /**
     * 回溯算法
     * 时间复杂度: O(N! * N)
     * 空间复杂度: O(N)
     * @param nums   数组
     * @param path   已选择的path
     * @param result 结果集
     */
    private void backtrace(int[] nums, List<Integer> path, List<Integer> selectedIdx, List<List<Integer>> result) {
        //terminate
        if (path.size() == nums.length) {
            result.add(new ArrayList(path));
            return;
        }

        Set<Integer> selectedList = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            // 剪枝条件
            if (!selectedList.contains(num) && !selectedIdx.contains(i)) {
                path.add(num);
                selectedIdx.add(i);
                selectedList.add(num);

                backtrace(nums, path, selectedIdx, result);

                selectedIdx.remove(selectedIdx.size() - 1);
                path.remove(path.size() - 1);
            }
        }
    }
}
