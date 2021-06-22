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
public class LeetCode77 implements Solution {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (k <= 0 || n <k) {
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
}
