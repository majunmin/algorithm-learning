package com.majm.offer;

import com.majm.common.TreeNode;

/**
 * 剑指 Offer 07. 重建二叉树 </br>
 * https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof/
 *
 * @author majunmin
 * @description
 * @datetime 2021-10-07 21:56
 * @since
 */
public class Offer07 {

    /**
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // checkArgument
        if (preorder == null || inorder == null || preorder.length == 0 || preorder.length != inorder.length) {
            return null;
        }
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int pLeft, int pRight, int[] inorder, int iLeft, int iRight) {
        if (pLeft > pRight || iLeft > iRight) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[pLeft]);
        if (pLeft == pRight) {
            return root;
        }

        int cnt = 0;
        for (int i = iLeft; i <= iRight; i++) {
            if (inorder[i] == preorder[pLeft]) {
                break;
            }
            cnt++;
        }
        root.left = buildTree(preorder, pLeft + 1, pLeft + cnt, inorder, iLeft, iLeft + cnt);
        root.right = buildTree(preorder, pLeft + cnt + 1, pRight, inorder, iLeft + cnt + 1, iRight);
        return root;
    }
}
