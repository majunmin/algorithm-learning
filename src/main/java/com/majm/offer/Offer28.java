package com.majm.offer;

import com.majm.common.TreeNode;

/**
 * 剑指 Offer 28. 对称的二叉树 </br>
 *
 * @author majunmin
 * @description
 * @datetime 2021-09-13 20:08
 * @since
 */
public class Offer28 {

    /**
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
//        if (root == null) {
//            return true;
//        }
//        if (root.left == null && root.right == null) {
//            return true;
//        }
        return isSymmetric(root, root);

    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }

        if (left.val != right.val) {
            return false;
        }

        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }

}
