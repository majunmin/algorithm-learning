package com.majm.offer;

import com.majm.common.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 剑指 Offer 54. 二叉搜索树的第k大节点 </br>
 * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/
 *
 * @author majunmin
 * @description
 * @datetime 2021-09-28 14:32
 * @since
 */
public class Offer54 {


    private int index;
    private int res;

    /**
     * 二叉搜索树的 第 k 大节点,
     * 二叉搜索树的 中序遍历时有序的
     *
     * @param root
     * @param k
     * @return
     */
    public int kthLargest(TreeNode root, int k) {
        return iterSolution(root, k);
    }

    private int iterSolution(TreeNode root, int k) {
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;
        int index = 0;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.right;
            }
            node = stack.pop();
            if (++index == k) {
                return node.val;
            }
            node = node.left;
        }
        return -1;
    }


    private int recurSolution(TreeNode root, int k) {
        dfs(root, k);
        return res;
    }

    private void dfs(TreeNode node, int k) {
        if (node == null) {
            return;
        }
        dfs(node.right, k);
        index++;
        if (k == index) {
            res = node.val;
            return;
        }
        dfs(node.left, k);
    }
}
