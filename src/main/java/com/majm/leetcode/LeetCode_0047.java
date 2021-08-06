package com.majm.leetcode;

import com.majm.Solution;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author majunmin
 * @description
 * @datetime 2020/11/7 2:52 下午
 * @since
 */
public class LeetCode_0047 implements Solution {


    @Override
    public List<List<Integer>> permuteUnique(int[] nums) {
        return backTraceSolution3(nums);
    }


    /**
     *
     * @param nums
     * @return
     */
    private List<List<Integer>> backTraceSolution3(int[] nums) {
        // 边界条件
        if (nums == null || nums.length == 0){
            throw new IllegalArgumentException();
        }
        List<List<Integer>> result = new ArrayList<>();
        // 记录已访问过得下标
        Set<Integer> visited = new HashSet<>();
        backTrace2(0, new ArrayList<>(), visited, nums, result);
        return result;
    }

    private void backTrace2(int level, List<Integer> path, Set<Integer> visited, int[] nums, List<List<Integer>> result) {
        // terminate
        if (level == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        Set<Integer> levelNum = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            // 过滤 已访问的,  和同层重复的
            if (visited.contains(i)) {
                continue;
            }
            if (levelNum.contains(nums[i])) {
                continue;
            }
            visited.add(i);
            path.add(nums[i]);
            levelNum.add(nums[i]);
            backTrace2(level + 1, path, visited, nums, result);
            path.remove(path.size() - 1);
            visited.remove(i);
        }
    }


    private List<List<Integer>> backTraceSolution(int[] nums) {
        if (nums == null || nums.length == 0) {

        }
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backTrace(0, new ArrayDeque<>(), new ArrayDeque<>(), nums, result);
        return result;
    }

    private void backTrace(int level, Deque<Integer> visitedIdx, Deque<Integer> path, int[] nums, List<List<Integer>> result) {
        if (level == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }


        Set<Integer> set = new HashSet<>();
        // foreach choice in choiceList
        for (int i = 0; i < nums.length; i++) {
            // 不重复选择
            if (visitedIdx.contains(i)) {
                continue;
            }
            // 同级不能重复选择
            if (set.contains(nums[i])) {
                continue;
            }
            set.add(nums[i]);

            path.addLast(nums[i]);
            visitedIdx.addLast(i);
            backTrace(level + 1, visitedIdx, path, nums, result);
            visitedIdx.removeLast();
            path.removeLast();
        }
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
     * <p>
     * 这个剪枝的逻辑看的我好晕 看了这个图解才看懂
     *
     * @param nums
     * @param path
     * @param visited
     * @param result
     */
    private void backtrace2(int[] nums, List<Integer> path, boolean[] visited, List<List<Integer>> result) {
        if (path.size() == nums.length) {
            result.add(path);
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            if (visited[i] || i > 0 && (nums[i] == nums[i - 1] && !visited[i - 1])) {
                continue;
            }
            path.add(nums[i]);
            visited[i] = true;
            backtrace2(nums, path, visited, result);
            //reset status
            visited[i] = false;
            path.remove(path.size() - 1);
        }


    }


    /**
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
     *
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


    public static void main(String[] args) {
        Solution leetCode = new LeetCode_0047();
        System.out.println(leetCode.permuteUnique(new int[]{1, 1, 2}));
    }
}



