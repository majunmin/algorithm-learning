package com.majm.leetcode;

import com.majm.Solution;
import com.majm.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author majunmin
 * @description
 * @datetime 2020/11/4 9:40 上午
 * @since
 */
public class LeetCode111 implements Solution {

    @Override
    public int minDepth(TreeNode root) {
        return bfs(root);
    }


    /**
     * 广度优先搜索🔍
     *
     * @param root
     * @return
     */
    private int bfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int depth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null) {
                    return depth + 1;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                size--;
            }
            depth++;
        }

        return depth;
    }

    /**
     * 递归 深度优先搜索
     * <p>
     * 时间复杂度: O(N)
     * 空间复杂度: O(logN)
     *
     * @param root
     * @return
     */
    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        } else if (root.left == null) {
            return dfs(root.right) + 1;
        } else if (root.right == null) {
            return dfs(root.left) + 1;
        } else {
            return Math.min(dfs(root.left), dfs(root.right)) + 1;
        }
    }
}
