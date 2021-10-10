package com.majm.offer;

import com.majm.common.TreeNode;

/**
 * 剑指 Offer 68 - I. 二叉搜索树的最近公共祖先 </br>
 * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-zui-jin-gong-gong-zu-xian-lcof/
 *
 * @author majunmin
 * @description
 * @datetime 2021-10-07 20:06
 * @since
 */
public class Offer68_1 {

    /**
     * 利用二叉搜索树的性质
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ancestor = root;
        while (true) {
            if (p.val < ancestor.val && q.val < ancestor.val) {
                ancestor = ancestor.left;
            } else if (p.val > ancestor.val && q.val > ancestor.val) {
                ancestor = ancestor.right;
            } else {
                break;
            }
        }
        return ancestor;
    }
}
