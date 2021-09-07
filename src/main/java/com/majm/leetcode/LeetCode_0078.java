package com.majm.leetcode;

import com.majm.Solution;

import java.util.ArrayList;
import java.util.List;

/**
 * 这里注意理解 递归算法与 回溯算法的区别
 *
 * @author majunmin
 * @description
 * @datetime 2020/11/7 10:12 上午
 * @since
 */
public class LeetCode_0078 implements Solution {


    @Override
    public List<List<Integer>> subsets(int[] nums) {
        return dfsSolution(nums);
    }


    /**
     * 位运算
     * 时间复杂度:
     * 空间复杂度:
     * <p>
     * https://leetcode-cn.com/problems/subsets/solution/hui-su-python-dai-ma-by-liweiwei1419/
     *
     * @param nums
     * @return
     */
    private List<List<Integer>> bitSolution(int[] nums) {
        int len = nums.length;
        int n = 1 << len;
        // 比特位 一共有  1<<n 种排列方式
        List<List<Integer>> result = new ArrayList<>();

        // 遍历每一种牌排列方式， 比较每种排列方式的 各个比特位
        for (int i = 0; i < n; i++) {
            List<Integer> path = new ArrayList<>();
            for (int j = 0; j < len; j++) {
                //
                if (((i >> j) & 1) == 1) {
                    path.add(nums[j]);
                }
            }
            result.add(path);
        }
        return result;
    }


    /**
     * 递归算法 ??
     *
     * @param nums
     * @return
     */
    private List<List<Integer>> dfsSolution(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(0, nums, new ArrayList<>(), result);
        return result;
    }

    /**
     * @param cur
     * @param nums
     * @param path
     * @param result
     */
    private void dfs(int cur, int[] nums, List<Integer> path, List<List<Integer>> result) {
        if (cur == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        path.add(nums[cur]);
        // 考虑当前位置
        dfs(cur + 1, nums, path, result);
        path.remove(path.size() - 1);
        // 不考虑当前位置
        dfs(cur + 1, nums, path, result);
    }

    /**
     * 巧妙利用 -1 ,优化
     *
     * @param nums
     * @return
     */
    private List<List<Integer>> backTraceSolution2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backTrace(new ArrayList<>(), 0, nums, result);
        return result;
    }

    private void backTrace(List<Integer> path, int begin, int[] nums, List<List<Integer>> result) {
        result.add(new ArrayList<>(path));
        // terminate
        if (begin == nums.length) { // >=
            return;
        }

        // for choice in choiceList
        for (int i = begin; i < nums.length; i++) {
            path.add(nums[i]);
            backTrace(path, i + 1, nums, result);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        LeetCode_0078 leetCode = new LeetCode_0078();
        final List<List<Integer>> result = leetCode.subsets(new int[]{1, 2, 3});
        System.out.println(result);
    }

}
