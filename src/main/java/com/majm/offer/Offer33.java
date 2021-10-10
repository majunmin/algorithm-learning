package com.majm.offer;

/**
 * 剑指 Offer 33. 二叉搜索树的后序遍历序列 </br>
 * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/
 *
 * @author majunmin
 * @description
 * @datetime 2021-10-09 00:41
 * @since
 */
public class Offer33 {

    /**
     * @param postorder
     * @return
     */
    public boolean verifyPostorder(int[] postorder) {
        return helper(postorder, 0, postorder.length - 1);
    }

    /**
     * 递归的方式解决
     * 二叉树的后序遍历
     * <p>
     * 左子树 -> 右子树 -> 根节点
     * (可以根据根节点 判断 左右子树的边界)
     *
     * @param postorder
     * @param left
     * @param right
     * @return
     */
    private boolean helper(int[] postorder, int left, int right) {
        if (left >= right) {
            return true;
        }
        int mid = left;
        int rootVal = postorder[right];
        // 找出根节点左边第一个 > rootVal 的节点,
        // 该节点(不包含该节点)左边即时左子树
        // 该节点(包含该节点)右边即为右子树
        while (postorder[mid] < rootVal) {
            mid++;
        }
        int tmp = mid;

        // 验证右子树的 节点的值都 > rootVal, 才是一个二叉搜索树
        while (tmp < right) {
            if (postorder[tmp] <= postorder[right]) {
                return false;
            }
            tmp++;
        }
        return helper(postorder, left, mid - 1) && helper(postorder, mid, right - 1);
    }
}
