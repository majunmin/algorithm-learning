package com.majm.letcode;

import com.majm.Solution;
import com.majm.common.ListNode;

/**
 * @author majunmin
 * @description
 * @datetime 2020/10/22 12:56 下午
 * @since
 */
public class LeetCode24 implements Solution {

    @Override
    public ListNode swapPairs(ListNode head) {

        // 1.1 递归
        if (head == null || head.next == null){
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
        while(temp.next != null && temp.next.next != null){
            ListNode node1 = temp.next;
            ListNode node2 = temp.next.next;
            temp = node2.next;
            node2.next = node1;
            node1.next = node2.next;
        }
        return dummyHead.next;

    }

}