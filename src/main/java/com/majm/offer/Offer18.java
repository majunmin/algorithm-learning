package com.majm.offer;

import com.majm.common.ListNode;

/**
 * 剑指 Offer 18. 删除链表的节点 </br>
 * https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof/
 *
 * @author majunmin
 * @description
 * @datetime 2021-09-24 00:28
 * @since
 */
public class Offer18 {

    public ListNode deleteNode(ListNode head, int val) {
        return recurSolution(head, val);
    }

    private ListNode recurSolution(ListNode head, int val) {
        //  terminate
        if (head == null) {
            return null;
        }
        if (head.val == val) {
            return head.next;
        }
        // process
        head.next = deleteNode(head.next, val);
        return head;
    }

    private ListNode iterSolution(ListNode head, int val) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode prev = dummyNode;
        while (prev.next != null) {
            if (prev.next.val == val) {
                prev.next = prev.next.next;
                break;
            }
            prev = prev.next;
        }
        return dummyNode.next;
    }
}
