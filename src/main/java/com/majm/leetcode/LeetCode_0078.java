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
        List<List<Integer>> result = new ArrayList<>();
        dfs(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> path, int[] nums, int level) {
        if (level == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        //两种选择  添加  nums[level]  vs 不添加 nums[level]
        path.add(nums[level]);
        dfs(result, path, nums, level + 1);
        path.remove(new Integer(nums[level]));
        dfs(result, path, nums, level + 1);
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
    private List<List<Integer>> solution3(int[] nums) {
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
        return null;
    }


    /**
     * 递归算法 ??
     *
     * @param nums
     * @return
     */
    private List<List<Integer>> solution2(int[] nums) {
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
     * 回溯算法 根据代码模板还是比较容易写的
     * <p>
     * 时间复杂度:
     * 空间复杂度:
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> solution1(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();
        backtrace(nums, 0, new ArrayList<>(), result);
        return result;
    }

    /**
     * @param nums   数组
     * @param path   已选择的自子集
     * @param result 存放结果集
     */
    private void backtrace(int[] nums, int start, List<Integer> path, List<List<Integer>> result) {
        // termination  终结条件
        result.add(new ArrayList<>(path));

        // forEach choice in choiceList
        //     -> path  addChoice
        //     -> reset status
        for (int i = start; i < nums.length; i++) {
            int num = nums[i];
            if (!path.contains(num)) {
                path.add(num);
                backtrace(nums, i + 1, path, result);
                path.remove(path.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Solution leetCode = new LeetCode_0078();
        final List<List<Integer>> result = leetCode.subsets(new int[]{1, 2, 3});
        System.out.println(result);
    }

}
