package com.majm.leetcode;

import com.majm.Solution;

import java.util.HashMap;
import java.util.Map;

/**
 * 138. 复制带随机指针的链表 </br>
 *
 * @author majunmin
 * @description
 * @datetime 2021-09-22 14:58
 * @since
 */
public class LeetCode_0138 implements Solution {

    public Node copyRandomList(Node head) {

        return iterSolution(head);

    }

    /**
     * @param head
     * @return
     */
    private Node iterSolution(Node head) {
        // 构建 链表
        // 1 - 1' - 2 - 2' - 3 - 3' - 4 - 4'
        Node prev = head;
        while (prev != null) {
            Node node = new Node(prev.val);
            node.next = prev.next;
            prev.next = node;
            prev = node.next;
        }

        // copy random
        prev = head;
        while (prev != null) {
            if (prev.random != null) {
                prev.next.random = prev.random.next;
            }
            prev = prev.next.next;
        }

        // 3. 拆链表,并还原旧链表
        // 1 - 1' - 2 - 2'  => 1 - 2   and  1' - 2'
        Node dummyNode = new Node(-1);
        Node tmp = dummyNode;
        prev = head;
        while (prev != null) {
            tmp.next = prev.next;
            // del
            prev.next = prev.next.next;
            prev = prev.next;
        }
        return dummyNode.next;
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node1.next = node2;
        node1.random = node3;
        node2.next = node3;
        node2.random = node4;
        node3.next = node4;
        node3.random = null;

        LeetCode_0138 leetCode = new LeetCode_0138();
        leetCode.iterSolution(node1);

    }


    private Map<Node, Node> cache = new HashMap<>();

    /**
     * hash
     *
     * @param head
     * @return
     */
    private Node recurSolution(Node head) {
        // terminate
        if (head == null) {
            return null;
        }
        if (!cache.containsKey(head)) {
            Node node = new Node(head.val);
            cache.put(head, node);
            node.next = copyRandomList(head.next);
            node.random = copyRandomList(head.random);
        }
        return cache.get(head);
    }

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}


