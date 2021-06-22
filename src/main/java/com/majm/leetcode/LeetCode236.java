package com.majm.leetcode;

import com.majm.Solution;
import com.majm.common.TreeNode;

/**
 * @author majunmin
 * @description
 * @datetime 2020/11/4 7:37 下午
 * @since
 */
public class LeetCode236 implements Solution {

    /**
     * 最近最小公共祖先
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    @Override
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return solution2(root, p, q);
    }

    /**
     * 后序遍历 更容易理解一点
     * 先假设左右子树都已经算出结果
     *
     * [题解](https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/solution/236-er-cha-shu-de-zui-jin-gong-gong-zu-xian-hou-xu/)
     *
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode solution2(TreeNode root, TreeNode p, TreeNode q) {
        // 1.
        if (root == null || p == root || q == root) {
            return root;
        }

        TreeNode leftNode = lowestCommonAncestor(root.left, p, q);
        TreeNode rightNode = lowestCommonAncestor(root.right, p, q);
        if (leftNode == null) return rightNode;
        if (rightNode == null) return leftNode;
        return root;
    }


    private TreeNode ans;

    public TreeNode solution1(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return ans;
    }

    /**
     * dfs
     * 二叉树后序遍历
     *
     * @return
     */
    private boolean dfs(TreeNode root, TreeNode p, TreeNode q){
        if (root == null){
            return false;
        }
        boolean lson = dfs(root.left, p, q);
        boolean rson = dfs(root.right, p, q);
        if ((lson && rson) || ((root.val == p.val || root.val == q.val) && (lson || rson))) {
            ans = root;
        }
        return lson || rson || (root.val == p.val || root.val == q.val);
    }
}
