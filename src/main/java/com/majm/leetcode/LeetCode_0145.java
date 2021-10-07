package com.majm.leetcode;

import com.majm.Solution;
import com.majm.common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
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

    /**
     * 主要方式是 记录上一次打印的 右子节点
     *
     * @param root
     * @return
     */
    @Override
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();

        TreeNode prev = null;  // 记忆化 已经处理过的右节点
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode node = stack.pop();
            //  1. 什么时候 会将当前结果加入到 result 中?
            // 2. prev 节点的含义?
            if (node.right == null || node.right == prev) {
                prev = node;
                result.add(node.val);
            } else {
                stack.push(node);
                root = node.right;
            }

        }
        return result;
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

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        final LeetCode_0145 leetCode = new LeetCode_0145();
        final List<Integer> res = leetCode.postorderTraversal(root);
        System.out.println(res);

    }
}
