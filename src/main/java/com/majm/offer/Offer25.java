package com.majm.offer;

import com.majm.common.ListNode;

/**
 * 剑指 Offer 25. 合并两个排序的链表 </br>
 * https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof/
 *
 * @author majunmin
 * @description
 * @datetime 2021-09-24 08:31
 * @since
 */
public class Offer25 {

    /**
     * 递归和 迭代两种写法
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        return iterSolution(l1, l2);
    }

    private ListNode iterSolution(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode();
        ListNode prev = dummyNode;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        // process left
        if (l1 == null) {
            prev.next = l2;
        }
        if (l2 == null) {
            prev.next = l1;
        }
        return dummyNode.next;
    }


    private ListNode recurSolution(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val <= l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        l2.next = mergeTwoLists(l1, l2.next);
        return l2;
    }
}
