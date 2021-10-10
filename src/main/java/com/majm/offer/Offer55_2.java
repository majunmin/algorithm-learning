package com.majm.offer;

import com.majm.common.TreeNode;

/**
 * 剑指 Offer 55 - II. 平衡二叉树 </br>
 * https://leetcode-cn.com/problems/ping-heng-er-cha-shu-lcof/
 *
 * @author majunmin
 * @description
 * @datetime 2021-10-07 18:53
 * @since
 */
public class Offer55_2 {

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int height(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(height(node.left), height(node.right)) + 1;
    }
}
