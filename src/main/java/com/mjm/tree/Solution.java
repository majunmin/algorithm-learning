package com.mjm.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * 二叉树的遍历
 */
class Solution {

    public int count = 0;

    /**
     * 递归 构造 二叉树
     *
     * @param node
     * @return
     */
    public static TreeNode createTreeNode(TreeNode node) {
        if (node != null && node.val >= 0) {
            Scanner sc = new Scanner(System.in);
            node.left = createTreeNode(new TreeNode(sc.nextInt()));
            node.right = createTreeNode(new TreeNode(sc.nextInt()));
            return node;
        }
        return null;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeNode root = createTreeNode(new TreeNode(sc.nextInt()));
        List<Integer> res = preorderTraversal2(root);

        for (Integer i : res) {
            System.out.print(i);
        }
        System.out.println();
    }

    /**
     * 前序遍历  递归
     *
     * @param root
     * @return
     */
    public static List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root != null) {
            result.add(root.val);
            preTraversal(root.left, result);
            preTraversal(root.right, result);
        }
        return result;
    }

    private static void preTraversal(TreeNode node, List<Integer> result) {
        if (node != null) {
            result.add(node.val);
            preTraversal(node.left, result);
            preTraversal(node.right, result);
        }
    }


    /**
     * 前序遍历  非递归
     *
     * @param root
     * @return
     */
    public static List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) {
            return new ArrayList<>();
        }

        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            if (current == null) {
                current = stack.pop().right;
            } else {
                stack.push(current);
                result.add(current.val);
                current = current.left;
            }
        }
        return result;
    }

    /**
     * 中序遍历 递归
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root != null) {
            inTraversal(root.left, result);
            result.add(root.val);
            inTraversal(root.right, result);
        }
        return result;
    }

    private void inTraversal(TreeNode node, List<Integer> result) {
        if (node != null) {
            inTraversal(node.left, result);
            result.add(node.val);
            inTraversal(node.right, result);
        }
    }

    /**
     * 中序遍历 非递归
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                current = stack.pop();
                result.add(current.val);
                current = current.right;
            }
        }
        return result;
    }

    /**
     * 后序遍历 递归
     *
     * @param root
     * @return
     */
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root != null) {
            postTraversal(root.left, result);
            postTraversal(root.right, result);
            result.add(root.val);
        }
        return result;
    }

    private static void postTraversal(TreeNode node, List<Integer> result) {
        if (node != null) {
            postTraversal(node.left, result);
            postTraversal(node.right, result);
            result.add(node.val);
        }
    }

    /**
     * 二叉树 后序遍历 非递归
     *
     * @param root
     * @return
     */
    public static List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        TreeNode current;
        stack.push(root);
        while (!stack.isEmpty()) {
            current = stack.peek();
            //如果当前结点左右子节点为空或上一个访问的结点为当前结点的子节点时，当前结点出栈
            if ((current.left == null && current.right == null) || (pre != null && (pre.left == null || pre.right == null))) {
                result.add(current.val);
                pre = current;
                stack.pop();
            } else {
                if(current.right != null) stack.push(current.right); //先将右结点压栈
                if(current.left != null) stack.push(current.left);   //再将左结点入栈
            }
        }
        return result;
    }
}