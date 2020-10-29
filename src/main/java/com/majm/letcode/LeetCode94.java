package com.majm.letcode;

import com.majm.Solution;
import com.majm.common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
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

        return solution3(root);
    }

    /**
     * 递归方式实现
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
            continue;

        }
        return result;
    }

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
