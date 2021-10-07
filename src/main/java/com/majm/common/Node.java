package com.majm.common;

/**
 * Node 二叉树 节点 </br>
 *
 * @author majunmin
 * @description
 * @datetime 2021-09-16 20:57
 * @since
 */
// Definition for a Node.
public class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
