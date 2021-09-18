package com.majm.offer;

import com.majm.common.Node;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 剑指 Offer 36. 二叉搜索树与双向链表 </br>
 * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof/
 *
 * @author majunmin
 * @description
 * @datetime 2021-09-16 20:56
 * @since
 */
public class Offer36 {

    /**
     * 二叉搜索树的 中序遍历,就是一个有序的数据结构
     *
     * @param root
     * @return
     */
    public Node treeToDoublyList(Node root) {
        return iterSolution(root);
    }

    /**
     * 迭代遍历  遍历过程中组装双向链表
     *
     * @param root
     * @return
     */
    private Node iterSolution(Node root) {
        if (root == null) {
            return null;
        }
        Node head = new Node();
        Node prev = head;
        Deque<Node> stack = new LinkedList<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            prev.right = root;
            root.left = prev;
            prev = root;
            // 变换节点到右节点
            root = root.right;
        }
        // 处理 尾结点, 形成闭环
        prev.right = head.right;
        head.right.left = prev;
        return head.right;
    }


    /**
     * 1. 二叉树 中序遍历放到一个链表,
     * 2. 对这个有序链表 编排为 一个循环链表
     * > 优化, 遍历过程中 组装成一个双向链表
     *
     * @param root
     * @return
     */
    private Node solution1(Node root) {
        List<Node> nodeList = new ArrayList<>();
        if (root == null) {
            return null;
        }
        inOrder(root, nodeList);
        Node head = new Node();
        Node prev = head;
        for (Node node : nodeList) {
            prev.right = node;
            node.left = prev;
            prev = node;
        }
        prev.right = head.right;
        head.right.left = prev;
        return head.right;
    }

    private void inOrder(Node root, List<Node> nodeList) {
        if (root == null) {
            return;
        }
        inOrder(root.left, nodeList);
        nodeList.add(root);
        inOrder(root.right, nodeList);
    }

    public static void main(String[] args) {
        Node root = new Node(4);
        Node l = new Node(2);
        Node ll = new Node(1);
        Node lr = new Node(3);
        Node r = new Node(5);
        root.left = l;
        root.right = r;
        l.left = ll;
        l.right = lr;

        Offer36 offer = new Offer36();
        System.out.println(offer.treeToDoublyList(root));
    }
}
