package com.majm.leetcode;

import com.majm.Solution;
import com.majm.common.ListNode;

/**
 * @author majunmin
 * @description
 * @datetime 2020/10/22 12:56 下午
 * @since
 */
public class LeetCode_0024 implements Solution {

    @Override
    public ListNode swapPairs(ListNode head) {
        return iterSolution2(head);
    }

    /***
     * 其实就是 两个 操作,
     * 删除一个节点
     * 添加一个节点  🤪
     * @param head
     * @return
     */
    private ListNode iterSolution2(ListNode head) {
        ListNode dummyNode = new ListNode();
        dummyNode.next = head;
        ListNode prev = dummyNode;
        while (head != null && head.next != null) {
            ListNode next = head.next;
            head.next = next.next;
            next.next = head;
            prev.next = next;
            prev = head;
            head = head.next;
        }
        return dummyNode.next;
    }


    private ListNode recurSolution(ListNode head) {
        // terminate condition
        if (head == null || head.next == null) {
            return head;
        }

        final ListNode newHead = head.next;
        head.next = swapPairs(head.next.next);
        newHead.next = head;
        return newHead;
    }


    private ListNode iterSolution(ListNode head) {
        // 1.1 递归
        if (head == null || head.next == null) {
            return head;
        }
//        ListNode p = head;
//        ListNode q = head.next;
//        head = head.next.next;
//
//        q.next = p;
//        p.next = swapPairs(head);
//        return q;

        // 1.2
//        ListNode newHead = head.next;
//        head.next = swapPairs(newHead.next);
//        newHead.next = head;
//        return newHead;

        //2.迭代
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode temp = dummyHead;
        while (temp.next != null && temp.next.next != null) {
            ListNode node1 = temp.next;
            ListNode node2 = temp.next.next;
            temp = node2.next;
            node2.next = node1;
            node1.next = node2.next;
        }
        return dummyHead.next;
    }

}