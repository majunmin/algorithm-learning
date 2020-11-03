package com.majm.letcode;

import com.majm.Solution;
import com.majm.common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 二叉树前序遍历
 * @author majunmin
 * @description
 * @datetime 2020/10/31 3:12 下午
 * @since
 */
public class LeetCode144 implements Solution {

    @Override
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();

        while (!stack.isEmpty() || root != null) {
            while(root != null) {
                result.add(root.val);
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
        }
        return result;
    }

    /**
     * 递归方式
     * 其实可以新建一个方法写一个 空间复杂度比较小的 递归
     *
     * @param root
     * @return
     */
    private List<Integer> solution1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root != null) {
            result.add(root.val);
            result.addAll(preorderTraversal(root.left));
            result.addAll(preorderTraversal(root.right));
        }
        return result;
    }
}
