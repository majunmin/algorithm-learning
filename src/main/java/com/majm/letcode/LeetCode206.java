package com.majm.letcode;

import com.majm.Solution;
import com.majm.common.ListNode;

/**
 * @author majunmin
 * @description
 * @datetime 2020/10/21 10:32 下午
 * @since
 */
public class LeetCode206 implements Solution {

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    @Override
    public ListNode reverseList(ListNode head) {
        // 1. 遍历链表

        // 1. 构建一个新链表(往链表的头部插值很容易)
        ListNode newNode = null;
        //
        ListNode oldNode;
        while(head.next != null){
            // 保存head指针
            oldNode = head;
            // 记录head指针
            head = head.next;
            // 往新链表头部插值
            oldNode.next = newNode;
            // 更新新链表头
            newNode = oldNode;
        }
        return newNode;



        // 2. 递归

        // 递归终点
//        if (head == null || head.next == null){
//            return head;
//        }
//        //
//        ListNode newHead = reverseList(head.next);
//        //
//        head.next.next = head;
//        head.next = null;
//        return  newHead;

    }
}
