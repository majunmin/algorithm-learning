package com.majm.leetcode;

import com.majm.Solution;
import com.majm.common.ListNode;

/**
 * 反转链表|| </br>
 *
 * @author majunmin
 * @description
 * @datetime 2021-06-21 23:44
 * @since
 */
public class LeetCode_0092 implements Solution {

    @Override
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummyNode = new ListNode();
        dummyNode.next = head;
        ListNode prev = dummyNode;
        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }
        ListNode leftNode = prev.next;
        ListNode tmpNode = null;

        // 循环将 left.next 插入到  prev.next
        for (int i = 1; i <= right - left; i++) {
            // 暂存 leftNode 下个节点
            tmpNode = leftNode.next;
            leftNode.next = leftNode.next.next;

            // insert
            tmpNode.next = prev.next;
            prev.next = tmpNode;
        }
        return dummyNode.next;
    }


    private ListNode solution2(ListNode head, int left, int right) {
        return null;
    }

    /**
     * 时间复杂度:  O(N)
     * 空间复杂度:  O(1)
     *
     * @param head
     * @param left
     * @param right
     * @return
     */
    private ListNode solution1(ListNode head, int left, int right) {
        if (head == null || head.next == null || left == right) {
            return head;
        }

        ListNode leftNode = null, rightNode = null, prev, succor = null;

        ListNode dummyNode = new ListNode();
        dummyNode.next = head;
        prev = dummyNode;
        while (prev.next != null) {
            if (prev.next.val == left) {
                leftNode = prev.next;
                break;
            }
            prev = prev.next;
        }
        ListNode node = prev.next;
        while (node != null) {
            if (node.val == right) {
                rightNode = node;
                succor = rightNode.next;
                break;
            }
            node = node.next;
        }

        rightNode.next = null;
        reverseList(leftNode);
        prev.next = rightNode;
        leftNode.next = succor;

        return dummyNode.next;
    }

}
