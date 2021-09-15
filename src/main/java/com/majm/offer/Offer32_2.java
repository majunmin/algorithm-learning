package com.majm.offer;

import com.majm.common.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 剑指 Offer 32 - II. 从上到下打印二叉树 II </br>
 * https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof/
 *
 * @author majunmin
 * @description
 * @datetime 2021-09-15 21:26
 * @since
 */
public class Offer32_2 {


    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        // param check
        if (root == null) {
            return result;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            // process
            List<Integer> curLevel = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.pop();
                curLevel.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            result.add(curLevel);
        }
        return result;
    }
}
