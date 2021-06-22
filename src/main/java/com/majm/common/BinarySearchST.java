package com.majm.common;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * BSt 部分代码实现 </br>
 * ![](https://gitee.com/niubenwsl/image_repo/raw/master/image/java/20210613122356.png)
 *
 * @author majunmin
 * @description
 * @datetime 2021-06-13 10:52
 * @since
 */
public class BinarySearchST<Key extends Comparable<Key>, Value> {

    public Node root; // rootNode

    private class Node {
        private Key key;
        private Value value;
        private Node left, right;
        private int N; // 以该节点为根的子树中  节点数

        public Node(Key key, Value value, int n) {
            this.key = key;
            this.value = value;
            N = n;
        }

        public int size() {
            return size(root);
        }

        private int size(Node node) {
            if (node == null) {
                return 0;
            }
            int leftSize = size(node.left) + 1;
            int rightSize = size(node.right) + 1;
            return leftSize + rightSize + 1;
        }

        public Value get(Key key) {

            return get(root, key);
        }

        private Value get(Node node, Key key) {
            // terminate
            if (node == null) { // 没找到
                return null;
            }

            int cmp = key.compareTo(node.key);
            if (cmp < 0) {
                return get(node.left, key);
            }
            if (cmp > 0) {
                return get(node.right, key);
            }
            return node.value;
        }

        // 先查找key 找到就替换, 否则创建一个新节点
        public void put(Key key, Value value) {
            put(root, key, value);
        }

        private Node put(Node node, Key key, Value value) {
            if (node == null) {
                return new Node(key, value, 1);
            }
            int cmp = key.compareTo(node.key);
            if (cmp > 0) {
                node.right = put(node.right, key, value);
            } else if (cmp < 0) {
                node.left = put(node.left, key, value);
            } else {
                // update value
                node.value = value;
            }
            // update N
            node.N = size(node.left) + size(node.right) + 1;
            return node;
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

        public Node max(Node node) {
            if (node.right == null) {
                return node;
            }
            return min(node.right);
        }

        public Key floor(Key key) {
            Node node = floor(root, key);
            if (node == null) {
                return null;
            }
            return node.key;
        }

        private Node floor(Node node, Key key) {
            if (node == null) {
                return null;
            }
            int cmp = key.compareTo(node.key);
            if (cmp == 0) {
                return node;
            } else if (cmp < 0) {
                return floor(node.left, key);
            } else {
                Node t = floor(node.right, key);
                return t == null ? node : t;
            }
        }

        public Node celling() {
            return null;
        }

        public void deleteMin() {
            deleteMin(root);
        }

        private Node deleteMin(Node node) {
            if (node.left == null) {
                return node.right;
            }
            node.left = deleteMin(node.left);
            node.N = size(node.left) + size(node.right) + 1;
            return node;
        }

        public void delete(Key key) {
            delete(root, key);
        }

        private Node delete(Node node, Key key) {
            if (node == null) {
                return null;
            }
            int cmp = key.compareTo(node.key);
            if (cmp < 0) {
                node.left = delete(node.left, key);
            }
            if (cmp > 0) {
                node.right = delete(node.right, key);
            } else {
                if (node.left == null) {
                    return node.right;
                }
                if (node.right == null) {
                    return node.left;
                }
                // 暂存当前节点
                Node tmp = node;
                // 将当前节点替换为  右子树最小节点
                node = min(node.right);
                node.right = deleteMin(tmp.right);
                node.left = tmp.left;
            }
            node.N = size(node.left) + size(node.right) + 1;
            return node;
        }

        /**
         * 二叉查找树 范围查找
         */
        public Iterable<Key> keys() {
            return keys(min(), max());
        }

        private Iterable<Key> keys(Key low, Key high) {
            Queue<Key> queue = new ArrayDeque<>();
            keys(root, queue, low, high);
            return queue;
        }

        /**
         * 而查找数 范围查询
         *
         * @param node
         * @param queue
         * @param low
         * @param high
         */
        private void keys(Node node, Queue<Key> queue, Key low, Key high) {
            if (node == null) {
                return;
            }
            int cmplo = low.compareTo(node.key);
            int cmphi = high.compareTo(node.key);
            // node 进入 queue的条件: low <= node.key <= hi
            if (cmplo <= 0 && cmphi >= 0) {
                queue.add(node.key);
            }
            if (cmplo < 0) {
                keys(node.left, queue, low, high);
            }
            if (cmphi > 0) {
                keys(node.right, queue, low, high);
            }
        }

        // 返回排名为 k 的节点(索引) 0 start
        public Key select(int k) {
            return select(root, k);
        }

        // 从node 节点查找 排名为k的 key
        // 如果 size(node.left) == k，返回当前节点 key
        // 如果 t = size(node.left) < k, 查询 node, k-t-1
        private Key select(Node node, int k) {
            if (node == null) {
                return null;
            }
            int t = size(node.left);
            if (t == k) {
                return node.key;
            }
            if (t > k) {
                return select(node.left, k);
            }
            return select(node.right, k - t - 1);
        }

        // 返回 key 所在节点的的排名
        public int rank(Key key) {
            return rank(root, key);
        }

        private int rank(Node node, Key key) {
            if (node == null) {
                return -1;
            }
            int cmp = key.compareTo(node.key);
            if (cmp == 0) {
                return size(node.left);
            }
            // 在左子树
            if (cmp < 0) {
                return rank(node.left, key);
            }

            int t = size(node.left);
            return t + 1 + rank(node, key);
        }
    }
}
