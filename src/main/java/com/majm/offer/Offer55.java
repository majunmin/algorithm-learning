package com.majm.offer;

import com.majm.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 剑指 Offer 55 - I. 二叉树的深度 </br>
 * https://leetcode-cn.com/problems/er-cha-shu-de-shen-du-lcof/
 *
 * @author majunmin
 * @description
 * @datetime 2021-09-14 15:07
 * @since
 */
public class Offer55 {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 利用队列 使用层次遍历
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            depth++;
        }
        return depth;
    }


    /**
     * 递归解法
     * > 一般情况  二叉树问题 一般都适合利用递归解决
     *
     * @param root
     * @return
     */
    private int recurSolution(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

}
