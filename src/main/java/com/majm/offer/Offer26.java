package com.majm.offer;

import com.majm.common.TreeNode;

/**
 * 剑指 Offer 26. 树的子结构 </br>
 * https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof/
 *
 * @author majunmin
 * @description
 * @datetime 2021-09-16 21:39
 * @since
 */
public class Offer26 {

    /**
     * 包含相同子结构:
     * 1. A 的根节点 是否 和 B 是相同的 子结构
     * 2. A的 子节点 是否和  B 是 相同子结构
     * <p>
     * 是相同子结构:
     * 1. node1.val = node2.val
     *  node1 != null && node2 == null
     *
     * @param A
     * @param B
     * @return
     */
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        // param check, A B其中有一个 为null 时 return false
        if (A == null || B == null) {
            return false;
        }

        if (isSame(A, B)) {
            return true;
        }
        return isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    /**
     * A B 的parent节点相同时, 判断 A B 是否有相同的 structure
     *
     * @param A
     * @param B
     * @return
     */
    private boolean isSame(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        if (A == null || A.val != B.val) {
            return false;
        }
        return isSame(A.left, B.left) && isSame(A.right, B.right);
    }
}
