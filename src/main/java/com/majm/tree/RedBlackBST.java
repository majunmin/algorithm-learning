package com.majm.tree;

import java.util.Objects;

/**
 * @author majunmin
 * @description
 * @datetime 2020/9/18 2:17 下午
 * @since
 */
public class RedBlackBST<Key extends Comparable<Key>, Value> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private Node root; //root of the BST

    static class Node<Key, Value> {

        private Key key;        // key
        private Value value;    // associated data
        private boolean color;
        private Node left, right;
        private int size;

        public Node(Key key, Value value, boolean color, Node left, Node right, int size) {
            this.key = key;
            this.value = value;
            this.color = color;
            this.left = left;
            this.right = right;
            this.size = size;
        }
    }

    public boolean isRed(Node n) {
        return Objects.isNull(n.color)? BLACK : n.color == RED;
    }

    public int size(Node n) {
        return Objects.isNull(n)? 0 : n.size;
    }

    public int size() {
        return size(root);
    }

}
