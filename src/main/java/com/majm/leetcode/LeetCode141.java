package com.majm.leetcode;

import com.majm.Solution;
import com.majm.common.ListNode;

import java.util.HashSet;

/**
 * @author majunmin
 * @description
 * @datetime 2020/10/22 12:50 上午
 * @since
 */
public class LeetCode141 implements Solution {

    @Override
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        // 1. 暴力解法  hash表
//        HashSet<ListNode> hashSet = new HashSet<>();
//        while (head != null) {
//            if (hashSet.contains(head)) {
//                return true;
//            } else {
//                hashSet.add(head);
//            }
//            head = head.next;
//        }
//        return false;

        // 2. 快慢指针
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (slow == null || fast == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
