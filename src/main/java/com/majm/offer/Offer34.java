package com.majm.offer;

import com.majm.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer 34. 二叉树中和为某一值的路径 </br>
 * https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof/
 *
 * @author majunmin
 * @description
 * @datetime 2021-09-28 12:41
 * @since
 */
public class Offer34 {

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        List<Integer> path = new ArrayList<>();
        path.add(root.val);
        backTrace(root, path, root.val, target, result);
        return result;
    }

    private void backTrace(TreeNode curNode, List<Integer> path, int sum, int target, List<List<Integer>> result) {
        // terminate
        if (sum > target) {
            return;
        }
        if (sum == target && curNode.left == null && curNode.right == null) {
            result.add(new ArrayList<>(path));
            return;
        }

        // for choice in choiceList
        TreeNode leftNode;
        if ((leftNode = curNode.left) != null) {
            path.add(leftNode.val);
            backTrace(leftNode, path, sum + leftNode.val, target, result);
            path.remove(path.size() - 1);
        }

        TreeNode rightNode;
        if ((rightNode = curNode.right) != null) {
            path.add(rightNode.val);
            backTrace(rightNode, path, sum + rightNode.val, target, result);
            path.remove(path.size() - 1);
        }
    }
}
