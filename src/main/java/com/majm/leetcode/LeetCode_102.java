package com.majm.leetcode;

import com.majm.Solution;
import com.majm.common.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author majunmin
 * @description
 * @datetime 2020/11/8 8:22 下午
 * @since
 */
public class LeetCode_102 implements Solution {


    /**
     * @param root
     * @return
     */
    @Override
    public List<List<Integer>> levelOrder(TreeNode root) {
        return solution2(root);

    }

    private List<List<Integer>> solution2(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> path = new ArrayList<>();
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                final TreeNode node = queue.poll();
                path.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            result.add(path);
        }
        return result;
    }


    /**
     * 二叉树的层次遍历
     * 时间复杂度: O()
     * 空间复杂度:
     *
     * @param root
     * @return
     */
    private List<List<Integer>> solution1(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> path = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                path.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            result.add(path);
        }
        return result;
    }
}
