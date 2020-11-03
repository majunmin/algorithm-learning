package com.majm.letcode;

import com.majm.Solution;
import com.majm.common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 二叉树后序遍历
 * @author majunmin
 * @description
 * @datetime 2020/10/31 3:22 下午
 * @since
 */
public class LeetCode145 implements Solution {

    @Override
    public List<Integer> postorderTraversal(TreeNode root) {
        return solution1(root);
    }







    /**
     * 迭代方式 Stack
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
     * 时间复杂度: O()
     * 空间复杂度: O()
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
