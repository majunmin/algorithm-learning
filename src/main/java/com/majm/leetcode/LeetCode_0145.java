package com.majm.leetcode;

import com.majm.Solution;
import com.majm.common.TreeNode;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

/**
 * 二叉树后序遍历
 *
 * @author majunmin
 * @description
 * @datetime 2020/10/31 3:22 下午
 * @since
 */
public class LeetCode_0145 implements Solution {

    @Override
    public List<Integer> postorderTraversal(TreeNode root) {
        return postOrder(root);
    }

    private List<Integer> postOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();
        final Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode node = root;
        TreeNode prev = null;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();

            // 仅当 node.right == null || node.right == prev,添加进 结果集
            if (node.right == null || node.right == prev) {
                result.add(node.val);
                prev = node;
                node = null;
            } else {
                stack.push(node);
                node = node.right;
            }
        }
        return result;
    }


    /**
     * 迭代方式 Stack
     *
     * @param root
     * @return
     */
    public List<Integer> solution2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode prev = null;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.right == null || root.right == prev) {
                result.add(root.val);
                prev = root;
                root = null;
            } else {
                stack.push(root);
                root = root.right;
            }
        }
        return result;
    }


    /**
     * 递归方法
     * 时间复杂度: O(logN)
     * 空间复杂度: O(logN)
     *
     * @param root
     * @return
     */
    private List<Integer> solution1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root != null) {
            result.addAll(postorderTraversal(root.left));
            result.addAll(postorderTraversal(root.right));
            result.add(root.val);
        }
        return result;
    }
}
