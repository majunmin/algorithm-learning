package com.majm.offer;

import com.majm.common.ListNode;

/**
 * 剑指 Offer 24. 反转链表 </br>
 *
 * @author majunmin
 * @description
 * @datetime 2021-09-13 20:34
 * @since
 */
public class Offer24 {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummyNode = new ListNode();
        while (head != null) {
            ListNode temp = head.next;
            head.next = dummyNode.next;
            dummyNode.next = head;
            head = temp;
        }
        return dummyNode.next;
    }


    private ListNode iterSolution(ListNode head) {
        ListNode node = head;
        ListNode dummyNode = new ListNode();
        while (node != null) {
            ListNode tmpNode = node.next;
            node.next = dummyNode.next;
            dummyNode.next = node;
            // 遍历链表
            node = tmpNode;
        }
        return dummyNode.next;
    }

    private ListNode recurSolution(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode newHead = recurSolution(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        root.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        Offer24 offer24 = new Offer24();
        System.out.println(offer24.reverseList(root));
    }
}
