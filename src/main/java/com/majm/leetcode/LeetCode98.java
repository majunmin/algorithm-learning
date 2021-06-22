package com.majm.leetcode;

import com.majm.Solution;
import com.majm.common.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author majunmin
 * @description
 * @datetime 2020/11/3 8:23 下午
 * @since
 */
public class LeetCode98 implements Solution {


    @Override
    public boolean isValidBST(TreeNode root) {
        return solution2(root);
    }














    /**
     * 中序遍历迭代方式解决
     *
     * @param root
     * @return
     */
    private boolean solution2(TreeNode root) {
        TreeNode prev = null;
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (!stack.isEmpty() || root != null) {
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (prev != null && root.val < prev.val) {
                return false;
            }
            // 如果 root符合条件 就记录 root的值 -> prev
            prev = root;
            root = root.right;
        }
        return true;
    }


    /**
     * 性质: 二叉搜索树 中序遍历是 递增的
     *
     * 中序遍历递归解决
     * 找一个 prev指针放外边
     * @param root
     * @return isValidBST
     */
    TreeNode prev;
    public boolean validBST(TreeNode root) {
        if (root == null)
            return true;
        if (!validBST(root.left)) {
            return false;
        }

        // 移动 比较 是否是递增的,  给prev赋值
        if (prev != null && root.val <= prev.val) {
            return false;
        }
        prev = root;

        if (!validBST(root.right)) {
            return false;
        }
        return true;
    }

    /**
     *
     * @param root (左子树 | 右子树)
     * @param lower 递归右子树时的最小值(root.val)
     * @param upper 递归左子树时的最大值(root.val)
     * @return
     */
    private boolean helper(TreeNode root, Integer lower, Integer upper) {
        if (root == null) {
            return true;
        }
        int val = root.val;
        if (lower != null && val <= lower) {
            return false;
        }
        if (upper != null && val >= upper) {
            return false;
        }
        if (!helper(root.left, lower, val)){
            return false;
        }
        if (!helper(root.right, val, upper)){
            return false;
        }
        return true;
    }
}
