package com.majm.letcode;

import com.majm.Solution;
import com.majm.common.TreeNode;

/**
 * @author majunmin
 * @description
 * @datetime 2020/11/4 11:13 下午
 * @since
 */
public class LeetCode105 implements Solution {

    @Override
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        return myBuildTree(preorder, inorder, 0, n - 1, 0, n - 1);
    }


    /**
     * 递归的方式构造二叉树
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
            if (inorder[i] == rootVal){
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
}
