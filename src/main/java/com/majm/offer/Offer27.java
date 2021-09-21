package com.majm.offer;

import com.majm.common.TreeNode;

/**
 * 剑指 Offer 27. 二叉树的镜像 </br>
 * https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof/
 *
 * @author majunmin
 * @description
 * @datetime 2021-09-19 09:10
 * @since
 */
public class Offer27 {

    public TreeNode mirrorTree(TreeNode root) {
        // terminate
        if (root == null) {
            return null;
        }
        // swap
        TreeNode tmpNode = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(tmpNode);
        return root;
    }
}
