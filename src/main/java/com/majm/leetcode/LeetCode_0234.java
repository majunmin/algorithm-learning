package com.majm.leetcode;

import com.majm.Solution;
import com.majm.common.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 一句话功能简述 </br>
 *
 * @author majunmin
 * @description
 * @datetime 2021-08-07 23:56
 * @since
 */
public class LeetCode_0234 implements Solution {

    @Override
    public boolean isPalindrome(ListNode head) {
        return solution2(head);
    }

    /**
     * 快慢指针复杂解法
     * <p>
     * 1. 通过快慢指针找到中点
     * 2. 反转后半部分
     * 3. 比较
     * 4. 恢复链表
     *
     * @param head
     * @return
     */
    private boolean solution2(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        // 找到中间靠右的节点
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        boolean result = true;
        // 反转slow后的链表
        slow.next = revertList(slow.next);
        ListNode l1 = head;
        ListNode l2 = slow.next;
        while (l2 != null) {
            if (l1.val != l2.val) {
                result = false;
                break;
            }
            l1 = l1.next;
            l2 = l2.next;
        }

        // 恢复链表
        slow.next = revertList(slow.next);
        return result;
    }

    private ListNode revertList(ListNode head) {
        ListNode oldNode = null;
        ListNode newNode = head;
        while (newNode != null) {
            ListNode tmpNode = newNode.next;
            newNode.next = oldNode;
            oldNode = newNode;
            newNode = tmpNode;
        }
        return oldNode;
    }

    /**
     * 利用数组 双指针 判断回文链表
     *
     * @param head
     * @return
     */
    private boolean arrSolution(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int left = 0;
        int right = list.size();

        while (left > right) {
            if (!list.get(left++).equals(list.get(right--))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        final Solution leetCode = new LeetCode_0234();
        final ListNode listNode1 = new ListNode(2);
        final ListNode listNode2 = new ListNode(1);
        final ListNode listNode3 = new ListNode(3);
        final ListNode listNode4 = new ListNode(1);
        final ListNode listNode5 = new ListNode(2);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        System.out.println(leetCode.isPalindrome(listNode1));
    }
}
