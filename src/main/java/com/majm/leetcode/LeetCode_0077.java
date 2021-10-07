package com.majm.leetcode;

import com.majm.Solution;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author majunmin
 * @description
 * @datetime 2020/11/5 10:35 下午
 * @since
 */
public class LeetCode_0077 implements Solution {

    @Override
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backTrace2(1, new ArrayList<>(), n, k, result);
        return result;
    }

    private void backTrace2(int begin, List<Integer> path, int n, int k, List<List<Integer>> result) {
        // 剪枝
        if (path.size() + (n - begin + 1) < k){
            return;
        }
        // terminate
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }

        // for choice in choiceList
        for (int i = begin; i <= n; i++) {
            path.add(i);
            backTrace2(i + 1, path, n, k, result);
            path.remove(path.size() - 1);
        }
    }


    private List<List<Integer>> dfsSolution2(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(1, new ArrayList<>(), n, k, result);
        return result;
    }

    private void dfs(int cur, List<Integer> path, int n, int k, List<List<Integer>> result) {

        // 剪枝: 如果 path.size() + n  - cur + 1  < k ,剩下的就一定不满足条件,
        if (path.size() + (n - cur + 1) < k) {
            return;
        }

        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }
//        if (cur > n) {
//            return;
//        }

        // 选择当前值 vs 不选当前值
        path.add(cur);
        dfs(cur + 1, path, n, k, result);
        path.remove(path.size() - 1);
        dfs(cur + 1, path, n, k, result);
    }

    /**
     * 时间复杂度:  O()
     * 空间复杂度:  O(N)
     *
     * @param n
     * @param k
     * @return
     */
    private List<List<Integer>> backTraceSolution(int n, int k) {
        // 参数检查
        if (k < 0 || n < 1) {
            throw new IllegalArgumentException();
        }

        List<List<Integer>> result = new ArrayList<>();
        int[] nums = new int[n];
        for (int i = 1; i <= n; i++) {
            nums[i - 1] = i;
        }
        backTrace(0, new ArrayList<>(), nums, k, result);

        return result;
    }

    private void backTrace(int begin, List<Integer> path, int[] nums, int k, List<List<Integer>> result) {
        // 剪枝
        if (path.size() + (nums.length - begin + 1) < k) {
            return;
        }
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }

        // for choice in choiceList
        for (int i = begin; i < nums.length; i++) {
            path.add(nums[i]);
            backTrace(i + 1, path, nums, k, result);
            path.remove(path.size() - 1);
        }
    }


    /**
     * DFS
     *
     * @param n
     * @param k
     * @return
     */
    private List<List<Integer>> dfsSolution(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (k <= 0 || n < k) {
            return result;
        }
        Deque<Integer> path = new ArrayDeque<>();
        dfs(n, k, 1, path, result);
        return result;
    }

    private void dfs(int n, int k, int start, Deque path, List<List<Integer>> result) {
        // 递归的终止条件
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }

        // 遍历可能的搜索节点
        for (int i = start; i < n; i++) {
            // 向路径变量里加一个数
            path.push(i);
            // 下一轮搜索，设置的搜索起点要加 1，因为组合数理不允许出现重复的元素
            dfs(n, k, i + 1, path, result);
            // 清理状态
            // 重点理解在这里: 深度优先遍历有回头过程 因此递归之前做了什么，递归之后要做相同的逆向操作
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        final LeetCode_0077 leetCode = new LeetCode_0077();
        System.out.println(leetCode.combine(4, 2));
        System.out.println(leetCode.combine(1, 1));

    }
}
