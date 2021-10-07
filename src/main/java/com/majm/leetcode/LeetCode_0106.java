package com.majm.leetcode;

import com.majm.Solution;
import com.majm.common.TreeNode;

/**
 * 106. 从中序与后序遍历序列构造二叉树 </br>
 * https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 *
 * @author majunmin
 * @description
 * @datetime 2021-07-11 23:04
 * @since
 */
public class LeetCode_0106 {


    /**
     * @param inorder
     * @param postorder
     * @return
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {

        if (inorder.length == 0 || inorder.length != postorder.length) {
            return null;
        }
        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    /**
     * @param inorder   中序遍历数组
     * @param il        左索引
     * @param ir        右索引
     * @param postorder 后序遍历数组
     * @param pl        左索引
     * @param pr        右索引
     * @return
     */
    private TreeNode buildTree(int[] inorder, int il, int ir, int[] postorder, int pl, int pr) {
        // terminate
        if (pl > pr) {
            return null;
        }

        int rootVal = postorder[pr];
        TreeNode curNode = new TreeNode(rootVal);
        int inIdx = findIdxInArr(curNode.val, inorder);
        int subLeftSize = inIdx - il;
        curNode.left = buildTree(inorder, il, inIdx - 1, postorder, pl, pl + subLeftSize - 1);
        curNode.right = buildTree(inorder, inIdx + 1, ir, postorder, pl + subLeftSize, pr - 1);
        return curNode;
    }

    /**
     * 寻找 val 在中序遍历数组的索引
     *
     * @param val
     * @param inorder
     * @return
     */
    private int findIdxInArr(int val, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == val) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        final LeetCode_0106 leetCode = new LeetCode_0106();
        final TreeNode tree = leetCode.buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3});
        System.out.println(tree);
    }
}
