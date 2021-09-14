package com.majm.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer 35. 复杂链表的复制 </br>
 * https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof/
 *
 * @author majunmin
 * @description
 * @datetime 2021-09-14 12:27
 * @since
 */
public class Offer35 {
    // 保存新旧节点的映射
    private Map<Node, Node> cache = new HashMap<>();

    public Node copyRandomList(Node head) {
        return iterSolution(head);
    }


    /**
     * 根据 解法一的 思路 需要记录  oldNode -> newNode 的映射关系
     * 可以 转化为  用前驱节点记录  这个映射关系
     * 1 -> 4 -> 5 -> 7 -> 9
     * 1 -> 1' -> 4 -> 4' -> 5 -> 5' -> 7 -> 7' -> 9 -> 9'
     *
     * <ol>
     *     <li>将复制节点插入 到源链表后面</li>
     *     <li>填充 newNode 的 random指针</li>
     *     <li>构建新链表,恢复老链表</li>
     * </ol>
     *
     * @param head
     * @return
     */
    private Node iterSolution(Node head) {
        if (head == null) {
            return null;
        }
        Node node = head;
        while (node != null) {
            Node newNode = new Node(node.val);
            Node next = node.next;
            // insert newNode
            newNode.next = node.next;
            node.next = newNode;
            node = next;
        }

        node = head;
        while (node != null) {
            Node randomNode = node.random;
            if (randomNode != null) {
                node = node.next;
                node.random = randomNode;
            }
            node = node.next;
        }

        Node result = new Node(0);
        Node prev = result;
        while (head != null) {
            Node tmpNode = head.next;
            head.next = head.next.next;
            prev.next = tmpNode;
            prev = prev.next;
            head = head.next;
        }
        return result.next;
    }


    /**
     * 很妙  对递归理解的还是不透彻
     * 1. 从前往后 构建 next指针
     * 2. 从后往前 构建 random指针
     *
     * @param head
     * @return
     */
    private Node recurSolution(Node head) {
        if (head == null) {
            return null;
        }
        if (!cache.containsKey(head)) {
            Node newHead = new Node(head.val);
            cache.put(head, newHead);
            newHead.next = copyRandomList(head.next);
            newHead.random = copyRandomList(head.random);
        }
        return cache.get(head);
    }


    private static class Node {
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
