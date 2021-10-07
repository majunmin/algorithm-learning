package com.majm.leetcode;

import com.majm.Solution;
import com.majm.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 113. 路径总和 II </br>
 * https://leetcode-cn.com/problems/path-sum-ii/
 *
 * @author majunmin
 * @description
 * @datetime 2021-09-28 17:10
 * @since
 */
public class LeetCode_0113 implements Solution {

    /**
     * 1. dfs
     * 2. BFS 从上到下遍历,
     *
     * @param root
     * @param targetSum
     * @return
     */
    @Override
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        return backTraceSolution(root, targetSum);
    }


    private List<List<Integer>> backTraceSolution(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        List<Integer> path = new ArrayList<>();
        path.add(root.val);
        backTrace(root, path, result, targetSum - root.val);
        return result;
    }

    private void backTrace(TreeNode curNode, List<Integer> path, List<List<Integer>> result, int targetSum) {
        // terminate
        if (targetSum == 0 && curNode.left == null && curNode.right == null) {
            result.add(new ArrayList<>(path));
            return;
        }

        // for choice in choiceList
        TreeNode left;
        if ((left = curNode.left) != null) {
            path.add(left.val);
            backTrace(left, path, result, targetSum - left.val);
            path.remove(path.size() - 1);
        }
        TreeNode right;
        if ((right = curNode.right) != null) {
            path.add(right.val);
            backTrace(right, path, result, targetSum - right.val);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution leetCode = new LeetCode_0113();
        TreeNode root = new TreeNode(5);
        TreeNode left = new TreeNode(4);
        TreeNode right = new TreeNode(8);
        root.left = left;
        root.right = right;
    }
}
