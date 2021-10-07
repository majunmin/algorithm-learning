package com.majm.leetcode;

import com.majm.Solution;
import com.majm.common.TreeNode;

/**
 * 112. 路径总和 </br>
 * https://leetcode-cn.com/problems/path-sum/
 *
 * @author majunmin
 * @description
 * @datetime 2021-09-28 17:04
 * @since
 */
public class LeetCode_0112 implements Solution {

    @Override
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return recurSolution(root, targetSum);
    }

    /**
     * 二叉树天然适合递归解法, 这里可以思考一下🤔
     *
     * @param root
     * @param targetSum
     * @return
     */
    private boolean recurSolution(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.val == targetSum && root.left == null && root.right == null) {
            return true;
        }
        if (hasPathSum(root.left, targetSum - root.val)) {
            return true;
        }
        if (hasPathSum(root.right, targetSum - root.val)) {
            return true;
        }
        return false;
    }


    private boolean solution2(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        return backTrace(root, targetSum - root.val);
    }

    private boolean backTrace(TreeNode curNode, int targetSum) {
        // terminate
        if (0 == targetSum && curNode.left == null && curNode.right == null) {
            return true;
        }

        // for choice in choiceList
        TreeNode left;
        if ((left = curNode.left) != null) {
            if (backTrace(left, targetSum - left.val)) {
                return true;
            }
        }

        TreeNode right;
        if ((right = curNode.right) != null) {
            if (backTrace(right, targetSum - right.val)) {
                return true;
            }
        }
        return false;
    }
}
