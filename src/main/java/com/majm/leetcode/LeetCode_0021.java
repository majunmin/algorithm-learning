package com.majm.leetcode;

import com.majm.Solution;
import com.majm.common.ListNode;

/**
 * @author majunmin
 * @description
 * @datetime 2020/10/24 12:23 上午
 * @since
 */
public class LeetCode_0021 implements Solution {


    @Override
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val <= l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }


    private ListNode recursiveSolution(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        if (l1.val <= l2.val) {
            l1.next = recursiveSolution(l1.next, l2);
            return l1;
        } else {
            l2.next = recursiveSolution(l1, l2.next);
            return l2;
        }
    }

    /**
     * 迭代方式解决
     *
     * @param l1
     * @param l2
     * @return
     */
    private ListNode iterSolution(ListNode l1, ListNode l2) {
        // 标记节点
        ListNode dummyNode = new ListNode();
        ListNode prev = dummyNode;
        while (l1 != null && l2 != null) {
            //拼接链表
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        if (l1 != null) {
            prev.next = l1;
        }
        if (l2 != null) {
            prev.next = l2;
        }

        return dummyNode.next;
    }
}


//    @Override
//    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        // 1. 递归
////            if (l1 == null){
////                return l2;
////            }
////            if (l2 == null){
////                return l1;
////            }
////            if (l1.val <= l2.val){
////                l1.next = mergeTwoLists(l1.next, l2);
////                return l1;
////            } else {
////                l2.next = mergeTwoLists(l1.next, l2);
////                return l2;
////            }
//
//        // 2. 迭代， 暴力解法
//        if (l1 == null) {
//            return l2;
//        }
//        if (l2 == null) {
//            return l1;
//        }
//        ListNode dummyHead = new ListNode(-1);
//        ListNode preHead = dummyHead;
//        while (l1 != null && l2 != null) {
//            if (l1.val <= l2.val) {
//                preHead.next = l1;
//                l1 = l1.next;
//            } else {
//                preHead.next = l2;
//                l2 = l2.next;
//            }
//            preHead = preHead.next;
//        }
//        preHead.next = (l1 != null) ? l1 : l2;
//        return dummyHead.next;
//
//    }