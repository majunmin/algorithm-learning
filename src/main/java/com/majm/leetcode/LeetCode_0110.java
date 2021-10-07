package com.majm.leetcode;

import com.majm.Solution;
import com.majm.common.TreeNode;
import com.sun.org.apache.xpath.internal.operations.Bool;

/**
 * 110. 平衡二叉树 </br>
 * https://leetcode-cn.com/problems/balanced-binary-tree/
 *
 * @author majunmin
 * @description
 * @datetime 2021-07-16 23:53
 * @since
 */
public class LeetCode_0110 implements Solution {

    private static class ReturnRes {
        private boolean isBalance;
        private Integer height;

        public ReturnRes(boolean isBalance, Integer height) {
            this.isBalance = isBalance;
            this.height = height;
        }

        public boolean isBalance() {
            return isBalance;
        }

        public void setBalance(boolean balance) {
            isBalance = balance;
        }

        public Integer getHeight() {
            return height;
        }

        public void setHeight(Integer height) {
            this.height = height;
        }
    }

    @Override
    public boolean isBalanced(TreeNode root) {
        ReturnRes result = isBalancedHelper(root);
        return result.isBalance;
    }

    private ReturnRes isBalancedHelper(TreeNode root) {
        if (root == null) {
            return new ReturnRes(true, 0);
        }
        ReturnRes lRes = isBalancedHelper(root.left);
        ReturnRes rRes = isBalancedHelper(root.right);
        boolean isBalance = true;
        if (!lRes.isBalance || !rRes.isBalance) {
            isBalance = false;
        }
        if (Math.abs(lRes.height - rRes.height) > 1) {
            isBalance = false;
        }
        return new ReturnRes(isBalance, Math.max(lRes.height, rRes.height) + 1);
    }


}
