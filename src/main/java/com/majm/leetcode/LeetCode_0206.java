package com.majm.leetcode;

import com.majm.Solution;
import com.majm.common.ListNode;

/**
 * @author majunmin
 * @description
 * @datetime 2020/10/21 10:32 下午
 * @since
 */
public class LeetCode_0206 implements Solution {

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
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newNode = reverseList(head.next);
        head.next.next = head;
        return newNode;
    }


    /**
     * 利用哑结点实现,易于理解
     *
     * @param head
     * @return
     */
    private ListNode iterSolution2(ListNode head) {
        ListNode dummyNode = new ListNode();
        // 遍历链表,插入到  dummyNode 后面,就可以实现反转了
        while (head != null) {
            ListNode tempNode = head;
            head = head.next;

            // 插入到  dummyNode后面
            tempNode.next = dummyNode.next;
            dummyNode.next = tempNode;
        }
        return dummyNode.next;
    }

//    // terminate
//        if (head == null || head.next == null) {
//        return head;
//    }
//
//    // 画图解决
//    ListNode newNode = reverseList(head.next);
//    head.next.next = head;
//    head.next = null;
//    return newNode;


    /**
     * 递归的方式
     * 时间复杂度:
     * 空间复杂度:
     *
     * @param head
     * @return
     */
    private ListNode recursiveSolution(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = recursiveSolution(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }


    /**
     * 遍历链表 建立一个新链表作为反转后的 结果
     * 时间复杂度: O(N)
     * 空间复杂度: O(N)
     *
     * @param head
     * @return
     */
    public ListNode iterSolution(ListNode head) {
        // 1. 遍历链表

        // 1. 构建一个新链表(往链表的头部插值很容易)
        ListNode newNode = head;
        ListNode tmpNode;
        while (head.next != null) {
            // 保存head指针
            tmpNode = head;
            // 记录head指针
            head = head.next;
            // 往新链表头部插值
            tmpNode.next = newNode;
            // 更新新链表头
            newNode = tmpNode;
        }
        return newNode;
    }
}
