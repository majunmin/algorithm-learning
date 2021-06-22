package com.majm;

import com.majm.common.TreeNode;
import com.majm.leetcode.LeetCode33;

/**
 * @author majunmin
 * @description
 * @datetime 2020/10/20 2:37 下午
 * @since
 */
public class App {

    public static void main(String[] args) {
//        String[] strList1 = new String[]{"bdddddddddd", "bbbbbbbbbbc"};
//        String[] strList = new String[]{"eat","tea","tan","ate","nat","bat"};
//        int[] nums = new int[]{7, 2, 4};
//
        // build Tree
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(3);
        treeNode.right = new TreeNode(2);
        treeNode.left.left = new TreeNode(5);
        treeNode.left.right = new TreeNode(3);
        treeNode.right.right = new TreeNode(9);
//
//        int[] preorder = new int[]{1, 2};
//        int[] inorder = new int[]{2, 1};


//[["1","1","1","1","0"],["1","1","0","1","0"],["1","1","0","0","0"],["0","0","0","0","0"]]
        char[][] charArr = {
                {'1', '1', '1'},
                {'0', '1', '1'},
                {'1', '1', '1'}
        };
        int[] arr = new int[]{4,5,6,7,0,1,2};
        Solution solution = new LeetCode33();
        System.out.println(solution.search(arr, 0));


//        Interview que = new Inter1709();
//        que.getKthMagicNumber(6);
    }
}
