package com.majm.leetcode;

import com.majm.Solution;
import com.majm.common.TreeNode;
import com.sun.tools.javac.util.Assert;

/**
 * @author majunmin
 * @description
 * @datetime 2020/11/4 11:13 下午
 * @since
 */
public class LeetCode_0105 implements Solution {

    @Override
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null) {
            return null;
        }
        if (preorder.length == 0 || preorder.length != inorder.length) {
            return null;
        }
        int rootVal = preorder[0];
        TreeNode root = buildTreeHelper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
        return root;

    }

    /**
     * @param preorder 前序遍历数组
     * @param pl       左索引
     * @param pr       右索引
     * @param inorder  中序遍历数组
     * @param il       左索引
     * @param ir       右索引
     * @return
     */
    private TreeNode buildTreeHelper(int[] preorder, int pl, int pr, int[] inorder, int il, int ir) {
        // terminate
        if (pl > pr) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[pl]);
        int idxInOrder = findIdxInArr(inorder, preorder[pl]);
        int leftSubTreeSize = idxInOrder - il;
        root.left = buildTreeHelper(preorder, pl + 1, pl + leftSubTreeSize, inorder, il, idxInOrder - 1);
        root.right = buildTreeHelper(preorder, pl + leftSubTreeSize + 1, pr, inorder, idxInOrder + 1, ir);
        return root;
    }

    // 从中序比寻找根节点索引
    private int findIdxInArr(int[] inorder, int rootVal) {
        for (int i = 0; i < inorder.length; i++) {
            if (rootVal == inorder[i]) {
                return i;
            }
        }
        return -1;
    }


    private TreeNode solution1(int[] preorder, int[] inorder) {
        int n = preorder.length;
        return myBuildTree(preorder, inorder, 0, n - 1, 0, n - 1);
    }


    /**
     * 递归的方式构造二叉树
     *
     * @param preorder
     * @param inorder
     * @param preLeft
     * @param preRight
     * @param inLeft
     * @param inRight
     * @return
     */
    private TreeNode myBuildTree(int[] preorder, int[] inorder, int preLeft, int preRight, int inLeft, int inRight) {

        // 这样写是有问题的  当 是一个[][] 会报数组越界
        //   if (preLeft == preRight) {
        //       return new TreeNode(preorder[preLeft]);
        //   }

        if (preLeft > preRight) {
            return null;
        }

        int rootVal = preorder[preLeft];
        // 中序遍历中寻找根节点
        int inRootIdx = inLeft;
        for (int i = inLeft; i <= inRight; i++) {
            if (inorder[i] == rootVal) {
                inRootIdx = i;
                break;
            }
        }
        TreeNode root = new TreeNode(rootVal);
        int leftSubTreeSize = inRootIdx - inLeft;
        // 递归构造左子树
        // 先序遍历中「从 左边界+1 开始的 size_left_subtree」个元素就对应了中序遍历中「从 左边界 开始到 根节点定位-1」的元素
        root.left = myBuildTree(preorder, inorder, preLeft + 1, preLeft + leftSubTreeSize, inLeft, inRootIdx - 1);
        root.right = myBuildTree(preorder, inorder, preLeft + leftSubTreeSize + 1, preRight, inRootIdx + 1, inRight);
        return root;
    }


    public static void main(String[] args) {
        final LeetCode_0105 leetCode = new LeetCode_0105();
        TreeNode root = leetCode.buildTree(new int[]{1, 2}, new int[]{2, 1});
        System.out.println(root);
    }
}
