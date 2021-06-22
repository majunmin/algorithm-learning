package com.majm.leetcode;

import com.majm.Solution;
import com.majm.common.TreeNode;

import javax.xml.transform.Result;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author majunmin
 * @description
 * @datetime 2020/11/11 10:00 上午
 * @since
 */
public class LeetCode551 implements Solution {

    @Override
    public List<Integer> largestValues(TreeNode root) {
        return solution2(root);
    }


    /**
     * dfs 深度优先遍历 (记录当前深度 depth/level)
     *
     * 时间复杂度 O(N)
     * 空间复杂度 O(logN)
     * @param root
     * @return
     */
    private List<Integer> solution2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfs(root, 0, result);
        return null;
    }

    private void dfs(TreeNode root, int depth, List<Integer> result) {
        if (root == null) {
            return;
        }

        if (result.size() == depth) {
            result.add(root.val);
        } else if (result.get(depth) < root.val) {
            result.set(depth, root.val);
        }

        dfs(root.left, depth + 1, result);
        dfs(root.right, depth + 1, result);
    }


    /**
     * BFS
     * 广度优先遍历想法比较简单
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)  引入了一个队列
     * @param root
     * @return
     */
    private List<Integer> solution1(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int maxVal = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                maxVal = Math.max(node.val, maxVal);
                if (node.left != null){
                    queue.offer(node.left);
                }
                if (node.right != null){
                    queue.offer(node.right);
                }
            }
            result.add(maxVal);

        }

        return result;
    }
}
