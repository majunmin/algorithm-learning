package com.majm.leetcode;

import com.majm.Solution;
import com.majm.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author majunmin
 * @description
 * @datetime 2020/10/31 5:41 下午
 * @since
 */
public class LeetCode_0104 implements Solution {

    @Override
    public int maxDepth(TreeNode root) {
       if (root == null){
           return 0;
       }

       int lDepth = maxDepth(root.left);
       int rDepth = maxDepth(root.right);
       return Math.max(lDepth, rDepth) + 1;

    }

















    /**
     * 广度优先搜索
     *
     * (也可以用于实现 🌲的层次遍历)
     *
     * @param root
     * @return
     */
    private int soluiton2(TreeNode root) {
        int result = 0;
        if (root == null){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        while (!queue.isEmpty()){
            int size = queue.size();
            while(size > 0) {
                TreeNode node = queue.poll();
                if (node.left != null){
                    queue.offer(node.left);
                }
                if (node.right != null){
                    queue.offer(node.right);
                }
                size--;
            }
            result++;
        }

        return result;
    }


    /**
     * 递归
     * 时间复杂度 O(N)
     * 空间复杂度 O(height)
     * 两行代码即可搞定
     *
     * max(l, r) + 1
     *
     * @param root
     * @return
     */
    private int soluiton1(TreeNode root) {
        if (root == null){
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        return Math.max(leftDepth, rightDepth) + 1;
    }
}
