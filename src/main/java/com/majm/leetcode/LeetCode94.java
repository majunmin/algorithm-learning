package com.majm.leetcode;

import com.majm.Solution;
import com.majm.common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author majunmin
 * @description
 * @datetime 2020/10/29 12:03 上午
 * @since
 */
public class LeetCode94 implements Solution {


    @Override
    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            result.add(node.val);
            node = node.right;
        }
        return result;
    }

    /**
     * 迭代方式实现
     * 时间复杂度: O(N)
     * 空间复杂度: O(N)
     *
     * @param root
     * @return
     */
    private List<Integer> solution3(TreeNode root) {
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode middle = stack.pop();
            result.add(middle.val);
            root = middle.right;
        }
        return result;
    }


    /**
     * 递归实现
     * 空间复杂度 要优于 solution1
     *
     * @param root
     * @return
     */
    private List<Integer> solution2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inOrder(root, result);
        return result;
    }

    private void inOrder(TreeNode root, List<Integer> result) {
        if (root != null) {
            inOrder(root.left, result);
            result.add(root.val);
            inOrder(root.right, result);
        }
    }

    /**
     * 递归实现
     *
     * @param root
     * @return
     */
    private List<Integer> solution1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root != null) {
            result.addAll(inorderTraversal(root.left));
            result.add(root.val);
            result.addAll(inorderTraversal(root.right));
        }
        return result;
    }
}
