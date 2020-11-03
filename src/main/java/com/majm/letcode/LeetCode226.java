package com.majm.letcode;

import com.majm.Solution;
import com.majm.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author majunmin
 * @description
 * @datetime 2020/11/3 8:16 下午
 * @since
 */
public class LeetCode226 implements Solution {



    @Override
    public TreeNode invertTree(TreeNode root) {
        return solution2(root);
    }


    /**
     * 广度优先遍历
     * 需要一个而外的存储结构 queue
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     * @param root
     * @return
     */
    private TreeNode solution2(TreeNode root) {
        if (root == null){
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();

            // 交换其左右节点
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;

            // 如果左节点不为空 放入队列
            if (node.left != null) {
                queue.offer(node.left);
            }
            // 如果右节点不为空 放入队列
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return root;
    }


    /**
     * 递归 (DFS)
     *
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     * @param root
     * @return
     */
    public TreeNode solution1(TreeNode root) {
        if (root == null){
            return root;
        }

        TreeNode temp = root.right;
        root.right = invertTree(root.left);
        root.left = invertTree(temp);
        return root;
    }
}
