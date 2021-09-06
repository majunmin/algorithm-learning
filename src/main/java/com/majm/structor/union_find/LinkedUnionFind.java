package com.majm.structor.union_find;

/**
 * 并查集 列表实现 </br>
 * 并查集 多用于 比较几个元素是否有关联
 * 主要包含 两个操作   find  & union
 *
 * @author majunmin
 * @description
 * @datetime 2021-07-24 17:10
 * @since
 */
public class LinkedUnionFind {

    private Node[] nodes;

    public LinkedUnionFind(int m) {
        for (int i = 0; i < m; i++) {
            nodes[i] = new Node();
        }
    }

    public void union(int i, int j) {
        Node lHead = nodes[i].R;
        Node lTail = lHead.prev;
        Node rHead = nodes[j].R;
        Node rTail = rHead.prev;

        lHead.prev = rTail;
        rTail.next = lHead;
        rHead.prev = lTail;
        lTail.next = rHead;
        Node p = rHead;
        while (p != lHead) {
            p.R = lHead.R;
            p = p.next;
        }
    }

    public boolean find(int i, int j) {
        return nodes[i].R == nodes[j].R;
    }

    public class Node {
        private Node prev;
        private Node next;
        private Node R;

        public Node() {
            this.prev = this;
            this.next = this;
            R = this;
        }
    }
}
