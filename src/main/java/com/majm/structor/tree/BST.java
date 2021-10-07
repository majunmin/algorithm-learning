package com.majm.structor.tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 二叉查找树 </br>
 *
 * @author majunmin
 * @description
 * @datetime 2021-09-03 16:18
 * @since
 */
public class BST<Key extends Comparable<Key>, Value> {

    private Node root;

    private class Node {
        private Key key;
        private Value value;
        private Node left;
        private Node right;
        // 以 node 为根节点的 左右子树节点数之和
        private int size;

        public Node(Key key, Value value, int size) {
            this.key = key;
            this.value = value;
            this.size = size;
        }
    }

    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node node, Key key) {
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            return get(root.left, key);
        }
        if (cmp > 0) {
            return get(root.right, key);
        }
        return node.value;
    }

    public void put(Key key, Value value) {
        // 查找key, 找到就更新,找不到就插入
        root = put(root, key, value);
    }

    private Node put(Node node, Key key, Value value) {
        if (node == null) {
            return new Node(key, value, 1);
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = put(node.left, key, value);
        } else if (cmp > 0) {
            node.right = put(node.right, key, value);
        } else {
            node.value = value;
        }
        // update size
        node.size = size(node.left) + size(node.right) + 1;
        return node;
    }

    public int size() {
        return size(root);
    }

    /**
     * 递归
     * 返回 该节点及其子节点的节点数
     *
     * @param root
     * @return
     */
    private int size(Node root) {
        // terminate
        if (root == null) {
            return 0;
        }
        int leftSize = size(root.left);
        int rightSize = size(root.right);
        return leftSize + rightSize + 1;
    }


    public Key min() {
        return min(root).key;
    }

    private Node min(Node node) {
        if (node.left == null) {
            return node;
        }
        return min(node.left);
    }

    public Key max() {
        return max(root).key;
    }

    private Node max(Node node) {
        if (node.right == null) {
            return node;
        }
        return max(node.right);
    }


    /**
     * 向下取整, 小于等于key的最大键
     *
     * @param key
     * @return
     */
    public Key floor(Key key) {
        Node x = floor(root, key);
        if (x == null) {
            return null;
        }
        return x.key;
    }

    private Node floor(Node node, Key key) {
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp == 0) {
            return node;
        }
        if (cmp < 0) {
            return floor(node.left, key);
        }
        Node t = floor(node.right, key);
        if (t != null) {
            return t;
        }
        // 如果 在右子树中未找到，返回当前节点
        return node;
    }

    /**
     * 向下取整, 大于等于ceil的最小键
     *
     * @param key
     * @return
     */
    public Key ceilling(Key key) {
        Node x = ceilling(root, key);
        if (x == null) {
            return null;
        }
        return x.key;
    }

    private Node ceilling(Node node, Key key) {
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp == 0) {
            return node;
        }
        if (cmp > 0) {
            return ceilling(node.right, key);
        }
        Node t = ceilling(node.left, key);
        if (t != null) {
            return t;
        }
        return node;
    }

    /**
     * 返回排名 为k 的key
     *
     * @param k
     * @return
     */
    public Key select(int k) {
        return select(root, k).key;
    }

    private Node select(Node node, int k) {
        if (node == null) {
            return null;
        }
        int t = size(node.left);
        if (t > k) {
            return select(node.left, k);
        }
        if (t < k) {
            return select(node.right, t - k - 1);
        }
        return node;
    }

    /**
     * 返回 key 的排名(index)
     *
     * @param key
     * @return
     */
    public int rank(Key key) {
        return rank(root, key);
    }

    private int rank(Node node, Key key) {
        // 以 node 为根节点的 子树中 ,小于 node  的 节点数
        if (node == null) {
            return 0;
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            return rank(node.left, key);
        }
        if (cmp > 0) {
            return rank(node.right, key) + size(node.left) + 1;
        }
        return size(node.left);
    }

    // delete

    public void deleteMin() {
        root = deleteMin(root);
    }

    private Node deleteMin(Node node) {
        // node is minNode
        if (node.left == null) {
            return node.right;
        }
        node.left = deleteMin(node.left);
        node.size = size(node.left) + size(node.right) + 1;
        return node;
    }

    public void deleteMax() {
        root = deleteMax(root);
    }

    private Node deleteMax(Node node) {
        // node is maxNode
        if (node.right == null) {
            return node.left;
        }
        node.right = deleteMax(node.right);
        node.size = size(node.left) + size(node.right) + 1;
        return node;
    }

    // 二叉树的 范围查找操作
    public Iterable<Key> keys() {
        return keys(min(), max());
    }

    private Iterable<Key> keys(Key lo, Key hi) {
        Deque<Key> queue = new ArrayDeque<>();
        keys(root, lo, hi, queue);
        return queue;
    }

    private void keys(Node node, Key lo, Key hi, Deque<Key> queue) {
        if (node == null) {
            return;
        }
        int loCmp = lo.compareTo(node.key);
        int hiCmp = lo.compareTo(node.key);
        if (loCmp < 0) {
            keys(node.left, lo, hi, queue);
        }
        if (hiCmp > 0) {
            keys(node.right, lo, hi, queue);
        }
        if (loCmp <= 0 && hiCmp >= 0) {
            // add result
            queue.offer(node.key);
        }
    }


}
