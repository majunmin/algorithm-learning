package com.majm.leetcode;

import com.majm.Solution;
import com.majm.common.TreeNode;

/**
 * 437. 路径总和 III </br>
 *
 * @author majunmin
 * @description
 * @datetime 2021-09-28 16:51
 * @since
 */
public class LeetCode_0437 implements Solution {


    @Override
    public int pathSum2(TreeNode root, int targetSum) {
        return 0;
    }


    /**
     * dfsSolution
     *
     * @param root
     * @param targetSum
     * @return
     */
    private int dfsSolution(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        int ret = 0;
        ret += rootSum(root, targetSum);
        ret += pathSum2(root.left, targetSum);
        ret += pathSum2(root.right, targetSum);
        return ret;
    }

    /**
     * 计算以 node 节点为 根节点, 求 sum == targetSum 的 路径数
     *
     * @param node
     * @param targetSum
     * @return
     */
    private int rootSum(TreeNode node, int targetSum) {
        if (node == null) {
            return 0;
        }
        int ret = 0;
        if (node.val == targetSum) {
            ret += 1;
        }
        ret += rootSum(node.left, targetSum - node.val);
        ret += rootSum(node.right, targetSum - node.val);
        return ret;
    }

}
