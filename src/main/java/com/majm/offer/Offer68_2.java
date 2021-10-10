package com.majm.offer;

import com.majm.common.TreeNode;

/**
 * 剑指 Offer 68 - II. 二叉树的最近公共祖先
 *
 * @author majunmin
 * @description
 * @datetime 2020/11/5 1:38 下午
 * @since
 */
public class Offer68_2 {


    /**
     * 该题目的解决思路就是  后序遍历
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // terminate
        if (root == null || p == root || q == root) {
            return null;
        }

        TreeNode leftNode = lowestCommonAncestor(root.left, p, q);
        TreeNode rightNode = lowestCommonAncestor(root.right, p, q);
        // 如果 p q 都在 右子树
        if (leftNode == null) {
            return rightNode;
        }
        // 如果 p q 都在 左子树
        if (rightNode == null) {
            return leftNode;
        }
        // 如果 p q 分别在 左右子树
        return root;
    }

}
